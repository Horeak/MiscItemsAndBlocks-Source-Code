package MiscItemsApi.Recipes;

import MiscItemsApi.Utils.DoubleStackUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SqueezerRecipes
{
    private static final SqueezerRecipes instance = new SqueezerRecipes();
    private static HashMap<DoubleStackUtil, ItemStack> Recipes = new HashMap<DoubleStackUtil, ItemStack>();
    public static final SqueezerRecipes instance()
    {
        return instance;
    }

  
/**
* Registers a recipes for the squeezer
*
* @param InputLeft left item input
* @param InputRight right item input
* @param Output the recipes output
*/
    public void AddRecipe(ItemStack InputLeft, ItemStack InputRight, ItemStack Output)
    {

        Recipes.put(new DoubleStackUtil(new ItemStack(InputLeft.getItem(), 1, InputLeft.getItemDamage()), new ItemStack(InputRight.getItem(), 1, InputRight.getItemDamage())), Output);
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

        ItemStack result = Recipes.get(new DoubleStackUtil(new ItemStack(InputLeft.getItem(), 1, InputLeft.getItemDamage()), new ItemStack(InputRight.getItem(), 1, InputRight.getItemDamage())));
        return result;

    }

}