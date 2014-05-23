package com.miscitems.MiscItemsAndBlocks.Book;

import com.miscitems.MiscItemsAndBlocks.Book.Pages.Page;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.Iterator;
import java.util.List;

public class InfoPage extends GuiScreen{


    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public final ResourceLocation TextureLeft = new ResourceLocation("miscitems" , "textures/gui/ResBook/bookLeft.png");
    public final ResourceLocation TextureRight = new ResourceLocation("miscitems" , "textures/gui/ResBook/bookRight.png");

    public static final int xSizeOfTexture = 400;
    public static final int ySizeOfTexture = 206;

    public Page[] Pages;
    public ItemStack stack;

    public int Page = 1;
    public int UsePageLeft;
    public int UsePageRight;
    public int PageAmount = 1;

    public int LastTab = 0;

    public InfoPage(ItemStack stack, int Tab){
        this.stack = stack;

        LastTab = Tab;

        this.width = xSizeOfTexture;
        this.height = ySizeOfTexture;

    }

    public void updateScreen(){
        initGui();
    }


    public int posX, posY;

    @Override
    public void drawScreen(int x, int y, float f) {
        drawDefaultBackground();

        Pages = BookUtils.GetInfoPagesForItem(stack);
        UsePageLeft = Page - 1;
        UsePageRight = Page;


        posX = (this.width - xSizeOfTexture) / 2;
        posY = (this.height - ySizeOfTexture) / 2;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        Minecraft.getMinecraft().renderEngine.bindTexture(TextureLeft);
        drawTexturedModalRect(posX, posY, 50, 0, 206, 200);


        Minecraft.getMinecraft().renderEngine.bindTexture(TextureRight);
        drawTexturedModalRect(posX + 206, posY, 0, 0, 206, 200);



        if(Pages != null) {
            PageAmount = Pages.length - 1;



            if ((Pages.length - 1) >= UsePageLeft)
                Pages[UsePageLeft].Render(this.itemRender, this, fontRendererObj, posX, posY, 1, x, y);

            if(UsePageRight > 1) {
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
            if ((Pages.length - 1) >= UsePageRight)
                Pages[UsePageRight].Render(this.itemRender, this, fontRendererObj, posX + 200, posY, 2, x, y);


            if(UsePageRight > 1) {
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }


        if(Page == 1)
        fontRendererObj.drawString(stack.getDisplayName(), posX + 20, posY + 10, 0x949292);


        fontRendererObj.drawString((UsePageLeft + 1) + "/" + (PageAmount + 1), posX + 100, posY + 180, 0x949292);

        if(UsePageRight <= PageAmount)
        fontRendererObj.drawString((UsePageRight + 1) + "/" + (PageAmount + 1), posX + 300, posY + 180, 0x949292);

        super.drawScreen(x, y, f);
    }


    protected void keyTyped(char par1, int par2)
    {
        if (par2 == 1)
        {

            MainPage page = new MainPage();
            page.CurrentTab = this.LastTab;

            FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, page);
        }
    }

    public void initGui(){
        super.initGui();
        posX = (this.width - xSizeOfTexture) / 2;
        posY = (this.height - ySizeOfTexture) / 2;

        buttonList.clear();

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        buttonList.add(new NextPageButton(1, posX + 20, posY + 170, 2));
        buttonList.add(new NextPageButton(2, posX + 375, posY + 170, 1));
    }

    @Override
    protected void actionPerformed(GuiButton button){

        int id = button.id;

        if(id == 1){
            if(Page > 1) {
                Page -= 2;
            }
        }else if(id == 2){
            if(Page < PageAmount) {
                Page += 2;
            }
        }

    }


    protected void mouseClicked(int x, int y, int f)
    {
       super.mouseClicked(x,y,f);

        if( y >= posY && y <= posY + 200 ) {

            if (x < posX + 206) {

                if ((Pages.length - 1) >= UsePageLeft)
                    Pages[UsePageLeft].OnClick(this, x, y);

            }else if(x > posX + 206){

                if ((Pages.length - 1) >= UsePageRight)
                    Pages[UsePageRight].OnClick(this, x, y);

            }

        }
    }



    }
