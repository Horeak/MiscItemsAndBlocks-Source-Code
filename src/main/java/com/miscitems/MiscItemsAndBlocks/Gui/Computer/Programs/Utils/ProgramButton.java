package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import com.miscitems.MiscItemsAndBlocks.Gui.Computer.ProgramIconInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class ProgramButton extends GuiButton{

    ProgramIconInfo icon;

    public ProgramButton(int id, int x, int y, ProgramIconInfo ic) {
        super(id, x, y, 16, 16, "");
        icon = ic;
    }

    public void drawButton(Minecraft par1Minecraft, int p_146112_2_, int p_146112_3_)
    {
        if (this.visible)
        {

            FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(icon.GetTexture());
            GL11.glColor4f(0.9F, 0.9F, 0.9F, 1.0F);

            drawTexturedModalRect(this.xPosition, this.yPosition, icon.GetX(), icon.GetY(), 16, 16);




        }
    }
}
