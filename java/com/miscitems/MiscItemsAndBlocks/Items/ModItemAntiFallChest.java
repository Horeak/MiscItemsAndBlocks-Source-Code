package com.miscitems.MiscItemsAndBlocks.Items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemAntiFallChest extends ModItemElArmor{

	public ModItemAntiFallChest(int RenderIndex, int ArmorType) {
		super(RenderIndex, ArmorType);
		this.setCreativeTab(Main.CreativeTab);
		this.setMaxDamage(2453);
	}

	
	   @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	    {
	    	
	    		return Refrence.Mod_Id + ":" + "textures/models/armor/AntiFallArmor_layer_1.png";

	    	
	    }
	   
	   
	   
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
			list.add(StatCollector.translateToLocal("items.desc.antifallchestplate.1"));
			list.add(StatCollector.translateToLocal("items.desc.antifallchestplate.2"));
	    	int i = itemstack.getMaxDamage() - itemstack.getItemDamage();
	    	

            list.add(StatCollector.translateToLocal("items.desc.string.powerleft") + ": " + i);
            if(itemstack.getItemDamage() == itemstack.getMaxDamage())
            	list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("items.desc.string.outofpowerrecharge"));

	    }
	    
	    
	    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack){
	    	
	    	super.onArmorTickUpdate(world, player, itemStack);
	    	
			if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ModItemAntiFallChest)
			if(player.capabilities.isCreativeMode == false){
				int Left = player.inventory.armorInventory[2].getMaxDamage() - player.inventory.armorInventory[2].getItemDamage();
				if(Left > 0){

					
					
						if(player.fallDistance > 2 && player.motionY < 0){
					player.fallDistance = 2;
					if(!player.isSneaking())
					player.motionY = -0.35;
					if(player.worldObj.rand.nextInt(50) == 1)
					player.inventory.armorInventory[2].attemptDamageItem(1, world.rand);
						}
					

				}
				
			}
	    	
	    }
	    
	    
		@Override
		public int MaxPower(ItemStack stack) {
			return 2453;
		}


		@Override
		public int ChargeAmount(ItemStack stack) {
			return 2;
		}


		@Override
		public boolean CanBackpackRecharge(ItemStack stack) {
			return false;
		}
}
