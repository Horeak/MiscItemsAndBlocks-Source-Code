package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModItemBigBattery extends ModItemPowerStorage{

	public ModItemBigBattery() {
		super();
		this.setMaxDamage(32);
	}

	
	IIcon Icon1;
	IIcon Icon2;
	IIcon Icon3;
	IIcon Icon4;
	IIcon Icon5;
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   
		   Icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBatteryEmpty");
		   Icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBattery1");
		   Icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBattery2");
		   Icon4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBattery3");
		   Icon5 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BigBatteryFull");
		   
	   }
	   
		@Override
	    public IIcon getIconFromDamage(int Damage)
	    {
			if(Damage == 32) {
				return Icon1;
			}
			
			if(Damage > 12 && Damage <= 31) {
				return Icon2;
			}
			
			if(Damage > 6 && Damage <= 12) {
				return Icon3;
			}
			
			if(Damage > 0 && Damage <= 6) {
				return Icon4;
			}

			if(Damage == 0) {
				return Icon5;
			}
			
			
			
			
			
			return Icon1;
			
	    }
	   
		
		@Override
		public int MaxPower(ItemStack stack) {
			return 32;
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
