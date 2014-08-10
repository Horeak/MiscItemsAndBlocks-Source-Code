package com.miscitems.MiscItemsAndBlocks.Network.Server;

import MiscUtils.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Utils.Game.GameInfo;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ServerGamePacketClosed extends AbstractPacket {

	String Player1;
	String Player2;
	
	public ServerGamePacketClosed(){}
	public ServerGamePacketClosed(String Player_1, String Player_2){
		
		Player1 = Player_1;
		Player2 = Player_2;
	}
	
	@Override
public void fromBytes(ByteBuf buf, Side side) {
		
		
		Player1 = ByteBufUtils.readUTF8String(buf);
		Player2 = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {
		
		
		ByteBufUtils.writeUTF8String(buf, Player1);
		ByteBufUtils.writeUTF8String(buf, Player2);
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {
		


		if(player.getCommandSenderName().equalsIgnoreCase(Player1) || player.getCommandSenderName().equalsIgnoreCase(Player2)){
  	  for(GameInfo ti : Main.proxy.tickHandlerServer.activeGames)
        {
                if(ti.isPlayerInGame(player))
                {
              	  ti.terminate(player);
                        break;
                }
        }
  	  
		}
  	  

	}

}
