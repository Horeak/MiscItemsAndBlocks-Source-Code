package com.miscitems.MiscItemsAndBlocks.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityStorageBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.List;

public class ModItemBlockStorageBlock extends ItemBlock {

	public ModItemBlockStorageBlock(Block par1) {
		super(par1);
	}

	
	 public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	    {
	      
		 if(stack.stackTagCompound != null){
			 world.setBlock(x, y, z, ModBlocks.StorageBlock);
			 if(world.getTileEntity(x, y, z) != null){
				 TileEntityStorageBlock tile = (TileEntityStorageBlock)world.getTileEntity(x, y, z);
				 
				 NBTTagList nbttaglist = stack.stackTagCompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
			        for (int i = 0; i < nbttaglist.tagCount(); i++)
			        {
			            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			            int j = nbttagcompound1.getByte("Slot") & 0xff;
			            if (j >= 0 && j < tile.getSizeInventory())
			            {
			            	tile.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
			            }
			        }
			 }
			 
			 
		 }else{
			 world.setBlock(x, y, z, ModBlocks.StorageBlock); 
		 }

            ModBlocks.StorageBlock.onBlockPlacedBy(world, x, y, z, player, stack);
	       return true;
	    }
	 
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	
	    	if(itemstack.stackTagCompound != null){


	    		if(itemstack.stackTagCompound.getInteger("ItemsNumber") == 0){
	    			itemstack.setTagCompound(null);
	    		}
	    		
				
					list.add("Stored stacks " + itemstack.stackTagCompound.getInteger("ItemsNumber") + " of " + itemstack.stackTagCompound.getInteger("MaxItems"));

	    		
	    		
	    	}else{
    			list.add("Storage is empty");
	    	}
	    }
}
