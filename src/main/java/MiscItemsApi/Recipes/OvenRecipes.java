package MiscItemsApi.Recipes;

import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OvenRecipes {


    private static final OvenRecipes instance = new OvenRecipes();

    private HashMap<List<Integer>, ItemStack> Recipes = new HashMap<List<Integer>, ItemStack>();
    public static final OvenRecipes instance()
    {
        return instance;
    }


    /**
     * Registers a recipes for the Oven (used when registering items that do not extend ItemFood)
     *
     * @param Input input item number 1
     * @param Output input item number 2
     * @param Output the recipes output
     */
    public void AddRecipe(ItemStack Input, ItemStack Output)
    {

        Recipes.put(Arrays.asList(Input.getItem().getIdFromItem(Input.getItem()), Input.getItemDamage()), Output);


    }


    /**
     * Gets the result for a recipe in the Oven
     *
     * @param item input item number 1
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
