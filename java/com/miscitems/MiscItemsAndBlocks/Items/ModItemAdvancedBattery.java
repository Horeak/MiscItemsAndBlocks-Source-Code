package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModItemAdvancedBattery extends ModItemPowerStorage{

	public ModItemAdvancedBattery() {
		super();
		this.setMaxDamage(64);
	}

	
	@Override
	public int MaxPower(ItemStack stack) {
		return 64;
	}
	
	IIcon Icon1;
	IIcon Icon2;
	IIcon Icon3;
	IIcon Icon4;
	IIcon Icon5;
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister par1IconRegister)
	   {
		   
		   Icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBatteryEmpty");
		   Icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBattery1");
		   Icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBattery2");
		   Icon4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBattery3");
		   Icon5 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":AdvancedBatteryFull");
		   
	   }
	   
		@Override
	    public IIcon getIconFromDamage(int Damage)
	    {
			if(Damage == 64) {
				return Icon1;
			}
			
			if(Damage > 32 && Damage <= 63) {
				return Icon2;
			}
			
			if(Damage > 16 && Damage <= 32) {
				return Icon3;
			}
			
			if(Damage > 0 && Damage <= 16) {
				return Icon4;
			}

			if(Damage == 0) {
				return Icon5;
			}
			
			
			
			
			
			return Icon1;
			
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
