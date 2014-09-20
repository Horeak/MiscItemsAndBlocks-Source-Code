package com.miscitems.MiscItemsAndBlocks.Book;

import MiscUtils.Utils.StackUtils;
import com.miscitems.MiscItemsAndBlocks.Book.Pages.Page;
import com.miscitems.MiscItemsAndBlocks.Book.Utils.UtilsStackPages;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookUtils {

    @SideOnly(Side.CLIENT)
    public static GuiItemRender renderitem = new GuiItemRender();


    //Dont change MaxTabs since it might cause buggynes when over 8
    public static final int MaxTabs = 8;
    public static int Tabs = 0;




    static ArrayList list = new ArrayList();






    public static HashMap<Integer, String> TabNames = new HashMap<Integer, String>();
    public static HashMap<Integer, ItemStack> TabIcons = new HashMap<Integer, ItemStack>();

    /**
     * 1 = text
     * 2 = item list
     */
    public static HashMap<Integer, Integer> TabType = new HashMap<Integer, Integer>();

    private static HashMap<Integer, ItemStack[]> TabItems = new HashMap<Integer, ItemStack[]>();
    public static HashMap<Integer, String> TextTabString = new HashMap<Integer, String>();



    public static ItemStack[] GetTabItems(int i){

        return TabItems.get(i);
    }

    public static int RecipeChangeTime = 100;

    public static List<IRecipe> GetShapedRecipeItems(ItemStack stack){
        List<IRecipe> list = new ArrayList<IRecipe>();

        for(Object r : CraftingManager.getInstance().getRecipeList()){
            if(r instanceof ShapedRecipes){
                ShapedRecipes res = (ShapedRecipes)r;

                if(StackUtils.AreStacksEqual(stack, res.getRecipeOutput())){
                    list.add(res);
                }

            }
        }

        if(list.size() <= 0){
            for(Object r : CraftingManager.getInstance().getRecipeList()){
                if(r instanceof ShapedOreRecipe){
                    ShapedOreRecipe res = (ShapedOreRecipe)r;

                    if(StackUtils.AreStacksEqual(stack, res.getRecipeOutput())){
                        list.add(res);
                    }

                }
            }
        }


        return list;
    }

    public static List<IRecipe> GetShapelessRecipeItems(ItemStack stack){
        List<IRecipe> list = new ArrayList<IRecipe>();

        for(Object r : CraftingManager.getInstance().getRecipeList()){
            if(r instanceof ShapelessRecipes){
                ShapelessRecipes res = (ShapelessRecipes)r;

                if(StackUtils.AreStacksEqual(stack, res.getRecipeOutput())){
                    list.add(res);
                }

            }
        }


        if(list.size() <= 0){
            for(Object r : CraftingManager.getInstance().getRecipeList()){
                if(r instanceof ShapelessOreRecipe){
                    ShapelessOreRecipe res = (ShapelessOreRecipe)r;

                    if(StackUtils.AreStacksEqual(stack, res.getRecipeOutput())){
                        list.add(res);
                    }

                }
            }
        }

        return list;
    }

    public static List<HashMap<ItemStack, ItemStack>> GetSmeltingRecipeItems(ItemStack stack){
        List<HashMap<ItemStack, ItemStack>> stacks = new ArrayList<HashMap<ItemStack, ItemStack>>();
        HashMap<ItemStack, ItemStack> Hash = new HashMap<ItemStack, ItemStack>();
        Hash.put(stack, FurnaceRecipes.smelting().getSmeltingResult(stack));

        stacks.add(Hash);

        return stacks;
    }





    public static void RegisterPagesForItem(ItemStack item, Page[] Pages) {
        list.add(new UtilsStackPages(item, Pages));
    }

    public static Page[] GetInfoPagesForItem(ItemStack stack){

        for(Object r : list){
            if(r instanceof UtilsStackPages){
                UtilsStackPages pg = (UtilsStackPages)r;

                if(StackUtils.AreStacksEqual(stack, pg.item)){
                    return pg.pages;
                }

            }

        }

        return null;
    }

    public static void RegisterTab(int Number, String Name, ItemStack stack, int Type){
        if(TabNames.size() < MaxTabs){
             TabNames.put(Number, Name);

            ItemStack stan = StackUtils.GetObject(Blocks.bedrock);

            if(stack!= null && stack.getItem() != null){

                if(stack.getItem() instanceof ItemBlock){
                    Block bl = (Block)Block.getBlockFromItem((ItemBlock)stack.getItem());

                    if(Main.config.IsBlockEnabled(bl))
                        stan = stack;

                }else{

                    if(Main.config.IsItemEnabled(stack.getItem()))
                        stan = stack;
                }

            }

             TabIcons.put(Number, stan);


            TabType.put(Number, Type);
            Tabs++;
        }

    }


    public static void RegisterItemsForTab(int Number, ItemStack[] stacks){
        if(!TabNames.get(Number).isEmpty()){
            ArrayList<ItemStack> list = new ArrayList<ItemStack>();

            for(ItemStack sta : stacks){
                if(sta!= null && sta.getItem() != null){

                    if(sta.getItem() instanceof ItemBlock){
                        Block bl = (Block)Block.getBlockFromItem((ItemBlock)sta.getItem());

                        if(Main.config.IsBlockEnabled(bl))
                            list.add(sta);

                    }else{

                        if(Main.config.IsItemEnabled(sta.getItem()))
                            list.add(sta);
                    }

                }
            }

            ItemStack[] stak = new ItemStack[list.size()];
            for(int i = 0; i < stak.length; i++)
                stak[i] = list.get(i);

            TabItems.put(Number, stak);
        }
    }


    public static void RegisterTextForTab(int Number, String text){
        if(TabType.get(Number) == 1){
            TextTabString.put(Number, text);
        }
    }


    public static String GetTextForTab(int Number){
        return TextTabString.get(Number);
    }

    public static String GetTabName(int Number){
        return TabNames.get(Number);
    }


    public static ItemStack GetTabIconItem(int Number){
        return TabIcons.get(Number);
    }

    public static int GetTabType(int Number){
        return TabType.get(Number);
    }


}
