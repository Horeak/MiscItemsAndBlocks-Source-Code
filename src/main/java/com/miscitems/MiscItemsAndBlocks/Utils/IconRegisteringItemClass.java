package com.miscitems.MiscItemsAndBlocks.Utils;

import com.miscitems.MiscItemsAndBlocks.Utils.References.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class IconRegisteringItemClass extends Item {




    public static IIcon EmptySlot;
    public static IIcon LiquidSlot;
    public static IIcon FruitSlot;
    public static IIcon ChipSlot;

    public static IIcon BatterySlot;
    public static IIcon RedstoneSlot;
    public static IIcon LapisSlot;


    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {


        this.EmptySlot = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "EmptyUpgradeSlot");

        LiquidSlot = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "LiquidSlot");
        FruitSlot = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "FruitSlot");
        ChipSlot = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "ChipSlot");

        BatterySlot = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "BatterySlot");
        RedstoneSlot = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "RedstoneSlot");
        LapisSlot = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "LapisSlot");




    }
}
