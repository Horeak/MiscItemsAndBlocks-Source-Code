package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiChat;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class ClientChatMessageRecivedPacket  implements IMessage, IMessageHandler<ClientChatMessageRecivedPacket, IMessage> {

	
	String Line;
	
	public ClientChatMessageRecivedPacket(){}
	
	
	public ClientChatMessageRecivedPacket(String Line){
		
		this.Line = Line;
	}
	
	@Override
public void fromBytes(ByteBuf buf) {
		
		Line = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {

        ByteBufUtils.writeUTF8String(buf,Line);
		
	}

	@Override
	  public IMessage onMessage(ClientChatMessageRecivedPacket message, MessageContext ctx) {

		String fullLine1 = message.Line;
		
		
		
		
		if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
			GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
			gui.ReciveChatMessage(fullLine1);
		}

        return null;
	}
}
