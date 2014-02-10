package com.miscitems.MiscItemsAndBlocks.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerSolarPanel;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntitySolarPanel;

public class GuiSolarPanel extends GuiContainer{

	private TileEntitySolarPanel tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/SolarPanelGui.png");
	GuiTextField textfield;
	
	public GuiSolarPanel(InventoryPlayer InvPlayer, TileEntitySolarPanel tile) {
		super(new ContainerSolarPanel(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 166;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          
          fontRendererObj.drawString(StatCollector.translateToLocal("gui.solarpanel"), 7, 3, 4210752);
          textfield.drawTextBox();
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         

	     	String Mode = "No Charger";
	    	String State = "off";
	    	

    		int MetaData = tile.GetMeta();
    		
    		if(MetaData == 1 || MetaData == 0){
    			
    			Mode = StatCollector.translateToLocal("gui.string.solar.state1");
    			State = "on";
    			
    		}else if (MetaData == 2){
    			
    			Mode = StatCollector.translateToLocal("gui.string.solar.state2");
    			State = "blocked";
    			
    		}else if (MetaData == 3){
    			
    			Mode = StatCollector.translateToLocal("gui.string.solar.state3");
    			State = "rain";
    			
    		}else if (MetaData == 4){
    			
    			Mode = StatCollector.translateToLocal("gui.string.solar.state3");
    			State = "night";
    			
    		}
	    	
	    	
	    	
	         textfield.setText(Mode);
	         
	         
	         
	         
	         if(State == "on"){
	             this.drawTexturedModalRect(x + 79, y + 14, 176, 3, 18, 18);
	         }else if (State == "rain"){
	        	 this.drawTexturedModalRect(x + 79, y + 14, 176, 39, 18, 18);
	         }else if (State == "blocked"){
	        	 this.drawTexturedModalRect(x + 79, y + 14, 176, 21, 18, 18);
	         }else if (State == "night"){
	        	 this.drawTexturedModalRect(x + 79, y + 14, 176, 57, 18, 18);
	         }
	         
	         

	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		textfield = new GuiTextField(fontRendererObj, 7, 45, 162, 21);
		
	}
	

}
