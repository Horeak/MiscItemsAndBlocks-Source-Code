package com.miscitems.MiscItemsAndBlocks.Items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemTomato extends ItemFood{

	public ModItemTomato(int par2, float par3, boolean par4) {
		super(par2, par3, par4);
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Tomato");
		   
	   }
	   

	
	

}
