package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketInviteRecived;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.Utils.Game.GameInvite;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerGamePacketInvite extends AbstractPacket {

	public String Player;
	
	public ServerGamePacketInvite(){}
	public ServerGamePacketInvite(String Player){
		this.Player = Player;
	}
	
	@Override

    public void fromBytes(ByteBuf buf, Side side) {


		Player = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

		
		ByteBufUtils.writeUTF8String(buf, Player);
	}

	
	//Server Network
	@Override
    public void onMessage(Side side, EntityPlayer player) {
		
		
		  EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152612_a(Player);
          
		  if(plyr != null){
          GameInvite tr = ServerProxy.tickHandlerServer.playerGameRequests.get(plyr.getCommandSenderName());
          if(tr == null || !tr.Name.equalsIgnoreCase(player.getCommandSenderName()))
          {
        	  
          	ServerProxy.tickHandlerServer.playerGameRequests.put(plyr.getCommandSenderName(), new GameInvite(player.getCommandSenderName()));
          	PacketHandler.sendToPlayer(new ClientGamePacketInviteRecived(player.getCommandSenderName()), plyr);
          }
		  }

	}

}
