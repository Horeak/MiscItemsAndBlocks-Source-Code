package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemXpExtractor;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class RecipeBigPage extends Page {


    ItemStack RecipeItem;
    ItemStack[] RecipeItems;
    ShapedRecipes Recipe;


    public RecipeBigPage(ItemStack Output){
        RecipeItem = Output;

        Recipe = BookUtils.InfoPageShapedRecipes.get(RecipeItem.getUnlocalizedName().replace(".name", ""));
        RecipeItems = BookUtils.InfoPageShapedRecipes.get(RecipeItem.getUnlocalizedName().replace(".name", "")).recipeItems;
    }

    @Override
    public void Render(InfoPage Page, FontRenderer render, int posX, int posY, int Side) {
        render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.recipe"), posX + 70, posY + 25, 0x949294, false);



        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
        Page.drawTexturedModalRect(posX + 60, posY + 65, 0, 40, 106, 52);


        GL11.glDisable(GL11.GL_LIGHTING);

        RenderItem(RecipeItems[0], posX + 60, posY + 65);
        RenderItem(RecipeItems[1], posX + 60 + 18, posY + 65);
        RenderItem(RecipeItems[2], posX + 60 + (2 * 18), posY + 65);

        RenderItem(RecipeItems[3], posX + 60, posY + 65 + 18);
        RenderItem(RecipeItems[4], posX + 60 + 18, posY + 65 + 18);
        RenderItem(RecipeItems[5], posX + 60 + (2 * 18), posY + 65 + 18);

        RenderItem(RecipeItems[6], posX + 60, posY + 65 + (2 * 18));
        RenderItem(RecipeItems[7], posX + 60 + 18, posY + 65 + (2 * 18));
        RenderItem(RecipeItems[8], posX + 60 + (2 * 18), posY + 65 + (2 * 18));


        RenderItem(RecipeItem, posX + 60 + 88, posY + 65 + 18);

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_LIGHTING);

    }

    public void RenderItem(ItemStack stack, int x, int y){

        GL11.glDisable(GL11.GL_LIGHTING);
        if(stack != null && stack.getItem() != null) {
            BookUtils.renderitem.renderItemIntoGUI(Main.font, Minecraft.getMinecraft().renderEngine, stack, x, y, false);
        }

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

    }

    }
