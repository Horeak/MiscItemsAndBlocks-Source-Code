package MiscItemsApi.Recipes;

import net.minecraft.item.ItemStack;

public class MillRecipe
{

   public ItemStack Input, Output;

    public MillRecipe(ItemStack Input, ItemStack Output){
        this.Input = Input;
        this.Output = Output;
    }
}