package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketChange;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerGamePacketChange implements IMessage, IMessageHandler<ServerGamePacketChange, IMessage> {

	

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
public void fromBytes(ByteBuf buf) {
		
		Number = buf.readInt();
		Player = buf.readInt();
		
		Player_1 = ByteBufUtils.readUTF8String(buf);
		Player_2 = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {


        buf.writeInt(Number);
        buf.writeInt(Player);
		ByteBufUtils.writeUTF8String(buf, Player_1);
		ByteBufUtils.writeUTF8String(buf, Player_2);
	}

	@Override
	  public IMessage onMessage(ServerGamePacketChange message, MessageContext ctx) {
		
		 EntityPlayerMP plyr;
		 
		 if(message.Player == 1)
			 plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(message.Player_2);
		 else
			 plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(message.Player_1);
		 
		PacketHandler.INSTANCE.sendTo(new ClientGamePacketChange(message.Number, message.Player, message.Player_1, message.Player_2), plyr);
        return null;
	}

}
