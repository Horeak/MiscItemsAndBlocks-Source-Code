package com.miscitems.MiscItemsAndBlocks.Items;

import java.awt.Color;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemLense extends Item{

	IIcon Item;
	IIcon Item_lense;
	
	public ModItemLense(){
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}
	
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister icon)
	   {
		   Item = icon.registerIcon(Refrence.Mod_Id + ":" + "Lense");
		   Item_lense = icon.registerIcon(Refrence.Mod_Id + ":" + "Lense_Part");
		   
	   }
	   
	    @SideOnly(Side.CLIENT)
	    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
	    {
	    	if(par2 == 0)
	    		return super.getColorFromItemStack(par1ItemStack, par2);
	    	else{
	    		if(par1ItemStack.stackTagCompound != null){
	    			int Red = par1ItemStack.stackTagCompound.getInteger("Red");
	    			int Green = par1ItemStack.stackTagCompound.getInteger("Green");
	    			int Blue = par1ItemStack.stackTagCompound.getInteger("Blue");
	    			
	    			return new Color(Red, Green, Blue).getRGB();
	    			
	    			
	    			
	    		}else{
	    			return super.getColorFromItemStack(par1ItemStack, par2);
	    		}
	    		
	    	}
	    }
	    
	    
	    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
	    	if(stack.stackTagCompound != null){
	    		list.add("Red: " + stack.stackTagCompound.getInteger("Red"));
	    		list.add("Green: " + stack.stackTagCompound.getInteger("Green"));
	    		list.add("Blue: " + stack.stackTagCompound.getInteger("Blue"));
	    		
	    		
	    		if(stack.stackTagCompound.getBoolean("Redstone"))
	    			list.add("Activates Redstone Recivers");
	    		
	    		if(stack.stackTagCompound.getBoolean("Safe"))
	    			list.add("Safe lasers");
	    		
	    		
	    	}
	    	
	    	
	    	
	    	
	    }
	    
	    
	    @SideOnly(Side.CLIENT)
	    public boolean requiresMultipleRenderPasses()
	    {
	        return true;
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(ItemStack par1, int par2)
	    {

	    	if(par2 == 0){
	    		return Item;
	    	}else{
	    			return Item_lense;
	    	}
	    	
	    }
}
