package com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots;

import com.miscitems.MiscItemsAndBlocks.Items.*;
import com.miscitems.MiscItemsAndBlocks.Utils.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

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
        return IconRegisteringItemClass.ChipSlot;
    }
    
    public int getSlotStackLimit()
    {
        return 1;
    }

}
