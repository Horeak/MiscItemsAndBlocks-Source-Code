package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityElectricFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiElectricFurnace extends GuiContainer{

	private TileEntityElectricFurnace tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ElectricFurnaceGui.png");
	
	public GuiElectricFurnace(InventoryPlayer InvPlayer, TileEntityElectricFurnace tile) {
		super(new ContainerElectricFurnace(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 166;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          fontRendererObj.drawString(StatCollector.translateToLocal("gui.electricfurnace"), 2, 3, 4210752);
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         int WorkTime = this.tile.GetWorkTime();
	         
	         if(WorkTime > 0)
	             this.drawTexturedModalRect(x + 85, y + 35, 176, 0, WorkTime / 4, 17);
	         
	         
	         int Power = (int)this.tile.GetPower();
	         fontRendererObj.drawString(StatCollector.translateToLocal("words.power") + ": " + Power + "/" + (int)tile.GetMaxPower(), x + 5, y + 39, 4210752);
	         
	         

	         

	}

}