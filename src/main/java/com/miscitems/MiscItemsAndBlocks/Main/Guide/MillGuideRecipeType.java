package com.miscitems.MiscItemsAndBlocks.Main.Guide;

import MiscItemsApi.Recipes.MillRecipe;
import MiscItemsApi.Recipes.RecipeHandler;
import MiscUtils.GuideBase.Gui.Utils.GuideItem;
import MiscUtils.GuideBase.Utils.GuideRecipeTypeRender;
import MiscUtils.Utils.StackUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class MillGuideRecipeType extends GuideRecipeTypeRender {
    @Override
    public String GetName() {
        return "gui.mill";
    }

    @Override
    public int GetRenderXSize() {
        return 46;
    }

    @Override
    public int GetRenderYSize() {
        return 70;
    }

    @Override
    public int GetRenderPositionX() {
        return 64;
    }

    @Override
    public int GetRenderPositionY() {
        return 8;
    }

    @Override
    public ResourceLocation GetRenderTexture() {
        return new ResourceLocation("miscitems" , "textures/gui/MillGui.png");
    }

    @Override
    public ItemStack[] GetRequiredItemsFor(ItemStack stack, int At) {
        ItemStack[] stacks = new ItemStack[1];


        int h = 0;
        for(Object r : RecipeHandler.getCraftingRecipes()) {
            if (r instanceof MillRecipe) {
                MillRecipe res = (MillRecipe)r;
                if (StackUtils.AreStacksEqualIgnoreData(stack, res.Output)) {

                    if (h == At) {

                        stacks[0] = res.Input;
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
            if (r instanceof MillRecipe) {
                MillRecipe res = (MillRecipe) r;
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


        ListToAddTo.add(new GuideItem(0, PosX + 15, PosY + 5, GetRequiredItemsFor(stack, At)[0]));

        int h = 0;
        for(Object r : RecipeHandler.getCraftingRecipes()) {
            if (r instanceof MillRecipe) {
                MillRecipe res = (MillRecipe)r;
                if (StackUtils.AreStacksEqualIgnoreData(render, res.Output)) {

                    if (h == At) {
                        render.stackSize = res.Output.stackSize;
                        render.setItemDamage(res.Output.getItemDamage());
                    }


                    h += 1;
                }
            }
        }



        ListToAddTo.add(new GuideItem(0, PosX + 15, PosY + 48, render));


        return ListToAddTo;
    }

    double burn = 0, BurnMax = 15;

    public void RenderExtras(GuiScreen gui, int posX, int posY, ItemStack stack, int at){

        if(burn >= BurnMax)
            burn = 0;

        else
            burn += 0.02;

        gui.drawTexturedModalRect(posX + 67, posY + 56, 176, 3, 11, (int)burn);



    }
}
