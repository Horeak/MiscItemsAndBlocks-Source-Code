package com.miscitems.MiscItemsAndBlocks.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Slots.ModSlotBatterySlot;
import com.miscitems.MiscItemsAndBlocks.Slots.ModSlotItemsOnly;
import com.miscitems.MiscItemsAndBlocks.Slots.ModSlotLapisSlot;
import com.miscitems.MiscItemsAndBlocks.Slots.ModSlotRedstoneSlot;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;

public class ContainerLensBench  extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    public TileEntityLensBench tile;

	
    public ContainerLensBench(InventoryPlayer InvPlayer, TileEntityLensBench tile)
    {
    	this.tile = tile;
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 232));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 174 + y * 18));
    		}
    }
    	
    	
    	
    	addSlotToContainer(new ModSlotItemsOnly(tile, 0, 7, 7, new Item[]{ModItems.Lens}));
    	
    	addSlotToContainer(new ModSlotBatterySlot(tile, 1, 68, 17));
    	
    	addSlotToContainer(new ModSlotRedstoneSlot(tile, 2, 86, 17));

    	addSlotToContainer(new ModSlotLapisSlot(tile, 3, 104, 17));

}
    

    
    @Override
	  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {

		  return null;
	    }
    
}