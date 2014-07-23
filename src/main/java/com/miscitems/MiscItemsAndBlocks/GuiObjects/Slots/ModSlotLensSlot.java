package com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots;

import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLensBench;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

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
