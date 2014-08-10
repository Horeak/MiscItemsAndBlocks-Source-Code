package com.miscitems.MiscItemsAndBlocks.Gui.Machines;

import MiscUtils.GuiObjects.GuiTipButton;
import com.miscitems.MiscItemsAndBlocks.Container.Machines.ContainerPizzaOven;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityOven;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Messages;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiPizzaOven extends GuiContainer{

	private TileEntityOven tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/PizzaOvenGui.png");
	
	
	public GuiPizzaOven(InventoryPlayer InvPlayer, TileEntityOven tile) {
		super(new ContainerPizzaOven(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 166;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          
          fontRendererObj.drawString(StatCollector.translateToLocal("gui.oven"), 7, 3, 4210752);
       
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         
	         
	         int Heat = this.tile.GetHeat();
	         int Fuel = this.tile.GetFuel();
	         int Time = this.tile.GetWorkTime();
	         
	         if(Fuel > 0)
	             this.drawTexturedModalRect(x + 69, y + 29, 176, 3, 5, Fuel + 5);
	         

	         if(this.tile.CanWork())
	             this.drawTexturedModalRect(x + 84, y + 38, 181, 14, 7, 7);
	         else
	             this.drawTexturedModalRect(x + 84, y + 38, 181, 21, 7, 7);
	         
	         if(Time > 0)
	        	 this.drawTexturedModalRect(x + 100, y + 33, 176, 28, Time / 12, 17);
	         
	         
	          fontRendererObj.drawString(StatCollector.translateToLocal("words.heat") + ": " + Heat + "%", x + 14, y + 37, 0x00000);

	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.PizzaOvenTips));
	}
}