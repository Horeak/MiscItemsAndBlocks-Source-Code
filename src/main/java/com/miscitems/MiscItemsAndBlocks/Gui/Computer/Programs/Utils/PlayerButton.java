package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class PlayerButton extends GuiButton {
    String Name;
    boolean Admin;

    public PlayerButton(int id, int x, int y, String Name, boolean Admin) {
        super(id, x, y, 65, 9, "");
        this.Name = Name;
        this.Admin = Admin;
    }


    public void drawButton(Minecraft par1Minecraft, int p_146112_2_, int p_146112_3_)
    {
        if (this.visible)
        {


            FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(new ResourceLocation("miscitems" , "textures/gui/ChatGui.png"));

            GL11.glColor4f(1F, 1F, 1F, 1F);

            if(Admin) {
                drawTexturedModalRect((this.xPosition - 2), (this.yPosition - 2), 22, 153, 11, 11);

                float scale = 0.5F;
                GL11.glScalef(scale, scale, scale);
                fontRendererObj.drawString("     " + Name, (this.xPosition + 2) * 2, (this.yPosition + 2) * 2, 24737632);
            }else{
                float scale = 0.5F;
                GL11.glScalef(scale, scale, scale);
                fontRendererObj.drawString(Name, this.xPosition * 2, (this.yPosition + 2) * 2, 24737632);
            }




        }
    }
}
