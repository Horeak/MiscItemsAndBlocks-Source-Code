package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileWithItemUpdate;
import com.miscitems.MiscItemsAndBlocks.Utils.ItemHelper;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;

public class TileEntityItemPedestal extends TileEntityInvBase implements IInventory{


	public TileEntityItemPedestal() {
		super(1, "Pedestal", 64);
	}

    @Override
    public Packet getDescriptionPacket() {

        ItemStack itemStack = getStackInSlot(0);

        if (itemStack != null && itemStack.stackSize > 0)
            return PacketHandler.GetPacket(new PacketTileWithItemUpdate(xCoord, yCoord, zCoord, orientation, state, customName, itemStack.getItem().getIdFromItem(itemStack.getItem()), itemStack.getItemDamage(), itemStack.stackSize, ItemHelper.getColor(itemStack)));
        else
            return super.getDescriptionPacket();
    }
  	
  	
}
