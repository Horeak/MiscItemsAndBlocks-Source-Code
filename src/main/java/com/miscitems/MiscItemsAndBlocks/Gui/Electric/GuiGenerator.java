package com.miscitems.MiscItemsAndBlocks.Gui.Electric;

import com.miscitems.MiscItemsAndBlocks.Container.Electric.ContainerGenerator;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiGenerator extends GuiContainer{

	private TileEntityGenerator tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GeneratorGui.png");
	
	
	public GuiGenerator(InventoryPlayer InvPlayer, TileEntityGenerator tile) {
		super(new ContainerGenerator(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 166;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 5, ySize - 99 + 2, 4210752);
          
          fontRendererObj.drawString(StatCollector.translateToLocal("gui.generator"), 7, 3, 4210752);
       
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         int TimeLeft = tile.GetTimeLeft();
	         
	         
	         if(TimeLeft > 0 && TimeLeft <= 20)
	        	 this.drawTexturedModalRect(x + 80, y + 63, 176, 13, 14, 4);
	         
	         else if(TimeLeft > 20 && TimeLeft <= 40)
	        	 this.drawTexturedModalRect(x + 80, y + 59, 176, 9, 14, 8);
	         
	         else if(TimeLeft > 40 && TimeLeft <= 60)
	        	 this.drawTexturedModalRect(x + 80, y + 56, 176, 6, 14, 11);
	         
	         else if(TimeLeft > 60 && TimeLeft <= 80)
	        	 this.drawTexturedModalRect(x + 80, y + 53, 176, 3, 14, 14);
	        	 
	         
	         
	         


	         

	}
}