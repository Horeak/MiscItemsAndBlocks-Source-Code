package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGhostBlock extends TileEntity{

	
	public Block Camo;
	public int Meta;
	
	
	//TODO //FIXME Try to find a way to encode block id in meta data
//	public void updateEntity(){
//	}
	
	 public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);

		  Camo = Block.getBlockById(NBT.getInteger("BLID"));
		  
		  Meta = NBT.getInteger("Meta");

	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);
	      
	      NBT.setInteger("BLID", Block.getIdFromBlock(Camo));
	      
	      NBT.setInteger("Meta", Meta);

	    }
	    
	    
}
