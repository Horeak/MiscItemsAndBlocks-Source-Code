package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;

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

}
