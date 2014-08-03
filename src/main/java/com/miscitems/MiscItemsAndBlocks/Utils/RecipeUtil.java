package com.miscitems.MiscItemsAndBlocks.Utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

public class RecipeUtil {



    private static ItemStack GetObject(Object ob){

        if(ob instanceof Block)
            return new ItemStack((Block)ob);

        if(ob instanceof Item)
            return new ItemStack((Item)ob);

        if(ob instanceof ItemStack)
            return (ItemStack)ob;

        return null;
    }


    private static ItemStack[] GetMultiObject(Object... ob){
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


    public static ArrayList<ItemStack> GetTotalRecipeItems(ItemStack stack){
        return GetTotalItemListFromRecipe(GetRecipeItems(stack));
    }

    public static ArrayList<ItemStack> GetTotalItemListFromRecipe(ArrayList<ItemStack> stacks){
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();

        for(ItemStack stack : stacks){
            ArrayList<ItemStack> e = new ArrayList<ItemStack>();

            for(ItemStack st : GetRecipeItems(stack)){

                if(GetRecipeItems(stack).size() > 0)
                e.add(st);
            }

            for(int i = 0; i < e.size(); i++){
                list.add(e.get(i));
            }

            list.add(stack);

        }



        return list;
    }

    public static ArrayList<ItemStack> GetRecipeItems(ItemStack recipe){
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();


        for(Object r : CraftingManager.getInstance().getRecipeList()) {
            if (r instanceof IRecipe) {
                IRecipe res = (IRecipe)r;
                if (AreStacksEqual(res.getRecipeOutput(), recipe)) {


                    if(res instanceof ShapedRecipes){
                        ShapedRecipes rep = (ShapedRecipes)res;
                        for(int i = 0; i < rep.recipeItems.length; i++){
                            list.add(GetObject(rep.recipeItems[i]));

                        }



                    }else if (res instanceof ShapelessRecipes){
                        ShapelessRecipes rep = (ShapelessRecipes)res;
                        for(int i = 0; i < rep.recipeItems.size(); i++){
                            list.add(GetObject(rep.recipeItems.get(i)));

                        }

                    }else if(res instanceof ShapedOreRecipe){
                        ShapedOreRecipe rep = (ShapedOreRecipe)res;
                        for(int i = 0; i < rep.getInput().length; i++){
                            list.add(GetObject(rep.getInput()[i]));

                        }


                    }else if(res instanceof ShapelessOreRecipe){
                        ShapelessOreRecipe rep = (ShapelessOreRecipe)res;
                        for(int i = 0; i < rep.getInput().size(); i++){
                            list.add(GetObject(rep.getInput().get(i)));

                        }


                    }


                }
            }
        }


        return list;
    }
}
