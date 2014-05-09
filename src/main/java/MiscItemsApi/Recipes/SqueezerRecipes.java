package MiscItemsApi.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SqueezerRecipes
{
    private static final SqueezerRecipes instance = new SqueezerRecipes();
    private static HashMap<List<Integer>, ItemStack> Recipes = new HashMap<List<Integer>, ItemStack>();
    public static final SqueezerRecipes instance()
    {
        return instance;
    }

  
/**
* Registers a recipes for the squeezer (used when registering items that do not extend ItemFood)
*
* @param InputLeft left item input
* @param InputRight right item input
* @param Output the recipes output
*/
    public void AddRecipe(ItemStack InputLeft, ItemStack InputRight, ItemStack Output)
    {

        Recipes.put(Arrays.asList(Item.getIdFromItem(InputLeft.getItem()), InputLeft.getItemDamage(), Item.getIdFromItem(InputRight.getItem()), InputRight.getItemDamage()), Output);
    }



/**
* Gets the result for a recipe in the squeezer
*
*
* @param InputLeft left item input
* @param InputRight right item input
* @return the result (null if nothing)
*/
    public ItemStack GetResult(ItemStack InputLeft, ItemStack InputRight)
    {

    
     if(InputLeft == null || InputRight == null)
     return null;

        ItemStack result = Recipes.get(Arrays.asList(Item.getIdFromItem(InputLeft.getItem()), InputLeft.getItemDamage(), Item.getIdFromItem(InputRight.getItem()), InputRight.getItemDamage()));
        return result;

    }

}