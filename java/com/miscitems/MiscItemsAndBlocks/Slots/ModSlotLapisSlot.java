package com.miscitems.MiscItemsAndBlocks.Slots;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemBattery;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgrades;

public class ModSlotLapisSlot extends Slot{

	public ModSlotLapisSlot(IInventory par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
	public boolean isItemValid(ItemStack stack)
    {
		
		if(stack.getItem() == Items.dye){
			if(stack.getItemDamage() == 4)
				return true;
			
		}
        return false;
    }
    
    public IIcon getBackgroundIconIndex()
    {
        return ModItemUpgrades.LapisSlot;
    }
    
}