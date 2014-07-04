package com.miscitems.MiscItemsAndBlocks.Item.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class ModItemBlockDice extends ItemBlock{

	public ModItemBlockDice(Block par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
    	return false;
    }
	
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
    	
    	Random rand = new Random();
    	
    	item.setItemDamage(rand.nextInt(6));

    	
        return true;
    }
}
