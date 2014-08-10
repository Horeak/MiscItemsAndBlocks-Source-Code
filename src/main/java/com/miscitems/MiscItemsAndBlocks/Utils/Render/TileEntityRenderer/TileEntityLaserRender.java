package com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaser;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserUtil;
import com.miscitems.MiscItemsAndBlocks.Utils.Render.Entity.LaserRender;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class TileEntityLaserRender extends TileEntitySpecialRenderer {

    public void renderLaser(TileEntityLaser laser, double x, double y, double z, float tick) {
     if(!laser.getWorldObj().isBlockIndirectlyGettingPowered(laser.xCoord, laser.yCoord, laser.zCoord) || !laser.Valid)
     return;
    
     GL11.glPushMatrix();
     LaserRender.preLaserRender();

        AxisAlignedBB laserOutline = LaserUtil.getLaserOutline(laser, laser.getBlockMetadata(), x, y, z);
        
     GL11.glColor4f((float)(laser.Red) / 255, (float)(laser.Green) / 255, (float)(laser.Blue) / 255, 0.4F);
     LaserRender.drawBoundingBox(laserOutline);
     LaserRender.drawBoundingBox(laserOutline.contract(0.12D, 0.12D, 0.12D));



     LaserRender.postLaserRender();
        GL11.glPopMatrix();
        

    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        renderLaser((TileEntityLaser)tileEntity, x, y, z, tick);
    }
}