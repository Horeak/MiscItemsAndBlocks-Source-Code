package com.miscitems.MiscItemsAndBlocks.GuiObjects;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.MainPage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class BookItemSelectButton extends GuiButton{
    int Id;
    MainPage gui;

    public BookItemSelectButton(int par1, int par2, int par3, MainPage Gui) {
        super(par1, par2, par3, 60, 10, "\u00a7n" + BookUtils.TabItems.get(Gui.CurrentTab)[par1 - BookUtils.MaxTabs].getDisplayName());

        this.Id = par1;
        this.gui = Gui;

    }

    public void drawButton(Minecraft par1Minecraft, int x, int y)
    {


        FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
        par1Minecraft.getTextureManager().bindTexture(gui.Texture);


        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);


        RenderHelper.enableGUIStandardItemLighting();



        if(BookUtils.GetTabType(gui.CurrentTab) == 2 && BookUtils.TabItems.get(gui.CurrentTab) != null)
        if(BookUtils.TabItems.get(gui.CurrentTab) != null && BookUtils.TabItems.get(gui.CurrentTab)[this.id - BookUtils.MaxTabs] != null && (this.id - BookUtils.MaxTabs) < BookUtils.TabItems.get(gui.CurrentTab).length && BookUtils.TabItems.get(gui.CurrentTab)[this.id - BookUtils.MaxTabs].getItem() != null){

            this.drawString(fontRendererObj, BookUtils.TabItems.get(gui.CurrentTab)[this.id - BookUtils.MaxTabs].getDisplayName(), xPosition + 2, yPosition, 0x737373);

        }


        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);


    }
}
