package MiscItemsApi.Access;

import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class InDirectAccess {


    public static HashMap<String, ItemStack> Items = new HashMap<String, ItemStack>();
    public static HashMap<String, ItemStack> Blocks = new HashMap<String, ItemStack>();


    public static ItemStack GetItem(String Name){
        return Items.get(Name.toLowerCase());
    }

    public static ItemStack GetBlock(String Name){
        return Blocks.get(Name.toLowerCase());
    }
}
