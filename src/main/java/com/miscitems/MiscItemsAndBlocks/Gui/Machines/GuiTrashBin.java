package com.miscitems.MiscItemsAndBlocks.Gui.Machines;

import MiscUtils.GuiObjects.GuiTipButton;
import com.miscitems.MiscItemsAndBlocks.Container.ContainerBin;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityTrashBin;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Messages;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiTrashBin extends GuiContainer{

	 TileEntityTrashBin tile = new TileEntityTrashBin();
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/BinGui.png");
	
	
	public GuiTrashBin(InventoryPlayer InvPlayer, TileEntityTrashBin tile) {
		super(new ContainerBin(InvPlayer, tile));
		xSize = 197;
		ySize = 166;
	}
	
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {

            fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
            
            fontRendererObj.drawString(StatCollector.translateToLocal("gui.trashbin"), 7, 3, 4210752);
         
            
            
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         

	}

	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.TrashBinTips));
	}
}
