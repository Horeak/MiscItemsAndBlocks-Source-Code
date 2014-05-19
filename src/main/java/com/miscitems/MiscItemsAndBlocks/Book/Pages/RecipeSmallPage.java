package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
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
    public void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side) {
            render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.recipe"), posX + 70, posY + 25, 0x949294, false);

            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
            Page.drawTexturedModalRect(posX + 60, posY + 65, 3, 0, 81, 34);


        GL11.glDisable(GL11.GL_LIGHTING);

            for(int i = 0; i < 4; i++){
                    if(RecipeItems.size() > i)
                    RenderItem(ItemRender, render, (ItemStack)RecipeItems.get(i), posX + 60 + (i == 1 || i == 3 ? 18 : 0), posY + 65 + (i > 1 ? 18 : 0));
            }
                     RenderItem(ItemRender, render, RecipeItem, posX + 60 + 63, posY + 65 + 9);

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_LIGHTING);

   }
}

