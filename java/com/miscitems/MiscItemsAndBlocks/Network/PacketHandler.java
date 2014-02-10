package com.miscitems.MiscItemsAndBlocks.Network;

import ibxm.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerMetalPress;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerXpStorage;
import com.miscitems.MiscItemsAndBlocks.Gui.GuiChat;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemPaintBrush;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningChamber;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityXpStorage;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class PacketHandler implements IPacketHandler{

	
	



	public static void sendButtonPacket(byte id) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte)1);
			dataStream.writeByte(id);			
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send button click packet");
		}
	}
	
	public static void sendPaintBrushColorChange(int Red, int Green, int Blue) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);


		try {
			dataStream.writeByte((byte)2);
			dataStream.writeInt(Red);		
			dataStream.writeInt(Green);
			dataStream.writeInt(Blue);
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send paint brush color change packet");
		}
	}
	
	public static void Game_1Invite(String From, String To) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);


		try {
			dataStream.writeByte((byte)7);
			dataStream.writeBytes(From + "-" + To);

			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send packet");
		}
	}

	
	
	public static void SendGameChange(String Player, int Number) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);


		try {
			dataStream.writeByte((byte)8);
			dataStream.writeInt(Number);
			dataStream.writeBytes(Player);

			
			PacketDispatcher.sendPacketToPlayer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()), (Player)FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(Player));
		}catch(IOException ex) {
			System.err.append("Failed to send packet");
		}
	}
	

	

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		
	       ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		EntityPlayer entityPlayer = (EntityPlayer)player;
		
		byte packetId = reader.readByte();
		
		
		
		switch (packetId) {
			case 1:		
				byte buttonId = reader.readByte();
				Container container = entityPlayer.openContainer;
				
				if (container != null && container instanceof ContainerXpStorage) {
					TileEntityXpStorage XpStorage = ((ContainerXpStorage)container).getTile();
					XpStorage.receiveButtonEvent(buttonId);
					
				}else if (container != null && container instanceof ContainerMiningChamber) {
					TileEntityMiningChamber MiningChamber = ((ContainerMiningChamber)container).getTile();
					MiningChamber.receiveButtonEvent(buttonId);
					

				}else if (container != null && container instanceof ContainerMetalPress){
					TileEntityMetalPress tile = ((ContainerMetalPress)container).getTile();
					tile.receiveButtonEvent(buttonId);
					
					if(tile.Mode == 1){
						
						entityPlayer.inventory.addItemStackToInventory(tile.getStackInSlot(2));
						entityPlayer.inventory.addItemStackToInventory(tile.getStackInSlot(3));
						entityPlayer.inventory.addItemStackToInventory(tile.getStackInSlot(4));
						entityPlayer.inventory.addItemStackToInventory(tile.getStackInSlot(5));
						
						tile.setInventorySlotContents(2, null);
						tile.setInventorySlotContents(3, null);
						tile.setInventorySlotContents(4, null);
						tile.setInventorySlotContents(5, null);
	
					}else if (tile.Mode == 2){

						entityPlayer.inventory.addItemStackToInventory(tile.getStackInSlot(1));
						tile.setInventorySlotContents(1, null);
					}
					
				}
				
				
				return;
				
			case 2:

				int Red = reader.readInt();
				int Green = reader.readInt();
				int Blue = reader.readInt();
				
				if(entityPlayer.inventory.getCurrentItem() != null && entityPlayer.inventory.getCurrentItem().getItem() instanceof ModItemPaintBrush){
					ModItemPaintBrush item = (ModItemPaintBrush)entityPlayer.inventory.getCurrentItem().getItem();
					
					item.ReciveColors(Red, Green, Blue, entityPlayer.inventory.getCurrentItem());
				}
				
				
				return;
				
				
			case 3:
				String fullLine = reader.readLine();
				
				String[] text = fullLine.split("-");
				if(text.length > 1){
				
				String Player = text[0];
				String Message = text[1];
				String Channel = text[2];

				

				
				ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
				DataOutputStream dataStream = new DataOutputStream(byteStream);


				try {
					dataStream.writeByte((byte)4);
					
					dataStream.writeUTF(Player + "-" + Message + "-" + Channel);

					
					PacketDispatcher.sendPacketToAllPlayers(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
				}catch(IOException ex) {
					System.err.append("Failed to send packet");
				}
				
				}
				
				return;
				
				
			case 4:
				
				String fullLine1 = reader.readLine();
				
				
				
				
				if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
					GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
					gui.ReciveChatMessage(fullLine1);
				}

				
				return;
				

				//Player Joined
			case 5:
				
				String fullLine2 = reader.readLine();
				String[] text1 = fullLine2.split("-");
				
				
				if(text1.length > 1){
				
				String Player1 = text1[0];
				String Channel = text1[1];
				
				if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
					GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
					gui.ReciveChatMessage(Player1 + "-#JC#Joined the chat.-" + Channel);
				}
				

					
					
					
				}
				
				return;
				
				
				//Player Left
			case 6:
				
				String[] text2 = reader.readLine().split("-", 3);
				if(text2.length > 1){
					
				
				String Player1 = text2[0];
				String Message = text2[1];
				String Channel = text2[2];

				
				if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
					GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
					gui.ReciveChatMessage(Player1 + "-" + "#LC#left the chat. " + "(" + Message + ")" + "-" + Channel);
				}
				
				

			
				}
				
				return;
			
			


		}
		
	       ModPacket ModPacket = PacketTypeHandler.buildPacket(packet.data);
	       ModPacket.execute(manager, player);
		

	}
	
	

	
	
}
