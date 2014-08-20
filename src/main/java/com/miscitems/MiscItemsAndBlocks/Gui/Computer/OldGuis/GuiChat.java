package com.miscitems.MiscItemsAndBlocks.Gui.Computer.OldGuis;

import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerChatBlock;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerChatMessagePacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class GuiChat extends GuiContainer{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ChatGui.png");
	
    
    public GuiTextField chatBar;
    public GuiTextField ChannelBar;
    
    public ArrayList<String> chatMessages = new ArrayList<String>();
    

    
    public String Channel = "Default";
    
    public float chatScroll;

    
    public boolean chatScrolling;
    

    
    public float mouseX;
    public float mouseY;

	
	public GuiChat(InventoryPlayer InvPlayer, TileEntityComputer tile) {
		super(new ContainerChatBlock(InvPlayer, tile));
		
	    this.xSize = 198;
	    this.ySize = 152;
		
	    
	    
	    

	
	        
	}

	
  
  public void drawScreen(int par1, int par2, float par3)
  {

	  
      drawDefaultBackground();
      if(mc == null)
      {
              mc = Minecraft.getMinecraft();
              fontRendererObj = mc.fontRenderer;
      }
      
      
      boolean flag = Mouse.isButtonDown(0);
      if(!flag)
      {

              chatScrolling = false;
      }
      else if(chatScrolling)
      {
              chatScroll = MathHelper.clamp_float((float)((guiTop + 95 + 7) - par2) / 82F, 0.0F, 0.77F);
      }

	    
	    super.drawScreen(par1, par2, par3);
	    
	    if(Channel != null)
	    	 fontRendererObj.drawString("Channel:" + Channel, guiLeft + 96, guiTop + 10, 0, false);
	    
        drawChat();
        
        if(ChannelBar.getVisible())
        {
      	  ChannelBar.drawTextBox();
      	  
      	  
        }

	    
  }
  
  
  public void drawChat()
  {
	  
          if(chatBar.getVisible())
          {
               chatBar.drawTextBox();
          }
          
          
      GL11.glEnable(GL11.GL_STENCIL_TEST);
      GL11.glColorMask(false, false, false, false);

      GL11.glStencilFunc(GL11.GL_ALWAYS, 1, 0xFF);
      GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE);
      GL11.glStencilMask(0xFF);
      GL11.glClear(GL11.GL_STENCIL_BUFFER_BIT);

          drawSolidRect(guiLeft + 13, guiTop + 34, 166, 76, 0xffffff, 1.0F);
          
              GL11.glStencilMask(0x00);
              GL11.glStencilFunc(GL11.GL_EQUAL, 1, 0xFF);

      GL11.glColorMask(true, true, true, true);
          
              GL11.glPushMatrix();
              float scale = 0.5F;
              
      GL11.glScalef(scale, scale, scale);
      int lines = 0; 
      
          for(int i = 0; i < chatMessages.size(); i++)
          {
                   String msg = chatMessages.get(i);
                  
          List<?> list = fontRendererObj.listFormattedStringToWidth(msg, 342);
                  
          lines += list.size();
          }
          
          if(lines > 15)
          {
                  GL11.glTranslatef(0.0F, -(lines - 15) *13.0F * (0.77F - chatScroll), 0.0F);
          }
          
          lines = 0;
          
          for(int i = 0; i < chatMessages.size(); i++)
          {
                   String msg = chatMessages.get(i);
                  
          List<?> list = fontRendererObj.listFormattedStringToWidth(msg, 342);
                  
                  for(int kk = 0; kk < list.size(); kk++)
                  {
                	  

                               if(kk == 0)
                               {
                            	   
                            	   String[] text = list.get(kk).toString().split("-", 2);
                            	   
                            	   if(text.length > 1){
                                       String line = text[1];
                                       String prefix = text[0].substring(2) + ": ";
                      
                                       fontRendererObj.drawString(prefix, (int)((guiLeft + 13) / scale), (int)((guiTop + 34 + (lines * 5)) / scale), 0, false);
                                       fontRendererObj.drawString(line, (int)((guiLeft + 13) / scale + fontRendererObj.getStringWidth(prefix)), (int)((guiTop + 34 + (lines * 5)) / scale), 24737632, false);
                            	   }
                            	   }
                               else
                               {
                                       fontRendererObj.drawString(" " + (String)list.get(kk).toString(), (int)((guiLeft + 13) / scale), (int)((guiTop + 39 + (lines * 5)) / scale), 24737632, false);
                               }
                               
                          }
                  if(list.size() > 1)
                	  lines++;

                           lines++;
                  }
          
          
      GL11.glDisable(GL11.GL_STENCIL_TEST);
          
          GL11.glPopMatrix();
          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
          if(lines > 15){
                  GL11.glPushMatrix();
          	    mc.renderEngine.bindTexture(Texture);
                  GL11.glTranslatef(0.0F, -82F * chatScroll, 0.0F);
                  drawTexturedModalRect(guiLeft + 182, guiTop + 96, 3, 154, 4, 15);
                  GL11.glPopMatrix();
          }
  }
  
 
  
  protected void mouseClicked(int x, int y, int par3)
  {
      super.mouseClicked(x, y, par3);
  
      this.chatBar.mouseClicked(x, y, par3);
      this.ChannelBar.mouseClicked(x, y, par3);
      
      boolean isOnChatScroll = x >= guiLeft + 182 && x < guiLeft + 182 + 4 && y >= guiTop + 95 - 82 && y < guiTop + 95 + 15;
      if(isOnChatScroll)
      {
              chatScrolling = true;
      }


      
      
  }
  
  public void drawSolidRect(int par0, int par1, int par2, int par3, int par4, float alpha)
  {
	  float f1 = (float)(par4 >> 16 & 255) / 255.0F;
	  float f2 = (float)(par4 >> 8 & 255) / 255.0F;
	  float f3 = (float)(par4 & 255) / 255.0F;
	  Tessellator tessellator = Tessellator.instance;
	  GL11.glDisable(GL11.GL_TEXTURE_2D);
	  GL11.glColor4f(f1, f2, f3, alpha);
	  tessellator.startDrawingQuads();
	  tessellator.addVertex((double)(par0 + 0), (double)(par1 + par3), (double)this.zLevel);
	  tessellator.addVertex((double)(par0 + par2), (double)(par1 + par3), (double)this.zLevel);
	  tessellator.addVertex((double)(par0 + par2), (double)(par1 + 0), (double)this.zLevel);
	  tessellator.addVertex((double)(par0 + 0), (double)(par1 + 0), (double)this.zLevel);
	  tessellator.draw();
	  GL11.glEnable(GL11.GL_TEXTURE_2D);
  }


	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	   	  

	}
	
    protected void keyTyped(char par1, int par2)
    {
    	
   
        
        if(chatBar.isFocused() && par2 == Keyboard.KEY_RETURN && !chatBar.getText().isEmpty())
        {



        	PacketHandler.sendToServer(new ServerChatMessagePacket(mc.thePlayer.getCommandSenderName() + "-" + chatBar.getText() + "-" + Channel), Main.Utils.channels);

                
                
                chatBar.setText("");
                
        }else if(ChannelBar.isFocused() && par2 == Keyboard.KEY_RETURN && !ChannelBar.getText().isEmpty())
            {
        	if(ChannelBar.getText() != Channel){
        		  

                    
                    
                    Channel = ChannelBar.getText();
                    ChannelBar.setText("");
        	}else{
                ChannelBar.setText("");
        	}
                    
            }else if (ChannelBar.isFocused()){
        		ChannelBar.textboxKeyTyped(par1, par1);
        		
            }else if (chatBar.isFocused()){
        		chatBar.textboxKeyTyped(par1, par2);
            }
    	
    	
        if (par2 == 1)
        {
            this.mc.thePlayer.closeScreen();
        }
        
        
    	
    	
     
    }
	
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		

        
		
        int posX = (this.width - this.xSize) / 2;
        int posY = (this.height - this.ySize) / 2;
		
	        
	        
            chatBar = new GuiTextField(mc.fontRenderer, posX + 9, posY + 131, 180, 19);
            chatBar.setMaxStringLength(80);
            chatBar.setEnableBackgroundDrawing(false);
            chatBar.setTextColor(26777215);
            
            
            ChannelBar = new GuiTextField(mc.fontRenderer, posX + 9, posY + 11, 78, 19);
            ChannelBar.setMaxStringLength(9);
            ChannelBar.setEnableBackgroundDrawing(false);
            ChannelBar.setTextColor(26777215);


		

		

		
		
	}
	
	public void AddMessage(String msg){
		chatMessages.add(msg);
	
	}
	
	public void ReciveChatMessage(String Line){
		
		String[] text1 = Line.split("-");
		if(text1.length > 1){
		
		String Player = text1[0];
		String Message = text1[1];
		String Channel = text1[2];
		
		if(this.Channel.equals(Channel)){

			if (!Message.startsWith("/")){
			AddMessage("  " + Player + "-" + Message);
			}
			
			
		}
		
		}
	}

		
		
	public void SendMessage(String Message){
    	PacketHandler.sendToServer(new ServerChatMessagePacket(mc.thePlayer.getCommandSenderName() + "-" + Message + "-" + Channel), Main.Utils.channels);

        
         
		
	}
	




	
}