package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientChatMessageRecivedPacket;

public class ServerChatMessagePacket extends IPacket{

	
	String Line;
	
	public ServerChatMessagePacket(){}
	
	public ServerChatMessagePacket(String Line){
		this.Line = Line;
	}
	
	
	
	@Override
	public void read(DataInputStream data) throws IOException {
		Line = data.readUTF();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		data.writeUTF(Line);
	}

	@Override
	public void execute(EntityPlayer player) {
		String[] text = Line.split("-");
		if(text.length > 1){
		
		String Player = text[0];
		String Message = text[1];
		String Channel = text[2];

		
		Main.NETWORK_MANAGER.sendPacketToPlayer(new ClientChatMessageRecivedPacket(Player + "-" + Message + "-" + Channel), player);

		}

	}

}
