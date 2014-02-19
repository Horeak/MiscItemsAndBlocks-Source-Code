package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerMetalPress;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerXpStorage;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningChamber;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;

public class ServerButtonPacket extends IPacket{

	byte ID;
	
	public ServerButtonPacket(){}
	public ServerButtonPacket(byte id){
		ID = id;
	}
	
	@Override
	public void read(DataInputStream data) throws IOException {
		
		ID = data.readByte();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		
		data.writeByte(ID);
	}

	@Override
	public void execute(EntityPlayer player) {
		
		Container container = player.openContainer;
		
		if (container != null && container instanceof ContainerXpStorage) {
			TileEntityXpStorage XpStorage = ((ContainerXpStorage)container).getTile();
			XpStorage.receiveButtonEvent(ID);
			
		}else if (container != null && container instanceof ContainerMiningChamber) {
			TileEntityMiningChamber MiningChamber = ((ContainerMiningChamber)container).getTile();
			MiningChamber.receiveButtonEvent(ID);
			

		}else if (container != null && container instanceof ContainerMetalPress){
			TileEntityMetalPress tile = ((ContainerMetalPress)container).getTile();
			tile.receiveButtonEvent(ID);
			
			if(tile.Mode == 1){
				
				player.inventory.addItemStackToInventory(tile.getStackInSlot(2));
				player.inventory.addItemStackToInventory(tile.getStackInSlot(3));
				player.inventory.addItemStackToInventory(tile.getStackInSlot(4));
				player.inventory.addItemStackToInventory(tile.getStackInSlot(5));
				
				tile.setInventorySlotContents(2, null);
				tile.setInventorySlotContents(3, null);
				tile.setInventorySlotContents(4, null);
				tile.setInventorySlotContents(5, null);

			}else if (tile.Mode == 2){

				player.inventory.addItemStackToInventory(tile.getStackInSlot(1));
				tile.setInventorySlotContents(1, null);
			}
			
		}
	}

}
