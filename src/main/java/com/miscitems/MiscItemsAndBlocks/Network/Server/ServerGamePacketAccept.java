package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Utils.Game.GameInvite;
import com.miscitems.MiscItemsAndBlocks.Utils.Handlers.ChatMessageHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerGamePacketAccept extends AbstractPacket {

	
	String Player;
	
	public ServerGamePacketAccept(){}
	public ServerGamePacketAccept(String Player){
		this.Player = Player;
	}
	
	@Override

    public void fromBytes(ByteBuf buf, Side side) {

		Player = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

		ByteBufUtils.writeUTF8String(buf,Player);
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {
		 //Accept request


        GameInvite tr = Main.proxy.tickHandlerServer.playerGameRequests.get(player.getCommandSenderName());
        if(tr == null)
        {
        	ChatMessageHandler.sendChatToPlayer(player, "Cannot Acceppt Game Invite");
        }
        
        
        EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152612_a(Player);
        
        if(plyr != null && plyr.isEntityAlive() )
        {

                Main.proxy.tickHandlerServer.playerGameRequests.remove(player.getCommandSenderName());
                Main.proxy.tickHandlerServer.initializeGame(player, plyr);
                
        }
        else
        {
        	
        	ChatMessageHandler.sendChatToPlayer(player, "Cannot Acceppt Game Invite");

        }

	}

}
