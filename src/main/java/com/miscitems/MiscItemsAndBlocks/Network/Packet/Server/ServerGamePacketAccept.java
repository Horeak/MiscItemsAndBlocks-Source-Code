package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Utils.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.GameInvite;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerGamePacketAccept extends IPacket {

	
	String Player;
	
	public ServerGamePacketAccept(){}
	public ServerGamePacketAccept(String Player){
		this.Player = Player;
	}
	
	@Override
	public void read(DataInputStream data) throws IOException {

		Player = data.readUTF();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {

		data.writeUTF(Player);
	}

	@Override
	public void execute(EntityPlayer player) {
		 //Accept request
        
        GameInvite tr = Main.proxy.tickHandlerServer.playerGameRequests.get(player.getCommandSenderName());
        if(tr == null)
        {
        	ChatMessageHandler.sendChatToPlayer(player, "Cannot Acceppt Game Invite");
        }
        
        
        EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(Player);
        
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
