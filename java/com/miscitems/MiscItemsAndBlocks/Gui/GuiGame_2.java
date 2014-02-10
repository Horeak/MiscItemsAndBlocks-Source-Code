package com.miscitems.MiscItemsAndBlocks.Gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.miscitems.MiscItemsAndBlocks.GuiObjects.GuiColorButton;

public class GuiGame_2 extends GuiScreen{

	

	
	
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/MasterMindGui.png");

    protected static int xSize = 176;
    protected static int ySize = 155;
	
    public static final int xSizeOfTexture = xSize;
    public static final int ySizeOfTexture = ySize;

    
    protected int guiLeft;
    protected int guiTop;
    
    GuiButton ResetButton;

    public int Row = 1;
    public int MaxRows = 7;
    
    List<Integer> ColorList = new ArrayList<Integer>();
    
    GuiColorButton[] Colors = new GuiColorButton[GuiColorButton.Types.length - 2];
    
    GuiColorButton[] CurrentRow = new GuiColorButton[4];
    
    int[] CurrentRowColors = new int[4];
    
    GuiColorButton[] AllRows = new GuiColorButton[28];
    GuiColorButton[] StateRows = new GuiColorButton[28];
    
    int CurrentColor = 0;
    
    boolean Win = false;
    boolean Lose = false;
    
    
    
	public void ResetGame(){
		Row = 1;
		
		ColorList.clear();
		Win = false;
		Lose = false;
		
		for(int i = 0; i < 4; i++){
			Random rand = new Random();
			
			int g = rand.nextInt(GuiColorButton.Types.length - 2);
			
			if(g <= 0)
				g = 1;
			
			if(g >= 8)
				g = 8;
			
			
			
			ColorList.add(g);
			System.out.println(ColorList.get(ColorList.size() - 1));
			
		}

		
		
	}
	
	public GuiGame_2(){
		ResetGame();
		
	}
    
    @Override
    public void updateScreen()
    {
    	
    }

	
	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;

	        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

	        if(Win){
	        	
	        	this.drawString(fontRendererObj, "You Won!", posX + 10, posY + 114, 0x666666);
	        }else if (Lose){
	        	this.drawString(fontRendererObj, "You Lost!", posX + 10, posY + 114, 0x666666);
	        }
	        
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glDisable(GL11.GL_LIGHTING);

	        super.drawScreen(x, y, f);
	    }
	 
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
			
	        this.guiLeft = (this.width - this.xSize) / 2;
	        this.guiTop = (this.height - this.ySize) / 2;
	        
	        for(int i = 1; i < Colors.length; i++){
	        	
	        	Colors[i] = new GuiColorButton(i, guiLeft + 157, (guiTop + 6) + ((i - 1) * 14), i);
	        	buttonList.add(Colors[i]);
	        }
	        
	        
	        
	        for(int x = 0; x < CurrentRow.length; x++){
	        	
	        	CurrentRow[x] = new GuiColorButton(x + Colors.length, guiLeft + 10 + (x * 16), guiTop + 129, CurrentRowColors[x]);
	        	buttonList.add(CurrentRow[x]);

	        }
	        
	        for(int y = 0; y < 7; y++){
	        for(int x = 0; x < 4; x++){
	        	
	        	AllRows[x + y] = new GuiColorButton(x + y + (Colors.length) + CurrentRow.length, guiLeft + 10 + (x * 14), guiTop + 8 + (y * 15), 0);
	        	buttonList.add(AllRows[x + y]);
	        	AllRows[x + y].CanBeActivated = false;
	        	AllRows[x + y].CanMouseOver = false;
	        }
	        }
	        
	        
	        //TODO Fix state rows adding rows multiple times
	        for(int y = 0; y < 7; y++){
		        for(int x = 0; x < 4; x++){
		        	
		        	StateRows[x + y] = new GuiColorButton(x + y + ((Colors.length) + CurrentRow.length) + AllRows.length, guiLeft + 71 + (x * 14), guiTop + 8 + (y * 15), 0);
		        
		        	System.out.println((x + y));
		        	buttonList.add(StateRows[x + y]);
		        	StateRows[x + y].CanBeActivated = false;
		        	StateRows[x + y].CanMouseOver = false;
		        }
		        }
	        
	        buttonList.add(new GuiButton(Colors.length + CurrentRow.length + AllRows.length + StateRows.length, guiLeft + 80, guiTop + 113, 60, 20, "Test Line"));
	        
	        
	        ResetButton = new GuiButton(Colors.length + CurrentRow.length + AllRows.length + StateRows.length + 1, guiLeft + 80, guiTop + 132, 60, 20, "Reset Game");
	        ResetButton.enabled = true;
	        buttonList.add(ResetButton);
	        
	    }
	    
	
	    
	    @Override
	    protected void actionPerformed(GuiButton button) {

	    	int id = button.id;
	    	
	    	if(id < Colors.length){
	    		
	    		
	    		if(CurrentColor != id){
	    		
	    		CurrentColor = id;

	    		for(int i = 1; i < Colors.length; i++){
	    			Colors[i].Active = false;
	    			Colors[i].Mode = 0;
	    		}
	    		
	    		
	    		Colors[id].Active = true;
	    		Colors[id].Mode = 2;
	    		}else{
	    			

		    		for(int i = 1; i < Colors.length; i++){
		    			Colors[i].Active = false;
		    			Colors[i].Mode = 0;
		    		}
		    		
		    		CurrentColor = 0;
	    		}
	    		
	    		
	    	}else if (id <= 12 && id > 8){
	    		
	    		int i = 0;
	    		
	    		if(id == 9)
	    			i = 0;
	    		else if (id == 10)
	    			i = 1;
	    		else if (id == 11)
	    			i = 2;
	    		else if (id == 12)
	    			i = 3;
	    		
	    		
	    		CurrentRowColors[i] = CurrentColor;
	    		CurrentRow[i].Type = CurrentColor;
	    		
	    		
	    	}else if (id == Colors.length + CurrentRow.length + AllRows.length + StateRows.length){
	    		
	    		for(int i = 0; i < 4; i++){
	    			if(CurrentRow[i].Type == ColorList.get(i)){
	    				
	    				//TODO Crash for setting invalid row number. Find a better way to get the first button on each row with the Row veriable
	    				StateRows[((Row - 1) * 4) + i].Type = 10;
	    			}else if (ColorList.contains(CurrentRow[i].Type)){
	    				
	    				StateRows[((Row - 1) * 4) + i].Type = 9;
	    			}
	    			
	    			AllRows[((Row - 1) * 4) + i].Type = CurrentRow[i].Type;
	    			
	    			
	    			
	    			
	    		}
	    		
	    		
	    		
	    		
	    		for(int i = 0; i < CurrentRowColors.length; i++){

	    			CurrentRowColors[i] = 0;
	    		}
	    		
	    		
	    		for(int i = 0; i < CurrentRow.length; i++){
	    			CurrentRow[i].Active = false;
	    			CurrentRow[i].Mode = 0;
	    			CurrentRow[i].Type = 0;
	    		}
	    		
	    		
	    		
	    		if(Row < MaxRows){
	    		Row++;
	    		}else if (Row > MaxRows){
	    			Row = MaxRows;
	    		}
	    		
	    		
	    		
	    	}else if (id == Colors.length + CurrentRow.length + AllRows.length + StateRows.length + 1){
	    		for(int i = 0; i < CurrentRowColors.length; i++){

	    			CurrentRowColors[i] = 0;
	    		}
	    		
	    		
	    		for(int i = 0; i < CurrentRow.length; i++){
	    			CurrentRow[i].Active = false;
	    			CurrentRow[i].Mode = 0;
	    			CurrentRow[i].Type = 0;
	    		}
	    		
	    		for(int i = 0; i < StateRows.length - 1; i++){
	    			
	    			StateRows[i].Type = 0;
	    		}
	    		
	    		ResetGame();
	    	}
	    	
	    	
	    

	        }
}
