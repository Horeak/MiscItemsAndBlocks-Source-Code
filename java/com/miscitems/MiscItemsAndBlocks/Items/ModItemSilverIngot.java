package com.miscitems.MiscItemsAndBlocks.Items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemSilverIngot extends Item{

	public ModItemSilverIngot() {
		super();
	}

	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":SilverIngot");
		   
	   }
	   

}
