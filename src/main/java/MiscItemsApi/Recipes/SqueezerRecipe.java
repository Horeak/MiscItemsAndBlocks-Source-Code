package MiscItemsApi.Recipes;

import net.minecraft.item.ItemStack;

public class SqueezerRecipe
{

    public ItemStack[] Items;
    public ItemStack Output;

    public SqueezerRecipe(ItemStack[] Items, ItemStack Output){
        this.Items = Items;
        this.Output = Output;
    }

}