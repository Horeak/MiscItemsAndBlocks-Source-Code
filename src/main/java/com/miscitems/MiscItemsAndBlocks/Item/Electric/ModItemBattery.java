package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

public class ModItemBattery extends ModItemPowerStorage{

	public ModItemBattery() {

	}


	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
           super.registerIcons(par1IconRegister);
		   
		   itemIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":Battery");

		   
	   }

	   
		@Override
		public double MaxPower(ItemStack stack) {
			return 16;
		}

		@Override
		public double ChargeAmount(ItemStack stack) {
			return 1;
		}

		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return false;
		}

}
