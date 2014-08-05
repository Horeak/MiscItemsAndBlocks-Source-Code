package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

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





    protected boolean OverSlot(int x, int y, int MouseX, int MouseY){
        return MouseX >= x && MouseX <= x + 16 && MouseY >= y && MouseY <= y + 16;

    }

    protected ArrayList GetToolTip(ItemStack stack, boolean h){
        ArrayList<String> list = new ArrayList<String>();
        List t = stack.getTooltip(Minecraft.getMinecraft().thePlayer, false);

        if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && t.size() > 1) {
            for (int i = 0; i < t.size(); i++) {
                list.add(EnumChatFormatting.WHITE + (String) t.get(i));
            }
        }else{
            list.add(stack.getRarity().rarityColor + stack.getDisplayName());
            if(t.size() > 1)
            list.add(EnumChatFormatting.WHITE + "Hold LControl to see default tooltip.");
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
