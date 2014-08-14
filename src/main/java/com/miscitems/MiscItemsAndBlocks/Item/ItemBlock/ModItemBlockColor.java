package com.miscitems.MiscItemsAndBlocks.Item.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ModItemBlockColor extends ItemBlock{


    public ModItemBlockColor(Block p_i45328_1_) {
        super(p_i45328_1_);
    }


    public String getItemStackDisplayName(ItemStack stack)
    {
        int m = 15 - stack.getItemDamage();

        if(m < 0)
            m = 0;

        return StatCollector.translateToLocal("item.fireworksCharge." + ItemDye.field_150923_a[m]) + " " + StatCollector.translateToLocal(stack.getItem().getUnlocalizedName() + ".name");
    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        return super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, stack.getItemDamage());
    }

}
