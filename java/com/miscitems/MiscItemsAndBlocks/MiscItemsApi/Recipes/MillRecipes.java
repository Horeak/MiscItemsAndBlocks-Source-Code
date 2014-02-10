package com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;

public class MillRecipes
{
    private static final MillRecipes instance = new MillRecipes();

    private HashMap<ItemStack, ItemStack> Recipes = new HashMap<ItemStack, ItemStack>();
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

    	ItemStack stack = new ItemStack(Input.getItem(), 1, Input.getItemDamage());
    	stack.stackTagCompound = Input.stackTagCompound;

    	Recipes.put(stack, Output);
    	
    	
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
    	
    
    
    	ItemStack item_ = new ItemStack(item.getItem(), 1, item.getItemDamage());
    	item.stackTagCompound = item.stackTagCompound;
    	

    		ItemStack result = Recipes.get(item_);
    		
    		if(result != null)
    		return result;
    		
    	
    	
    	
    	
    
    	return null;
    }


  

}
