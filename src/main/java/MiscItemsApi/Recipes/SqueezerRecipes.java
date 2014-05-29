package MiscItemsApi.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SqueezerRecipes
{
    private static final SqueezerRecipes instance = new SqueezerRecipes();
    private static HashMap<List<Item>, ItemStack> Recipes = new HashMap<List<Item>, ItemStack>();
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


        List<Item> list = new ArrayList<Item>();
        list.add(InputLeft.getItem());
        list.add(InputRight.getItem());
        Recipes.put(list, Output);
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

        List<Item> list = new ArrayList<Item>();
        list.add(InputLeft.getItem());
        list.add(InputRight.getItem());

        ItemStack result = Recipes.get(list);
        return result;

    }

}