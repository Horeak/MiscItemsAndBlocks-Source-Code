package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerGamePacketAccept;
import com.miscitems.MiscItemsAndBlocks.Proxies.ServerProxy;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GuiGame1Select extends GuiScreen{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GuiBlankOutInv.png");

    protected int xSize = 176;
    protected int ySize = 170;
    
    EntityPlayer player;

    
    protected int guiLeft;
    protected int guiTop;
    
    GuiButton Invite;
    GuiButton Accept;
    

    
	
	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSize) / 2;
	        int posY = (this.height - ySize) / 2;
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);
	        
	        
	        Gui.drawRect(posX + 5, posY + 28, posX + 5 + 165, posY + 28 + 55, new Color(100, 100, 100).getRGB());

	        if(ServerProxy.tickHandlerClient.tradeReq != null){
	        	this.drawString(this.fontRendererObj, "Invite from: " + ServerProxy.tickHandlerClient.tradeReq, posX + 7, posY + 30 , new Color(200, 200, 200).getRGB());
	        }
	        
	        Accept.enabled = ServerProxy.tickHandlerClient.tradeReq != null;
	        
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glDisable(GL11.GL_LIGHTING);


	        
	        super.drawScreen(x, y, f);
	        drawForeground(x, y, f);
	    }
	 
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    
	    @SuppressWarnings("unchecked")
		@Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
	        this.guiLeft = (this.width - this.xSize) / 2;
	        this.guiTop = (this.height - this.ySize) / 2;
	      

	        Invite = new GuiButton(1, guiLeft +  6, guiTop + 6, 80, 20, "Invite");
	        Accept = new GuiButton(2, guiLeft + 90, guiTop + 6, 80, 20, "Accept Invite");
	        
	        buttonList.add(Invite);
	        buttonList.add(Accept);
	        

	        Accept.enabled = ServerProxy.tickHandlerClient.tradeReq != null;
	        

	        
	        
	        
	    }
	    
	
	    
	    @Override
	    protected void actionPerformed(GuiButton button) {

	    	
	    	if(button.id == 1){
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new GuiGame_1_Invite());
	    	
	    	}else if(button.id == 2){
	    		

	                   
	    		Main.NETWORK_MANAGER.sendPacketToServer(new ServerGamePacketAccept(Minecraft.getMinecraft().thePlayer.getCommandSenderName()));

	    	}
	        	
	        
	    	

	        

	        }
	    
        public void drawForeground(int par1, int par2, float par3)
        {
        	for(int i = 0; i < this.buttonList.size(); i++){
            GuiButton btn = (GuiButton)this.buttonList.get(i);
        	
            if(btn.func_146115_a()){
            
            if(btn.id == 2){
            	
            drawTooltip(Arrays.asList(new String[] {ServerProxy.tickHandlerClient.tradeReq != null ? "Accept game invite from: " + ServerProxy.tickHandlerClient.tradeReq : "No game invites."}), par1, par2);
          
            }else if (btn.id == 1){
            	
            	
                    drawTooltip(Arrays.asList(new String[] {"Invite a player to play."}), par1, par2);
                    
            }
            
            }
        	}
        
        
        }
        
        @SuppressWarnings("rawtypes")
		protected void drawTooltip(List par1List, int par2, int par3)
        {
            if (!par1List.isEmpty())
            {
                GL11.glDisable(GL12.GL_RESCALE_NORMAL);
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                int k = 0;
                Iterator iterator = par1List.iterator();

                while (iterator.hasNext())
                {
                    String s = (String)iterator.next();
                    int l = this.fontRendererObj.getStringWidth(s);

                    if (l > k)
                    {
                        k = l;
                    }
                }

                int i1 = par2 + 12;
                int j1 = par3 - 12;
                int k1 = 8;

                if (par1List.size() > 1)
                {
                    k1 += 2 + (par1List.size() - 1) * 10;
                }

                if (i1 + k > this.width)
                {
                    i1 -= 28 + k;
                }

                if (j1 + k1 + 6 > this.height)
                {
                    j1 = this.height - k1 - 6;
                }

                this.zLevel = 300.0F;
                int l1 = -267386864;
                this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
                this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
                this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
                this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
                this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
                int i2 = 1347420415;
                int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
                this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
                this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
                this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
                this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

                for (int k2 = 0; k2 < par1List.size(); ++k2)
                {
                    String s1 = (String)par1List.get(k2);
                    this.fontRendererObj.drawStringWithShadow(s1, i1, j1, -1);

                    if (k2 == 0)
                    {
                        j1 += 2;
                    }

                    j1 += 10;
                }

                this.zLevel = 0.0F;
                GL11.glEnable(GL11.GL_DEPTH_TEST);
                GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            }
        }


}