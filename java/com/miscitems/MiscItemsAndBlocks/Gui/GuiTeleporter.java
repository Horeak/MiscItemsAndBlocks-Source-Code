package com.miscitems.MiscItemsAndBlocks.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerTeleporter;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTeleporter;

public class GuiTeleporter extends GuiContainer{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/TeleporterGui.png");
	
	TileEntityTeleporter tile;
	
	GuiTextField TextField;
	
	
	public GuiTeleporter(InventoryPlayer InvPlayer, TileEntityTeleporter tile) {
		super(new ContainerTeleporter(InvPlayer, tile));
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);

       
          TextField.drawTextBox();
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         
	     	this.drawString(fontRendererObj, "Power: " + tile.GetPower() + "/" + tile.PowerMax, x + 62, y + 44, 0x666666);
	     	
	     	

	     	int CardMode = tile.GetCardMode();
	     	
	     	if(CardMode == 0 || CardMode == 2){
	     		
	     		TextField.setText("Invalid Chip");
	     		
	     	}else if (CardMode == 1){
	     		TextField.setText("Valid Chip");
	     	}
	     	
	     	
	     	if(CardMode == 1){
	     		
	     		this.drawString(fontRendererObj, "Linked to: ", x + 62, y + 53, 0x666666);
	     		this.drawString(fontRendererObj, "X: " + tile.GetX() + " Y: " + tile.GetY() + " Z: " + tile.GetZ(), x + 62, y + 62, 0x666666);
	     	}
	     	
	         

	}
	
	

	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		TextField = new GuiTextField(fontRendererObj, 80, 6, 90, 18);
		
		
		
	}

}