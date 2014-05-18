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
                Pages[UsePageLeft].Render(this, fontRendererObj, posX, posY, 1);

            if ((Pages.length - 1) >= UsePageRight)
                Pages[UsePageRight].Render(this, fontRendererObj, posX + 200, posY, 2);

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
