package com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer;

import com.miscitems.MiscItemsAndBlocks.Models.LaserReciverModel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaserReciver;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TileEntityLaserReciverRender extends TileEntitySpecialRenderer {
    
    private final LaserReciverModel model;
   
    public TileEntityLaserReciverRender() {
            this.model = new LaserReciverModel();
    }
   
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
            int meta = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            GL11.glRotatef(meta * (- 90), 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
    }
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
    	if(te instanceof TileEntityLaserReciver){
    		TileEntityLaserReciver tile = (TileEntityLaserReciver)te;
    	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            
            
            bindTexture(new ResourceLocation("miscitems" , "textures/models/LaserReciver.png"));
            
            GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
            	int Meta = tile.getBlockMetadata();
            	int face = Meta == 2 ? 0 : Meta == 3 ? 2 : Meta == 4 ? 3 : Meta == 5 ? 5 : 0;
            	
            GL11.glRotatef((face * 90F), 0.0F, 1.0F, 0.0F);
            

            
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            
    	}
    }
    	
     
    
}