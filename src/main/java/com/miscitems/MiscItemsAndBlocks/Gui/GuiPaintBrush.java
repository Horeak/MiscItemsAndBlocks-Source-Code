package com.miscitems.MiscItemsAndBlocks.Gui;

import com.miscitems.MiscItemsAndBlocks.GuiObjects.ModGuiSlider;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerPaintBrushChangePacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPaintBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GuiPaintBrush extends GuiScreen
{
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/PaintBrushGui.png");
	
	
    public static final int xSizeOfTexture = 210;
    public static final int ySizeOfTexture = 114;
    
    private final ItemStack stack;
    
    ModGuiSlider SliderRed;
    ModGuiSlider SliderBlue;
    ModGuiSlider SliderGreen;
    
    
    int Max = TileEntityPaintBlock.Max;
    
	
	
	public GuiPaintBrush(ItemStack stack){
		
		this.stack = stack;
	}

	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

            
	        
	        fontRendererObj.drawString(StatCollector.translateToLocal("gui.painteditor"), posX + 10, posY + 6, 10);
	        
	        
	        int xd = 159;
	        int yd = 63;

	        this.drawRect(posX + xd,  posY + yd, posX + xd + 46, posY + yd + 46, GetColor());
	         
	        
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glDisable(GL11.GL_LIGHTING);

	        super.drawScreen(x, y, f);
	    }

	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    

	    public int GetColor(){

	    	Color color = new Color(SliderRed.sliderValue, SliderGreen.sliderValue, SliderBlue.sliderValue);
	    	
	    	return color.getRGB();
	    }

	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        
	        SliderRed = new ModGuiSlider(0, posX + 5, posY + 20, StatCollector.translateToLocal("gui.string.redvalue"), 0, Max);
	        SliderGreen = new ModGuiSlider(1, posX + 5, posY + 50, StatCollector.translateToLocal("gui.string.greenvalue"), 0, Max);
	        SliderBlue = new ModGuiSlider(2, posX + 5, posY + 80, StatCollector.translateToLocal("gui.string.bluevalue"), 0, Max);
	        
	        buttonList.add(new GuiButton(3, posX + 157, posY + 34, 48, 18, StatCollector.translateToLocal("gui.string.setcolor")));


			
			
	        buttonList.add(SliderRed);
	        buttonList.add(SliderGreen);
	        buttonList.add(SliderBlue);
	    }
	    


	    @Override
	    protected void actionPerformed(GuiButton par1GuiButton) {
	        switch (par1GuiButton.id) {
	        
	        case 3:

	        	
		    	if(stack.stackTagCompound == null){
		    		stack.setTagCompound(new NBTTagCompound());
		    			
		    		
		    		stack.stackTagCompound.setInteger("Red", (int) ((SliderRed.sliderValue * 100) * Max / 100));
		    		stack.stackTagCompound.setInteger("Green", (int) ((SliderGreen.sliderValue * 100) * Max / 100));
		    		stack.stackTagCompound.setInteger("Blue", (int) ((SliderBlue.sliderValue * 100) * Max / 100));

		    			
		    			
		    	}else{
		    		stack.stackTagCompound.setInteger("Red", (int) ((SliderRed.sliderValue * 100) * Max / 100));
		    		stack.stackTagCompound.setInteger("Green", (int) ((SliderGreen.sliderValue * 100) * Max / 100));
		    		stack.stackTagCompound.setInteger("Blue", (int) ((SliderBlue.sliderValue * 100) * Max / 100));

		    		
		    	}
	        	
		    	
		    	PacketHandler.sendToServer(new ServerPaintBrushChangePacket((int) ((SliderRed.sliderValue * 100) * Max / 100), (int) ((SliderGreen.sliderValue * 100) * Max / 100), (int) ((SliderBlue.sliderValue * 100) * Max / 100)));
	        	break;
	        }

	    }
	    
	    



}
