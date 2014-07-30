package com.miscitems.MiscItemsAndBlocks.Book;

import com.miscitems.MiscItemsAndBlocks.Book.Pages.Page;
import com.miscitems.MiscItemsAndBlocks.Book.Utils.UtilsStackPages;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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

    public static GuiItemRender renderitem = new GuiItemRender();


    //Dont change MaxTabs since it might cause buggynes when over 8
    public static final int MaxTabs = 8;
    public static int Tabs = 0;




    static ArrayList list = new ArrayList();



    public static ItemStack GetObject(Object ob){

        if(ob instanceof Block)
            return new ItemStack((Block)ob);

        if(ob instanceof Item)
            return new ItemStack((Item)ob);

        if(ob instanceof ItemStack)
            return (ItemStack)ob;

        return null;
    }


    public static ItemStack[] GetMultiObject(Object... ob){
        if(ob instanceof Block[]) {
            Block[] bl = (Block[])ob;
            ItemStack[] stacks = new ItemStack[bl.length];

            for(int i  = 0; i < stacks.length; i++){
                stacks[i] = new ItemStack(bl[i]);
            }

            return stacks;
        }

        if(ob instanceof Item[]) {
            Item[] bl = (Item[])ob;
            ItemStack[] stacks = new ItemStack[bl.length];

            for(int i  = 0; i < stacks.length; i++){
                stacks[i] = new ItemStack(bl[i]);
            }

            return stacks;
        }



        if(ob instanceof ItemStack[])
            return (ItemStack[])ob;

        if(ob instanceof Object[]){
            Object[] obj = (Object[])ob;
            ItemStack[] stacks = new ItemStack[obj.length];

            for(int i = 0; i < stacks.length; i++){
                stacks[i] = (ItemStack)GetObject(obj[i]);
            }

            return stacks;

        }


        return null;
    }

    private static boolean AreStacksEqual(ItemStack stack1, ItemStack stack2){
        return stack1 == null && stack2 == null ||
                stack1 != null && stack2 == null ? false :
                stack1 == null && stack2 != null ? false :

                        stack1.getItem() == stack2.getItem() && stack1.getItemDamage() == stack2.getItemDamage();

    }



    public static HashMap<Integer, String> TabNames = new HashMap<Integer, String>();
    public static HashMap<Integer, ItemStack> TabIcons = new HashMap<Integer, ItemStack>();

    /**
     * 1 = text
     * 2 = item list
     */
    public static HashMap<Integer, Integer> TabType = new HashMap<Integer, Integer>();

    public static HashMap<Integer, ItemStack[]> TabItems = new HashMap<Integer, ItemStack[]>();
    public static HashMap<Integer, String> TextTabString = new HashMap<Integer, String>();




    public static int RecipeChangeTime = 100;

    public static List<IRecipe> GetShapedRecipeItems(ItemStack stack){
        List<IRecipe> list = new ArrayList<IRecipe>();

        for(Object r : CraftingManager.getInstance().getRecipeList()){
            if(r instanceof ShapedRecipes){
                ShapedRecipes res = (ShapedRecipes)r;

                if(AreStacksEqual(stack, res.getRecipeOutput())){
                    list.add(res);
                }

            }else if(r instanceof ShapedOreRecipe){
                ShapedOreRecipe res = (ShapedOreRecipe)r;

                if(AreStacksEqual(stack, res.getRecipeOutput())){
                    list.add(res);
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

                if(AreStacksEqual(stack, res.getRecipeOutput())){
                    list.add(res);
                }

            }else if(r instanceof ShapelessOreRecipe){

                ShapelessOreRecipe res = (ShapelessOreRecipe)r;

                if(AreStacksEqual(stack, res.getRecipeOutput())){
                    list.add(res);
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

                if(AreStacksEqual(stack, pg.item)){
                    return pg.pages;
                }

            }

        }

        return null;
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
