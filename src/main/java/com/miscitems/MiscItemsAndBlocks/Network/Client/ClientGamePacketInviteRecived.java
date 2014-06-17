package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.Handlers.ChatMessageHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

public class ClientGamePacketInviteRecived  implements IMessage, IMessageHandler<ClientGamePacketInviteRecived, IMessage> {

	String Player;
	
	public ClientGamePacketInviteRecived(){}
	public ClientGamePacketInviteRecived(String Pl){
		Player = Pl;
	}
	
	@Override
public void fromBytes(ByteBuf buf) {
		Player = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf,Player);
	}

	@Override
	  public IMessage onMessage(ClientGamePacketInviteRecived message, MessageContext ctx) {

		Main.proxy.tickHandlerClient.tradeReq = message.Player;
		
        Minecraft.getMinecraft().theWorld.playSoundEffect((float)Minecraft.getMinecraft().thePlayer.posX, (float)Minecraft.getMinecraft().thePlayer.posY, (float)Minecraft.getMinecraft().thePlayer.posZ, "random.successful_hit", 1.0F, 1.0F);

        ChatMessageHandler.sendChatToPlayer(Minecraft.getMinecraft().thePlayer, EnumChatFormatting.GOLD + "You have recived a game invite to play tic tac toe!");
        

        return null;
	}

}
