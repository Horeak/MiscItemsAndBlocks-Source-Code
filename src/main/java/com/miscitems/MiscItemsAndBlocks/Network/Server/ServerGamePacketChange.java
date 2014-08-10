package com.miscitems.MiscItemsAndBlocks.Network.Server;


import MiscUtils.Network.AbstractPacket;
import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketChange;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerGamePacketChange extends AbstractPacket {

	

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
public void fromBytes(ByteBuf buf, Side side) {
		
		Number = buf.readInt();
		Player = buf.readInt();
		
		Player_1 = ByteBufUtils.readUTF8String(buf);
		Player_2 = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {


        buf.writeInt(Number);
        buf.writeInt(Player);
		ByteBufUtils.writeUTF8String(buf, Player_1);
		ByteBufUtils.writeUTF8String(buf, Player_2);
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {
		
		 EntityPlayerMP plyr;
		 
		 if(Player == 1)
			 plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152612_a(Player_2);
		 else
			 plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152612_a(Player_1);
		 
		PacketHandler.sendToPlayer(new ClientGamePacketChange(Number, Player, Player_1, Player_2), plyr, Main.channels);
	}

}
