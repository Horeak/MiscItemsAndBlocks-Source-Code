package com.miscitems.MiscItemsAndBlocks.Block.Electric;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaserReciver;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModBlockLaserReciver extends ModBlockContainer {

    public ModBlockLaserReciver() {
		super(Material.iron);
		this.setHardness(1F);
	}
	
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
    	int Meta = world.getBlockMetadata(x, y, z);
        ForgeDirection dir = ForgeDirection.getOrientation(Meta);

        if(dir == ForgeDirection.UP) {
            this.setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.3F, 0.9F);

        }else if(dir == ForgeDirection.DOWN) {
            this.setBlockBounds(0.1F, 0.7F, 0.1F, 0.9F, 1f, 0.9F);

        }else if(Meta == 2){
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


    public boolean canBlockStay(World world, int x, int y, int z)
    {

            ForgeDirection dir = ForgeDirection.getOrientation(world.getBlockMetadata(x,y,z));
             dir = dir.getOpposite();

            int xCord = x + dir.offsetX;
            int yCord = y + dir.offsetY;
            int zCord = z + dir.offsetZ;

            if(!world.isSideSolid(xCord, yCord, zCord, dir)){
                return false;
            }



        return true;
    }


    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(world.getBlock(x,y,z) == ModBlocks.LaserReciver) {
            if (!canBlockStay((World) world, x, y, z)) {
                world.getBlock(x, y, z).dropBlockAsItem((World) world, x, y, z, world.getBlockMetadata(x, y, z), 1);
                ((World) world).setBlock(x, y, z, Blocks.air, 0, 2);

            }
        }
    }
}
