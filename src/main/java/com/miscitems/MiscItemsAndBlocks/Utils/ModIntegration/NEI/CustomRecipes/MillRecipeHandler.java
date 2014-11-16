package com.miscitems.MiscItemsAndBlocks.Utils.ModIntegration.NEI.CustomRecipes;

import MiscItemsApi.Recipes.MillRecipe;
import MiscItemsApi.Recipes.RecipeHandler;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import com.miscitems.MiscItemsAndBlocks.Gui.Machines.GuiMill;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MillRecipeHandler extends TemplateRecipeHandler {

    int OffsetX = -5;
    int OffsetY = -11;

    public class MillRes extends CachedRecipe
    {

        public MillRes(MillRecipe res){
            this(res.Input, res.Output);
        }


        PositionedStack result;
        PositionedStack Input;

        public MillRes(ItemStack Input, ItemStack Output) {
            Input.stackSize = 1;
            this.result = new PositionedStack(Output, 79 + OffsetX, 56 + OffsetY);
            this.Input = new PositionedStack(Input, 79 + OffsetX, 13 + OffsetY);

        }

        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 48, java.util.Arrays.asList(Input));
        }

        public PositionedStack getResult() {
            return result;
        }


    }



    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(75 + OffsetX, 20, 11, 15), "Mill"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiMill.class;
    }


    @Override
    public TemplateRecipeHandler newInstance() {
        return super.newInstance();
    }


    @Override
    public void drawExtras(int recipe) {
        drawProgressBar(81 + OffsetX, 34 + OffsetY, 176, 3, 11, 14, 50, 1);


    }


    public MillRecipe GetRecipeFromInt(int i){
        MillRecipe res = null;
        ArrayList<MillRecipe> Res = new ArrayList<MillRecipe>();

        for(Object r : RecipeHandler.getCraftingRecipes()){
            if(r instanceof MillRecipe){
                Res.add((MillRecipe)r);
            }
        }

        if(Res.size() >= i)
            res = Res.get(i);


        return res;
    }

    @Override
    public String getOverlayIdentifier() {
        return "Mill";
    }

    @Override
    public String getGuiTexture() {
        return new ResourceLocation("miscitems", "textures/gui/MillGui.png").toString();
    }

    @Override
    public String getRecipeName() {
        return StatCollector.translateToLocal("tile.mill.name");
    }


    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("Mill") && getClass() == MillRecipeHandler.class) {
            for (Object r : RecipeHandler.getCraftingRecipes()) {
                MillRes recipe = null;
                if (r instanceof MillRecipe)
                    recipe = new MillRes((MillRecipe) r);


                if (recipe == null)
                    continue;

                arecipes.add(recipe);
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (Object r : RecipeHandler.getCraftingRecipes()) {
            if(r instanceof MillRecipe)
                if (NEIServerUtils.areStacksSameTypeCrafting(((MillRecipe) r).Output, result)) {
                    MillRes recipe = null;

                    if (r instanceof MillRecipe)
                        recipe = new MillRes((MillRecipe) r);


                    if (recipe == null)
                        continue;

                    arecipes.add(recipe);
                }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        for (Object r : RecipeHandler.getCraftingRecipes()) {
            MillRes recipe = null;

            if (r instanceof MillRecipe)
                recipe = new MillRes((MillRecipe) r);


            if (recipe == null || !recipe.contains(recipe.getIngredients(), ingredient.getItem()))
                continue;

            if (recipe.contains(recipe.getIngredients(), ingredient)) {
                recipe.setIngredientPermutation(recipe.getIngredients(), ingredient);
                arecipes.add(recipe);
            }
        }
    }


}
