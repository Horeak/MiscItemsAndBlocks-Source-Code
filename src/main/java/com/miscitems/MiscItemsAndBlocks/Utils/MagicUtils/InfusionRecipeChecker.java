package com.miscitems.MiscItemsAndBlocks.Utils.MagicUtils;

import net.minecraft.item.ItemStack;

public class InfusionRecipeChecker {
    public ItemStack[] stack;
    public ItemStack MainItem;

    public InfusionRecipeChecker(ItemStack[] items, ItemStack stack){

        this.stack = items;
        this.MainItem = stack;
    }

}
