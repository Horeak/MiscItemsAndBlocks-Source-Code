package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Misc.GameInfo;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import net.minecraft.entity.player.EntityPlayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerGamePacketClosed extends IPacket{

	String Player1;
	String Player2;
	
	public ServerGamePacketClosed(){}
	public ServerGamePacketClosed(String Player_1, String Player_2){
		
		Player1 = Player_1;
		Player2 = Player_2;
	}
	
	@Override
	public void read(DataInputStream data) throws IOException {
		
		
		Player1 = data.readUTF();
		Player2 = data.readUTF();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		
		
		data.writeUTF(Player1);
		data.writeUTF(Player2);
	}

	@Override
	public void execute(EntityPlayer player) {
		
		

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
