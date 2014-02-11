package com.miscitems.MiscItemsAndBlocks.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerLaser;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;

public class GuiLaser extends GuiContainer{

	private TileEntityLaser tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/LaserGui.png");
	
	
	public GuiLaser(InventoryPlayer InvPlayer, TileEntityLaser tile) {
		super(new ContainerLaser(InvPlayer, tile));
	
		this.xSize = 176;
		this.ySize = 166;
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 5, ySize - 99 + 2, 4210752);
          
          fontRendererObj.drawString("Laser Block", 7, 3, 4210752);
       
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


	         this.drawCenteredString(fontRendererObj, tile.GetPower() + "/" + tile.PowerMax, x + 88, y + 56, 0x666666);

	         

	}
}