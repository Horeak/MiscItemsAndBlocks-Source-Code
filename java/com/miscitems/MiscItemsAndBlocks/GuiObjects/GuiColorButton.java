package com.miscitems.MiscItemsAndBlocks.GuiObjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiColorButton extends GuiButton{

	public static ResourceLocation Icons = new ResourceLocation("miscitems", "textures/gui/Icons.png");
	
	public static String[] Types = new String[]{"Empty", "Red", "Orange", "Yellow", "White", "Green", "Purple", "Blue", "Black", "Mark_White", "Mark_Black"};
	public static HashMap<Integer, List<Integer>> TypesList = new HashMap<Integer, List<Integer>>();
	
	public int Type;
    public int Mode = 0;
    public boolean CanBeActivated = true;
    public boolean CanMouseOver = true;
    public boolean Active = false;
	
	public GuiColorButton(int par1, int par2, int par3, int Type) {
		super(par1, par2, par3, 14, 14, null);
		
		TypesList.put(0, Arrays.asList(0, 0));
		TypesList.put(1, Arrays.asList(15, 1));
		TypesList.put(2, Arrays.asList(26, 1));
		TypesList.put(3, Arrays.asList(37, 1));
		TypesList.put(4, Arrays.asList(48, 1));
		
		TypesList.put(5, Arrays.asList(15, 12));
		TypesList.put(6, Arrays.asList(26, 12));
		TypesList.put(7, Arrays.asList(37, 12));
		TypesList.put(8, Arrays.asList(48, 12));
		
		TypesList.put(9, Arrays.asList(15, 23));
		TypesList.put(10, Arrays.asList(26, 23));
		
		
		
		this.Type = Type;
		
	}

	
	public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.visible)
        {
            FontRenderer fontRendererObj = par1Minecraft.fontRenderer;
            par1Minecraft.getTextureManager().bindTexture(Icons);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            
          
            if(CanMouseOver && Mode != 2 && !Active)
            if(par2 >= this.xPosition && par2 < this.xPosition + width && par3 >= yPosition && par3 < yPosition + height){
            	Mode = 1;
            }else{
            	Mode = 0;
            }
            
            
            if(Mode == 0){
            	
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0, 14, 14);
            	if(Type != 0)
            	this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, TypesList.get(Type).get(0), TypesList.get(Type).get(1), 11, 11);
            	
            	
            }else if (Mode == 1){
            	
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 14, 14, 14);
            	if(Type != 0)
            	this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, TypesList.get(Type).get(0), TypesList.get(Type).get(1), 11, 11);
           
            
            }else if (Mode == 2 && CanBeActivated && Active){
            	
            	
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 28, 14, 14);
            	if(Type != 0)
            	this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, TypesList.get(Type).get(0), TypesList.get(Type).get(1), 11, 11);
            	
            	
            }else{
            	
            	
            	this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0, 14, 14);
            	if(Type != 0)
            	this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, TypesList.get(Type).get(0), TypesList.get(Type).get(1), 11, 11);
            	
            }
            
            
          this.mouseDragged(par1Minecraft, par2, par3);
            
        }
    }
}
