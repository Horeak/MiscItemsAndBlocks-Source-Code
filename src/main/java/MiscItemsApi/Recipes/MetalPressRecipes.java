package MiscItemsApi.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MetalPressRecipes {

    private static final MetalPressRecipes instance = new MetalPressRecipes();
    private static HashMap<List<Integer>, ItemStack> Recipes_Mode_1 = new HashMap<List<Integer>, ItemStack>();
    private static HashMap<List<Integer>, ItemStack> Recipes_Mode_4 = new HashMap<List<Integer>, ItemStack>();
    public static final MetalPressRecipes instance()
    {
        return instance;
    }


    /**
     * Registers a recipes for the MetalPressRecipes (This is the mode 1x1)
     *
     * @param Input the recipes Input
     * @param Output the recipes output
     */
    public void AddRecipeMode_1(ItemStack Input, ItemStack Output)
    {

        Recipes_Mode_1.put(Arrays.asList(Item.getIdFromItem(Input.getItem()), Input.getItemDamage()), Output);
    }



    /**
     * Registers a recipes for the MetalPressRecipes (This is the mode 4x4)
     *
     * @param InputTopLeft the recipes Input
     * @param InputTopRight the recipes Input
     * @param InputBottomLeft the recipes Input
     * @param InputBottomRight the recipes Input
     * @param Output the recipes output
     */
    public void AddRecipeMode_4(ItemStack InputTopLeft, ItemStack InputTopRight, ItemStack InputBottomLeft, ItemStack InputBottomRight, ItemStack Output)
    {

        Recipes_Mode_4.put(Arrays.asList(Item.getIdFromItem(InputTopLeft.getItem()), InputTopLeft.getItemDamage(),   Item.getIdFromItem(InputTopRight.getItem()), InputTopRight.getItemDamage(),    Item.getIdFromItem(InputBottomLeft.getItem()), InputBottomLeft.getItemDamage(),    Item.getIdFromItem(InputBottomRight.getItem()), InputBottomRight.getItemDamage()), Output);
    }





    /**
     * Gets the result for a recipe in the metal press
     * @param Input item input
     * @return the result (null if nothing)
     */
    public ItemStack GetResultMode_1(ItemStack Input)
    {

        if(Input == null)
            return null;


        ItemStack result = Recipes_Mode_1.get(Arrays.asList(Item.getIdFromItem(Input.getItem()), Input.getItemDamage()));
        return result;

    }


    /**
     * Gets the result for a recipe in the squeezer
     * @param InputTopLeft the recipes Input
     * @param InputTopRight the recipes Input
     * @param InputBottomLeft the recipes Input
     * @param InputBottomRight the recipes Input
     * @return the result (null if nothing)
     */
    public ItemStack GetResultMode_4(ItemStack InputTopLeft, ItemStack InputTopRight, ItemStack InputBottomLeft, ItemStack InputBottomRight)
    {

        if(InputTopLeft == null || InputTopRight == null || InputBottomLeft == null || InputBottomRight == null)
            return null;


        ItemStack result = Recipes_Mode_4.get(Arrays.asList(Item.getIdFromItem(InputTopLeft.getItem()), InputTopLeft.getItemDamage(),   Item.getIdFromItem(InputTopRight.getItem()), InputTopRight.getItemDamage(),    Item.getIdFromItem(InputBottomLeft.getItem()), InputBottomLeft.getItemDamage(),    Item.getIdFromItem(InputBottomRight.getItem()), InputBottomRight.getItemDamage()));
        return result;

    }

}
