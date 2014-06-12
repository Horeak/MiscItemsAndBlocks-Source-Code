package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerMiningChamber;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.ServerButtonPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMiningStation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiMiningChamber extends GuiContainer{

	private TileEntityMiningStation tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/MiningChamberGui.png");
	
	GuiButton Start;
	
	public GuiMiningChamber(InventoryPlayer InvPlayer, TileEntityMiningStation tile) {
		super(new ContainerMiningChamber(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 235;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          fontRendererObj.drawString(StatCollector.translateToLocal("gui.miningchamber"), 59, 7, 4210752);
          
          
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
	         int CurrentY = this.tile.GetMinedY();
	         int LastY = this.tile.GetLastY();
	         int HoleSize = this.tile.GetSize();
	         
	         int YLeft = CurrentY - LastY;
	         
	         fontRendererObj.drawString(StatCollector.translateToLocal("words.power") + ": " + Power + "/" + tile.GetMaxPower(), x + 59, y + 17, 0x000000);
	         fontRendererObj.drawString(StatCollector.translateToLocal("words.holesize") + ": " + HoleSize + "x" + HoleSize, x + 59, y + 27, 0x000000);
	         if(YLeft > 0)
	         fontRendererObj.drawString(StatCollector.translateToLocal("words.mining") + ": " + YLeft + " "+  StatCollector.translateToLocal("words.deeper") + ".", x + 59, y + 37, 0x000000);
	         else
		         fontRendererObj.drawString(StatCollector.translateToLocal("words.mining") + " " + 0 + " " + StatCollector.translateToLocal("words.deeper") , x + 59, y + 37, 0x000000);
	         fontRendererObj.drawString(StatCollector.translateToLocal("gui.string.miningdownto") + ": " + LastY, x + 59, y + 47, 0x000000);
	         fontRendererObj.drawString(StatCollector.translateToLocal("gui.string.currentlyat") + ": " + (CurrentY - 1), x + 59, y + 57, 0x000000);
	         
	         

	          if(tile.GetValue() == 1){
	        	  Start.displayString = StatCollector.translateToLocal("words.stop");
	          }else if (tile.GetValue() != 1){
	        	  Start.displayString = StatCollector.translateToLocal("words.start");
	          }
	          
	         
	}
	
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		int Meta = this.tile.getWorldObj().getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
		
		Start = new GuiButton(3, guiLeft + 5, guiTop + 86, 40, 20, StatCollector.translateToLocal("words.start"));
		
		buttonList.add(new GuiButton(1, guiLeft + 48, guiTop + 86, 19, 20, "y-"));
		buttonList.add(new GuiButton(2, guiLeft + 70,  guiTop + 86, 19, 20, "y+"));
		
		buttonList.add(Start);

		buttonList.add(new GuiButton(4, guiLeft + 92,  guiTop + 86, 79, 20, StatCollector.translateToLocal("gui.string.settostart")  + " y"));
		
		buttonList.add(new GuiButton(5, guiLeft + 5,  guiTop + 111, 50, 20, StatCollector.translateToLocal("words.size") + " +"));
		buttonList.add(new GuiButton(6, guiLeft + 58,  guiTop + 111, 50, 20, StatCollector.translateToLocal("words.size") + " -"));
		
		
		
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.INSTANCE.sendToServer(new ServerButtonPacket((byte) button.id));
		
//		if(button.id == 3){
//			if(Start.displayString == StatCollector.translateToLocal("words.start")){
//				Start.displayString = StatCollector.translateToLocal("words.stop");
//			}else if (Start.displayString == StatCollector.translateToLocal("words.stop")){
//				Start.displayString = StatCollector.translateToLocal("words.start");
//			}
//		}

	}
	
}