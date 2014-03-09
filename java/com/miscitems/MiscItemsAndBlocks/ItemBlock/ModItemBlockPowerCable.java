package com.miscitems.MiscItemsAndBlocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ModItemBlockPowerCable extends ItemBlock{

	public ModItemBlockPowerCable(Block par1) {
		super(par1);
	}
	
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
    	
    	list.add("Can be used to transfer power");
    }
    

}
