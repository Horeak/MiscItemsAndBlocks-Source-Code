package com.miscitems.MiscItemsAndBlocks.Gui.Computer;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerComputer;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ProgramButton;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiComputerScreen extends GuiContainer{

	public GuiComputerScreen(TileEntityComputer tile) {
		super(new ContainerComputer(tile));

	}

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ComputerScreenGui.png");
	
	
    public static final int xSizeOfTexture = 256;
    public static final int ySizeOfTexture = 177;

    boolean ProgramOpen = false;
    int IdOpen = 0;
    ComputerProgram CurrentProgram;

    public float _zLevel = zLevel;



    public void drawScreen(int par1, int par2, float par3)
    {
        int posX = (this.width - xSizeOfTexture) / 2;
        int posY = (this.height - ySizeOfTexture) / 2;

        if(CurrentProgram != null){
            CurrentProgram.DrawScreen(posX, posY, par1, par2, par3);
        }

        super.drawScreen(par1, par2, par3);

    }




        protected void keyTyped(char ch, int keyID)
    {

        if(CurrentProgram != null){
            if(!CurrentProgram.KeyTyped(ch, keyID))
                return;
        }

        if (keyID == 1)
        {
            if(ProgramOpen){

                if(CurrentProgram != null)
                 CurrentProgram.CloseProgram();

                ProgramOpen = false;
                IdOpen = 0;
                CurrentProgram = null;

            }else if (!ProgramOpen) {

                this.mc.displayGuiScreen((GuiScreen) null);
                this.mc.setIngameFocus();
            }
        }

        super.keyTyped(ch, keyID);
    }
	
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();

	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;


            if(!ProgramOpen) {
                for (int i = 0; i < ComputerUtils.Programs.size(); i++) {
                    if (ComputerUtils.Programs.get(i) != null) {

                        //12x
                        //7y
                        int h = i / 12;
                        int g = i - (h * 12);
                        if (h < 7) {

                            ProgramButton button = new ProgramButton(i, posX + 11 + (g * 20), posY + 13 + (h * 20), ComputerUtils.Programs.get(i).GetIcon(), ComputerUtils.Programs.get(i).GetName());

                            buttonList.add(button);

                        }

                    }

                }
            }else if(ProgramOpen) {

                if (CurrentProgram != null) {
                    CurrentProgram.AddButton(buttonList, posX, posY);

                }

            }

	    }

    protected void mouseClicked(int x, int y, int par3) {
        super.mouseClicked(x, y, par3);

        if(CurrentProgram != null){
            CurrentProgram.MouseClicked(x, y, par3);
        }

    }

        @Override
	    protected void actionPerformed(GuiButton bt) {

            if(!ProgramOpen){

                int id = bt.id;

                if(ComputerUtils.Programs.get(id) != null){

                    ProgramOpen = true;
                    IdOpen = id;

                  CurrentProgram = ComputerUtils.Programs.get(IdOpen).GetInstance();

                    if(CurrentProgram != null)
                  CurrentProgram.OpenProgram();


                }

            }else if (ProgramOpen){

                if(CurrentProgram != null)
                    CurrentProgram.ButtonClicked(bt);


            }
	    }
	    

		@Override
		protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
			  drawDefaultBackground();

            _zLevel = zLevel;

            int posX = (this.width - xSizeOfTexture) / 2;
            int posY = (this.height - ySizeOfTexture) / 2;


            initGui();

            if(!ProgramOpen) {
                GL11.glEnable(GL11.GL_BLEND);


                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(Texture);


                drawTexturedModalRect(posX, posY, 0, 1, 256, 177);


                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);

            }else if(ProgramOpen){

                if(CurrentProgram != null){
                    CurrentProgram.RenderWindow(this, fontRendererObj, posX, posY);



                }


            }
		        
		}

}
