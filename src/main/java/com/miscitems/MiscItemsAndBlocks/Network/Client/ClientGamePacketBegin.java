package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiGame_1;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class ClientGamePacketBegin implements IMessage, IMessageHandler<ClientGamePacketBegin, IMessage> {

	
	String Player1;
	String Player2;
	
	public ClientGamePacketBegin(){}
	public ClientGamePacketBegin(String pl1, String pl2){
		Player1 = pl1;
		Player2 = pl2;
	}
	
	@Override
public void fromBytes(ByteBuf buf) {
		Player1 = ByteBufUtils.readUTF8String(buf);
		Player2 = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf,Player1);
        ByteBufUtils.writeUTF8String(buf,Player2);
	}

	@Override
	  public IMessage onMessage(ClientGamePacketBegin message, MessageContext ctx) {

        FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new GuiGame_1(message.Player1, message.Player2));
        Main.proxy.tickHandlerClient.tradeReq = null;


        return null;
	}

}
