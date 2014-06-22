package com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots;

import com.miscitems.MiscItemsAndBlocks.Utils.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

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
        return IconRegisteringItemClass.LapisSlot;
    }
    
}