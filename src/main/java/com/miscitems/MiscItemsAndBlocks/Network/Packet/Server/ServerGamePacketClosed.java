package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.GameInfo;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ServerGamePacketClosed implements IMessage, IMessageHandler<ServerGamePacketClosed, IMessage> {

	String Player1;
	String Player2;
	
	public ServerGamePacketClosed(){}
	public ServerGamePacketClosed(String Player_1, String Player_2){
		
		Player1 = Player_1;
		Player2 = Player_2;
	}
	
	@Override
public void fromBytes(ByteBuf buf) {
		
		
		Player1 = ByteBufUtils.readUTF8String(buf);
		Player2 = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
		ByteBufUtils.writeUTF8String(buf, Player1);
		ByteBufUtils.writeUTF8String(buf, Player2);
	}

	@Override
	  public IMessage onMessage(ServerGamePacketClosed message, MessageContext ctx) {
		

        EntityPlayer player = ctx.getServerHandler().playerEntity;

		if(player.getCommandSenderName().equalsIgnoreCase(message.Player1) || player.getCommandSenderName().equalsIgnoreCase(message.Player2)){
  	  for(GameInfo ti : Main.proxy.tickHandlerServer.activeGames)
        {
                if(ti.isPlayerInGame(player))
                {
              	  ti.terminate(player);
                        break;
                }
        }
  	  
		}
  	  
  	  
  	  return null;
	}

}
