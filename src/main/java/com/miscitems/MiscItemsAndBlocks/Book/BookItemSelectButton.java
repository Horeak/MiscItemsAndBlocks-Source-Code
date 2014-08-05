package com.miscitems.MiscItemsAndBlocks.Book;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;

public class BookItemSelectButton extends GuiButton{
    int Id;
    MainPage gui;

    public static int XSize = 100;
    public static int YSize = 10;

    public BookItemSelectButton(int id, int par1, int par2, int par3, MainPage Gui) {
        super(id, par2, par3, XSize, YSize, "null");

        this.Id = par1;
        this.gui = Gui;

    }

    public void drawButton(Minecraft par1Minecraft, int x, int y)
    {


        FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
        par1Minecraft.getTextureManager().bindTexture(gui.Texture);


        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);


        RenderHelper.enableGUIStandardItemLighting();


        if(BookUtils.GetTabItems(gui.CurrentTab).length >= Id && BookUtils.GetTabItems(gui.CurrentTab)[Id] != null && BookUtils.GetTabItems(gui.CurrentTab)[Id].getItem() != null) {

            if (BookUtils.GetTabType(gui.CurrentTab) == 2 && BookUtils.GetTabItems(gui.CurrentTab) != null)
                if (BookUtils.GetTabItems(gui.CurrentTab) != null && BookUtils.GetTabItems(gui.CurrentTab)[Id] != null && (Id) < BookUtils.GetTabItems(gui.CurrentTab).length && BookUtils.GetTabItems(gui.CurrentTab)[Id].getItem() != null) {


                    if (x >= this.xPosition && x <= this.xPosition + XSize && y >= this.yPosition && y <= this.yPosition + YSize) {
                        fontRendererObj.drawString(BookUtils.GetTabItems(gui.CurrentTab)[Id].getDisplayName(), xPosition + 2, yPosition, 0x1602CC);
                    } else {
                        fontRendererObj.drawString(BookUtils.GetTabItems(gui.CurrentTab)[Id].getDisplayName(), xPosition + 2, yPosition, 0x949292);
                    }

                }

        }else{
            if (x >= this.xPosition && x <= this.xPosition + XSize && y >= this.yPosition && y <= this.yPosition + YSize) {
                fontRendererObj.drawString("Item/Block Disabled", xPosition + 2, yPosition, new Color(255, 0, 0).getRGB());
            } else {
                fontRendererObj.drawString("Item/Block Disabled", xPosition + 2, yPosition, new Color(130, 0, 0).getRGB());
            }
        }


        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);


    }
}