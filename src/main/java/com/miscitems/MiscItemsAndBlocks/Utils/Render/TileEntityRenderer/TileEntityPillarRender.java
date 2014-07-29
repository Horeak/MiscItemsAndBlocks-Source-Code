package com.miscitems.MiscItemsAndBlocks.Utils.Render.TileEntityRenderer;

import com.miscitems.MiscItemsAndBlocks.Block.Decorative.ModBlockPillar;
import com.miscitems.MiscItemsAndBlocks.Models.PillarModel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.Utils.PillarUtils;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;



public class TileEntityPillarRender extends TileEntitySpecialRenderer {
    
    private final PillarModel model;
   
    public TileEntityPillarRender() {
            this.model = new PillarModel();
    }
   
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
            int meta = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            GL11.glRotatef(meta * (- 90), 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
    }
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

              TileEntityPillar tile = (TileEntityPillar)te;


        if(tile.ID > PillarUtils.BlU.size())
            tile.ID = 0;

        if(PillarUtils.BlU.size() > 0) {
            Block block = Block.getBlockFromItem(PillarUtils.BlU.get(tile.ID).getItem());

            bindTexture(new ResourceLocation(GameRegistry.findUniqueIdentifierFor(block).modId.toLowerCase(), "textures/blocks/" + (block.getIcon(0, tile.me).getIconName()).replace(GameRegistry.findUniqueIdentifierFor(block).modId + ":", "") + ".png"));

        }
            if(te.hasWorldObj()){
            
            World world = te.getWorldObj();
            int X = te.xCoord;
            int Y = te.yCoord;
            int Z = te.zCoord;
            
            
            boolean top, bottom, front, back, right, left;
            
            bottom = IsPillar(world, X, Y - 1, Z);
            
            top = IsPillar(world, X, Y + 1, Z);
            
            front = IsPillar(world, X, Y, Z + 1);
            
            back = IsPillar(world, X, Y, Z - 1);
            
            right = IsPillar(world, X - 1, Y, Z);
            
            left = IsPillar(world, X + 1, Y, Z);
            
         GL11.glPushMatrix();

                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

                if(top || bottom) {
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, top, bottom);
                }

                if(front || back){
                    GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslatef( 0F, -1F,  -1F);
                    this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, back, front);
                }

                if(right || left){
                    GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef( 1F, -1F,  0F);
                    this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, right, left);

                }

                if(!front && !back && !right && !left && !top && !bottom){
                    this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, false, false);
                }
            
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            }
    }
     
    
    public boolean IsPillar(World world, int x, int y, int z){
    	
    	Block BlockID = world.getBlock(x, y, z);
    	
    	Block block = BlockID;
    	
    	if(block instanceof ModBlockPillar)return true;

    	
    	return false;
    }
}
