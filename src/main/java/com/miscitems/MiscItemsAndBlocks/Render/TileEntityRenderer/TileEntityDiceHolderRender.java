package com.miscitems.MiscItemsAndBlocks.Render.TileEntityRenderer;

import com.miscitems.MiscItemsAndBlocks.Models.DiceHolderModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TileEntityDiceHolderRender extends TileEntitySpecialRenderer {
    
    private final DiceHolderModel model;
   
    public TileEntityDiceHolderRender() {
            this.model = new DiceHolderModel();
    }
   
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            
            
            bindTexture(new ResourceLocation("miscitems" , "textures/models/DiceHolder.png"));
            
            
         GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
            
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, te.getWorldObj().getBlockMetadata(te.xCoord, te.yCoord, te.zCoord), false);
            
            
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    }
     
}