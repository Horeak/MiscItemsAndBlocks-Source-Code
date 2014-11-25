package com.miscitems.MiscItemsAndBlocks.Gui;

import MiscUtils.GuiObjects.ModGuiColorSlider;
import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Server.ServerPaintBrushChangePacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPaintBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
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

    ModGuiColorSlider SliderRed, SliderBlue, SliderGreen;

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

            initGui();
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
	        fontRendererObj.drawString(StatCollector.translateToLocal("gui.painteditor"), posX + 10, posY + 6, 10);
	        
	        
	        int xd = 159;
	        int yd = 63;

	        this.drawRect(posX + xd,  posY + yd, posX + xd + 46, posY + yd + 46, GetColor().getRGB());
	         
	        
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        super.drawScreen(x, y, f);
	    }

	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    

	    public Color GetColor(){
            if(SliderRed != null && SliderGreen != null && SliderBlue != null) {
                Color color = new Color((SliderRed.sliderValue), (SliderGreen.sliderValue), (SliderBlue.sliderValue));
                return color;
            }
            return new Color(0,0,0);
	    }

	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;


            if(SliderRed == null) {
                SliderRed = new ModGuiColorSlider(0, posX + 5, posY + 20, 150, 20, new Color(0,0,0), new Color(Max,0,0));
            }else{
                SliderRed.xPosition = posX + 5;
                SliderRed.yPosition = posY + 20;

                SliderRed.label = EnumChatFormatting.RED + "Red: " + GetColor().getRed() + EnumChatFormatting.RESET;
        }


            if(SliderGreen == null){
	        SliderGreen = new ModGuiColorSlider(1, posX + 5, posY + 50, 150, 20, new Color(0, 0, 0), new Color(0, Max, 0));
            }else{
                SliderGreen.xPosition = posX + 5;
                SliderGreen.yPosition = posY + 50;

                SliderGreen.label = EnumChatFormatting.GREEN + "Green: " + GetColor().getGreen() + EnumChatFormatting.RESET;
            }

            if(SliderBlue == null){
	        SliderBlue = new ModGuiColorSlider(2, posX + 5, posY + 80, 150, 20, new Color(0, 0, 0), new Color(0, 0, Max));
            }else{
                SliderBlue.xPosition = posX + 5;
                SliderBlue.yPosition = posY + 80;

                SliderBlue.label = EnumChatFormatting.BLUE + "Blue: " + GetColor().getBlue() + EnumChatFormatting.RESET;
            }



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
	        	
		    	
		    	PacketHandler.sendToServer(new ServerPaintBrushChangePacket((int) ((SliderRed.sliderValue * 100) * Max / 100), (int) ((SliderGreen.sliderValue * 100) * Max / 100), (int) ((SliderBlue.sliderValue * 100) * Max / 100)), Main.Utils.channels);
	        	break;
	        }

	    }
	    
	    



}
