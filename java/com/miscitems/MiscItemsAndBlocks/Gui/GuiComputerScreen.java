package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerComputer;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class GuiComputerScreen extends GuiContainer{

	TileEntityComputer tile;
	
	boolean Menu = false;
	boolean Hide = false;
	
	double Version = 0.01;

	
	
	GuiButton Button_Chat;
	GuiButton Button_PlayerFinder;
	GuiButton Button_Hide;
	
	GuiButton Button_Game_1;
	GuiButton Button_Game_2;
	
	GuiButton Button_3;
	GuiButton Button_4;
	
	GuiButton Button_5;
	GuiButton Button_6;
	
	GuiButton Button_7;
	GuiButton Button_8;
	
	GuiButton Button_9;
	GuiButton Button_10;
	
	public GuiComputerScreen(TileEntityComputer tile) {
		super(new ContainerComputer(tile));
		this.tile = tile;
	}

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ComputerScreenGui.png");
	
	
    public static final int xSizeOfTexture = 256;
    public static final int ySizeOfTexture = 177;
    
    int ButtonSizeX = 75;
    int ButtonSizeY = 20;
    

   
    
	
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
			
	        Random rand = new Random();

			
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        
	        Button_Chat = new GuiButton(1, posX + 8, posY + 4, ButtonSizeX, ButtonSizeY, StatCollector.translateToLocal("gui.string.chat"));
	        Button_PlayerFinder = new GuiButton(2, posX + 90, posY + 4, ButtonSizeX, ButtonSizeY, StatCollector.translateToLocal("gui.string.playerfinder"));
	        Button_Game_1 = new GuiButton(3, posX + 170, posY + 4, ButtonSizeX, ButtonSizeY, "Tic Tac Toe");
	        
	        Button_Game_2 = new GuiButton(4, posX + 8, posY + 4 + (ButtonSizeY * 2) - 16, ButtonSizeX, ButtonSizeY, "Master Mind [WIP]");
	        Button_3 = new GuiButton(5, posX + 90, posY + 4 + (ButtonSizeY * 2) - 16, ButtonSizeX, ButtonSizeY, "");
	        Button_4 = new GuiButton(6, posX + 170, posY + 4 + (ButtonSizeY * 2) - 16, ButtonSizeX, ButtonSizeY, "");
	        
	        Button_5 = new GuiButton(7, posX + 8, posY + 4 + (ButtonSizeY * 3) - 12, ButtonSizeX, ButtonSizeY, "");
	        Button_6 = new GuiButton(8, posX + 90, posY + 4 + (ButtonSizeY * 3) - 12, ButtonSizeX, ButtonSizeY, "");
	        Button_7 = new GuiButton(9, posX + 170, posY + 4 + (ButtonSizeY * 3) - 12, ButtonSizeX, ButtonSizeY, "");
	        
	        Button_8 = new GuiButton(10, posX + 8, posY + 4 + (ButtonSizeY * 4) - 8, ButtonSizeX, ButtonSizeY, "");
	        Button_9 = new GuiButton(11, posX + 90, posY + 4 + (ButtonSizeY * 4)  - 8, ButtonSizeX, ButtonSizeY, "");
	        Button_10 = new GuiButton(12, posX + 170, posY + 4 + (ButtonSizeY * 4) - 8, ButtonSizeX, ButtonSizeY, "");
	        
	        Button_Hide = new GuiButton(13, posX + 218, posY + 82, 33, 16, "Hide");
	        
	        
	        Button_3.enabled = false;
	        Button_4.enabled = false;
	        Button_5.enabled = false;
	        Button_6.enabled = false;
	        Button_7.enabled = false;
	        Button_8.enabled = false;
	        Button_9.enabled = false;
	        Button_10.enabled = false;
	        
	        buttonList.add(Button_Chat);
	        buttonList.add(Button_PlayerFinder);
	        buttonList.add(Button_Hide);
	        
	        buttonList.add(Button_Game_1);
	        buttonList.add(Button_Game_2);
	        buttonList.add(Button_3);
	        buttonList.add(Button_4);
	        buttonList.add(Button_5);
	        buttonList.add(Button_6);
	        buttonList.add(Button_7);
	        buttonList.add(Button_8);
	        buttonList.add(Button_9);
	        buttonList.add(Button_10);
	        
	        
			
	        
	    }
	    
	    @Override
	    protected void actionPerformed(GuiButton par1GuiButton) {
	        switch (par1GuiButton.id) {
	        
	        
	        case 1:
	        	Minecraft.getMinecraft().thePlayer.openGui(Main.instance, GuiHandler.ChatID, Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
	        	break;
	        	
	        case 2:
	        	Minecraft.getMinecraft().thePlayer.openGui(Main.instance, GuiHandler.PlayerFindID, Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
	        	break;
	        	
	        case 3:
	        	Minecraft.getMinecraft().thePlayer.openGui(Main.instance, GuiHandler.TicTacToeID, Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
	        	break;
	        	
	        case 4:
	        	Minecraft.getMinecraft().thePlayer.openGui(Main.instance, GuiHandler.MasterMindID, Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
	        	break;
	        
	        case 13:
	        	if(Hide)
	        		Hide = false;
	        	else
	        		Hide = true;
	        	break;
	        }
	        
	    }
	    

		@Override
		protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
			  drawDefaultBackground();
			  
		        GL11.glEnable(GL11.GL_BLEND);


		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

		        int posX = (this.width - xSizeOfTexture) / 2;
		        int posY = (this.height - ySizeOfTexture) / 2;
		        

		        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		        
		        
		        
		        if(Hide){
		        	Button_Game_1.visible = false;
		        	Button_Game_2.visible = false;
			        Button_3.visible = false;
			        Button_4.visible = false;
			        Button_5.visible = false;
			        Button_6.visible = false;
			        Button_7.visible = false;
			        Button_8.visible = false;
			        Button_9.visible = false;
			        Button_10.visible = false;
			        
			        Button_Chat.visible = false;
			        Button_PlayerFinder.visible = false;
			        
			        Button_Hide.displayString = "Show";
			        
		        }else{
		        	Button_Game_1.visible = true;
		        	Button_Game_2.visible = true;
			        Button_3.visible = true;
			        Button_4.visible = true;
			        Button_5.visible = true;
			        Button_6.visible = true;
			        Button_7.visible = true;
			        Button_8.visible = true;
			        Button_9.visible = true;
			        Button_10.visible = true;
			        
			        Button_Chat.visible = true;
			        Button_PlayerFinder.visible = true;
			        
			        Button_Hide.displayString = "Hide";
		        }
		        
		        
		        
		        if(Menu){
			        drawTexturedModalRect(posX + 208, posY + 160, 223, 195, 15, 15);
			        
			        drawTexturedModalRect(posX + 149, posY + 81, 0, 178, 103, 78);
			        
			        
			        GL11.glScalef(0.5F, 0.5F, 0.5F);
			        fontRendererObj.drawString(StatCollector.translateToLocal("gui.computer"), (posX + 152) * 2, (posY + 84) * 2, 1);
			        fontRendererObj.drawString(StatCollector.translateToLocal("gui.string.computerversion") + Version, (posX + 152) * 2, (posY + 90) * 2, 1);
			        fontRendererObj.drawString(StatCollector.translateToLocal("gui.string.loggedinas") + ": " + Minecraft.getMinecraft().thePlayer.getCommandSenderName(), (posX + 152) * 2, (posY + 96) * 2, 1);
			        
			        fontRendererObj.drawString("Cords: ", (posX + 152) * 2, (posY + 146) * 2, 1);
			        fontRendererObj.drawString("X: " + tile.xCoord + " Y: " + tile.yCoord + " Z: " + tile.zCoord, (posX + 152) * 2, (posY + 152) * 2, 1);
			       //8 and below to not overwrite menu
			        
			        Button_8.visible = false;
			        Button_9.visible = false;
			        Button_10.visible = false;
			        
			        Button_Hide.visible = true;
		        }else{
			        drawTexturedModalRect(posX + 208, posY + 160, 223, 179, 15, 15);
			        
			        if(!Hide){
			        Button_8.visible = true;
			        Button_9.visible = true;
			        Button_10.visible = true;
			        }
			        
			        Button_Hide.visible = false;
		        }
		        
		        
		
		        if(!Menu)
		        GL11.glScalef(1F, 1F, 1F);
		        else
			        GL11.glScalef(2F, 2F, 2F);	
		        
		        
		        
		        GL11.glDisable(GL11.GL_BLEND);
		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        GL11.glDisable(GL11.GL_LIGHTING);
		        
		        
		}
		        
		        
			
	    
		
		public void ButtonPressed(int x, int y){
			
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        if(x >= posX + 207 && x <= posX + 207 + 15 && y >= posY + 159 && y <= posY + 159 + 15){
	        	
	        	if(Menu){
	        		Menu = false;
	        	}else{
	        		Menu = true;
	        	}
	        }
			
			
		}
		
	    protected void mouseClicked(int x, int y, int z)
	    {
	    	super.mouseClicked(x, y, z);
	    	ButtonPressed(x, y);
	    }
}
