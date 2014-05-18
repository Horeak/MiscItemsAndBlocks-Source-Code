package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import net.minecraft.client.gui.FontRenderer;

public class TextPage extends Page {

    String Text;

    public TextPage(String Text){
        this.Text = Text;
    }



    public void Render(InfoPage Page, FontRenderer render, int posX, int posY, int Side){
            render.drawSplitString(Text, posX + 20, posY + 25, 180, 0x949294);
    }
}
