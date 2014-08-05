package com.miscitems.MiscItemsAndBlocks.Book;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;

public class BookTabButton extends GuiButton {

    MainPage gui;
    RenderItem render;
    int id;

    public BookTabButton(int par1, int x, int y, MainPage gui, RenderItem renderer) {
        super(par1, x, y, 27, 20, "");
        this.gui = gui;
         this.id = par1;
        this.render = renderer;
    }

    public void drawButton(Minecraft par1Minecraft, int x, int y)
    {

        par1Minecraft.getTextureManager().bindTexture(gui.Texture);



        if(this.id == (gui.CurrentTab)) {

            this.drawTexturedModalRect(this.xPosition, this.yPosition, 24, 184, 27, 20);

        }else {

            this.drawTexturedModalRect(this.xPosition, this.yPosition, 24, 205, 27, 20);
        }

        if(BookUtils.GetTabIconItem(this.id) != null && BookUtils.GetTabIconItem(this.id).getItem() != null){


            RenderHelper.enableStandardItemLighting();
            BookUtils.renderitem.RenderItem(render, par1Minecraft.fontRenderer, BookUtils.GetTabIconItem(this.id), this.xPosition + 8, this.yPosition + 2);
            RenderHelper.disableStandardItemLighting();

        }





    }

}
