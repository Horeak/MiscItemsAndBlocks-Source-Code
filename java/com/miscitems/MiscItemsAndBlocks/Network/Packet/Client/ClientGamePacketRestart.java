package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiGame_1;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientGamePacketRestart extends IPacket{

	public ClientGamePacketRestart(){}
	
	@Override
	public void read(DataInputStream data) throws IOException {

	}

	@Override
	public void write(DataOutputStream data) throws IOException {

	}

	@Override
	public void execute(EntityPlayer player) {

	     if (FMLCommonHandler.instance().getEffectiveSide().isClient())
    if(FMLClientHandler.instance().getClient().currentScreen instanceof GuiGame_1){
		GuiGame_1 gui = (GuiGame_1)Minecraft.getMinecraft().currentScreen;
		
		for(int i = 0; i < gui.Buttons.length; i++){
			gui.Buttons[i].displayString = "";
			gui.Buttons[i].enabled = true;
		}
		
		gui.CurrentTurn = 1;
		gui.CurrentPlayer = gui.player_1;
		gui.RedWin = false;
		gui.BlueWin = false;
		
		gui.Button_Restart.enabled = false;
		
    
    	
    	
    }
	}

}
