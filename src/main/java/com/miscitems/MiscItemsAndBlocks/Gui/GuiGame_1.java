package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientGamePacketRestart;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerGamePacketChange;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerGamePacketClosed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class GuiGame_1 extends GuiScreen
{
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/TicTacToeGui.png");
	
	
    public static final int xSizeOfTexture = 256;
    public static final int ySizeOfTexture = 155;

    
    public boolean RedWin = false;
    public boolean BlueWin = false;
    
    public int RedWins = 0;
    public int BlueWins = 0;

    
    
    public static String Mark_X = EnumChatFormatting.BLUE + "X";
    public static String Mark_O = EnumChatFormatting.RED + "O";
    
   public EntityPlayer player_1;
   public EntityPlayer player_2;
    
    
    
    public int CurrentTurn;
    public EntityPlayer CurrentPlayer;
    
    
    GuiButton Button_1;
    GuiButton Button_2;
    GuiButton Button_3;
    
    GuiButton Button_4;
    GuiButton Button_5;
    GuiButton Button_6;
    
    GuiButton Button_7;
    GuiButton Button_8;
    GuiButton Button_9;
    
    public GuiButton Button_Restart;
    
    public GuiButton[] Buttons;
    
	
	
	public GuiGame_1(String player2, String player1){
		
		
		player_2 = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(player2);
		player_1 = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(player1);
		

		CurrentPlayer = player_1;
		CurrentTurn = 1;
	}

	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

	        if(player_1 != null)
	        this.drawString(this.fontRendererObj, (player_1 == Minecraft.getMinecraft().thePlayer ?  "Player 1: " + EnumChatFormatting.BLUE + "You" : "Player 1: "+ EnumChatFormatting.BLUE + player_1.getCommandSenderName()), posX + 127, posY + 26, 0x888888);
	        
	        if(player_2 != null)
	        this.drawString(this.fontRendererObj, (player_2 == Minecraft.getMinecraft().thePlayer ?  "Player 2: "+ EnumChatFormatting.RED +"You" : "Player 2: " + EnumChatFormatting.RED + player_2.getCommandSenderName()), posX + 127, posY + 26 + 10, 0x888888);
	        
	        this.drawString(this.fontRendererObj, EnumChatFormatting.GRAY + "Score: ", posX + 127, posY + 56, 0x888888);
	        this.drawCenteredString(this.fontRendererObj, "" + EnumChatFormatting.RED + "" + RedWins + EnumChatFormatting.RESET + " : " + EnumChatFormatting.BLUE + BlueWins, posX + 177, posY + 66, 0x888888);
	        
	        	
	        	if(BlueWin){
	    	        this.drawString(this.fontRendererObj, EnumChatFormatting.BLUE + "Blue won!", posX + 127, posY + 83, 0x888888);
	        		
	        	}else if(RedWin){
	    	        this.drawString(this.fontRendererObj, EnumChatFormatting.RED + "Red won!", posX + 127, posY + 83, 0x888888);
	        	}
	        
	        
	        this.drawString(this.fontRendererObj, CurrentTurn == 1 ? EnumChatFormatting.BLUE + "Player 1" + EnumChatFormatting.RESET + "`s turn." : EnumChatFormatting.RED + "Player 2" + EnumChatFormatting.RESET + "`s turn.", posX + 127, posY + 107, 0x888888);
	        
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glDisable(GL11.GL_LIGHTING);

	        super.drawScreen(x, y, f);
	    }

	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    

	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        
	        Button_1 = new GuiButton(1, posX + 32, posY + 39, 20, 20, "");
	        Button_2 = new GuiButton(2, posX + 53, posY + 39, 20, 20, "");
	        Button_3 = new GuiButton(3, posX + 74, posY + 39, 20, 20, "");
	        
	        Button_4 = new GuiButton(4, posX + 32, posY + 60, 20, 20, "");
	        Button_5 = new GuiButton(5, posX + 53, posY + 60, 20, 20, "");
	        Button_6 = new GuiButton(6, posX + 74, posY + 60, 20, 20, "");
	        
	        Button_7 = new GuiButton(7, posX + 32, posY + 81, 20, 20, "");
	        Button_8 = new GuiButton(8, posX + 53, posY + 81, 20, 20, "");
	        Button_9 = new GuiButton(9, posX + 74, posY + 81, 20, 20, "");
	        
	        Button_Restart = new GuiButton(10, posX + 82, posY + 123, 96, 20, "Restart");
	        
	        buttonList.add(Button_1);
	        buttonList.add(Button_2);
	        buttonList.add(Button_3);
	        
	        buttonList.add(Button_4);
	        buttonList.add(Button_5);
	        buttonList.add(Button_6);
	        
	        buttonList.add(Button_7);
	        buttonList.add(Button_8);
	        buttonList.add(Button_9);
	        
	        buttonList.add(Button_Restart);
	        
	        
	        
	        Button_Restart.enabled = false;
	        
	        Buttons = new GuiButton[]{Button_1, Button_2, Button_3, Button_4, Button_5, Button_6, Button_7, Button_8, Button_9};
	        

	    }
	    


	    @Override
	    public void actionPerformed(GuiButton button) {
	    	

	    	
	    	
	    	if(button.id == 10){
	    		
	    		for(int i = 0; i < Buttons.length; i++){
	    			Buttons[i].displayString = "";
	    			Buttons[i].enabled = true;
	    		}
	    		
	    		CurrentPlayer = player_1;
	    		CurrentTurn = 1;
	    		
	    		RedWin = false;
	    		BlueWin = false;
	    		
		    	Button_Restart.enabled = false;
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                DataOutputStream stream1 = new DataOutputStream(bytes);
                
                try {

					stream1.writeUTF(player_1.getCommandSenderName());
					stream1.writeUTF(player_2.getCommandSenderName());
                	
                        if(player_1 != player_2){
                        	
                        	if(player_1.getCommandSenderName().equalsIgnoreCase(Minecraft.getMinecraft().thePlayer.getCommandSenderName())){
                        		PacketHandler.INSTANCE.sendTo(new ClientGamePacketRestart(), (EntityPlayerMP)player_2);
                        		
                        	}else if (player_2.getCommandSenderName().equalsIgnoreCase(Minecraft.getMinecraft().thePlayer.getCommandSenderName())){
                        		PacketHandler.INSTANCE.sendTo(new ClientGamePacketRestart(), (EntityPlayerMP)player_1);
                        	}
                        	
                        }
				} catch (IOException e) {
					e.printStackTrace();
				}
                        
	    		return;
	    		
	    	}else{

	    		
	    		


	    	
	    	
	    	if(!RedWin && !BlueWin){
	    		
	    		
	    	if(CurrentPlayer == Minecraft.getMinecraft().thePlayer || player_1.equals(player_2)){
	    		
	    		


			                        if(player_1 != player_2)

			                        	PacketHandler.INSTANCE.sendToServer(new ServerGamePacketChange(button.id - 1, CurrentTurn, player_1.getCommandSenderName(), player_2.getCommandSenderName()));
	                     
	    	
	    	if(Buttons[button.id - 1].enabled){
	    		if(CurrentTurn == 1){
	    			Buttons[button.id - 1].displayString = Mark_X;
	    			Buttons[button.id - 1].enabled = false;
	    			CurrentTurn = 2;
	    			CurrentPlayer = player_2;
	    			
	    		}else{
	    			Buttons[button.id - 1].displayString = Mark_O;
	    			Buttons[button.id - 1].enabled = false;
	    			CurrentTurn = 1;
	    			CurrentPlayer = player_1;
	    		}
	    	}

	    }
	    	}
	    	
	    	
	        if(CheckWinBlue() || CheckWinRed()){
		    	Button_Restart.enabled = true;
		    	
		    	if(CheckWinBlue()){
		    		BlueWins++;
		    		BlueWin = true;
		    	}else if (CheckWinRed()){
		    		RedWins++;
		    		RedWin = true;
		    		
		    	}
		    	
		    	for(int h = 0; h < Buttons.length; h++){
		    		Buttons[h].enabled = false;
		    	}
	        }
	    	
	    	
	    	for(int i = 0; i < Buttons.length; i++){
	    		
	    		if(Buttons[i].enabled){
	    			return;
	    		}
	    	}
	    	
	    	Button_Restart.enabled = true;
	    
	    
	    	
	    	}

	    	
	    }
	    
	    
	    
	    public boolean CheckWinBlue(){
	    	
	    	boolean b1 = Button_1.displayString == Mark_X;
	    	boolean b2 = Button_2.displayString == Mark_X;
	    	boolean b3 = Button_3.displayString == Mark_X;
	    	
	    	boolean b4 = Button_4.displayString == Mark_X;
	    	boolean b5 = Button_5.displayString == Mark_X;
	    	boolean b6 = Button_6.displayString == Mark_X;
	    	
	    	boolean b7 = Button_7.displayString == Mark_X;
	    	boolean b8 = Button_8.displayString == Mark_X;
	    	boolean b9 = Button_9.displayString == Mark_X;
	    	
	    	return Check(b1,b2,b3,b4,b5,b6,b7,b8,b9);
	    }
	    
	    public boolean CheckWinRed(){
	    	
	    	boolean b1 = Button_1.displayString == Mark_O;
	    	boolean b2 = Button_2.displayString == Mark_O;
	    	boolean b3 = Button_3.displayString == Mark_O;
	    	
	    	boolean b4 = Button_4.displayString == Mark_O;
	    	boolean b5 = Button_5.displayString == Mark_O;
	    	boolean b6 = Button_6.displayString == Mark_O;
	    	
	    	boolean b7 = Button_7.displayString == Mark_O;
	    	boolean b8 = Button_8.displayString == Mark_O;
	    	boolean b9 = Button_9.displayString == Mark_O;
	    	

	    	return Check(b1,b2,b3,b4,b5,b6,b7,b8,b9);
	    }
	    
	    public boolean Check(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6, boolean b7, boolean b8, boolean b9){
	    	
	    	
	    	if(b1 && b2 && b3) return true;
	    	if(b1 && b4 && b7) return true;
	    	if(b7 && b8 && b9) return true;
	    	if(b3 && b6 && b9) return true;
	    	
	    	if(b2 && b5 && b8) return true;
	    	if(b4 && b5 && b6) return true;
	    	
	    	if(b1 && b5 && b9) return true;
	    	if(b3 && b5 && b7) return true;
	    	
	    	return false;
	    }
	    
	  
	    public void onGuiClosed() {
	    	
	    	


		                        if(player_1 != player_2)

		                        	PacketHandler.INSTANCE.sendToServer(new ServerGamePacketClosed(player_1.getCommandSenderName(), player_2.getCommandSenderName()));
		                        	
		                        	
	    	
	    	
	    }

}
