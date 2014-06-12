package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientChatMessageRecivedPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.PacketHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class ServerChatMessagePacket implements IMessage, IMessageHandler<ServerChatMessagePacket, IMessage> {

	
	String Line;
	
	public ServerChatMessagePacket(){}
	
	public ServerChatMessagePacket(String Line){
		this.Line = Line;
	}
	
	
	
	@Override
public void fromBytes(ByteBuf buf) {
		Line = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, Line);
	}

	@Override
	  public IMessage onMessage(ServerChatMessagePacket message, MessageContext ctx) {
		String[] text = message.Line.split("-");
		if(text.length > 1){
		
		String Player = text[0];
		String Message = text[1];
		String Channel = text[2];


            PacketHandler.INSTANCE.sendTo(new ClientChatMessageRecivedPacket(Player + "-" + Message + "-" + Channel), ctx.getServerHandler().playerEntity);

		}

        return null;
	}

}
