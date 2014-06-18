package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerMetalPress;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerXpStorage;
import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningStation;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ServerButtonPacket extends AbstractPacket {

	byte ID;
	
	public ServerButtonPacket(){}
	public ServerButtonPacket(byte id){
		ID = id;
	}
	
	@Override
public void fromBytes(ByteBuf buf, Side side) {
		
		ID = buf.readByte();
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

        buf.writeByte(ID);
	}

	@Override
    public void onMessage(Side side, EntityPlayer pl) {
		
		Container container = pl.openContainer;
        EntityPlayer player = pl;
		
		if (container != null && container instanceof ContainerXpStorage) {
			TileEntityXpStorage XpStorage = ((ContainerXpStorage)container).getTile();
			XpStorage.receiveButtonEvent(ID);
			
		}else if (container != null && container instanceof ContainerMiningChamber) {
			TileEntityMiningStation MiningChamber = ((ContainerMiningChamber)container).getTile();
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
