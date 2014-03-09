package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiChat;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientChatMessageRecivedPacket extends IPacket{

	
	String Line;
	
	public ClientChatMessageRecivedPacket(){}
	
	
	public ClientChatMessageRecivedPacket(String Line){
		
		this.Line = Line;
	}
	
	@Override
	public void read(DataInputStream data) throws IOException {
		
		Line = data.readUTF();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {

		data.writeUTF(Line);
		
	}

	@Override
	public void execute(EntityPlayer player) {
		
	     if (FMLCommonHandler.instance().getEffectiveSide().isClient()){
		String fullLine1 = Line;
		
		
		
		
		if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
			GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
			gui.ReciveChatMessage(fullLine1);
		}
	}

	}
}
