package com.miscitems.MiscItemsAndBlocks.Book;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class BookTabButton extends GuiButton {

    MainPage gui;
    RenderItem render;
    int id;

    public BookTabButton(int par1, int x, int y, MainPage gui, RenderItem renderer) {
        super(par1, x, y, 27, 20, "");
        this.gui = gui;
         this.id = par1;
        this.render =renderer;
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

            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            BookUtils.renderitem.RenderItem(render, par1Minecraft.fontRenderer, BookUtils.GetTabIconItem(this.id), this.xPosition + 8, this.yPosition + 2);

            GL11.glEnable(GL11.GL_LIGHTING);
        }


        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);



    }

}
