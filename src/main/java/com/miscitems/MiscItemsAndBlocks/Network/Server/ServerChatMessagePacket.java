package com.miscitems.MiscItemsAndBlocks.Network.Server;


import MiscUtils.Network.AbstractPacket;
import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientChatMessageRecivedPacket;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ServerChatMessagePacket extends AbstractPacket {

	
	String Line;
	
	public ServerChatMessagePacket(){}
	
	public ServerChatMessagePacket(String Line){
		this.Line = Line;
	}
	
	
	
	@Override
public void fromBytes(ByteBuf buf, Side side) {
		Line = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {
		ByteBufUtils.writeUTF8String(buf, Line);
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {
		String[] text = Line.split("-");
		if(text.length > 1){
		
		String Player = text[0];
		String Message = text[1];
		String Channel = text[2];


            PacketHandler.sendToPlayer(new ClientChatMessageRecivedPacket(Player + "-" + Message + "-" + Channel), player, Main.channels);

		}

	}

}
