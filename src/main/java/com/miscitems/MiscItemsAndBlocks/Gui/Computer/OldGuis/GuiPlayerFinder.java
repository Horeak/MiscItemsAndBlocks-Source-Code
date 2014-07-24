package com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

public class GuiPlayerFinder extends GuiScreen{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GuiPlayerFinder.png");

    protected static int xSize = 248;
    protected static int ySize = 169;
	
    public static final int xSizeOfTexture = xSize;
    public static final int ySizeOfTexture = ySize;
    
    
    GuiTextField textField;
    GuiButton teleport;
    
    EntityPlayer player;
    String Mode;
    
    int Page = 1;
    int Pages = 1;
    
    protected int guiLeft;
    protected int guiTop;

    
    public ArrayList<EntityPlayer> players = new ArrayList<EntityPlayer>();
    
    @Override
    public void updateScreen()
    {
    	
    	
    	players.clear();
    	
    	 for(int i = 0; i < mc.theWorld.playerEntities.size(); i++)
         {
                 EntityPlayer player = (EntityPlayer)mc.theWorld.playerEntities.get(i);
                 if(player.isEntityAlive() && !players.contains(player.getCommandSenderName()))
                 {
                         players.add(player);
                 }
         }
    	 
    	 
         buttonList.clear();
    	 Pages = players.size() / 5;
    	
    	 
    	 
    	 if(Pages <= 0)
    		 Pages = 1;
    	 
    	 if(players.size() > Pages * 5){
    		 Pages++;
    	 }

    	 
    	 buttonList.add(new GuiButton(players.size() + 1, guiLeft + 160, guiTop + 114, 80, 20, "Prev Page"));
    	 buttonList.add(new GuiButton(players.size() + 2, guiLeft + 160, guiTop + 144, 80, 20, "Next Page"));
         
    	 
    	 
         for(int i = 0; i < players.size(); i++)
         {
        	 


        	 if(i < Page * 5 && i >= (Page - 1) * 5){

                 buttonList.add(new GuiButton(i, guiLeft + 160, (guiTop - ((Page - 1) * 110)) + 4  + 22 * (int)Math.floor((double)i / 1D), 80, 20, players.get(i).getCommandSenderName()));
         
        	 }
         }
         
         
	        teleport = new GuiButton(players.size() + 5, guiLeft + 60, guiTop + 5, 50, 20, StatCollector.translateToLocal("gui.string.teleport"));
	        
	        buttonList.add(new GuiButton(players.size() + 4, guiLeft + 6, guiTop + 5, 50, 20, StatCollector.translateToLocal("gui.string.clear")));
	        buttonList.add(teleport);
	        
	        if(player == null || !Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
	        teleport.enabled = false;
    }

	
	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;

	        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
	        
	    	 this.drawCenteredString(fontRendererObj, Page + "/" + Pages, guiLeft + 200, guiTop + 135, 0x444444);
	        
	        this.drawRect(posX + 5, posY + 97, posX + 130, posY + 30, new Color(100,100,100).getRGB());

	        if(player != null && Mode == "Valid"){
		    fontRendererObj.drawString(player.getCommandSenderName() + "`s Coords: ", posX + 7, posY + 32, 10);
	        fontRendererObj.drawString("X Coord: " + (int)player.posX, posX + 7, posY + 40, 10);
	        fontRendererObj.drawString("Y Coord: " + (int)player.posY, posX + 7, posY + 48, 10);
	        fontRendererObj.drawString("Z Coord: " + (int)player.posZ, posX + 7, posY + 56, 10);
	        
	        if(Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode){
	        	teleport.enabled = true;
	        }else{
	        	teleport.enabled = false;
	        }

	        }
	        
	        
	        
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
			
	        this.guiLeft = (this.width - this.xSize) / 2;
	        this.guiTop = (this.height - this.ySize) / 2;
	    }
	    
	
	    
	    @Override
	    protected void actionPerformed(GuiButton button) {
	    	

	    	if(button.id == players.size() + 1){
	    		
	    		if(Page - 1 > 0)
	    			Page--;
	    		
	    		
	    		
	    	}else if (button.id == players.size() + 2){
	    		
	    		if(Page + 1 <= Pages)
	    		Page++;
	    		
	    	}else if (button.id == players.size() + 4){
	        	teleport.enabled = false;
	        	Mode = "Empty";
	        	player = null;
	    	}else if (button.id == players.size() + 5){

	    	

	        	if(this.player != null && Mode == "Valid"){
	        		
	        		Minecraft.getMinecraft().thePlayer.setLocationAndAngles((int)this.player.posX, (int)this.player.posY, (int)this.player.posZ, Minecraft.getMinecraft().thePlayer.rotationYaw, Minecraft.getMinecraft().thePlayer.rotationPitch);
	        		Minecraft.getMinecraft().thePlayer.closeScreen();
	        	}
	        	
	        
	    	}else{
	    		
	    		if(this.players.get(button.id) != null){
	    			
	    			


	    		       
	    		       if(players.get(button.id) != null){
	    		    	   
	    		    	   Mode = "Valid";
	    		    	   player = players.get(button.id);
	    		       }
	    		}
	    	}
	        

	        }
}
