package com.miscitems.MiscItemsAndBlocks.Block.Decorative;

import MiscUtils.Block.ModBlock;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.awt.*;

public class ModBlockColorBlock extends ModBlock {



    public ModBlockColorBlock() {
        super(Material.glass);
    }





    public int damageDropped(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, java.util.List p_149666_3_)
    {
        for(int i = 0; i < ItemDye.field_150922_c.length; i++)
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        if (((world instanceof World)) &&
                (!((World)world).blockExists(x, y, z))) {
            return 0;
        }


            return getLightLevel(world.getBlockMetadata(x,y,z));

    }

    public static int getLightLevel(int metadata)
    {
        Color c  = new Color(ItemDye.field_150922_c[15 - metadata]);

        if(metadata == 15)
            c = new Color(0,0,0);


        return (int)(((float)(c.getRed() / 255) + (float)(c.getBlue() / 255) + (float)(c.getGreen() / 255)) / 3.0F * 15.0F);
    }


    @SideOnly(Side.CLIENT)
    public int getRenderColor(int Meta)
    {
        int m = 15 - Meta;

        if(m < 0)
            m = 0;

        Color c = new Color(ItemDye.field_150922_c[m]);

        if(Meta == 15)
            c = new Color(0,0,0);

        return c.getRGB();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
    {

        return getRenderColor(world.getBlockMetadata(x,y,z));
    }

    public boolean isNormalCube(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    public int getRenderType()
    {
        return Main.proxy.RenderColorBlock;
    }
}
