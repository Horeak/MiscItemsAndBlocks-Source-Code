package com.miscitems.MiscItemsAndBlocks.Items.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlockColoredMetalBrick;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
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

    public String getUnlocalizedName(ItemStack stack)
    {
        return "item.coloredbrick";
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        return ModBlockColoredMetalBrick.Icons[meta];
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        return ModBlockColoredMetalBrick.Colors[stack.getItemDamage()] + " " + StatCollector.translateToLocal("item.coloredbrick.name");
    }
}
