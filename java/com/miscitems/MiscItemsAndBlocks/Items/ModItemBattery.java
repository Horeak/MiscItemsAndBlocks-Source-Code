package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModItemBattery extends ModItemPowerStorage{

	public ModItemBattery() {
		this.setMaxDamage(16);

	}
	
	IIcon Icon1;
	IIcon Icon2;
	IIcon Icon3;
	IIcon Icon4;
	IIcon Icon5;
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   
		   Icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BatteryEmpty");
		   Icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Battery1");
		   Icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Battery2");
		   Icon4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Battery3");
		   Icon5 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BatteryFull");
		   
	   }
	   
		@Override
	    public IIcon getIconFromDamage(int Damage)
	    {
			if(Damage == 16) {
				return Icon1;
			}
			
			if(Damage > 8 && Damage <= 15) {
				return Icon2;
			}
			
			if(Damage > 4 && Damage <= 8) {
				return Icon3;
			}
			
			if(Damage > 0 && Damage <= 4) {
				return Icon4;
			}

			if(Damage == 0) {
				return Icon5;
			}
			
			
			
			
			
			return Icon1;
			
	    }
	   
		@Override
		public int MaxPower(ItemStack stack) {
			return 16;
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
