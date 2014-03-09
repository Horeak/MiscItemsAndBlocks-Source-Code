package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiGame_1;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientGamePacketBegin extends IPacket{

	
	String Player1;
	String Player2;
	
	public ClientGamePacketBegin(){}
	public ClientGamePacketBegin(String pl1, String pl2){
		Player1 = pl1;
		Player2 = pl2;
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
		
	     if (FMLCommonHandler.instance().getEffectiveSide().isClient()){
        FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new GuiGame_1(Player1, Player2));
        Main.proxy.tickHandlerClient.tradeReq = null;
	     }
	}

}
