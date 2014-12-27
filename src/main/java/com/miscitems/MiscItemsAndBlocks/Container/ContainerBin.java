package com.miscitems.MiscItemsAndBlocks.Container;

import MiscUtils.GuiObjects.Slots.ModSlotArmor;
import MiscUtils.Utils.ContainerBase;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityTrashBin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerBin extends ContainerBase {

    private TileEntityTrashBin tile;
    
    public ContainerBin(InventoryPlayer InvPlayer, TileEntityTrashBin tile)
    {
    	this.tile = tile;
    	
    	addSlotToContainer(new Slot(tile, 0, 80, 30));
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    		
    		
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 1, 177, 14, 0, InvPlayer.player));
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 2, 177, 32, 1, InvPlayer.player));
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 3, 177, 50, 2, InvPlayer.player));
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 4, 177, 68, 3, InvPlayer.player));
    		
    		
    	}

}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}


	@Override
	public IInventory getTile() {
		return tile;
	}

	  
}
