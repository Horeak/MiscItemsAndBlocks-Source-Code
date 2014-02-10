package com.miscitems.MiscItemsAndBlocks.Slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ModSlotOutput extends Slot{

	public ModSlotOutput(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}

    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return false;
    }
}
