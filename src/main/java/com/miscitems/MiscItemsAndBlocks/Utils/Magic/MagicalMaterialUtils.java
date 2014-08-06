package com.miscitems.MiscItemsAndBlocks.Utils.Magic;

import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.Utils.StackUtils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

public class MagicalMaterialUtils {



    public static ArrayList list = new ArrayList();


    public static void RegisterManualValues(){

        RegisterManualValue(Items.iron_ingot, 100);

    }


    public static void RegisterAutomaticValues(){


       RegisterAutomaticValue(new ItemStack(ModItems.IronPlate));

    }


    public static boolean ContainesStack(ItemStack stack){
        return GetValue(stack) != null;
    }

    public static void RegisterManualValue(Object r, double value){
        RegisterValue(StackUtils.GetObject(r), value);
    }

    public static void RegisterAutomaticValue(ItemStack stack){
        double val = 0;

        ArrayList<ItemStack> RecipeItems = GetResItems(stack);

        for(ItemStack sta : RecipeItems){
            if(ContainesStack(sta)){
                MaterialValue valu = GetValue(sta);
                if(valu != null)
                    val += valu.value;

            }
        }

        RegisterValue(stack, val);

    }

    public static boolean HasRecipe(ItemStack stack){
        ArrayList<ItemStack> rs = GetRecipeItems(stack);
        return rs != null && rs.size() > 0;
    }

    public static ArrayList<ItemStack> GetResItems(Object stack){
        return GetTotalRecipeItems(GetRecipeItems(stack));
    }

    public static ArrayList<ItemStack> GetTotalRecipeItems(ArrayList<ItemStack> stacks){
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();

                ArrayList<ItemStack> Total = stacks;
                ArrayList<ItemStack> e = new ArrayList<ItemStack>();


        int x = 0;


            Start:
            for (ItemStack s : Total) {
                x += 1;

                ItemStack st = s.copy();

                if(!st.getHasSubtypes())
                    st.setItemDamage(0);

                if(!HasRecipe(st)) {
                    e.add(st);
                    continue;
                }


                if(!ContainesStack(st)) {
                    ArrayList<ItemStack> RecipeItems = GetRecipeItems(st);
                    for (ItemStack sta : RecipeItems) {
                        if (sta != null && !StackUtils.AreStacksEqual(sta, st))
                            e.add(sta);
                    }
                }else{
                    e.add(st);
                }


                    if (x >= Total.size()) {
                        Total = e;
                        break Start;
                    }


            }



        for(ItemStack sta : e) {
            if(sta != null)
            list.add(sta);
        }

        return list;
    }

    public static void RegisterValue(ItemStack stack, double value) {
        if (!ContainesStack(stack)) {

            MaterialValue val = new MaterialValue(stack, value);

            list.add(val);

        }
    }

    public static MaterialValue GetValue(ItemStack stack){
        for(Object r : list){
            if(r instanceof MaterialValue){
                ItemStack sta = stack.copy();
                sta.stackSize = 1;

                MaterialValue mat = (MaterialValue)r;
                if(StackUtils.AreStacksEqual(mat.stack, sta)){
                    return mat;


                }

            }

        }

        return null;
    }

    public static ArrayList<ItemStack> GetRecipeItems(Object r)
    {

        return GetRecipeItems(StackUtils.GetObject(r));
    }

    public static ArrayList<ItemStack> GetRecipeItems(ItemStack st)
    {
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();

        if(st != null){
        ItemStack stack = st.copy();

        if(!stack.getHasSubtypes())
            stack.setItemDamage(0);


        for(Object r : CraftingManager.getInstance().getRecipeList()) {
            if (r instanceof IRecipe) {
                IRecipe rep = (IRecipe) r;

                if (StackUtils.AreStacksEqual(rep.getRecipeOutput(), st)) {

                    if (rep instanceof ShapedRecipes) {
                        ShapedRecipes res = (ShapedRecipes) rep;
                        if (StackUtils.AreStacksEqual(res.getRecipeOutput(), stack)) {
                            for (ItemStack sta : res.recipeItems)
                                list.add(sta);


                        }
                    } else if (rep instanceof ShapelessRecipes) {
                        ShapelessRecipes res = (ShapelessRecipes) rep;
                        if (StackUtils.AreStacksEqual(res.getRecipeOutput(), stack)) {
                            for (Object h : res.recipeItems) {
                                list.add(StackUtils.GetObject(h));
                            }
                        }

                    } else if (rep instanceof ShapedOreRecipe) {
                        ShapedOreRecipe res = (ShapedOreRecipe) rep;
                        if (StackUtils.AreStacksEqual(res.getRecipeOutput(), stack)) {
                            for (Object h : res.getInput()) {
                                list.add(StackUtils.GetObject(h));
                            }
                        }
                    } else if (rep instanceof ShapelessOreRecipe) {
                        ShapelessOreRecipe res = (ShapelessOreRecipe) rep;
                        if (StackUtils.AreStacksEqual(res.getRecipeOutput(), stack)) {
                            for (Object h : res.getInput()) {
                                list.add(StackUtils.GetObject(h));
                            }
                        }
                    }

                }
            }

        }
        }

        for(ItemStack stack : list){
            if(stack.getItemDamage() > 0)
            if(!stack.getHasSubtypes())
                stack.setItemDamage(0);

        }


        return list;
    }



}
