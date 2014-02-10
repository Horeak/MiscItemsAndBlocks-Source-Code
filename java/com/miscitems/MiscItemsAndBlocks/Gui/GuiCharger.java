package com.miscitems.MiscItemsAndBlocks.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerCharger;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCharger;

public class GuiCharger extends GuiContainer{

	private TileEntityCharger tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ChargerBlockGui.png");
	
	public GuiCharger(InventoryPlayer InvPlayer, TileEntityCharger tile) {
		super(new ContainerCharger(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 166;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          fontRendererObj.drawString(StatCollector.translateToLocal("gui.charger") , 2, 3, 4210752);
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         int Power = this.tile.GetPower();
	         fontRendererObj.drawString(StatCollector.translateToLocal("words.power") + ": " + Power + "/" + tile.MaxPower, x + 45, y + 42, 4210752);

	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
	}
}