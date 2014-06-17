package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningStation;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockMiningStation extends ModBlockPowerMachine{

    public ModBlockMiningStation() {
		super(Material.rock);
		this.setHardness(2F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityMiningStation();
	}

	
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Reference.Mod_Id+ ":MiningStation");
        
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
   
    
    @Override
    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
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
		super.breakBlock(World, x, y, z, id, meta);
    }
}
