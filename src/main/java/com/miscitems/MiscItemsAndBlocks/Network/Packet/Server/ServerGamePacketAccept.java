package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.GameInvite;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerGamePacketAccept implements IMessage, IMessageHandler<ServerGamePacketAccept, IMessage> {

	
	String Player;
	
	public ServerGamePacketAccept(){}
	public ServerGamePacketAccept(String Player){
		this.Player = Player;
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
	  public IMessage onMessage(ServerGamePacketAccept message, MessageContext ctx) {
		 //Accept request

        EntityPlayer player = ctx.getServerHandler().playerEntity;

        GameInvite tr = Main.proxy.tickHandlerServer.playerGameRequests.get(player.getCommandSenderName());
        if(tr == null)
        {
        	ChatMessageHandler.sendChatToPlayer(player, "Cannot Acceppt Game Invite");
        }
        
        
        EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(message.Player);
        
        if(plyr != null && plyr.isEntityAlive() )
        {

                Main.proxy.tickHandlerServer.playerGameRequests.remove(player.getCommandSenderName());
                Main.proxy.tickHandlerServer.initializeGame(player, plyr);
                
        }
        else
        {
        	
        	ChatMessageHandler.sendChatToPlayer(player, "Cannot Acceppt Game Invite");

        }

        return null;
	}

}
