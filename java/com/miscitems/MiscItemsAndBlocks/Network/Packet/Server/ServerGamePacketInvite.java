package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Misc.GameInvite;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketInviteRecived;
import com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy;

import cpw.mods.fml.common.FMLCommonHandler;

public class ServerGamePacketInvite extends IPacket {

	public String Player;
	
	public ServerGamePacketInvite(String Player){
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

	
	//Server Packet
	@Override
	public void execute(EntityPlayer player) {

		
		  EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(Player);
          
          GameInvite tr1 = ServerProxy.tickHandlerServer.playerGameRequests.get(player.getCommandSenderName());
          
          if(tr1 != null && tr1.Name.equalsIgnoreCase(plyr.getCommandSenderName()))
          {
          	ServerProxy.tickHandlerServer.initializeGame(player, plyr);
          }
          
          GameInvite tr = ServerProxy.tickHandlerServer.playerGameRequests.get(plyr.getCommandSenderName());
          if(tr == null || !tr.Name.equalsIgnoreCase(player.getCommandSenderName()))
          {
          	ServerProxy.tickHandlerServer.playerGameRequests.put(plyr.getCommandSenderName(), new GameInvite(player.getCommandSenderName()));
               
          	
          	
          	
          	Main.NETWORK_MANAGER.sendPacketToPlayer(new ClientGamePacketInviteRecived(player.getCommandSenderName()), plyr);
          }
	}

}
