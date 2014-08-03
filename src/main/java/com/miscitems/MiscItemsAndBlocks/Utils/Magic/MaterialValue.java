package com.miscitems.MiscItemsAndBlocks.Utils.Magic;

import net.minecraft.item.ItemStack;

public class MaterialValue {

    public ItemStack stack;
    public double Value;


    public MaterialValue(ItemStack stack, double Value){
        this.stack = stack;
        this.Value = Value;
    }
}
