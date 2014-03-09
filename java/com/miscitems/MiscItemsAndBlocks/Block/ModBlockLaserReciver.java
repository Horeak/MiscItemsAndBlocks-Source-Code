package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaserReciver;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockLaserReciver extends BlockContainer{

	protected ModBlockLaserReciver() {
		super(Material.iron);
		this.setHardness(1F);
	}
	
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
    	int Meta = world.getBlockMetadata(x, y, z);
    	
    	if(Meta == 2){
    		this.setBlockBounds(0.1F, 0.1F, 0.7F, 0.9F, 0.9F, 1F);
    		
    	}else if (Meta == 3){
    		this.setBlockBounds(0.1F, 0.1F, 0F, 0.9F, 0.9F, 0.3F);
    		
    	}else if (Meta == 4){
    		
    		this.setBlockBounds(0.7F, 0.1F, 0.1F, 1F, 0.9F, 0.9F);
    		
    	}else if (Meta == 5){
    		
    		this.setBlockBounds(0F, 0.1F, 0.1F, 0.3F, 0.9F, 0.9F);
    		
    	}else{
    		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
    	}
    	
    	
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityLaserReciver();
	}

	
	 private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
	    {
	        if (!p_149930_1_.isRemote)
	        {
	            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
	            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
	            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
	            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
	            byte b0 = 3;

	            if (block.func_149730_j() && !block1.func_149730_j())
	            {
	                b0 = 3;
	            }

	            if (block1.func_149730_j() && !block.func_149730_j())
	            {
	                b0 = 2;
	            }

	            if (block2.func_149730_j() && !block3.func_149730_j())
	            {
	                b0 = 5;
	            }

	            if (block3.func_149730_j() && !block2.func_149730_j())
	            {
	                b0 = 4;
	            }

	            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
	        }
	    }
	  
	    public void onBlockAdded(World par1World, int par2, int par3, int par4)
	    {
	        super.onBlockAdded(par1World, par2, par3, par4);
	        this.func_149930_e(par1World, par2, par3, par4);
	     
	    }
	
 
	    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
	    {
	    	
	    	 if(side == 2)
	    		return world.getBlock(x, y, z + 1).isOpaqueCube();
	    	
	    	
	    	else if(side == 3)
	    		return world.getBlock(x, y, z - 1).isOpaqueCube();
	    	
	    	
	    	else if(side == 4)
	    		return world.getBlock(x + 1, y, z).isOpaqueCube();
	    	
	    	
	    	else if(side == 5)
	    		return world.getBlock(x - 1, y, z).isOpaqueCube();
	    	
	    	
	    	
	    	
	        return false;
	    }
	    
	    
 public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
 {
     int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

     if (l == 0)
     {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
     }

     if (l == 1)
     {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
     }

     if (l == 2)
     {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
     }

     if (l == 3)
     {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
     }

 }
	
	@Override
	public void breakBlock(World World, int x, int y, int z, Block block, int meta)
	{
		TileEntity tile = World.getTileEntity(x, y, z);
		
		if(tile != null && tile instanceof IInventory){
			IInventory inv = (IInventory)tile;
			
			for(int i = 0; i < inv.getSizeInventory(); i++){
				ItemStack stack = inv.getStackInSlotOnClosing(i);
				
				if(stack != null){
					float spawnX = x + World.rand.nextFloat();
					float spawnY = y + World.rand.nextFloat();
					float spawnZ = z + World.rand.nextFloat();
					
					
					EntityItem droppedItem = new EntityItem(World, spawnX, spawnY, spawnZ, stack);
					
					float mult = 0.05F;
					
					droppedItem.motionX = (-0.5 + World.rand.nextFloat()) * mult;
					droppedItem.motionY = (4 + World.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5 + World.rand.nextFloat()) * mult;
					
					World.spawnEntityInWorld(droppedItem);

				}
				
			}
		}
		super.breakBlock(World, x, y, z, block, meta);
	}
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}

	public boolean isOpaqueCube()
	{
	   return false;
	}


	
    @Override
    public int getRenderType() {
            return -1;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
}
    
    
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int p_149709_5_)
    {
    	TileEntity tilee = world.getTileEntity(x, y, z);
    	
    	if(tilee instanceof TileEntityLaserReciver){
    		TileEntityLaserReciver tile = (TileEntityLaserReciver)tilee;
    		return tile.Redstone ? 16 : 0;
    		
    		
    	}
    	
        return 0;
    }
   
    
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int p_149709_5_)
    {

    	TileEntity tilee = world.getTileEntity(x, y, z);
    	
    	if(tilee instanceof TileEntityLaserReciver){
    		TileEntityLaserReciver tile = (TileEntityLaserReciver)tilee;
    		return tile.Redstone ? 16 : 0;
    		
    		
    	}
    	
        return 0;
    }

}
