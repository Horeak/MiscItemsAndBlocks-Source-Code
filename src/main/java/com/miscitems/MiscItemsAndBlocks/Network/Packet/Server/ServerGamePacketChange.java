package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGamePacketChange;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerGamePacketChange extends IPacket{

	

	int Number;
	int Player;
	String Player_1;
	String Player_2;
	
	public ServerGamePacketChange(){}
	public ServerGamePacketChange(int Number, int Player, String Player_1, String Player_2){
		this.Number = Number;
		this.Player = Player;
		
		this.Player_1 = Player_1;
		this.Player_2 = Player_2;
	}
	
	@Override
	public void read(DataInputStream data) throws IOException {
		
		Number = data.readInt();
		Player = data.readInt();
		
		Player_1 = data.readUTF();
		Player_2 = data.readUTF();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		
		
		data.writeInt(Number);
		data.writeInt(Player);
		data.writeUTF(Player_1);
		data.writeUTF(Player_2);
	}

	@Override
	public void execute(EntityPlayer player) {
		
		 EntityPlayerMP plyr;
		 
		 if(Player == 1)
			 plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(Player_2);
		 else
			 plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(Player_1);
		 
		Main.NETWORK_MANAGER.sendPacketToPlayer(new ClientGamePacketChange(Number, Player, Player_1, Player_2), plyr);
	}

}
