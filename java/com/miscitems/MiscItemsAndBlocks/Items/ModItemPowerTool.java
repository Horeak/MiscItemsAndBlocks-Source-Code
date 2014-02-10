package com.miscitems.MiscItemsAndBlocks.Items;

import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerItem;

public abstract class ModItemPowerTool extends ItemTool implements IPowerItem{

	public ModItemPowerTool(float damage, ToolMaterial material, Set blocks) {
		super(damage, material, blocks);
		this.canRepair = false;
	}
    public int getItemEnchantability()
    {
        return 0;
    }
    
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }
}
