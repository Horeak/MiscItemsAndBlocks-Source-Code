package com.miscitems.MiscItemsAndBlocks.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerLensBench;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerLensBenchPacketDone;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;

public class GuiLensBench extends GuiContainer{

	private TileEntityLensBench tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GuiLensBench.png");
	
	ModGuiSlider Power;
	ModGuiSlider Strength;
	
	ModGuiSlider Red;
	ModGuiSlider Green;
	ModGuiSlider Blue;
	
	GuiButton Color;
	GuiButton Done;
	
	
	public GuiLensBench(InventoryPlayer InvPlayer, TileEntityLensBench tile) {
		super(new ContainerLensBench(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 256;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString("Lens Bench" , 32, 4, 4210752);
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         if(!Power.func_146115_a())Power.dragging = false;
	         if(!Strength.func_146115_a())Strength.dragging = false;
	         
	         if(!Red.func_146115_a())Red.dragging = false;
	         if(!Green.func_146115_a())Green.dragging = false;
	         if(!Blue.func_146115_a())Blue.dragging = false;
	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
        int posX = (this.width - xSize) / 2;
        int posY = (this.height - ySize) / 2;
		
		Power = new ModGuiSlider(0, posX + 7, posY + 40, "Power", 0 , 10);
		Strength = new ModGuiSlider(1, posX + 7, posY + 61, "Strength", 0 , 100);
		
		Red = new ModGuiSlider(2, posX + 7, posY + 89, EnumChatFormatting.RED + "Red", 0 , 255);
		Green = new ModGuiSlider(3, posX + 7, posY + 110, EnumChatFormatting.GREEN + "Green", 0 , 255);
		Blue = new ModGuiSlider(4, posX + 7, posY + 131, EnumChatFormatting.BLUE + "Blue", 0 , 255);
		
		Color = new GuiButton(5, posX + 7, posY + 152, 72, 20, "Color");
		Done = new GuiButton(6, posX + 85, posY + 152, 72, 20, "Done");
		
		Red.enabled = false;
		Green.enabled = false;
		Blue.enabled = false;
		
		buttonList.add(Power);
		buttonList.add(Strength);
		
		buttonList.add(Red);
		buttonList.add(Green);
		buttonList.add(Blue);
		
		buttonList.add(Color);
		buttonList.add(Done);
		
	}
	
    @Override
    protected void actionPerformed(GuiButton button) {
    	
    	if(button.id == 5){
    		if(Red.enabled && Green.enabled && Blue.enabled){
    			Red.enabled = false;
    			Green.enabled = false;
    			Blue.enabled = false;
    		}else{
    		Red.enabled = true;
    		Green.enabled = true;
    		Blue.enabled = true;
    		
    		}
    	}
    	
    	if(tile.getStackInSlot(0) != null){
    	if(button.id == 6){
    		
    		
    		Main.NETWORK_MANAGER.sendPacketToServer(new ServerLensBenchPacketDone(Red.enabled && Green.enabled && Blue.enabled,
    				(int)((Red.sliderValue * 100) * Red.sliderMaxValue / 100), (int)((Green.sliderValue * 100) * Green.sliderMaxValue / 100), (int)((Blue.sliderValue * 100) * Blue.sliderMaxValue / 100),
    				(int)((Power.sliderValue * 100) * Power.sliderMaxValue / 100), (int)((Strength.sliderValue * 100) * Strength.sliderMaxValue / 100),tile.xCoord, tile.yCoord, tile.zCoord)
    		);
    		
    	}
    	
    	
    	}
    }
    
    
    
	 @Override
	    public void drawScreen(int x, int y, float f) {
		 
		 
		 
		 if(!Red.enabled)
			 Red.label = EnumChatFormatting.GRAY + "Red";
		 else
			 Red.label = EnumChatFormatting.RED + "Red";
		 
		 
		 if(!Green.enabled)
			 Green.label = EnumChatFormatting.GRAY + "Green";
		 else
			 Green.label = EnumChatFormatting.GREEN + "Green";
		 
		 if(!Blue.enabled)
			 Blue.label = EnumChatFormatting.GRAY + "Blue";
		 else
			 Blue.label = EnumChatFormatting.BLUE + "Blue";
		 
		 
		 super.drawScreen(x, y, f);
	 }
}