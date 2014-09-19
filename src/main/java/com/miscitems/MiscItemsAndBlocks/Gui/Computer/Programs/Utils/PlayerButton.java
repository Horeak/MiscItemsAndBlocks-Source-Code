package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class PlayerButton extends GuiButton {
    EntityPlayer Player;
    ChatChannel Channel;

    public PlayerButton(int id, int x, int y, EntityPlayer Player, ChatChannel Channel) {
        super(id, x, y, 65, 13, "");
        this.Player = Player;
        this.Channel = Channel;
    }


    public void drawButton(Minecraft par1Minecraft, int p_146112_2_, int p_146112_3_)
    {
        if (this.visible)
        {


            FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(new ResourceLocation("miscitems" , "textures/gui/ChatGui.png"));

            GL11.glColor4f(1F, 1F, 1F, 1F);


            if(Player != null) {

                ChatRanks Rank = Channel.GetPlayerRank(Player);

                if (Rank.color != null) {


                    GL11.glPushMatrix();
                    Color c = Rank.color;

                    float r = (float) ((double) c.getRed() / (double) 255), g = (float) ((double) c.getGreen() / (double) 255), b = (float) ((double) c.getBlue() / (double) 255);

                    GL11.glColor4f(r, g, b, 1F);

                    drawTexturedModalRect((this.xPosition - 2), (this.yPosition - 2), 22, 153, 11, 11);

                    GL11.glColor4f(1F, 1F, 1F, 1F);

                    float scale = 0.5F;
                   // GL11.glScalef(scale, scale, scale);
                    fontRendererObj.drawString("  " + Player.getDisplayName(), (this.xPosition + 2), (this.yPosition ), c.getRGB());

                    GL11.glPopMatrix();


                } else {
                    float scale = 0.5F;
                   // GL11.glScalef(scale, scale, scale);
                    fontRendererObj.drawString(Player.getDisplayName(), this.xPosition, (this.yPosition + 2), 24737632);
                }


            }


        }
    }
}
