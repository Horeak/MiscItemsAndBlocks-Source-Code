package com.miscitems.MiscItemsAndBlocks.Gui.Machines;

import MiscUtils.GuiObjects.GuiTipButton;
import com.miscitems.MiscItemsAndBlocks.Container.Machines.ContainerMill;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityMill;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Messages;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;


public class GuiMill extends GuiContainer{

	private TileEntityMill tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/MillGui.png");
	
	
	public GuiMill(InventoryPlayer InvPlayer, TileEntityMill tile) {
		super(new ContainerMill(InvPlayer, tile));
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          
          fontRendererObj.drawString(StatCollector.translateToLocal("gui.mill"), 7, 3, 4210752);
       
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         
	         
	         int Time = this.tile.GetWorkTime();
	         

	         if(Time > 0)
             this.drawTexturedModalRect(x + 81, y + 34, 176, 3, 14, Time / 21);


	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.MillTips));
	}
	
	

}