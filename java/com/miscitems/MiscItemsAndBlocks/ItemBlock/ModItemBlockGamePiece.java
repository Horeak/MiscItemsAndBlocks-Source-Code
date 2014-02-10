package com.miscitems.MiscItemsAndBlocks.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ModItemBlockGamePiece extends ItemBlock{

	public ModItemBlockGamePiece(Block par1) {
		super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

	
    public int getMetadata(int par1)
    {
        return par1;
    }
    
    public String getUnlocalizedName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();
    	

    	
    	return "item.GamePart.Number." + meta;
    }
}
