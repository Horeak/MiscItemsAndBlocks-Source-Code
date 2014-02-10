package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;

import com.miscitems.MiscItemsAndBlocks.Misc.ItemHelper;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileWithItemUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTypeHandler;

public class TileEntityItemPedestal extends TileEntityInvBase implements IInventory{


	public TileEntityItemPedestal() {
		super(1, "Pedestal", 64);
	}

	//TODO
//	   @Override
//	    public Packet getDescriptionPacket() {
//
//	        ItemStack itemStack = getStackInSlot(0);
//
//	        if (itemStack != null && itemStack.stackSize > 0)
//	            return PacketTypeHandler.populatePacket(new PacketTileWithItemUpdate(xCoord, yCoord, zCoord, orientation, state, customName, itemStack.itemID, itemStack.getItemDamage(), itemStack.stackSize, ItemHelper.getColor(itemStack)));
//	        else
//	            return super.getDescriptionPacket();
//	    }
  	
  	
}
