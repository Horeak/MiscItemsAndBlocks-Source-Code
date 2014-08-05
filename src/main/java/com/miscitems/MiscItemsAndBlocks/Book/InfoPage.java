package com.miscitems.MiscItemsAndBlocks.Book;

import com.miscitems.MiscItemsAndBlocks.Book.Pages.Page;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.ArrayList;
import java.util.Iterator;

public class InfoPage extends GuiScreen{


    public boolean doesGuiPauseGame()
    {
        return false;
    }

    public final ResourceLocation TextureLeft = new ResourceLocation("miscitems" , "textures/gui/ResBook/BookLeft.png");
    public final ResourceLocation TextureRight = new ResourceLocation("miscitems" , "textures/gui/ResBook/BookRight.png");

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
        GL11.glDisable(GL11.GL_LIGHTING);

        Minecraft.getMinecraft().renderEngine.bindTexture(TextureLeft);
        drawTexturedModalRect(posX, posY, 50, 0, 206, 200);


        Minecraft.getMinecraft().renderEngine.bindTexture(TextureRight);
        drawTexturedModalRect(posX + 206, posY, 0, 0, 206, 200);


        GL11.glDisable(GL11.GL_LIGHTING);

        if(Pages != null) {
            PageAmount = Pages.length - 1;



            if ((Pages.length - 1) >= UsePageLeft)
                Pages[UsePageLeft].Render(this.itemRender, this, fontRendererObj, posX, posY, 1, x, y);

            GL11.glDisable(GL11.GL_LIGHTING);


            if ((Pages.length - 1) >= UsePageRight)
                Pages[UsePageRight].Render(this.itemRender, this, fontRendererObj, posX + 200, posY, 2, x, y);


        }


        GL11.glEnable(GL11.GL_LIGHTING);


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


    public void drawTooltip(ArrayList var4, int par2, int par3)

    {
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        
                 if (!var4.isEmpty())
        {
                 int var5 = 0;
        Iterator var6 = var4.iterator();
        
                 while (var6.hasNext())
        {
                String var7 = (String) var6.next();
         int var8 = fontRendererObj.getStringWidth(var7);
        
                 if (var8 > var5)
        {
                var5 = var8;
        }
        }
        
                 int var15 = par2 + 12;
         int var16 = par3 - 12;
         int var9 = 8;
        
                 if (var4.size() > 1)
        {
                var9 += 2 + (var4.size() - 1) * 10;
        }
        
         this.zLevel = 500.0F;
        itemRender.zLevel = 300.0F;
         int var10 = -267386864;
        this.drawGradientRect(var15 - 3, var16 - 4, var15 + var5 + 3, var16 - 3, var10, var10);
        this.drawGradientRect(var15 - 3, var16 + var9 + 3, var15 + var5 + 3, var16 + var9 + 4, var10, var10);
        this.drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 + var9 + 3, var10, var10);
        this.drawGradientRect(var15 - 4, var16 - 3, var15 - 3, var16 + var9 + 3, var10, var10);
        this.drawGradientRect(var15 + var5 + 3, var16 - 3, var15 + var5 + 4, var16 + var9 + 3, var10, var10);
         int var11 = 1347420415;
         int var12 = (var11 & 16711422) >> 1 | var11 & -16777216;
        this.drawGradientRect(var15 - 3, var16 - 3 + 1, var15 - 3 + 1, var16 + var9 + 3 - 1, var11, var12);
        this.drawGradientRect(var15 + var5 + 2, var16 - 3 + 1, var15 + var5 + 3, var16 + var9 + 3 - 1, var11, var12);
        this.drawGradientRect(var15 - 3, var16 - 3, var15 + var5 + 3, var16 - 3 + 1, var11, var11);
        this.drawGradientRect(var15 - 3, var16 + var9 + 2, var15 + var5 + 3, var16 + var9 + 3, var12, var12);
        
                 for (int var13 = 0; var13 < var4.size(); ++var13)
        {
                String var14 = (String) var4.get(var13);

        {
                var14 = "\u00a77" + var14;
        }
        
                fontRendererObj.drawStringWithShadow(var14, var15, var16, -1);
        
                 if (var13 == 0)
        {
                var16 += 2;
        }
        
                var16 += 10;
        }
        
                this.zLevel = 0.0F;
            itemRender.zLevel = 0.0F;
        }

    }


    }
