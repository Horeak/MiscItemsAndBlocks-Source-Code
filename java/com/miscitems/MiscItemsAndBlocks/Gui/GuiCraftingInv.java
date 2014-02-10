package com.miscitems.MiscItemsAndBlocks.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerCraftingInv;
import com.miscitems.MiscItemsAndBlocks.Lib.Messages;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityCraftingInv;

public class GuiCraftingInv extends GuiContainer{

private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/CraftingInvGui.png");


private static boolean NEI_ACTIVE = false;

public GuiCraftingInv(InventoryPlayer InvPlayer, TileEntityCraftingInv tile) {
super(new ContainerCraftingInv(InvPlayer, tile));

this.xSize = 197;
this.ySize = 197;
}
	
 @Override
 protected void drawGuiContainerForegroundLayer(int param1, int param2) {

         fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 4, 4210752);
         fontRendererObj.drawString(StatCollector.translateToLocal("gui.worktable"), 8, 2, 4210752);
         
      
         
         
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
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.WorktableTips));
	}
	

}