package com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis;


import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerGamePacketInvite;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Collections;

public class GuiGame_1_Invite extends GuiScreen{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GameInvite.png");

    protected int xSize = 176;
    protected int ySize = 170;
    
    EntityPlayer player;
    int Page = 1;
    int Pages = 1;

    
    protected int guiLeft;
    protected int guiTop;
    
    
    public ArrayList<String> players = new ArrayList<String>();
    
    @Override
    public void updateScreen()
    {
    	
    	players.clear();
    	
    	 for(int i = 0; i < mc.theWorld.playerEntities.size(); i++)
         {
                 EntityPlayer player = (EntityPlayer)mc.theWorld.playerEntities.get(i);
                 if(player.isEntityAlive() && !players.contains(player.getCommandSenderName()))
                 {
                         players.add(player.getCommandSenderName());
                 }
         }
    	 
    	 
         Collections.sort(players);
         
         
         buttonList.clear();
    	 Pages = players.size() / 12;
    	 
    	 
    	 if(Pages <= 0)
    		 Pages = 1;
    	 
    	 if(players.size() > Pages * 12){
    		 Pages++;
    	 }

    	 
    	 buttonList.add(new GuiButton(players.size() + 1, guiLeft + 4, guiTop + 140, 70, 20, "Prev Page"));
    	 buttonList.add(new GuiButton(players.size() + 2, guiLeft + 102, guiTop + 140, 70, 20, "Next Page"));
         
         for(int i = 0; i < players.size(); i++)
         {
        	 


        	 if(i < Page * 12 && i >= (Page - 1) * 12 ){

        		 
                 buttonList.add(new GuiButton(i, guiLeft + 6 + (i % 2 == 1 ? 84 : 0), (guiTop - ((Page - 1) * 12) * 11) + 4 + 22 * (int)Math.floor((double)i / 2D), 80, 20, players.get(i)));
         
        	 }
    }
         
 }
    	
    
	
	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSize) / 2;
	        int posY = (this.height - ySize) / 2;
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);
	        
	        

	    	 this.drawString(fontRendererObj, Page + "/" + Pages, guiLeft + 79, guiTop + 146, 0x444444);
	        
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
	        this.guiLeft = (this.width - this.xSize) / 2;
	        this.guiTop = (this.height - this.ySize) / 2;
	      


	        
	        
	    }
	    
	
	    
	    @Override
	    protected void actionPerformed(GuiButton button) {

	        	
	    	if(button.id <= players.size()){

	    		PacketHandler.sendToServer(new ServerGamePacketInvite(players.get(button.id)), Main.Utils.channels);
	    	}
	    	
	    	if(button.id == players.size() + 1){
	    		
	    		if(Page - 1 > 0)
	    			Page--;
	    		
	    		
	    	}else if (button.id == players.size() + 2){
	    		
	    		if(Page + 1 <= Pages)
	    		Page++;
	    		
	    	}
	        	
	        
	        

	        }
	    
	    
	    protected void keyTyped(char par1, int par2)
	    {

	    	if(par2 == 1){
	            FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new GuiGame1Select());
	    	}
	    }
}