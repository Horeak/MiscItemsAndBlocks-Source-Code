package com.miscitems.MiscItemsAndBlocks.Main.Guide;

import MiscItemsApi.Recipes.RecipeHandler;
import MiscItemsApi.Recipes.SqueezerRecipe;
import MiscUtils.GuideBase.Gui.Utils.GuideItem;
import MiscUtils.GuideBase.Utils.GuideRecipeTypeRender;
import MiscUtils.Utils.StackUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class SquezerGuideRecipeType extends GuideRecipeTypeRender {
    @Override
    public String GetName() {
        return "gui.squeezer";
    }

    @Override
    public int GetRenderXSize() {
        return 58;
    }

    @Override
    public int GetRenderYSize() {
        return 72;
    }

    @Override
    public int GetRenderPositionX() {
        return 59;
    }

    @Override
    public int GetRenderPositionY() {
        return 8;
    }

    @Override
    public ResourceLocation GetRenderTexture() {
        return new ResourceLocation("miscitems" , "textures/gui/SquezerGui.png");
    }

    @Override
    public ItemStack[] GetRequiredItemsFor(ItemStack stack, int At) {
        ItemStack[] stacks = new ItemStack[2];


        int h = 0;
        for(Object r : RecipeHandler.getCraftingRecipes()) {
            if (r instanceof SqueezerRecipe) {
                SqueezerRecipe res = (SqueezerRecipe)r;
                if (StackUtils.AreStacksEqualIgnoreData(stack, res.Output)) {

                    if (h == At) {

                        stacks[0] = res.Items[0];
                        stacks[1] = res.Items[1];
                    }


                    h += 1;
                }
            }
        }



        return stacks;
    }

    @Override
    public boolean ContainsRecipeFor(ItemStack stack) {
        return GetRecipesAmountFor(stack) > 0;
    }

    @Override
    public int GetRecipesAmountFor(ItemStack stack) {
        int num = 0;

        for(Object r : RecipeHandler.getCraftingRecipes()) {
            if (r instanceof SqueezerRecipe) {
                SqueezerRecipe res = (SqueezerRecipe) r;
                if (StackUtils.AreStacksEqualIgnoreData(stack, res.Output)) {
                    num += 1;
                }
            }
        }

        return num;
    }

    @Override
    public ArrayList<GuideItem> AddItemsFor(int PosX, int PosY, ArrayList<GuideItem> ListToAddTo, ItemStack stack, int At) {
        ItemStack render = stack.copy();


        ListToAddTo.add(new GuideItem(0, PosX + 3, PosY + 3, GetRequiredItemsFor(stack, At)[0]));
        ListToAddTo.add(new GuideItem(0, PosX + 39, PosY + 3, GetRequiredItemsFor(stack, At)[1]));

        int h = 0;
        for(Object r : RecipeHandler.getCraftingRecipes()) {
            if (r instanceof SqueezerRecipe) {
                SqueezerRecipe res = (SqueezerRecipe)r;
                if (StackUtils.AreStacksEqualIgnoreData(render, res.Output)) {

                    if (h == At) {
                        render.stackSize = res.Output.stackSize;
                        render.setItemDamage(res.Output.getItemDamage());
                    }


                    h += 1;
                }
            }
        }



        ListToAddTo.add(new GuideItem(0, PosX + 20, PosY + 48, render));


        return ListToAddTo;
    }

    double burn = 0, BurnMax = 25;

    public void RenderExtras(GuiScreen gui, int posX, int posY, ItemStack stack, int at){

        if(burn >= BurnMax)
            burn = 0;

        else
            burn += 0.02;

        gui.drawTexturedModalRect(posX + 57, posY + 50, 176, 3, 43, (int)burn);



    }
}
