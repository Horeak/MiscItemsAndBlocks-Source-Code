package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {


    protected final ResourceLocation TextureIcons = new ResourceLocation("miscitems" , "textures/gui/ResBook/BookIcons.png");

    /**
     *
     *  Render the page into the gui
     *
     * @param render FontRenderer object
     * @param posX start position of x axis
     * @param posY start position of y axis
     * @param Side the side of the book it is renderd on
     */
    public abstract void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side, int MouseX, int MouseY);

    public abstract void OnClick(InfoPage page, int ClickedX, int ClickedY);

    protected int width = 200;
    protected int height = 206;

    protected float zLevel = 0;

    /**
     *
     * Renders a item into the guide book
     *
     * @param ItemRender
     * @param render
     * @param stack the stack to render
     * @param x the x position to render the item
     * @param y the y position to render the item
     */
    protected void RenderItem(RenderItem ItemRender, FontRenderer render, ItemStack stack, int x, int y)
    {
        GL11.glDisable(GL11.GL_LIGHTING);
        Minecraft mc = Minecraft.getMinecraft();
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);

        if(stack != null && stack.stackSize > 1){

            Minecraft.getMinecraft().fontRenderer.drawString("x" + stack.stackSize, x, y + 18, new Color(0, 0, 0).getRGB());
        }

        ItemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (font == null) font = render;
        ItemRender.renderItemAndEffectIntoGUI(font, mc.getTextureManager(), stack, x, y);


        ItemRender.zLevel = 0.0F;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }


    @SuppressWarnings("rawtypes")
    protected void drawTooltip(FontRenderer render, ArrayList par1List, int par2, int par3)
    {
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef(0.0F, 0.0F, 32.0F);

        if (!par1List.isEmpty()) {

            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            int k = 0;



            for ( int i = 0; i < par1List.size(); i++) {

                    String s = (String) par1List.get(i);
                    int l = render.getStringWidth(s);

                    if (l > k) {
                        k = l;
                    }
                }

                int i1 = par2 + 12;
                int j1 = par3 - 12;
                int k1 = 8;

                if (par1List.size() > 1) {
                    k1 += 2 + (par1List.size() - 1) * 10;
                }

                if (i1 + k > this.width) {
                    i1 -= 28 + k;
                }

                if (j1 + k1 + 6 > this.height) {
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

                for (int k2 = 0; k2 < par1List.size(); ++k2) {
                    String s1 = (String) par1List.get(k2);

                    render.drawString(s1, i1, j1, new Color(255, 255, 255).getRGB());

                    if (k2 == 0) {
                        j1 += 2;
                    }

                    j1 += 10;
                }

                this.zLevel = 0.0F;

            }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

    }


    protected void drawGradientRect(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = (float)(par5 >> 24 & 255) / 255.0F;
        float f1 = (float)(par5 >> 16 & 255) / 255.0F;
        float f2 = (float)(par5 >> 8 & 255) / 255.0F;
        float f3 = (float)(par5 & 255) / 255.0F;
        float f4 = (float)(par6 >> 24 & 255) / 255.0F;
        float f5 = (float)(par6 >> 16 & 255) / 255.0F;
        float f6 = (float)(par6 >> 8 & 255) / 255.0F;
        float f7 = (float)(par6 & 255) / 255.0F;
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f1, f2, f3, f);
        tessellator.addVertex((double)par3, (double)par2, (double)this.zLevel);
        tessellator.addVertex((double)par1, (double)par2, (double)this.zLevel);
        tessellator.setColorRGBA_F(f5, f6, f7, f4);
        tessellator.addVertex((double)par1, (double)par4, (double)this.zLevel);
        tessellator.addVertex((double)par3, (double)par4, (double)this.zLevel);
        tessellator.draw();
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LIGHTING);
    }


    protected boolean OverSlot(int x, int y, int MouseX, int MouseY){
        return MouseX >= x && MouseX <= x + 16 && MouseY >= y && MouseY <= y + 16;

    }

    protected ArrayList GetToolTip(ItemStack stack, boolean h){
        ArrayList<String> list = new ArrayList<String>();
        List t = stack.getTooltip(Minecraft.getMinecraft().thePlayer, false);

        if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && t.size() > 1) {
            for (int i = 0; i < t.size(); i++) {
                list.add((String) t.get(i));
            }
        }else{
            list.add(stack.getDisplayName());
            if(t.size() > 1)
            list.add("Hold LControl to see default tooltip.");
        }

        if(h) {
            if (BookUtils.GetInfoPagesForItem(stack) != null)
                list.add(EnumChatFormatting.WHITE + "  - " + (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) ? StatCollector.translateToLocal("book.gui.itemOpen") : StatCollector.translateToLocal("book.gui.shiftText")));
        }


        return list;

    }


    protected ArrayList GetToolTip(ItemStack stack){
        return GetToolTip(stack, true);
    }

    protected ArrayList GetToolTipWithoutLink(ItemStack stack){
        return GetToolTip(stack, false);
    }

}
