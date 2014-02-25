package com.miscitems.MiscItemsAndBlocks.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemGuideBook extends Item{

	
	public ModItemGuideBook(){
		this.setMaxStackSize(1);
	}
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	
    	par3List.add("\u00a7o" + "MiscItemsAndBlocks Guide");
    }
}
