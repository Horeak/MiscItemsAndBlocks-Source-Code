package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerMetalPress;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerButtonPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiMetalPress extends GuiContainer{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/MetalPressGui.png");
	
	TileEntityMetalPress tile;
	
	
	
	public GuiMetalPress(InventoryPlayer InvPlayer, TileEntityMetalPress tile) {
		super(new ContainerMetalPress(InvPlayer, tile));
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);

       
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;

	         
	         int Mode = tile.GetMode();
	         
	         if(Mode == 1){
	        	 this.drawTexturedModalRect(x + 9, y + 9, 179, 1, 18, 18);
	        	 
	        	 this.drawTexturedModalRect(x + 51, y + 9, 179, 1, 18, 18);
	        	 
	        	 this.drawTexturedModalRect(x + 9, y + 51, 179, 1, 18, 18);
	        	 
	        	 this.drawTexturedModalRect(x + 51, y + 51, 179, 1, 18, 18);
	         }else if (Mode == 2){
	        	 
	        	 this.drawTexturedModalRect(x + 30, y + 30, 179, 1, 18, 18);
	         }
	         
	         this.drawTexturedModalRect(x + 87, y + 29, 179, 20, tile.GetWorkTime() / 2, 16);

	         
	         this.drawCenteredString(fontRendererObj, "Power: " + tile.GetPower() + "/" + tile.GetMaxPower(), x + 120, y + 10, 0x666666);
	         
	}
	
	

	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
	
		buttonList.add(new GuiButton(1, guiLeft + 73, guiTop + 56, 66, 20, "Change Mode"));
		
		
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.sendToServer(new ServerButtonPacket((byte) button.id));
		
	}



    public boolean isMouseOverSlot(Slot par1Slot, int par2, int par3)
    {
    	if(par1Slot.inventory == tile && tile.GetMode() == 2 && par1Slot.getSlotIndex() == 1){
    		return false;

    	}else if (par1Slot.inventory == tile && tile.GetMode() == 1 && par1Slot.getSlotIndex() == 2
    			|| par1Slot.inventory == tile && tile.GetMode() == 1 && par1Slot.getSlotIndex() == 3
    			||par1Slot.inventory == tile && tile.GetMode() == 1 && par1Slot.getSlotIndex() == 4
    			|| par1Slot.inventory == tile && tile.GetMode() == 1 && par1Slot.getSlotIndex() == 5
    			){
    		return false;


    	}else{

        return this.func_146978_c(par1Slot.xDisplayPosition, par1Slot.yDisplayPosition, 16, 16, par2, par3);
    	}
    }
   
}