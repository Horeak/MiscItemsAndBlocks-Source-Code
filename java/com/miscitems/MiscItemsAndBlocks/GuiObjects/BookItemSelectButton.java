package com.miscitems.MiscItemsAndBlocks.GuiObjects;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Gui.BookPages.MainPage;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
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
        super(par1, par2, par3, 56, 184, "");

        this.Id = par1;
        this.gui = Gui;

    }

    public void drawButton(Minecraft par1Minecraft, int x, int y)
    {


        FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
        par1Minecraft.getTextureManager().bindTexture(gui.Texture);


        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);


        RenderHelper.enableGUIStandardItemLighting();

            this.drawTexturedModalRect(this.xPosition, this.yPosition, 56, 184, 55, 20);

        if(BookUtils.TabItems.get(gui.CurrentTab)[this.id - BookUtils.MaxTabs] != null && BookUtils.TabItems.get(gui.CurrentTab)[this.id - BookUtils.MaxTabs].getItem() != null){


            BookUtils.renderitem.renderItemAndEffectIntoGUI(Main.font, par1Minecraft.renderEngine, BookUtils.TabItems.get(gui.CurrentTab)[this.id - BookUtils.MaxTabs], this.xPosition + 3, this.yPosition + 2);

        }


        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);


    }
}
