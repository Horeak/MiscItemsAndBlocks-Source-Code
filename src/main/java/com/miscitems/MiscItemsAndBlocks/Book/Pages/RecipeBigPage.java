package com.miscitems.MiscItemsAndBlocks.Book.Pages;

import MiscUtils.Utils.StackUtils;
import com.miscitems.MiscItemsAndBlocks.Book.BookUtils;
import com.miscitems.MiscItemsAndBlocks.Book.InfoPage;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.List;

public class RecipeBigPage extends Page {


    ItemStack RecipeItem;
    List<IRecipe> Recipes;

    int CurrentRes = 0;

    int Switch = 0;

    ItemStack[] RecipeItems;


    int GridX = 60;
    int GridY = 65;


    int posX, posY;

    public ItemStack[] GetOreRecipe(Object[] ob){
        ItemStack[] stacks = new ItemStack[ob.length];

        for(int i = 0; i < stacks.length; i++){
            stacks[i] = StackUtils.GetObject(ob[i]);
        }

        return stacks;
    }


    public RecipeBigPage(ItemStack Output){
        Recipes = BookUtils.GetShapedRecipeItems(Output);

        if(Recipes.size() > 0)
               if (Recipes.get(0) instanceof ShapedRecipes) {
                RecipeItems = ((ShapedRecipes) (Recipes.get(0))).recipeItems;
                RecipeItem = ((Recipes.get(0))).getRecipeOutput();

            }else if(Recipes.get(0) instanceof ShapedOreRecipe){
                   RecipeItems = GetOreRecipe(((ShapedOreRecipe) (Recipes.get(0))).getInput());
                   RecipeItem = ((Recipes.get(0))).getRecipeOutput();
               }


    }

    @Override
    public void Render(RenderItem ItemRender, InfoPage Page, FontRenderer render, int posX, int posY, int Side, int MouseX, int MouseY) {
        render.drawString(EnumChatFormatting.UNDERLINE + StatCollector.translateToLocal("book.gui.recipe"), posX + 70, posY + 25, 0x949294, false);


        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureIcons);
        Page.drawTexturedModalRect(posX + GridX, posY + GridY, 0, 40, 106, 52);


        this.posX = posX;
        this.posY = posY;


        if(Recipes.size() > 0) {
            if (Recipes.size() > 1) {
                if (Switch >= BookUtils.RecipeChangeTime) {
                    Switch = 0;


                    if (CurrentRes < Recipes.size()-1)
                        CurrentRes += 1;

                    else
                        CurrentRes = 0;

                } else {
                    Switch += 1;
                }


                       if (Recipes.get(CurrentRes) instanceof ShapedRecipes){
                        RecipeItems = ((ShapedRecipes) (Recipes.get(CurrentRes))).recipeItems;
                        RecipeItem = ((Recipes.get(CurrentRes))).getRecipeOutput();

                }else if(Recipes.get(CurrentRes) instanceof ShapedOreRecipe){
                           RecipeItems = GetOreRecipe(((ShapedOreRecipe) (Recipes.get(CurrentRes))).getInput());
                           RecipeItem = ((Recipes.get(CurrentRes))).getRecipeOutput();
                       }
            }


            if(RecipeItems != null && RecipeItems.length > 0) {
                RenderItem(ItemRender, render, RecipeItems[0], posX + GridX, posY + GridY);


                if (OverSlot(posX + GridX, posY + GridY, MouseX, MouseY) && RecipeItems[0] != null)
                    Page.drawTooltip(GetToolTip(RecipeItems[0]), MouseX, MouseY);


                if (RecipeItems.length > 1) {
                    RenderItem(ItemRender, render, RecipeItems[1], posX + GridX + 18, posY + GridY);
                    if (OverSlot(posX + GridX + 18, posY + GridY, MouseX, MouseY) && RecipeItems[1] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[1]), MouseX, MouseY);
                }

                if (RecipeItems.length > 2) {
                    RenderItem(ItemRender, render, RecipeItems[2], posX + GridX + (2 * 18), posY + GridY);
                    if (OverSlot(posX + GridX + (2 * 18), posY + GridY, MouseX, MouseY) && RecipeItems[2] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[2]), MouseX, MouseY);
                }

                if (RecipeItems.length > 3) {
                    RenderItem(ItemRender, render, RecipeItems[3], posX + GridX, posY + GridY + 18);
                    if (OverSlot(posX + GridX, posY + GridY + 18, MouseX, MouseY) && RecipeItems[3] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[3]), MouseX, MouseY);
                }

                if (RecipeItems.length > 4) {
                    RenderItem(ItemRender, render, RecipeItems[4], posX + GridX + 18, posY + GridY + 18);
                    if (OverSlot(posX + GridX + 18, posY + GridY + 18, MouseX, MouseY) && RecipeItems[4] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[4]), MouseX, MouseY);
                }

                if (RecipeItems.length > 5) {
                    RenderItem(ItemRender, render, RecipeItems[5], posX + GridX + (2 * 18), posY + GridY + 18);
                    if (OverSlot(posX + GridX + (2 * 18), posY + GridY + 18, MouseX, MouseY) && RecipeItems[5] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[5]), MouseX, MouseY);
                }

                if (RecipeItems.length > 6) {
                    RenderItem(ItemRender, render, RecipeItems[6], posX + GridX, posY + GridY + (2 * 18));
                    if (OverSlot(posX + GridX, posY + GridY + (2 * 18), MouseX, MouseY) && RecipeItems[6] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[6]), MouseX, MouseY);
                }

                if (RecipeItems.length > 7) {
                    RenderItem(ItemRender, render, RecipeItems[7], posX + GridX + 18, posY + GridY + (2 * 18));
                    if (OverSlot(posX + GridX + 18, posY + GridY + (2 * 18), MouseX, MouseY) && RecipeItems[7] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[7]), MouseX, MouseY);
                }

                if (RecipeItems.length > 8) {
                    RenderItem(ItemRender, render, RecipeItems[8], posX + GridX + (2 * 18), posY + GridY + (2 * 18));
                    if (OverSlot(posX + GridX + (2 * 18), posY + GridY + (2 * 18), MouseX, MouseY) && RecipeItems[8] != null)
                        Page.drawTooltip(GetToolTip(RecipeItems[8]), MouseX, MouseY);
                }


                RenderItem(ItemRender, render, RecipeItem, posX + GridX + 88, posY + GridY + 18);


                if (OverSlot(posX + GridX + 88, posY + GridY + 18, MouseX, MouseY) && RecipeItem != null)
                    Page.drawTooltip((GetToolTipWithoutLink(RecipeItem)), MouseX, MouseY);

            }

        }
        else{


        net.minecraft.client.renderer.RenderHelper.disableStandardItemLighting();
        render.drawString(EnumChatFormatting.RED + StatCollector.translateToLocal("book.recipe.disabled"), posX + 50, posY + 85, new Color(255, 0, 0).getRGB());
        }



    }

    public void OnClick(InfoPage page, int ClickedX, int ClickedY){


        if(OverSlot(posX + GridX + 88, posY + GridY + 18, ClickedX, ClickedY) && RecipeItem != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItem) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItem, page.LastTab));
        }

        if(OverSlot(posX + GridX, posY + GridY, ClickedX, ClickedY) && RecipeItems[0] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[0]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[0], page.LastTab));
        }

        if(OverSlot(posX + GridX + 18, posY + GridY, ClickedX, ClickedY) && RecipeItems[1] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[1]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[1], page.LastTab));
        }

        if(OverSlot(posX + GridX + (2 * 18), posY + GridY, ClickedX, ClickedY) && RecipeItems[2] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[2]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[2], page.LastTab));
        }




        if(OverSlot(posX + GridX, posY + GridY + 18, ClickedX, ClickedY) && RecipeItems[3] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[3]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[3], page.LastTab));
        }

        if(OverSlot(posX + GridX + 18, posY + GridY + 18, ClickedX, ClickedY) && RecipeItems[4] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[4]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[4], page.LastTab));
        }

        if(OverSlot(posX + GridX + (2 * 18), posY + GridY + 18, ClickedX, ClickedY) && RecipeItems[5] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[5]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[5], page.LastTab));
        }






        if(OverSlot(posX + GridX, posY + GridY + (2 * 18), ClickedX, ClickedY) && RecipeItems[6] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[6]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[6], page.LastTab));
        }

        if(OverSlot(posX + GridX + 18, posY + GridY + (2 * 18), ClickedX, ClickedY) && RecipeItems[7] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[7]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[7], page.LastTab));
        }

        if(OverSlot(posX + GridX + (2 * 18), posY + GridY + (2 * 18), ClickedX, ClickedY) && RecipeItems[8] != null){
            if(BookUtils.GetInfoPagesForItem(RecipeItems[8]) != null)
                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new InfoPage(RecipeItems[8], page.LastTab));
        }


    }


    }
