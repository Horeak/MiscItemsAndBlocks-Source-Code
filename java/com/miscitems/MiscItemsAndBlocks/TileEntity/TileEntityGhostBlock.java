package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Misc.ItemHelper;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileWithItemUpdate;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGhostBlock extends TileEntity{

	
	public Block Camo;
	public int Meta;
	
	
	//TODO //FIXME Try to find a way to encode block id in meta data (maybe 0x00(blockid) example: 0x00425 == blockid 425)
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
