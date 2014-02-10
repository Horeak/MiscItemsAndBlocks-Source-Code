package com.miscitems.MiscItemsAndBlocks.TileEntityRenderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlockTable;
import com.miscitems.MiscItemsAndBlocks.Models.TableModel;

public class TileEntityTableRender extends TileEntitySpecialRenderer {
    
    private final TableModel model;
   
    public TileEntityTableRender() {
            this.model = new TableModel();
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
            
            
            bindTexture(new ResourceLocation("miscitems" , "textures/models/TableModel.png"));
            
            
         GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
            
            
            
            
            if(te.hasWorldObj()){
            	
            	
                World world = te.getWorldObj();
                int X = te.xCoord;
                int Y = te.yCoord;
                int Z = te.zCoord;
            	
            	   boolean front, back, right, left;
            	   boolean Tablefront, Tableback, Tableright, Tableleft;
                   
                   
                   front = IsTableWWool(world, X, Y, Z + 1);
                   back = IsTableWWool(world, X, Y, Z - 1);
                   right = IsTableWWool(world, X - 1, Y, Z);
                   left = IsTableWWool(world, X + 1, Y, Z);
                   
                   Tablefront = IsTable(world, X, Y, Z + 1);
                   Tableback = IsTable(world, X, Y, Z - 1);
                   Tableright = IsTable(world, X - 1, Y, Z);
                   Tableleft = IsTable(world, X + 1, Y, Z);
            	

                this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, te.getWorldObj().getBlockMetadata(te.xCoord, te.yCoord, te.zCoord) == 1, right, left, front, back, Tablefront, Tableback, Tableright, Tableleft);
            }else{
                this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, true, false, false, false, false, false, false, false, false);
            }
            

            GL11.glPopMatrix();
            GL11.glPopMatrix();
    }
     

   public boolean IsTableWWool(World world, int x, int y, int z){
    	
    	Block BlockID = world.getBlock(x, y, z);
    	int MetaData = world.getBlockMetadata(x, y, z);
    	
    	Block block = BlockID;
    	
    	if(block instanceof ModBlockTable && MetaData > 0)return true;

    	
    	return false;
    }
   
   public boolean IsTable(World world, int x, int y, int z){
   	
   	Block BlockID = world.getBlock(x, y, z);
   	
   	Block block = BlockID;
   	
   	if(block instanceof ModBlockTable)return true;

   	
   	return false;
   }
}