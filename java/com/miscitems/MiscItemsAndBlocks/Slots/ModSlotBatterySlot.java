package com.miscitems.MiscItemsAndBlocks.Slots;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemPowerStorage;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgrades;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModSlotBatterySlot extends Slot{

	public ModSlotBatterySlot(IInventory par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	public boolean isItemValid(ItemStack stack)
    {
        return stack.getItem() instanceof ModItemPowerStorage;
    }
    
    public IIcon getBackgroundIconIndex()
    {
        return ModItemUpgrades.BatterySlot;
    }
}
