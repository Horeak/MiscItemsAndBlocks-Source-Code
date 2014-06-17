package com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemUpgrades;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class SlotLiquidContainer extends Slot{

	public SlotLiquidContainer(IInventory par1iInventory, int par2, int par3,
			int par4) {
		super(par1iInventory, par2, par3, par4);
	}
	
    public boolean isItemValid(ItemStack itemstack)
    {
        return itemstack.getItem() == Items.bucket || itemstack.getItem() == Items.glass_bottle;
    }
    
    public IIcon getBackgroundIconIndex()
    {
        return ModItemUpgrades.LiquidSlot;
    }

}
