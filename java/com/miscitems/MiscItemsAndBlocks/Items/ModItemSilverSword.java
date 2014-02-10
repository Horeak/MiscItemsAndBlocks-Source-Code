package com.miscitems.MiscItemsAndBlocks.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemSilverSword extends ItemSword {

    public ModItemSilverSword(ToolMaterial ToolMaterial){
        super(ToolMaterial);
        setCreativeTab(Main.CreativeTab);
    }
      
    
 
    

    @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IIconRegister par1IconRegister)
        {
            this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "SilverSword");
        }
    
    
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase EntityHit, EntityLivingBase EntityAttacker)
    {
    	
    	
    	

    	
    	if(EntityHit instanceof EntityDragon || EntityHit instanceof EntityWither || EntityHit instanceof EntityPlayer){
    	}else{
    		
    		DamageSource dmg = new DamageSource("SilverSwordHit");
    		dmg.setDamageBypassesArmor();
    		
    		EntityHit.attackEntityFrom(dmg, 20);
    		EntityHit.attackEntityAsMob(EntityHit);
    		
			
    		
    	        if (itemstack.stackTagCompound == null){
    	        	itemstack.setTagCompound(new NBTTagCompound());
    	        }
    	        
    	        if(itemstack.stackTagCompound.getInteger("Kills") == 0){
    	        	itemstack.stackTagCompound.setInteger("Kills", 1);
    	        }else{
    	        	itemstack.stackTagCompound.setInteger("Kills", itemstack.stackTagCompound.getInteger("Kills") + 1);
    	        }
    	        
    	        
    	        itemstack.stackTagCompound.setString("LastMob", EntityHit.getCommandSenderName().toString());
    	        
    	        if(EntityAttacker instanceof EntityPlayer){
    	        	EntityPlayer player = (EntityPlayer)EntityAttacker;
    	        	
    	        	if(!player.capabilities.isCreativeMode)
    	        itemstack.attemptDamageItem(1, EntityHit.worldObj.rand);
    	        }
    			
    		
    	}
    		
    		
    	
    	
    	
    	
    	
    	
    	
    	
		return false;
    	
    }
    
    
    public void onCreated(ItemStack item, World world, EntityPlayer player) {
    	
    	if (item.stackTagCompound == null){
    		item.setTagCompound(new NBTTagCompound());
    	}
    	
    	item.stackTagCompound.setString("MadeBy", player.getCommandSenderName());
    	
    }
    
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
    	
    	
            list.add(StatCollector.translateToLocal("items.desc.silversword.1"));
            
            if(itemstack.stackTagCompound != null){
            	
            list.add(StatCollector.translateToLocal("items.desc.silversword.2") + ": " + itemstack.stackTagCompound.getInteger("Kills"));
            
            if(itemstack.stackTagCompound.getString("LastMob") == null)
            	list.add(StatCollector.translateToLocal("items.desc.silversword.4"));
            else
            list.add(StatCollector.translateToLocal("items.desc.silversword.3") + ": " + itemstack.stackTagCompound.getString("LastMob"));
            
            
            if(itemstack.stackTagCompound.getString("MadeBy") == null)
            	list.add(StatCollector.translateToLocal("items.desc.silversword.6"));
            else
            list.add(StatCollector.translateToLocal("items.desc.silversword.5") + ": " + itemstack.stackTagCompound.getString("MadeBy"));
            }else{
            	
            	list.add(StatCollector.translateToLocal("items.desc.silversword.2") + ": 0");
            	list.add(StatCollector.translateToLocal("items.desc.silversword.4"));
            	list.add(StatCollector.translateToLocal("items.desc.silversword.6"));
            

    }
    
    }
    
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }
  
    
}