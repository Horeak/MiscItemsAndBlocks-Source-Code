package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

public class ModItemAdvancedBattery extends ModItemPowerStorage{

	public ModItemAdvancedBattery() {
	}

	
	@Override
	public int MaxPower(ItemStack stack) {
		return 64;
	}

	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
           super.registerIcons(par1IconRegister);

           itemIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":AdvancedBattery");
		   
	   }



		@Override
		public int ChargeAmount(ItemStack stack) {
			return 1;
		}


		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return false;
		} 

}
