package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

import com.miscitems.MiscItemsAndBlocks.Main.Main;

public class ModBlockStair extends BlockStairs{

	public ModBlockStair(Block par2Block, int par3) {
		super(par2Block, par3);
		
		this.setCreativeTab(Main.CreativeTab);
	}

}
