package com.miscitems.MiscItemsAndBlocks.Book;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.MainPage;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class BookTabButton extends GuiButton {

    MainPage gui;
    int id;

    public BookTabButton(int par1, int x, int y, MainPage gui) {
        super(par1, x, y, 27, 20, "");
        this.gui = gui;
         this.id = par1;
    }

    public void drawButton(Minecraft par1Minecraft, int x, int y)
    {


        FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
        par1Minecraft.getTextureManager().bindTexture(gui.Texture);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);


        RenderHelper.enableGUIStandardItemLighting();


        if(this.id == (gui.CurrentTab))
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 24, 184, 27, 20);
        else
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 24, 205, 27, 20);

        if(BookUtils.GetTabIconItem(this.id) != null && BookUtils.GetTabIconItem(this.id).getItem() != null){

            BookUtils.renderitem.renderItemAndEffectIntoGUI(Main.font, par1Minecraft.renderEngine, BookUtils.GetTabIconItem(this.id), this.xPosition + 8, this.yPosition + 2);
        }

        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);


    }

}
