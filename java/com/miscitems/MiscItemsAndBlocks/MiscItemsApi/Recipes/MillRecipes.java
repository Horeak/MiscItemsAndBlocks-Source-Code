package com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;

public class MillRecipes
{
    private static final MillRecipes instance = new MillRecipes();

    private HashMap<List<Integer>, ItemStack> Recipes = new HashMap<List<Integer>, ItemStack>();
    public static final MillRecipes instance()
    {
        return instance;
    }

  
    /**
* Registers a recipes for the mill
*
* @param Input_1 input item number 1
* @param Input_2 input item number 2
* @param Output the recipes output
*/
    public void AddRecipe(ItemStack Input, ItemStack Output)
    {

     Recipes.put(Arrays.asList(Input.getItem().getIdFromItem(Input.getItem()), Input.getItemDamage()), Output);
    
    
    }



    /**
* Gets the result for a recipe in the mill
*
* @param item_1 input item number 1
* @param item_2 input item number 2
* @return the result (null if nothing)
*/
    public ItemStack GetResult(ItemStack item)
    {

    
     if(item == null)
     {
     return null;
     }
    
    
    
     ItemStack result = (ItemStack)Recipes.get(Arrays.asList(item.getItem().getIdFromItem(item.getItem()), item.getItemDamage()));
    
     if(result != null)
     return result;
    
    
    
    
    
    
     return null;
    }


  

}