package com.miscitems.MiscItemsAndBlocks.Utils.ModIntegration.NEI.CustomRecipes;

import MiscItemsApi.Recipes.RecipeHandler;
import MiscItemsApi.Recipes.SqueezerRecipe;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import com.miscitems.MiscItemsAndBlocks.Gui.Electric.GuiSquezer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SqueezerRecipeHandler extends TemplateRecipeHandler {

    int OffsetX = -5;
    int OffsetY = -11;

    public class SqueezerRes extends CachedRecipe
    {

        public SqueezerRes(SqueezerRecipe res){
            this(res.Output, res.Items);
        }


        PositionedStack result;
        ArrayList<PositionedStack>Stacks;

        public SqueezerRes(ItemStack Output, ItemStack[] Input) {
            this.result = new PositionedStack(Output, 80 + OffsetX, 57 + OffsetY);
            Stacks = new ArrayList<PositionedStack>();

            for(int i = 0; i < Input.length; i++){

                if(i > Input.length)
                    break;

                if(i == 0)
                    Stacks.add(new PositionedStack(Input[0], 62 + OffsetX, 11 + OffsetY));


                if(i == 1)
                    Stacks.add(new PositionedStack(Input[1], 98 + OffsetX, 11 + OffsetY));



            }

        }

        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 48, Stacks);
        }

        public PositionedStack getResult() {
            return result;
        }


    }



    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(75 + OffsetX, 20, 11, 15), "Squeezer"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiSquezer.class;
    }


    @Override
    public TemplateRecipeHandler newInstance() {
        return super.newInstance();
    }


    @Override
    public void drawExtras(int recipe) {
        drawProgressBar(67 + OffsetX, 29 + OffsetY, 177, 4, 41, 23, 70, 1);


    }


    @Override
    public String getOverlayIdentifier() {
        return "Squeezer";
    }

    @Override
    public String getGuiTexture() {
        return new ResourceLocation("miscitems", "textures/gui/SquezerGui.png").toString();
    }

    @Override
    public String getRecipeName() {
        return StatCollector.translateToLocal("tile.squeezer.name");
    }


    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("Squeezer") && getClass() == SqueezerRecipeHandler.class) {
            for (Object r : RecipeHandler.getCraftingRecipes()) {
                SqueezerRes recipe = null;
                if (r instanceof SqueezerRecipe)
                    recipe = new SqueezerRes((SqueezerRecipe) r);


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
            if(r instanceof SqueezerRecipe)
                if (NEIServerUtils.areStacksSameTypeCrafting(((SqueezerRecipe) r).Output, result)) {
                    SqueezerRes recipe = null;

                    if (r instanceof SqueezerRecipe)
                        recipe = new SqueezerRes((SqueezerRecipe) r);


                    if (recipe == null)
                        continue;

                    arecipes.add(recipe);
                }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        for (Object r : RecipeHandler.getCraftingRecipes()) {
            SqueezerRes recipe = null;

            if (r instanceof SqueezerRecipe)
                recipe = new SqueezerRes((SqueezerRecipe) r);


            if (recipe == null || !recipe.contains(recipe.getIngredients(), ingredient.getItem()))
                continue;

            if (recipe.contains(recipe.getIngredients(), ingredient)) {
                recipe.setIngredientPermutation(recipe.getIngredients(), ingredient);
                arecipes.add(recipe);
            }
        }
    }


}
