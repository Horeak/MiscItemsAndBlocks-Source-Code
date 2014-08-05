package com.miscitems.MiscItemsAndBlocks.Book;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainPage extends GuiScreen {



    public final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ResBook/MainBookPage.png");
    public final ResourceLocation Icons = new ResourceLocation("miscitems" , "textures/gui/ResBook/BookIcons.png");

    public int Tabs = BookUtils.Tabs;
    public int CurrentTab = 1;


    public static final int xSizeOfTexture = 260;
    public static final int ySizeOfTexture = 180;


    public int posX, posY;

    public int CurrentPage = 1;


    @Override
    public void drawScreen(int x, int y, float f) {
        drawDefaultBackground();

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

         posX = (this.width - xSizeOfTexture) / 2;
         posY = (this.height - ySizeOfTexture) / 2;


        drawTexturedModalRect(posX, posY, 20, 1, 236, 180);


        fontRendererObj.drawString(BookUtils.GetTabName(CurrentTab), posX + 10, posY + 8, 4210752);


        if(BookUtils.GetTabType(CurrentTab) == 1){
            this.fontRendererObj.drawSplitString(BookUtils.GetTextForTab(CurrentTab), posX + 10, posY + 20, 200, 4210752);
        }


        if(CurrentTab > Tabs)
            CurrentTab = 1;


        if(BookUtils.GetTabType(CurrentTab) == 2) {
            if(BookUtils.GetTabItems(CurrentTab)!= null && BookUtils.GetTabItems(CurrentTab).length > 1) {
                int Pages =  1 + BookUtils.GetTabItems(CurrentTab).length / 30;

                fontRendererObj.drawString("Page " + CurrentPage + "/" + Pages, posX + 170, posY + 8, 4210752);
            }
        }




        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);

        super.drawScreen(x, y, f);
        drawForeground(x, y, f);
    }




    public void initGui(){

        posX = (this.width - xSizeOfTexture) / 2;
        posY = (this.height - ySizeOfTexture) / 2;


        buttonList.clear();

            for (int i = 1; i < Tabs + 1; i++) {
                buttonList.add(new BookTabButton(i, posX - 26, posY + (12 + (((i - 1) * 20) + 1)), this, this.itemRender));
            }

        if(BookUtils.GetTabType(CurrentTab) == 2)
            ChangeItems();




    }


    public void ChangeItems(){
        if(BookUtils.GetTabType(CurrentTab) == 2){

            if(BookUtils.GetTabItems(CurrentTab)!= null && BookUtils.GetTabItems(CurrentTab).length > 1) {
                int Pages = 1 + BookUtils.GetTabItems(CurrentTab).length / 30;

                if(Pages > 1){
                    buttonList.add(new GuiButton(1 + BookUtils.MaxTabs, posX + 150, posY + 180, 55, 20, "Next Page"));
                    buttonList.add(new GuiButton(2 + BookUtils.MaxTabs, posX + 95, posY + 180, 55, 20, "Prev Page"));

                }

                    for (int i = 0; i < BookUtils.GetTabItems(CurrentTab).length; i++) {
                        int t = i - ((CurrentPage-1) * 30);

                        if(i < (BookUtils.GetTabItems(CurrentTab).length)) {

                            if(CurrentPage == 1 && i < 30) {
                                buttonList.add(new BookItemSelectButton(i + BookUtils.MaxTabs + 4, i, posX + 15 + (t >= 15 ? 100 : 0), posY + (t >= 15 ? (t - 13) * 10 : (t * 10) + 21), this));


                            }
                            else if(CurrentPage > 1 && i > (CurrentPage - 1) * 30 && i < ((CurrentPage) * 30) + 1) {
                                buttonList.add(new BookItemSelectButton(i + BookUtils.MaxTabs + 4, i, posX + 15 + (t >= 16 ? 100 : 0), posY + (t >= 16 ? (t - 14) * 10 : (t * 10) + 8), this));
                            }
                        }



                }

            }else if (BookUtils.GetTabItems(CurrentTab)!= null && BookUtils.GetTabItems(CurrentTab).length == 1){
                    int g = 1 >= 15 ? 1 : 0;
                    int h = g == 1 ? 1 - 15 : 0;

                    buttonList.add(new BookItemSelectButton(1 + BookUtils.MaxTabs, 1, posX + 15 + (100 * g), posY + (1 >= 15 ? (21 + (h * 10)) : (21 + (1 * 10))), this));

            }



        }else{
            buttonList.clear();
            initGui();
        }


    }

    @Override
    protected void actionPerformed(GuiButton button){
        if(button.id < BookUtils.MaxTabs) {

            CurrentPage = 1;
            if (button.id <= Tabs && button.id > 0) {
                CurrentTab = button.id;


            }
            initGui();

        }else if(button.id == 1 + BookUtils.MaxTabs){
            if(BookUtils.GetTabType(CurrentTab) == 2) {

                if (BookUtils.GetTabItems(CurrentTab) != null && BookUtils.GetTabItems(CurrentTab).length > 1) {
                    int Pages = 1 + BookUtils.GetTabItems(CurrentTab).length / 30;
                    if(Pages > CurrentPage)
                        CurrentPage++;
                    initGui();

                }
            }

        }else if(button.id == 2 + BookUtils.MaxTabs){

            if(BookUtils.GetTabType(CurrentTab) == 2) {

                if (BookUtils.GetTabItems(CurrentTab) != null && BookUtils.GetTabItems(CurrentTab).length > 1) {
                    if(CurrentPage > 1)
                        CurrentPage--;
                    initGui();

                }
            }

        }else{
            if(button instanceof BookItemSelectButton) {

                BookItemSelectButton btn = (BookItemSelectButton)button;

                if(BookUtils.GetTabItems(CurrentTab).length >= btn.Id && BookUtils.GetTabItems(CurrentTab)[btn.Id] != null && BookUtils.GetTabItems(CurrentTab)[btn.Id].getItem() != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(BookUtils.GetTabItems(CurrentTab)[btn.Id], CurrentTab));
            }
        }


    }


    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public void drawForeground(int par1, int par2, float par3)
    {
        for(int i = 0; i < this.buttonList.size(); i++) {
            GuiButton btn = (GuiButton) this.buttonList.get(i);



            if (btn instanceof BookTabButton) {
                if (isHovering(par1, par2, btn.getButtonWidth(), 20, btn.xPosition, btn.yPosition)) {


                    if (btn.id <= BookUtils.Tabs) {
                        drawTooltip(Arrays.asList(new String[]{BookUtils.GetTabName(btn.id)}), par1, par2);
                    }


                }
            }

        }


    }


    public boolean isHovering(int x, int y, int width, int height, int u, int v){


        return x >= u && x <= u + width && y >= v && y <= v + height;
    }


    @SuppressWarnings("rawtypes")
    protected void drawTooltip(List par1List, int par2, int par3)
    {
        if (!par1List.isEmpty())
        {
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            int k = 0;
            Iterator iterator = par1List.iterator();

            while (iterator.hasNext())
            {
                String s = (String)iterator.next();
                int l = this.fontRendererObj.getStringWidth(s);

                if (l > k)
                {
                    k = l;
                }
            }

            int i1 = par2 + 12;
            int j1 = par3 - 12;
            int k1 = 8;

            if (par1List.size() > 1)
            {
                k1 += 2 + (par1List.size() - 1) * 10;
            }

            if (i1 + k > this.width)
            {
                i1 -= 28 + k;
            }

            if (j1 + k1 + 6 > this.height)
            {
                j1 = this.height - k1 - 6;
            }

            this.zLevel = 300.0F;
            int l1 = -267386864;
            this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
            this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
            this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
            this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
            this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
            int i2 = 1347420415;
            int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
            this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
            this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
            this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
            this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

            for (int k2 = 0; k2 < par1List.size(); ++k2)
            {
                String s1 = (String)par1List.get(k2);
                this.fontRendererObj.drawStringWithShadow(s1, i1, j1, -1);

                if (k2 == 0)
                {
                    j1 += 2;
                }

                j1 += 10;
            }

            this.zLevel = 0.0F;
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        }
    }
}

