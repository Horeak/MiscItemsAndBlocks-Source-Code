package com.miscitems.MiscItemsAndBlocks.Book;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class NextPageButton extends GuiButton {

    public static ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/Icons.png");

    public static int xSize = 18;
    public static int ySize = 14;

    public int Type;
    public NextPageButton(int par1, int par2, int par3, int Type) {
        super(par1, par2, par3, xSize, ySize, null);
        this.Type = Type;
    }


    public void drawButton(Minecraft par1Minecraft, int x, int y)
    {

        FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);


        boolean IsMouseOver = x >= xPosition && x <= xPosition + xSize && y >= yPosition && y <= yPosition + ySize;


        if(Type == 1){
            if(IsMouseOver){
                this.drawTexturedModalRect(this.xPosition, this.yPosition, 27, 82, xSize, ySize);
            }else{
                this.drawTexturedModalRect(this.xPosition, this.yPosition, 4, 82, xSize, ySize);
            }

        }else{
            if(IsMouseOver){
                this.drawTexturedModalRect(this.xPosition, this.yPosition, 27, 99, xSize, ySize);
            }else{
                this.drawTexturedModalRect(this.xPosition, this.yPosition, 4, 99, xSize, ySize);
            }


        }

        this.mouseDragged(par1Minecraft, x, y);

    }
}
