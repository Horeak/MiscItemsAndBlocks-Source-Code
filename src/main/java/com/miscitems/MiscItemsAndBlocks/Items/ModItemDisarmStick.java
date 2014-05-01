package com.miscitems.MiscItemsAndBlocks.Items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ModItemDisarmStick extends Item{

	public ModItemDisarmStick() {
		super();
	}
	
    public boolean hitEntity(ItemStack stack, EntityLivingBase EntityHit, EntityLivingBase EntityAttacker)
    {
    	
    	if(EntityAttacker instanceof EntityPlayer){
    		EntityPlayer playr = (EntityPlayer)EntityAttacker;
    		if(playr.capabilities.isCreativeMode){
    	
    	if(EntityHit instanceof EntityPlayer){
    		EntityPlayer player = (EntityPlayer)EntityHit;
    		
    		player.inventory.dropAllItems();
    	}else{
    		EntityHit.onDeath(new DamageSource("disarmed"));
    		EntityHit.setDead();
    	}
    	
    		}
    	}
    	return false;
    }
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            list.add(StatCollector.translateToLocal("items.desc.disarmstick.1"));
            list.add(StatCollector.translateToLocal("items.desc.disarmstick.2"));
    }
    
    public void registerIcons(IIconRegister par1IconRegister)
    {
    	
        this.itemIcon = par1IconRegister.registerIcon("stick");
        
    }


}
