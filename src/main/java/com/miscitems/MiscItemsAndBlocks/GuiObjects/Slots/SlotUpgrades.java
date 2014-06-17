package com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgradeItem;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgrades;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class SlotUpgrades extends Slot{

	public SlotUpgrades(IInventory par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
	}

    public boolean isItemValid(ItemStack item)
    {

    	return item.getItem() instanceof ModItemUpgradeItem;
    	
    }
    
    public IIcon getBackgroundIconIndex()
    {
        return ModItemUpgrades.EmptySlot;
    }

	
}