package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis.GuiGame_1;
import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;


public class ClientGamePacketChange  extends AbstractPacket {

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

    public void fromBytes(ByteBuf buf, Side side){
		Number = buf.readInt();
		Player = buf.readInt();
		
		Player_1 = ByteBufUtils.readUTF8String(buf);
		Player_2 = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf, Side side) {


        buf.writeInt(Number);
        buf.writeInt(Player);
        ByteBufUtils.writeUTF8String(buf,Player_1);
        ByteBufUtils.writeUTF8String(buf, Player_2);
	}

	@Override
	  public void onMessage(Side side, EntityPlayer player) {

        if (FMLCommonHandler.instance().getEffectiveSide().isClient())
		if((Player == 1 && Minecraft.getMinecraft().thePlayer.getCommandSenderName().equalsIgnoreCase(Player_2)) || (Player == 2 && Minecraft.getMinecraft().thePlayer.getCommandSenderName().equalsIgnoreCase(Player_1)) ){
      		
    		
    		if(FMLClientHandler.instance().getClient().currentScreen instanceof GuiGame_1){
    			GuiGame_1 gui = (GuiGame_1)Minecraft.getMinecraft().currentScreen;
    			

    			
    			if(!gui.CheckWinBlue() && !gui.CheckWinRed()){
    				if(Player == 1){
    					gui.Buttons[Number].displayString = gui.Mark_X;
    					gui.Buttons[Number].enabled = false;
    					gui.CurrentTurn = 2;
    					gui.CurrentPlayer = gui.player_2;
    					
    				}else if (Player == 2){
    					gui.Buttons[Number].displayString = gui.Mark_O;
    					gui.Buttons[Number].enabled = false;
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
    		    			return;
    		    		}
    		    	}
    		    	
    		    	gui.Button_Restart.enabled = true;
    				
    			}
    		
        	
        	
        	
        	
          		}
        	
	}



}
