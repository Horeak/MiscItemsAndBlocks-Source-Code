package com.miscitems.MiscItemsAndBlocks.Items.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ModItemBlockColoredMetalBrick extends ItemBlock{
    public ModItemBlockColoredMetalBrick(Block p_i45328_1_) {
        super(p_i45328_1_);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int par1)
    {
        return par1;
    }


    public String getItemStackDisplayName(ItemStack stack)
    {
        return StatCollector.translateToLocal("item.fireworksCharge." + ItemDye.field_150923_a[15 - stack.getItemDamage()]) + " " + StatCollector.translateToLocal(stack.getItem().getUnlocalizedName() + ".name");
    }

}
