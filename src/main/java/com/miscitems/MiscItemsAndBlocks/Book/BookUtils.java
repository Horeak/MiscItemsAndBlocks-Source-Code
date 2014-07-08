package com.miscitems.MiscItemsAndBlocks.Book;

import com.miscitems.MiscItemsAndBlocks.Book.Pages.Page;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.DoubleStackUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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

    public static HashMap<String, Page[]> InfoPages = new HashMap<String, Page[]>();

    public static HashMap<String, ShapedRecipes> InfoPageShapedRecipes = new HashMap<String, ShapedRecipes>();
    public static HashMap<String, ShapelessRecipes> InfoPageShapelessRecipes = new HashMap<String, ShapelessRecipes>();
    public static HashMap<String, DoubleStackUtil> InfoPageFurnaceRecipes = new HashMap<String, DoubleStackUtil>();







    public static void RegisterPagesForItem(ItemStack item, Page[] Pages) {
        if (item != null)
            if (item.getItem() instanceof ItemBlock) {
                if (ConfigUtils.IsBlockEnabled(Block.getBlockById(Item.getIdFromItem(item.getItem()))))
                    InfoPages.put(item.getItem().getUnlocalizedName(item), Pages);

            } else if (item.getItem() instanceof Item) {
                if (ConfigUtils.IsItemEnabled(item.getItem()))
                    InfoPages.put(item.getItem().getUnlocalizedName(item), Pages);
            }
    }

    public static Page[] GetInfoPagesForItem(ItemStack stack){
        return InfoPages.get(stack.getItem().getUnlocalizedName(stack));
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
