package com.miscitems.MiscItemsAndBlocks.Slots;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgrades;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModSlotChipSlot extends Slot{

	public ModSlotChipSlot(IInventory par1iInventory, int par2, int par3,
			int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	public boolean isItemValid(ItemStack stack)
    {
        return stack.getItem() instanceof ModItemDataChip;
    }
    
    public IIcon getBackgroundIconIndex()
    {
        return ModItemUpgrades.ChipSlot;
    }
    
    public int getSlotStackLimit()
    {
        return 1;
    }

}
