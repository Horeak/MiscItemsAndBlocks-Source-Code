package com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative;

import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileWithItemUpdate;
import MiscUtils.TileEntity.TileEntityInvBase;
import MiscUtils.Utils.ItemHelper;
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
            return PacketHandler.GetPacket(new PacketTileWithItemUpdate(xCoord, yCoord, zCoord, orientation, state, customName, itemStack.getItem().getIdFromItem(itemStack.getItem()), itemStack.getItemDamage(), itemStack.stackSize, ItemHelper.getColor(itemStack)), Main.channels);
        else
            return super.getDescriptionPacket();
    }
  	
  	
}
