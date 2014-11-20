package com.miscitems.MiscItemsAndBlocks.GuiObjects;

import MiscUtils.Render.RenderHelper;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;
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

	
	public void drawButton(Minecraft mc, int par2, int par3)
    {
        if (this.visible)
        {
            FontRenderer fontRendererObj = mc.fontRenderer;
            mc.getTextureManager().bindTexture(Icons);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            
            IsMouseOver = par2 >= this.xPosition && par2 < this.xPosition + width && par3 >= yPosition && par3 < yPosition + height;
          
            if(!IsMouseOver)
        	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 42, 20, 20);
            else
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 62, 20, 20);


            if(Type == 1){
                if(Mode == 2)
                    GL11.glColor4f(0.3F, 0.3F, 0.3F, 1F);

            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 36, 42, 16, 16);

            	
            	
            }else if (Type == 2){
            	if(Mode == 1){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 52, 42, 16, 16);
            	}else if (Mode == 2){
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 68, 42, 16, 16);
            	}

            	
            	
            }else if (Type == 3){

                RenderHelper.drawItemStack(fontRendererObj, new ItemStack(ModItems.Battery), this.xPosition + 2, this.yPosition + 2);
                mc.getTextureManager().bindTexture(Icons);

            if (Mode == 2)
            		this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, 100, 42, 16, 16);

            	
            }
        
            
            
          this.mouseDragged(mc, par2, par3);
            
        }
    }
	
    public void drawForeground(int par1, int par2, float par3)
    {
    	
    	
    }
	
	


}
