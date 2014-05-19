package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

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
    public abstract void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side);


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
        ItemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (font == null) font = render;
        ItemRender.renderItemAndEffectIntoGUI(font, mc.getTextureManager(), stack, x, y);
        ItemRender.zLevel = 0.0F;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

}
