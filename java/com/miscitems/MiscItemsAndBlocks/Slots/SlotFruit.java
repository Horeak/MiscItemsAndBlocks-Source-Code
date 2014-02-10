package com.miscitems.MiscItemsAndBlocks.Slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.util.IIcon;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgrades;

public class SlotFruit extends Slot{

	public SlotFruit(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}

	
    public IIcon getBackgroundIconIndex()
    {
        return ModItemUpgrades.FruitSlot;
    }
}
