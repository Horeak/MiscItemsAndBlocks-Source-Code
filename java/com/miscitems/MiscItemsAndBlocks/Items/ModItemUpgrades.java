package com.miscitems.MiscItemsAndBlocks.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemUpgrades extends ModItemUpgradeItem{

	IIcon[] icons = new IIcon[10];
	
	public ModItemUpgrades() {
		super();
		this.maxStackSize = 16;

	}
	
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
		
	    
	    this.icons[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "PowerUpgrade");
	    
	    
	    this.EmptySlot = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "EmptyUpgradeSlot");
	    
   	 LiquidSlot = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "LiquidSlot");
   	 FruitSlot = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "FruitSlot");
   	 ChipSlot = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ChipSlot");
   	 
   	BatterySlot = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "BatterySlot");
   	RedstoneSlot = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "RedstoneSlot");
   	LapisSlot = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "LapisSlot");


	}

	public IIcon getIconFromDamage(int meta)
	{
			return icons[meta];

	}

	public String getItemDisplayName(ItemStack stack)
	{
		int meta = stack.getItemDamage();

		
		if(meta == 0)return StatCollector.translateToLocal("items.name.upgrades.power");
		
		
		
		return null;
	}

	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
	{
	    super.getSubItems(par1, par2CreativeTabs, list);
	    
	    
	}


}
