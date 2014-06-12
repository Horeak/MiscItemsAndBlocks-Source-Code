package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerLensBench;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.GuiLensBenchButton;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerLensBenchPacketDone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GuiLensBench extends GuiContainer{

	private TileEntityLensBench tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GuiLensBench.png");
	
	
	int Power, Strength = 1;
	boolean Damage, TransferPower, Redstone, Color;
	int Red, Green, Blue;
	
	GuiLensBenchButton DamageBTN, RedstoneBTN, PowerBTN;
	
	GuiTextField PowerText, StrengthText, RedText, GreenText, BlueText;
	
	
	public GuiLensBench(InventoryPlayer InvPlayer, TileEntityLensBench tile) {
		super(new ContainerLensBench(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 256;
		
		this.tile = tile;
		
	
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString("Lens Bench" , 32, 12, 4210752);
          
          
          PowerText.drawTextBox();
          StrengthText.drawTextBox();
          
          RedText.drawTextBox();
          GreenText.drawTextBox();
          BlueText.drawTextBox();
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
        int posX = (this.width - xSize) / 2;
        int posY = (this.height - ySize) / 2;
        
        DamageBTN = new GuiLensBenchButton(0, posX + 105, posY + 7, 1);
        RedstoneBTN = new GuiLensBenchButton(1, posX + 125, posY + 7, 2);
        PowerBTN = new GuiLensBenchButton(2, posX + 145, posY + 7, 3);
        
        PowerText = new GuiTextField(fontRendererObj, 8, 39, 60, 15);
        StrengthText = new GuiTextField(fontRendererObj, 88, 39, 80, 15);
        
        RedText = new GuiTextField(fontRendererObj, 8, 80, 60, 15);
        BlueText = new GuiTextField(fontRendererObj, 8, 120, 60, 15);
        GreenText = new GuiTextField(fontRendererObj, 88, 80, 80, 15);
        
        
        
        //Power
        buttonList.add(new GuiButton(3, posX + 7, posY + 56, 30, 20, "-"));
        buttonList.add(new GuiButton(4, posX + 39, posY + 56, 30, 20, "+"));
        
        //Strength
        buttonList.add(new GuiButton(5, posX + 87, posY + 56, 40, 20, "-"));
        buttonList.add(new GuiButton(6, posX + 129, posY + 56, 40, 20, "+"));
        
        //Red
        buttonList.add(new GuiButton(7, posX + 7, posY + 97, 30, 20, "-"));
        buttonList.add(new GuiButton(8, posX + 39, posY + 97, 30, 20, "+"));
        
        //Green
        buttonList.add(new GuiButton(9, posX + 87, posY + 97, 40, 20, "-"));
        buttonList.add(new GuiButton(10, posX + 129, posY + 97, 40, 20, "+"));
        
        //Blue
        buttonList.add(new GuiButton(11, posX + 7, posY + 137, 30, 20, "-"));
        buttonList.add(new GuiButton(12, posX + 39, posY + 137, 30, 20, "+"));
        
        
        
        //Reset Color
        buttonList.add(new GuiButton(13, posX + 90, posY + 120, 70, 20, "Reset Color"));
        
        buttonList.add(new GuiButton(14, posX + 86, posY + 142, 80, 20, "Load from Lens"));
        
        buttonList.add(DamageBTN);
        buttonList.add(RedstoneBTN);
        buttonList.add(PowerBTN);
		
	}
	
	public int Num = 1;
	
    @Override
    protected void actionPerformed(GuiButton button) {
    	
    	if(tile.getStackInSlot(0) != null){

    		PacketHandler.INSTANCE.sendToServer(new ServerLensBenchPacketDone(Color, Red, Green, Blue, Power, Strength, TransferPower, Damage, Redstone, tile.xCoord, tile.yCoord, tile.zCoord));
    	}
    	
		if(button.id == 0){
			if(DamageBTN.Mode == 1){
				DamageBTN.Mode = 2;
				Damage = false;
			}else if (DamageBTN.Mode == 2){
				DamageBTN.Mode = 1;
				Damage = true;
			}
			
		}else if (button.id == 1){
			
			if(RedstoneBTN.Mode == 1){
				RedstoneBTN.Mode = 2;
				Redstone = false;
			
			}else if (RedstoneBTN.Mode == 2){
				RedstoneBTN.Mode = 1;
				Redstone = true;
			}
			
			
		}else if (button.id == 2){
			if(PowerBTN.Mode == 1){
				PowerBTN.Mode = 2;
				TransferPower = false;
				
			}else if (PowerBTN.Mode == 2){
				PowerBTN.Mode = 1;
				TransferPower = true;
			}
			
		}
		
		
		if(button.id == 3){
			if(Power - Num >= 0)
				Power -= Num;
			else
				Power = 0;
			
		}else if (button.id == 4){
			if(Power + Num < 10)
				Power += Num;
			else
				Power = 10;
			
		}else if (button.id == 5){
			if(Strength - Num  > 1)
				Strength -= Num;
			else
				Strength = 1;
		
		}else if (button.id == 6){
			if(Strength + Num < 100)
				Strength += Num;
			else
				Strength = 100;
		
		}
		
		int id = button.id;
		
		if(id == 7){
			if(Red - Num >= 0)
				Red -= Num;
			else
				Red = 0;
		}
			
		
		if(id == 8){
			if(Red + Num < 255)
				Red += Num;
			else
				Red = 255;
		}
		
		
		
		if(id == 9){
			if(Green - Num >= 0)
				Green -= Num;
			else
				Green = 0;
		}
		
		
		if(id == 10)
			if(Green + Num < 255)
				Green += Num;
			else
				Green = 255;
		
		
		
		
		if(id == 11){
			if(Blue - Num >= 0)
				Blue -= Num;
			else
				Blue = 0;
			
		}
		
		if(id == 12){
			if(Blue + Num < 255)
				Blue += Num;
			else
				Blue = 255;
		}
		
		
		if(id == 13){
			Color = false;
			Red = 0;
			Green = 0;
			Blue = 0;
			
	    	if(tile.getStackInSlot(0) != null){

	    		PacketHandler.INSTANCE.sendToServer(new ServerLensBenchPacketDone(Color, Red, Green, Blue, Power, Strength, TransferPower, Damage, Redstone, tile.xCoord, tile.yCoord, tile.zCoord));
	    	}
		}
			
		
		if(id == 14){
			 
   		 if(this.tile.getStackInSlot(0) != null){
   				if(this.tile.getStackInSlot(0).stackTagCompound != null){
   					Red = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Red");
   					Green = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Green");
   					Blue = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Blue");
   					
   					Power = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Power");
   					Strength = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Strength");
   					
   					Color = this.tile.getStackInSlot(0).stackTagCompound.getBoolean("Color");
   					
   					if(this.tile.getStackInSlot(0).stackTagCompound.getBoolean("TransferPower")){
   						TransferPower = true;
   						PowerBTN.Mode = 1;
   					}else{
   						TransferPower = false;
   						PowerBTN.Mode = 2;
   					}
   					
   					if(this.tile.getStackInSlot(0).stackTagCompound.getBoolean("Redstone")){
   						Redstone = true;
   						RedstoneBTN.Mode = 1;
   					}else{
   						Redstone = false;
   						RedstoneBTN.Mode = 2;
   					}
   					
   					
    					if(this.tile.getStackInSlot(0).stackTagCompound.getBoolean("Safe")){
    						Damage = false;
   						DamageBTN.Mode = 2;
    					}else{
    						Damage = true;
   						DamageBTN.Mode = 1;
    					}
   					
   				}
   				
   			}
		}


    	if(tile.getStackInSlot(0) != null){

    		PacketHandler.INSTANCE.sendToServer(new ServerLensBenchPacketDone(Color, Red, Green, Blue, Power, Strength, TransferPower, Damage, Redstone, tile.xCoord, tile.yCoord, tile.zCoord));
    	}
    }
    
    
    
	 @Override
	    public void drawScreen(int x, int y, float f) {
		 
		 if(Red > 0 || Blue > 0 || Green > 0)
			 Color = true;
		 else
			 Color = false;
		 
		 
		 PowerText.setText("Power: " + Power);
		 StrengthText.setText("Strength: " + Strength);
		 
		 RedText.setText("Red: " + Red);
		 BlueText.setText("Blue: " + Blue);
		 GreenText.setText("Green: " + Green);
		 
		 if(Keyboard.isKeyDown(42))
			 Num = 10;
		 else
			 Num = 1;
		 
	        super.drawScreen(x, y, f);
	        drawForeground(x, y, f);
	 }
	 
     public void drawForeground(int par1, int par2, float par3)
     {
    	 
     	for(int i = 0; i < this.buttonList.size(); i++){
         GuiButton btn = (GuiButton)this.buttonList.get(i);
     	
         
         if(par1 >= btn.xPosition && par1 <= btn.xPosition + btn.getButtonWidth() && par2 >= btn.yPosition && par2 <= btn.yPosition + 20){

        	 if(btn.id == 0){
                 drawTooltip(Arrays.asList(new String[] {DamageBTN.Mode == 1 ? "Disable Laser Damage" : "Enable Laser Damage"}), par1, par2);
                 
        	 }else if (btn.id == 1){
                 drawTooltip(Arrays.asList(new String[] {RedstoneBTN.Mode == 1 ? "Disable Redstone" : "Enable Redstone"}), par1, par2);
                 
        	 }else if (btn.id == 2){
                 drawTooltip(Arrays.asList(new String[] {PowerBTN.Mode == 1 ? "Disable Power Transfer" : "Enable Power Transfer"}), par1, par2);
        	 }
        	 
        	 
         }
     	}
     
     
     }
     
     protected void keyTyped(char par1, int par2)
     {
    	 super.keyTyped(par1, par2);
    	 
    	 if(par2 == Keyboard.KEY_R){
    		 
    		 
    		 if(this.tile.getStackInSlot(0) != null){
    				if(this.tile.getStackInSlot(0).stackTagCompound != null){
    					Red = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Red");
    					Green = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Green");
    					Blue = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Blue");
    					
    					Power = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Power");
    					Strength = this.tile.getStackInSlot(0).stackTagCompound.getInteger("Strength");
    					
    					Color = this.tile.getStackInSlot(0).stackTagCompound.getBoolean("Color");
    					
    					if(this.tile.getStackInSlot(0).stackTagCompound.getBoolean("TransferPower"))
    						PowerBTN.Mode = 1;
    					else
    						PowerBTN.Mode = 2;
    					
    					
    					if(this.tile.getStackInSlot(0).stackTagCompound.getBoolean("Redstone"))
    						RedstoneBTN.Mode = 1;
    					else
    						RedstoneBTN.Mode = 2;
    					
    					
    					
     					if(this.tile.getStackInSlot(0).stackTagCompound.getBoolean("Safe"))
    						DamageBTN.Mode = 2;
    					else
    						DamageBTN.Mode = 1;
    					
    					
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