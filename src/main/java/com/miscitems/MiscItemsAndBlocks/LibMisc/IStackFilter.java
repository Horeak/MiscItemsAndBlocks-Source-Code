package com.miscitems.MiscItemsAndBlocks.LibMisc;

import net.minecraft.item.ItemStack;

public interface IStackFilter {

    public boolean matches(ItemStack stack);
}