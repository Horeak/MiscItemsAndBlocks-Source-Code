package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IChatComponent;

import com.miscitems.MiscItemsAndBlocks.Lib.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Misc.GameInvite;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;

import cpw.mods.fml.common.FMLCommonHandler;

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
