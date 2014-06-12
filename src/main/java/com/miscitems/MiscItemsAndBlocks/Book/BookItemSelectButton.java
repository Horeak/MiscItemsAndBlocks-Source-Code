package com.miscitems.MiscItemsAndBlocks.Book;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class BookItemSelectButton extends GuiButton{
    int Id;
    MainPage gui;

    public static int XSize = 100;
    public static int YSize = 10;

    public BookItemSelectButton(int id, int par1, int par2, int par3, MainPage Gui) {
        super(id, par2, par3, XSize, YSize, "\u00a7n" + BookUtils.TabItems.get(Gui.CurrentTab)[par1].getDisplayName());

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
        if(BookUtils.TabItems.get(gui.CurrentTab) != null && BookUtils.TabItems.get(gui.CurrentTab)[Id] != null && (Id) < BookUtils.TabItems.get(gui.CurrentTab).length && BookUtils.TabItems.get(gui.CurrentTab)[Id].getItem() != null){


            if(x >= this.xPosition && x <= this.xPosition + XSize && y >= this.yPosition && y <= this.yPosition + YSize){
                fontRendererObj.drawString(BookUtils.TabItems.get(gui.CurrentTab)[Id].getDisplayName(), xPosition + 2, yPosition, 0x1602CC);
            }else {
                fontRendererObj.drawString(BookUtils.TabItems.get(gui.CurrentTab)[Id].getDisplayName(), xPosition + 2, yPosition, 0x949292);
            }

        }


        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);


    }
}