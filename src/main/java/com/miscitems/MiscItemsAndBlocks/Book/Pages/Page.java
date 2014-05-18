package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public abstract class Page {


    protected final ResourceLocation TextureIcons = new ResourceLocation("miscitems" , "textures/gui/ResBook/BookIcons.png");

    /**
     *
     * @param render FontRenderer object
     * @param posX start position of x axis
     * @param posY start position of y axis
     * @param Side the side of the book it is renderd on
     */
    public abstract void Render(InfoPage Page, FontRenderer render, int posX, int posY, int Side);


    public void RenderItem(ItemStack stack, int x, int y){

        GL11.glDisable(GL11.GL_LIGHTING);
        if(stack != null && stack.getItem() != null && stack.getItem() != Item.getItemFromBlock(Blocks.air)) {
            BookUtils.renderitem.renderItemIntoGUI(Main.font, Minecraft.getMinecraft().renderEngine, stack, x, y, false);
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

    }

}
