package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketInviteRecived;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.Utils.GameInvite;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerGamePacketInvite implements IMessage, IMessageHandler<ServerGamePacketInvite, IMessage> {

	public String Player;
	
	public ServerGamePacketInvite(){}
	public ServerGamePacketInvite(String Player){
		this.Player = Player;
	}
	
	@Override
public void fromBytes(ByteBuf buf) {


		Player = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {

		
		ByteBufUtils.writeUTF8String(buf, Player);
	}

	
	//Server Packet
	@Override
	  public IMessage onMessage(ServerGamePacketInvite message, MessageContext ctx) {

        EntityPlayer player = ctx.getServerHandler().playerEntity;
		
		
		  EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(message.Player);
          
		  if(plyr != null){
          GameInvite tr = ServerProxy.tickHandlerServer.playerGameRequests.get(plyr.getCommandSenderName());
          if(tr == null || !tr.Name.equalsIgnoreCase(player.getCommandSenderName()))
          {
        	  
          	ServerProxy.tickHandlerServer.playerGameRequests.put(plyr.getCommandSenderName(), new GameInvite(player.getCommandSenderName()));
          	PacketHandler.INSTANCE.sendTo(new ClientGamePacketInviteRecived(player.getCommandSenderName()), plyr);
          }
		  }
          	
          	
         return null;
	}

}
