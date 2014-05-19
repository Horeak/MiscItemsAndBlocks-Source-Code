package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemXpExtractor;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
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
    public void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side) {
        render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.recipe"), posX + 70, posY + 25, 0x949294, false);



        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
        Page.drawTexturedModalRect(posX + 60, posY + 65, 0, 40, 106, 52);


        GL11.glDisable(GL11.GL_LIGHTING);

        RenderItem(ItemRender, render, RecipeItems[0], posX + 60, posY + 65);

        if(RecipeItems.length > 1)
        RenderItem(ItemRender, render, RecipeItems[1], posX + 60 + 18, posY + 65);

        if(RecipeItems.length > 2)
        RenderItem(ItemRender, render, RecipeItems[2], posX + 60 + (2 * 18), posY + 65);

        if(RecipeItems.length > 3)
        RenderItem(ItemRender, render, RecipeItems[3], posX + 60, posY + 65 + 18);

        if(RecipeItems.length > 4)
        RenderItem(ItemRender, render, RecipeItems[4], posX + 60 + 18, posY + 65 + 18);

        if(RecipeItems.length > 5)
        RenderItem(ItemRender, render, RecipeItems[5], posX + 60 + (2 * 18), posY + 65 + 18);

        if(RecipeItems.length > 6)
        RenderItem(ItemRender, render, RecipeItems[6], posX + 60, posY + 65 + (2 * 18));

        if(RecipeItems.length > 7)
        RenderItem(ItemRender, render, RecipeItems[7], posX + 60 + 18, posY + 65 + (2 * 18));

        if(RecipeItems.length > 8)
        RenderItem(ItemRender, render, RecipeItems[8], posX + 60 + (2 * 18), posY + 65 + (2 * 18));


        RenderItem(ItemRender, render, RecipeItem, posX + 60 + 88, posY + 65 + 18);

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(GL11.GL_LIGHTING);

    }


    }
