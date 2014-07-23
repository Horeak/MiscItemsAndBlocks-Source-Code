package com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Magic.TileEntityPowerCrystal;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class TileEntityPowerCrystalRender extends TileEntitySpecialRenderer {

    private final IModelCustom model;

    public TileEntityPowerCrystalRender() {
        model = AdvancedModelLoader.loadModel(new ResourceLocation("miscitems", "Models/BigCrystal.obj"));
    }


    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {

        TileEntityPowerCrystal tile = (TileEntityPowerCrystal)te;

        if(tile.Bottom) {
            GL11.glPushMatrix();
            GL11.glTranslated(x + 0.53, y + 1.1 + ((double) tile.Height / (double) 140), z + 0.53);
            GL11.glScalef(0.8F, 0.8F, 0.8F);

            GL11.glRotatef((tile.Rotation) * 2F, 0F, 1F, 0F);


            bindTexture(new ResourceLocation("miscitems", "textures/models/BigCrystalAlphaTexture.png"));

            GL11.glPushMatrix();

            //TODO Make model change color(switch between Red, Green And Blue (with all colors inbetween)), And make model rotate

            int r = tile.Red, g = tile.Green, b = tile.Blue;

            if (r > 255)
                r = 255;

            if (g > 255)
                g = 255;

            if (b > 255)
                b = 255;

            Color c = new Color(r, g, b);

            float Red = ((float) c.getRed() / (float) 255), Green = ((float) c.getGreen() / (float) 255), Blue = ((float) c.getBlue() / (float) 255);


            GL11.glColor4f(Red, Green, Blue, 1F);

            model.renderAll();



            GL11.glPopMatrix();
            GL11.glPopMatrix();

        }
    }


}