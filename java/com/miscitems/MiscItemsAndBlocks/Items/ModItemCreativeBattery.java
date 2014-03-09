package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ModItemCreativeBattery extends ModItemPowerStorage{

	public ModItemCreativeBattery() {
		this.setMaxDamage(-1);

	}
	

	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   

		   itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":CreativeBattery");
	   }
	   

	   
		@Override
		public int MaxPower(ItemStack stack) {
			return -1;
		}

		@Override
		public int ChargeAmount(ItemStack stack) {
			return 1;
		}

		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return false;
		}
		
	    @SuppressWarnings("rawtypes")
		public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
	    {

	    	list.add(new ItemStack(par1, 1, 0));
	    }
}
