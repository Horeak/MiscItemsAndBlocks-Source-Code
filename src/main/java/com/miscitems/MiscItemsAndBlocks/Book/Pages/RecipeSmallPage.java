package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import MiscUtils.Utils.StackUtils;
import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeSmallPage extends Page {

    ItemStack RecipeItem;
    List<IRecipe> Recipes;

    int CurrentRes = 0;

    int Switch = 0;

    List<ItemStack> RecipeItems;

    int GridX = 60;
    int GridY = 65;

    int posX, posY;


    public ArrayList<ItemStack> GetOreRecipe(ArrayList<Object> ob) {
        ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();

        for (int i = 0; i < ob.size(); i++) {
            stacks.add(StackUtils.GetObject(ob));

        }


        return stacks;
    }

    public RecipeSmallPage(ItemStack Output) {
        Recipes = BookUtils.GetShapelessRecipeItems(Output);

        if (Recipes.size() > 0)
        if (Recipes.get(0) instanceof ShapelessRecipes) {
            RecipeItems = ((ShapelessRecipes) (Recipes.get(0))).recipeItems;
            RecipeItem = (Recipes.get(0).getRecipeOutput());

        }else if(Recipes.get(0) instanceof ShapelessOreRecipe){
            RecipeItems = GetOreRecipe(((ShapelessOreRecipe) (Recipes.get(0))).getInput());
            RecipeItem = (Recipes.get(0).getRecipeOutput());
        }


}


    @Override
    public void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side, int MouseX, int MouseY) {
        render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.recipe"), posX + 70, posY + 25, 0x949294, false);

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
        Page.drawTexturedModalRect(posX + GridX, posY + GridY, 3, 0, 81, 34);

        this.posX = posX;
        this.posY = posY;


        if (Recipes.size() > 0) {
            if (Recipes.size() > 1) {
                if (Switch >= BookUtils.RecipeChangeTime) {
                    Switch = 0;

                    if (CurrentRes < Recipes.size())
                        CurrentRes += 1;

                    else
                        CurrentRes = 0;

                } else {
                    Switch += 1;
                }



                if (Recipes.get(CurrentRes) instanceof ShapelessRecipes) {
                    RecipeItems = ((ShapelessRecipes) (Recipes.get(CurrentRes))).recipeItems;
                    RecipeItem = (Recipes.get(CurrentRes).getRecipeOutput());

                }else if(Recipes.get(CurrentRes) instanceof ShapelessOreRecipe){
                    RecipeItems = GetOreRecipe(((ShapelessOreRecipe) (Recipes.get(CurrentRes))).getInput());
                    RecipeItem = (Recipes.get(CurrentRes).getRecipeOutput());

                }

            }


            GL11.glDisable(GL11.GL_LIGHTING);

            for (int i = 0; i < 4; i++) {
                if (RecipeItems.size() > i)
                    RenderItem(ItemRender, render, (ItemStack) RecipeItems.get(i), posX + GridX + (i == 1 || i == 3 ? 18 : 0), posY + GridY + (i > 1 ? 18 : 0));
            }

            if (OverSlot(posX + GridX, posY + GridY, MouseX, MouseY) && ((ItemStack) RecipeItems.get(0)) != null) {
                Page.drawTooltip(GetToolTip(((ItemStack) RecipeItems.get(0))), MouseX, MouseY);
            }


            if (RecipeItems.size() > 1)
                if (OverSlot(posX + GridX + 18, posY + GridY, MouseX, MouseY) && ((ItemStack) RecipeItems.get(1)) != null)
                    Page.drawTooltip(GetToolTip(((ItemStack) RecipeItems.get(1))), MouseX, MouseY);


            if (RecipeItems.size() > 2)
                if (OverSlot(posX + GridX, posY + GridY + 18, MouseX, MouseY) && ((ItemStack) RecipeItems.get(2)) != null)
                    Page.drawTooltip(GetToolTip(((ItemStack) RecipeItems.get(2))), MouseX, MouseY);


            if (RecipeItems.size() > 3)
                if (OverSlot(posX + GridX + 18, posY + GridY + 18, MouseX, MouseY) && ((ItemStack) RecipeItems.get(3)) != null)
                    Page.drawTooltip(GetToolTip(((ItemStack) RecipeItems.get(3))), MouseX, MouseY);


            if (OverSlot(posX + GridX + 63, posY + GridY + 9, MouseX, MouseY) && RecipeItem != null)
                Page.drawTooltip((GetToolTipWithoutLink(RecipeItem)), MouseX, MouseY);


            RenderItem(ItemRender, render, RecipeItem, posX + GridX + 63, posY + GridY + 9);


            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(GL11.GL_LIGHTING);

        }
        else{

            net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
            render.drawString(EnumChatFormatting.RED + StatCollector.translateToLocal("book.recipe.disabled"), posX + 40, posY + 78, new Color(255, 0, 0).getRGB());
        }

    }


    public void OnClick(InfoPage page, int ClickedX, int ClickedY){



        if(OverSlot(posX + GridX, posY + GridY, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(0)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(0))) != null) {
                Minecraft.getMinecraft().displayGuiScreen(new InfoPage(((ItemStack) RecipeItems.get(0)), page.LastTab));
            }
        }

        if(OverSlot(posX + GridX + 18, posY + GridY, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(1)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(1))) != null)
                Minecraft.getMinecraft().displayGuiScreen(new InfoPage(((ItemStack)RecipeItems.get(1)), page.LastTab));
        }

        if(OverSlot(posX + GridX, posY + GridY + 18, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(2)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(2))) != null)
                Minecraft.getMinecraft().displayGuiScreen(new InfoPage(((ItemStack)RecipeItems.get(2)), page.LastTab));
        }

        if(OverSlot(posX + GridX + 18, posY + GridY + 18, ClickedX, ClickedY) && ((ItemStack)RecipeItems.get(3)) != null){
            if(BookUtils.GetInfoPagesForItem(((ItemStack)RecipeItems.get(3))) != null)
                Minecraft.getMinecraft().displayGuiScreen(new InfoPage(((ItemStack)RecipeItems.get(3)), page.LastTab));
        }


        if(OverSlot(posX + GridX, posY + GridY, ClickedX, ClickedY) && RecipeItem != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItem) != null)
                Minecraft.getMinecraft().displayGuiScreen(new InfoPage(RecipeItem, page.LastTab));
        }

    }
}

