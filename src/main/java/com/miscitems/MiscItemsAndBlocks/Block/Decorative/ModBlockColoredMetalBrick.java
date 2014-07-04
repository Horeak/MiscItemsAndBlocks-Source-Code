package com.miscitems.MiscItemsAndBlocks.Block.Decorative;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

import java.awt.*;
import java.util.List;

public class ModBlockColoredMetalBrick extends Block {



    public int damageDropped(int par1)
    {
        return par1;
    }

    public MapColor getMapColor(int p_149728_1_)
    {
        return MapColor.getMapColorForBlockColored(p_149728_1_);
    }

    public ModBlockColoredMetalBrick() {
        super(Material.iron);
        this.setHardness(1.8F);
        this.setCreativeTab(Main.MiscTab);

    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {

        for (int i = 0; i < 16; ++i)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }



    public int colorMultiplier(IBlockAccess block, int x, int y, int z)
    {
       int Meta = block.getBlockMetadata(x,y,z);

        return new Color(ItemDye.field_150922_c[15 - Meta]).getRGB();

    }
}
