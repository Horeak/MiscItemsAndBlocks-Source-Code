package com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;

public class SqueezerRecipes
{
    private static final SqueezerRecipes instance = new SqueezerRecipes();

    private HashMap<ItemStack, ItemStack> Recipes = new HashMap<ItemStack, ItemStack>();
    public static final SqueezerRecipes instance()
    {
        return instance;
    }

  
    /**
     * Registers a recipes for the squeezer (the main item will always be a glass bottle)
     * 
     * @param Input_1 input item number 1
     * @param Input_2 input item number 2
     * @param Output the recipes output
     */
    public void AddRecipe(ItemStack Input, ItemStack Output)
    {
    	ItemStack stack = new ItemStack(Input.getItem(), 1, Input.getItemDamage());
    	stack.stackTagCompound = Input.stackTagCompound;

    	Recipes.put(stack, Output);
    	
    	
    }



    /**
     * Gets the result for a recipe in the squeezer
     * 
     * @param item_1 input item number 1
     * @param item_2 input item number 2
     * @return the result (null if nothing)
     */
    public ItemStack GetResult(ItemStack item_1, ItemStack item_2) 
    {

    	
    	if(item_1 == null || item_2 == null)
    	{
    		return null;
    	}
    	
    
    
    	ItemStack item = new ItemStack(item_2.getItem(), 1, item_2.getItemDamage());
    	item.stackTagCompound = item_2.stackTagCompound;
    	
    	if(item_1.getItem() instanceof ItemGlassBottle){

    		ItemStack result = Recipes.get(item);
    		
    		return result;
    		
    	}
    	
    	
    	
    
    	return null;
    }


  

}
