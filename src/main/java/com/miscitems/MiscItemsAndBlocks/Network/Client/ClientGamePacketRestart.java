package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiGame_1;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class ClientGamePacketRestart implements IMessage, IMessageHandler<ClientGamePacketRestart, IMessage> {

	public ClientGamePacketRestart(){}
	
	@Override
public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	  public IMessage onMessage(ClientGamePacketRestart message, MessageContext ctx) {

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
        return null;
	}

}
