package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ModItemPowerArmor extends ItemArmor {

    private String iconName;
    private int ArmorTypeNumber;
    
    private static ArmorMaterial material = ModItems.PowerArmor;
    
    public ModItemPowerArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, int par5, String Icon) {
        super(par2EnumArmorMaterial, par3, par4);
        iconName = Icon;

    }


    @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IIconRegister par1IconRegister)
        {
            this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + iconName);
            
        }
        


    

    
    @SideOnly(Side.CLIENT)
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
    	
    	if(stack.getItem() == ModItems.FlightChestPlate || stack.getItem() == ModItems.DivingHelmet || stack.getItem() == ModItems.JumpingBoots){
    		return Refrence.Mod_Id + ":" + "textures/models/armor/PowerArmor_layer_1.png";

    	}
    	if(stack.getItem() == ModItems.RunningLeggings){
    		
    		return Refrence.Mod_Id + ":" + "textures/models/armor/PowerArmor_layer_2.png";
    		
    	}else{
    		
    		
		return null;
    	}
    }
    
    public boolean getIsRepairable(ItemStack ItemToRepair, ItemStack RepairItem)
    {
        return RepairItem.getItem() == ModItems.SilverIngot;
    }
    
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
		list.add("");
		
    	if(itemstack.getItem() == ModItems.DivingHelmet){

    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.helmet.1"));
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.helmet.2"));
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.helmet.3"));
    		
    	}else if(itemstack.getItem() == ModItems.FlightChestPlate){
    		
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.chestplate.1"));
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.chestplate.2"));
    		
    	}else if(itemstack.getItem() == ModItems.RunningLeggings){
    		
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.leggings.1"));
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.leggings.2"));
    		
    	}else if(itemstack.getItem() == ModItems.JumpingBoots){
    		
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.boots.1"));
    		list.add(StatCollector.translateToLocal("items.desc.powerarmor.boots.2"));
    		
    	}
    	
    	
    	
    	
    }
    
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack){
    	
    	if(itemStack.getItem() == ModItems.FlightChestPlate){

    		player.getEntityData().setBoolean("HadFlightChest", true);
    		
    	}
    }

    
    }


