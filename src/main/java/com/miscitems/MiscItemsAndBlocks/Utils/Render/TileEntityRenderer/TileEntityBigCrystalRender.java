package com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer;

import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBigCrystal;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * Automatic file template
 * File was created 22.07.2014 at 12:43
 * Class is located in package com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer
 *
 * @author tm1990
 */
public class TileEntityBigCrystalRender extends TileEntitySpecialRenderer {

    private final IModelCustom model;

    public TileEntityBigCrystalRender() {
        model = AdvancedModelLoader.loadModel(new ResourceLocation("miscitems", "Models/BigCrystal.obj"));
    }


    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.3, y + 0.5, z + 0.3);
        GL11.glScalef(0.8F, 0.8F, 0.8F);

        TileEntityBigCrystal tile = (TileEntityBigCrystal)te;

        bindTexture(new ResourceLocation("textures/blocks/quartz_block_top.png"));

        GL11.glPushMatrix();

        //TODO Make model change color(switch between Red, Green And Blue (with all colors inbetween)), And make model rotate
        Color c = new Color(255, 0, 0);

        float Red = (c.getRed() / 255), Green = (c.getGreen() / 255), Blue = (c.getBlue() / 255);
        GL11.glColor4f(Red, Green, Blue, 0.2F);
        model.renderAll();


        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }


}