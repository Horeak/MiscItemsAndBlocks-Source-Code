package com.miscitems.MiscItemsAndBlocks.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public abstract class ModItemPowerStorage extends ModItemPowerTool{

	public ModItemPowerStorage() {
		super(0, ToolMaterial.IRON, null);
		this.setMaxStackSize(1);
	}
	
	
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
    	list.add(StatCollector.translateToLocal("items.desc.powerstorage.1"));
    	list.add(StatCollector.translateToLocal("items.desc.powerstorage.2"));
    	int Damage = itemstack.getMaxDamage() - itemstack.getItemDamage();
    	int MaxDamage = itemstack.getMaxDamage();
    	
    	list.add(StatCollector.translateToLocal("words.power") + ": " + Damage + "/" + MaxDamage);
    	
    	
    }
    
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        return false;
    }
    
    public void onCreated(ItemStack item, World par2World, EntityPlayer par3EntityPlayer) {
    	
    	item.setItemDamage(item.getMaxDamage());
    	
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	
    	return false;
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        
        list.add(new ItemStack(par1, 1, par1.getMaxDamage()));
        
    }


	
	

}
