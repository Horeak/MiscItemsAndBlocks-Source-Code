package com.miscitems.MiscItemsAndBlocks.Network.Client;

import MiscUtils.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis.GuiGame_1;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientGamePacketRestart extends AbstractPacket {

	public ClientGamePacketRestart(){}
	
	@Override
public void fromBytes(ByteBuf buf, Side side) {

	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {
if(side == Side.CLIENT)
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
