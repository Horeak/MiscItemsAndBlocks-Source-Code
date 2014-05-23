package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;

public class TextPage extends Page {

    String Text;

    public TextPage(String Text){
        this.Text = Text;
    }



    public void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side, int MouseX, int MouseY) {
            render.drawSplitString(Text, posX + 20, posY + 25, 180, 0x949294);
    }

    public void OnClick(InfoPage page, int ClickedX, int ClickedY){

    }
}
