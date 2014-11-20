package com.miscitems.MiscItemsAndBlocks.Gui.Electric;

import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerLensBench;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.GuiLensBenchButton;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerLensBenchPacketDone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLensBench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.Arrays;

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


       if(PowerText != null)
          PowerText.drawTextBox();

      if(StrengthText != null)
          StrengthText.drawTextBox();


      if(RedText != null)
          RedText.drawTextBox();

      if(GreenText != null)
          GreenText.drawTextBox();

      if(BlueText != null)
          BlueText.drawTextBox();
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        initGui();

	}

	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();

        int posX = (this.width - xSize) / 2;
        int posY = (this.height - ySize) / 2;

        if(DamageBTN == null){
            DamageBTN = new GuiLensBenchButton(0, posX + 105, posY + 7, 1);
        }else{
            DamageBTN.xPosition = posX + 105;
            DamageBTN.yPosition = posY + 7;
        }


        if(RedstoneBTN == null){
            RedstoneBTN = new GuiLensBenchButton(1, posX + 125, posY + 7, 2);
        }else{
            RedstoneBTN.xPosition = posX + 125;
            RedstoneBTN.yPosition = posY + 7;
        }


        if(PowerBTN == null) {
            PowerBTN = new GuiLensBenchButton(2, posX + 145, posY + 7, 3);
        }else{
            PowerBTN.xPosition = posX + 145;
            PowerBTN.yPosition = posY + 7;
        }


        if(PowerText == null)
        PowerText = new GuiTextField(fontRendererObj, 8, 39, 60, 15);

        if(StrengthText == null)
        StrengthText = new GuiTextField(fontRendererObj, 88, 39, 80, 15);




        if(RedText == null)
        RedText = new GuiTextField(fontRendererObj, 8,80, 60, 15);


        if(BlueText == null)
        BlueText = new GuiTextField(fontRendererObj, 8,120, 60, 15);


        if(GreenText == null)
        GreenText = new GuiTextField(fontRendererObj,88, 80, 80, 15);



        String add = Keyboard.isKeyDown(42) ? "++" : "+";
        String subtract = Keyboard.isKeyDown(42) ? "--" : "-";
        
        
        //Power
        buttonList.add(new GuiButton(3, posX + 7, posY + 56, 30, 20, subtract));
        buttonList.add(new GuiButton(4, posX + 39, posY + 56, 30, 20, add));
        
        //Strength
        buttonList.add(new GuiButton(5, posX + 87, posY + 56, 40, 20, subtract));
        buttonList.add(new GuiButton(6, posX + 129, posY + 56, 40, 20, add));

        //Red
        buttonList.add(new GuiButton(7, posX + 7, posY + 97, 30, 20, subtract));
        buttonList.add(new GuiButton(8, posX + 39, posY + 97, 30, 20, add));

        //Green
        buttonList.add(new GuiButton(9, posX + 87, posY + 97, 40, 20, subtract));
        buttonList.add(new GuiButton(10, posX + 129, posY + 97, 40, 20, add));

        //Blue
        buttonList.add(new GuiButton(11, posX + 7, posY + 137, 30, 20, subtract));
        buttonList.add(new GuiButton(12, posX + 39, posY + 137, 30, 20, add));


        
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

    		PacketHandler.sendToServer(new ServerLensBenchPacketDone(Color, Red, Green, Blue, Power, Strength, TransferPower, Damage, Redstone, tile.xCoord, tile.yCoord, tile.zCoord), Main.Utils.channels);
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

	    		PacketHandler.sendToServer(new ServerLensBenchPacketDone(Color, Red, Green, Blue, Power, Strength, TransferPower, Damage, Redstone, tile.xCoord, tile.yCoord, tile.zCoord), Main.Utils.channels);
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

    		PacketHandler.sendToServer(new ServerLensBenchPacketDone(Color, Red, Green, Blue, Power, Strength, TransferPower, Damage, Redstone, tile.xCoord, tile.yCoord, tile.zCoord), Main.Utils.channels);
    	}
    }
    
    
    
	 @Override
	    public void drawScreen(int x, int y, float f) {
		 
		 if(Red > 0 || Blue > 0 || Green > 0)
			 Color = true;
		 else
			 Color = false;
		 

         if(PowerText != null)
		 PowerText.setText("Power: " + Power);

         if(StrengthText != null)
		 StrengthText.setText("Strength: " + Strength);



         if(RedText != null)
		 RedText.setText("Red: " + Red);

         if(BlueText != null)
		 BlueText.setText("Blue: " + Blue);

         if(GreenText != null)
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
                 drawHoveringText(Arrays.asList(new String[] {EnumChatFormatting.WHITE + "Toggle damage", EnumChatFormatting.WHITE + "Currently enabled: " + (DamageBTN.Mode == 1 ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false")}), par1, par2, fontRendererObj);
                 
        	 }else if (btn.id == 1){
                 drawHoveringText(Arrays.asList(new String[] {EnumChatFormatting.WHITE + "Toggle redstone transfer", EnumChatFormatting.WHITE + "Currently enabled: " + (RedstoneBTN.Mode == 1 ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false")}), par1, par2, fontRendererObj);
                 
        	 }else if (btn.id == 2){
                 drawHoveringText(Arrays.asList(new String[] {EnumChatFormatting.WHITE + "Toggle power transfer", EnumChatFormatting.WHITE + "Currently enabled: " + (PowerBTN.Mode == 1 ? EnumChatFormatting.GREEN + "true" : EnumChatFormatting.RED + "false")}), par1, par2, fontRendererObj);
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


}