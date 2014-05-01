package com.miscitems.MiscItemsAndBlocks.Items;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.awt.*;
import java.util.List;

public class ModItemLens extends Item{

	IIcon Item;
	IIcon Item_Lens;
	
	public ModItemLens(){
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}
	
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IIconRegister icon)
	   {
		   Item = icon.registerIcon(Refrence.Mod_Id + ":Lens");
		   Item_Lens = icon.registerIcon(Refrence.Mod_Id + ":Lens_Part");
		   
	   }
	   
	    @SideOnly(Side.CLIENT)
	    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
	    {
	    	
	    	if(par2 == 0)
	    		return super.getColorFromItemStack(par1ItemStack, par2);
	    	else if (par2 == 1 || par2 == 2){
	    		if(par1ItemStack.stackTagCompound != null){
	    			if(par1ItemStack.stackTagCompound.getBoolean("Color")){
	    			int Red = par1ItemStack.stackTagCompound.getInteger("Red");
	    			int Green = par1ItemStack.stackTagCompound.getInteger("Green");
	    			int Blue = par1ItemStack.stackTagCompound.getInteger("Blue");
	    			
	    			return new Color(Red, Green, Blue).getRGB();
	    			
	    			}else{
		    			return super.getColorFromItemStack(par1ItemStack, par2);
	    			}
	    			
	    			
	    			
	    		}else{
	    			return super.getColorFromItemStack(par1ItemStack, par2);
	    		}
	    		
	    	}else{
    			return super.getColorFromItemStack(par1ItemStack, par2);
    		}
	    	
	    }
	    
	    
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
	    	if(stack.stackTagCompound != null){

	    		
	    		list.add("Power: " + stack.stackTagCompound.getInteger("Power"));
	    		list.add("Strength: " + stack.stackTagCompound.getInteger("Strength"));
	    		
	    		list.add("Power used: " + stack.stackTagCompound.getInteger("PowerUse"));
	    		

	    		list.add("Modifiers:");
	    		
	    		if(stack.stackTagCompound.getBoolean("TransferPower"))
	    			list.add("Transfers power");
	    		else
	    			list.add("Does not transfer power");
	    		
	    		if(stack.stackTagCompound.getBoolean("Redstone"))
	    			list.add("Emites redstone signal");
	    		else
	    			list.add("Does not emit redstone signal");
	    		
	    		if(stack.stackTagCompound.getBoolean("Safe"))
	    			list.add("Does no damage");
	    		else
	    			list.add("Damages entities");
	    		
	    		
	    		

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
	    			return Item_Lens;
	    	}
	    	
	    }
	    
	    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	    {
	    	
	    	if(player.isSneaking()){
	    		stack.setTagCompound(new NBTTagCompound());
	    		
	    		stack.stackTagCompound.setBoolean("Color", true);
	    		stack.stackTagCompound.setInteger("Red", 255);
	    		
	    		
	    	}
	        return false;
	    }
}
