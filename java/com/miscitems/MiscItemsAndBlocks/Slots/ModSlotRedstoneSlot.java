package com.miscitems.MiscItemsAndBlocks.Slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgrades;

public class ModSlotRedstoneSlot extends Slot{

	public ModSlotRedstoneSlot(IInventory par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	public boolean isItemValid(ItemStack stack)
    {
        return stack.getItem() instanceof ItemRedstone;
    }
    
    public IIcon getBackgroundIconIndex()
    {
        return ModItemUpgrades.RedstoneSlot;
    }
    
}