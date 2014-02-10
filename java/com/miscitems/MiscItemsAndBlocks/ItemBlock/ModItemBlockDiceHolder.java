package com.miscitems.MiscItemsAndBlocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemBlockDiceHolder extends ItemBlock{

	public ModItemBlockDiceHolder(Block par1) {
		super(par1);
	}
	
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
    	
    	world.setBlock(x, y, z, Block.getBlockById(stack.getItem().getIdFromItem(stack.getItem())), stack.getItemDamage(), 2);
    	
    	return true;
    }

}
