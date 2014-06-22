package com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots;

import com.miscitems.MiscItemsAndBlocks.Utils.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;

public class SlotFruit extends Slot{

	public SlotFruit(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}

	
    public IIcon getBackgroundIconIndex()
    {
        return IconRegisteringItemClass.FruitSlot;
    }
}
