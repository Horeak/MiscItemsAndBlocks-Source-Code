package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import com.miscitems.MiscItemsAndBlocks.Utils.ChatMessageHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientGamePacketInviteRecived extends IPacket{

	String Player;
	
	public ClientGamePacketInviteRecived(){}
	public ClientGamePacketInviteRecived(String Pl){
		Player = Pl;
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
		
	     if (FMLCommonHandler.instance().getEffectiveSide().isClient()){
		Main.proxy.tickHandlerClient.tradeReq = Player;
		
        Minecraft.getMinecraft().theWorld.playSoundEffect((float)Minecraft.getMinecraft().thePlayer.posX, (float)Minecraft.getMinecraft().thePlayer.posY, (float)Minecraft.getMinecraft().thePlayer.posZ, "random.successful_hit", 1.0F, 1.0F);

        ChatMessageHandler.sendChatToPlayer(Minecraft.getMinecraft().thePlayer, EnumChatFormatting.GOLD + "You have recived a game invite to play tic tac toe!");
        
	}
	}

}
