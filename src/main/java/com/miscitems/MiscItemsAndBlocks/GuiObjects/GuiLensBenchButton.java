package com.miscitems.MiscItemsAndBlocks.GuiObjects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiLensBenchButton extends GuiButton{

	public static ResourceLocation Icons = new ResourceLocation("miscitems", "textures/gui/Icons.png");
	
	int Type = 1;
	public int Mode = 2;
	public boolean IsMouseOver = false;
	
	public GuiLensBenchButton(int par1, int par2, int par3, int Type) {
		super(par1, par2, par3, 20, 20, null);
		this.Type = Type;
	}

	
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.visible)
        {
            FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(Icons);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            
            IsMouseOver = par2 >= this.xPosition && par2 < this.xPosition + width && par3 >= yPosition && par3 < yPosition + height;
          
            if(!IsMouseOver)
        	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 42, 20, 20);
            else
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 62, 20, 20);
            
        
            if(Type == 1){
            	if(Mode == 1){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 20, 42, 16, 16);
            	}else if (Mode == 2){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 36, 42, 16, 16);
            	}
            
            	
            	
            }else if (Type == 2){
            	if(Mode == 1){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 52, 42, 16, 16);
            	}else if (Mode == 2){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 68, 42, 16, 16);
            	}
            	
            	
            	
            }else if (Type == 3){
            	if(Mode == 1){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 84, 42, 16, 16);
            	}else if (Mode == 2){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 100, 42, 16, 16);
            	}
            	
            	
            }
        
            
            
          this.mouseDragged(par1Minecraft, par2, par3);
            
        }
    }
	
    public void drawForeground(int par1, int par2, float par3)
    {
    	
    	
    }
	
	


}
