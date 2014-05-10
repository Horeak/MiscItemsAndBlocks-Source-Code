package com.miscitems.MiscItemsAndBlocks.Book;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.HashMap;

public class BookUtils {

    public static GuiItemRender renderitem = new GuiItemRender();


    //Dont change MaxTabs since it might cause buggynes when over 8
    public static final int MaxTabs = 8;
    public static int Tabs = 0;


    public static HashMap<Integer, String> TabNames = new HashMap<Integer, String>();
    public static HashMap<Integer, ItemStack> TabIcons = new HashMap<Integer, ItemStack>();

    /**
     * 1 = text
     * 2 = item list
     */
    public static HashMap<Integer, Integer> TabType = new HashMap<Integer, Integer>();

    public static HashMap<Integer, ItemStack[]> TabItems = new HashMap<Integer, ItemStack[]>();
    public static HashMap<Integer, String> TextTabString = new HashMap<Integer, String>();

    public static HashMap<String, Integer> InfoPageType = new HashMap<String, Integer>();
    public static HashMap<String, String> InfoPageText = new HashMap<String, String>();
    public static HashMap<String, String> InfoPageRecipeName = new HashMap<String, String>();
    public static HashMap<String, String[]> InfoPageItemPages = new HashMap<String, String[]>();

    public static HashMap<String, ShapedRecipes> InfoPageShapedRecipes = new HashMap<String, ShapedRecipes>();
    public static HashMap<String, ShapelessRecipes> InfoPageShapelessRecipes = new HashMap<String, ShapelessRecipes>();

    public static HashMap<String, String> ItemRecipeStorage = new HashMap<String, String>();



    //Type 1 = text, Type 2 = crafting 2x2, Type 3 = crafting 3x3, Type 4 = smelting

    public static void RegisterInfoPage(String PageName, int Type){
        InfoPageType.put(PageName, Type);
    }

    public static void RegisterInfoPageRecipes(String PageName, String RecipeName){
        InfoPageRecipeName.put(PageName, RecipeName);
    }

    public static void RegisterTextForInfoPage(String NameForPage, String Text){
        InfoPageText.put(NameForPage, Text);
    }

    public static void RegisterRecipeForInfoPage(String PageName, ItemStack stack){
        ItemRecipeStorage.put(PageName, stack.getUnlocalizedName().replace(".name", ""));
    }


    public static void RegisterPagesForItem(ItemStack item, String[] Pages){
        InfoPageItemPages.put(item.getUnlocalizedName(), Pages);
    }

    public static String[] GetInfoPagesForItem(ItemStack stack){
        return InfoPageItemPages.get(stack.getUnlocalizedName());
    }

    public static void RegisterTab(int Number, String Name, ItemStack stack, int Type){
        if(TabNames.size() < MaxTabs){
             TabNames.put(Number, Name);
             TabIcons.put(Number, stack);
            TabType.put(Number, Type);
            Tabs++;
        }

    }


    public static void RegisterItemsForTab(int Number, ItemStack[] stacks){
        if(!TabNames.get(Number).isEmpty()){
            TabItems.put(Number, stacks);
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
