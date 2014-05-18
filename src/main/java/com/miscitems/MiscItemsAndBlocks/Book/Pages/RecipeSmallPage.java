package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class RecipeSmallPage extends Page{

   ItemStack RecipeItem;
   List RecipeItems;

    public RecipeSmallPage(ItemStack Output){
        RecipeItem = Output;

        RecipeItems = BookUtils.InfoPageShapelessRecipes.get(RecipeItem.getUnlocalizedName().replace(".name", "")).recipeItems;
    }


    @Override
    public void Render(InfoPage Page, FontRenderer render, int posX, int posY, int Side) {



            render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.recipe"), posX + 70, posY + 25, 0x949294, false);

            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
            Page.drawTexturedModalRect(posX + 60, posY + 65, 3, 0, 81, 34);



            for(int i = 0; i < 4; i++){
                    if(RecipeItems.size() > i)
                    BookUtils.renderitem.renderItemIntoGUI(Main.font, Minecraft.getMinecraft().renderEngine, (ItemStack)RecipeItems.get(i), posX + 60 + (i == 2 || i == 4 ? 18 : 0), posY + 65 + (i > 2 ? 18 : 0), false);
            }
                BookUtils.renderitem.renderItemIntoGUI(Main.font, Minecraft.getMinecraft().renderEngine, RecipeItem, posX + 60 + 64, posY + 65 + 10, false);

            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

   }
}

