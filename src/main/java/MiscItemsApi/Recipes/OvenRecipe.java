package MiscItemsApi.Recipes;

import net.minecraft.item.ItemStack;

public class OvenRecipe {


    public ItemStack Input, Output;

    public OvenRecipe(ItemStack Input, ItemStack Output){
        this.Input = Input;
        this.Output = Output;
    }
}
