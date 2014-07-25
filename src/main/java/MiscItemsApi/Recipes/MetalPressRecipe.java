package MiscItemsApi.Recipes;

import net.minecraft.item.ItemStack;

public class MetalPressRecipe {


    public ItemStack[] Items;
    public ItemStack Item;
    public int Mode;

    public MetalPressRecipe(ItemStack[] stacks, ItemStack stack, int Mode){
        this.Item = stack;
        this.Items = stacks;
        this.Mode = Mode;
    }


}
