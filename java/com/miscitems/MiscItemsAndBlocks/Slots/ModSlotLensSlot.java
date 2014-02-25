package com.miscitems.MiscItemsAndBlocks.Slots;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;

public class ModSlotLensSlot extends Slot{

	TileEntityLensBench tile;
	
	public ModSlotLensSlot(TileEntityLensBench par1iInventory, int par2, int par3,int par4) {
		super(par1iInventory, par2, par3, par4);
		tile = par1iInventory;
	}
	
    public void onSlotChange(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
    	tile.onSlotChanged();
    	
    }
    
    public boolean isItemValid(ItemStack stack)
    {
    	
    	return stack.getItem() == ModItems.Lens;
    }

}
