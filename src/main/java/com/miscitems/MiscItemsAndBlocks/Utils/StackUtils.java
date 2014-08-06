package com.miscitems.MiscItemsAndBlocks.Utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class StackUtils
{


    public static ItemStack GetObject(Object ob){


        if(ob instanceof Block)
            return new ItemStack((Block)ob);

        if(ob instanceof Item)
            return new ItemStack((Item)ob);

        if(ob instanceof ItemStack)
            return (ItemStack)ob;


        if(ob instanceof List){
            if(((List)ob).get(0) instanceof ItemStack){
                return (ItemStack)((List)ob).get(0);
            }
        }


        return null;
    }


    public static ItemStack[] GetMultiObject(Object... ob){

        ItemStack[] stacks = new ItemStack[ob.length];

        for(int i = 0; i < stacks.length; i++){
            stacks[i] = GetObject(ob);

        }

        return stacks;
    }

    public static boolean AreStacksEqual(ItemStack stack1, ItemStack stack2){
        return stack1 == null && stack2 == null ||
                stack1 != null && stack2 == null ? false :
                stack1 == null && stack2 != null ? false :

                        stack1.getItem() == stack2.getItem() && stack1.getItemDamage() == stack2.getItemDamage();

    }

}
