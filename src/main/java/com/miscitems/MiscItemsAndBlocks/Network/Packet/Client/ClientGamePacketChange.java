package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiGame_1;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class ClientGamePacketChange  implements IMessage, IMessageHandler<ClientGamePacketChange, IMessage> {

	int Number;
	int Player;
	String Player_1;
	String Player_2;
	
	public ClientGamePacketChange(){}
	public ClientGamePacketChange(int Number, int Player, String Player_1, String Player_2){
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
        ByteBufUtils.writeUTF8String(buf,Player_1);
        ByteBufUtils.writeUTF8String(buf, Player_2);
	}

	@Override
	  public IMessage onMessage(ClientGamePacketChange message, MessageContext ctx) {
		
	     if (FMLCommonHandler.instance().getEffectiveSide().isClient())
		if((message.Player == 1 && Minecraft.getMinecraft().thePlayer.getCommandSenderName().equalsIgnoreCase(message.Player_2)) || (message.Player == 2 && Minecraft.getMinecraft().thePlayer.getCommandSenderName().equalsIgnoreCase(message.Player_1)) ){
      		
    		
    		if(FMLClientHandler.instance().getClient().currentScreen instanceof GuiGame_1){
    			GuiGame_1 gui = (GuiGame_1)Minecraft.getMinecraft().currentScreen;
    			

    			
    			if(!gui.CheckWinBlue() && !gui.CheckWinRed()){
    				if(message.Player == 1){
    					gui.Buttons[message.Number].displayString = gui.Mark_X;
    					gui.Buttons[message.Number].enabled = false;
    					gui.CurrentTurn = 2;
    					gui.CurrentPlayer = gui.player_2;
    					
    				}else if (message.Player == 2){
    					gui.Buttons[message.Number].displayString = gui.Mark_O;
    					gui.Buttons[message.Number].enabled = false;
    					gui.CurrentTurn = 1;
    					gui.CurrentPlayer = gui.player_1;
    				}
    				
    				

    				
    			}
    			
    			
    				
    				if(gui.CheckWinBlue() || gui.CheckWinRed()){
    					gui.Button_Restart.enabled = true;
    					
    					if(gui.CheckWinBlue()){
    						gui.BlueWins++;
    						gui.BlueWin = true;
    					}else if (gui.CheckWinRed()){
    						gui.RedWins++;
    						gui.RedWin = true;
    						
    					}
    					
    					
    					
    					for(int i = 0; i < gui.Buttons.length; i++){
    						gui.Buttons[i].enabled = false;
    					}
    					
    				}
    				
    				
    				for(int i = 0; i < gui.Buttons.length; i++){
    		    		
    		    		if(gui.Buttons[i].enabled){
    		    			return null;
    		    		}
    		    	}
    		    	
    		    	gui.Button_Restart.enabled = true;
    				
    			}
    		
        	
        	
        	
        	
          		}
        	

        return null;
	}



}
