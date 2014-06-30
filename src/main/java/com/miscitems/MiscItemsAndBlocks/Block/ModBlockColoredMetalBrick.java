package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ModBlockColoredMetalBrick extends Block {

    public static String[] Colors = new String[]{"White", "Blue", "Green", "Red", "Yellow"};
    public static IIcon[] Icons = new IIcon[Colors.length];

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

        for (int i = 0; i < Colors.length; ++i)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {


        for (int i = 0; i < this.Colors.length; ++i)
        {
            this.Icons[i] = p_149651_1_.registerIcon(Reference.Mod_Id + ":" + Colors[i] + "Brick");
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return Icons[p_149691_2_];
    }
}
