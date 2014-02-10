package com.miscitems.MiscItemsAndBlocks.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;

public class ContainerComputer extends Container{
	
	public ContainerComputer(TileEntityComputer tile){
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

}
