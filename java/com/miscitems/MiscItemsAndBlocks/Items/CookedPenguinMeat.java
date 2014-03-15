package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

public class CookedPenguinMeat extends ItemFood{

	public CookedPenguinMeat(int i, int j, boolean b) {
		super(4, true);
	}
	
	@SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":CookedPenguinMeat");

}

}
