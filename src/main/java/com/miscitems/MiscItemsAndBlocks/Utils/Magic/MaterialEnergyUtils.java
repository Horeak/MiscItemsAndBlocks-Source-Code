package com.miscitems.MiscItemsAndBlocks.Utils.Magic;

import com.miscitems.MiscItemsAndBlocks.Utils.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class MaterialEnergyUtils {


   private static ArrayList List = new ArrayList();
   private static ArrayList<ItemStack> Stacks = new ArrayList<ItemStack>();


    private static ItemStack GetObject(Object ob){

        if(ob instanceof Block)
            return new ItemStack((Block)ob);

        if(ob instanceof Item)
            return new ItemStack((Item)ob);

        if(ob instanceof ItemStack)
            return (ItemStack)ob;

        return null;
    }


    private static ItemStack[] GetMultiObject(Object... ob){
        if(ob instanceof Block[]) {
            Block[] bl = (Block[])ob;
            ItemStack[] stacks = new ItemStack[bl.length];

            for(int i  = 0; i < stacks.length; i++){
                stacks[i] = new ItemStack(bl[i]);
            }

            return stacks;
        }

        if(ob instanceof Item[]) {
            Item[] bl = (Item[])ob;
            ItemStack[] stacks = new ItemStack[bl.length];

            for(int i  = 0; i < stacks.length; i++){
                stacks[i] = new ItemStack(bl[i]);
            }

            return stacks;
        }



        if(ob instanceof ItemStack[])
            return (ItemStack[])ob;

        if(ob instanceof Object[]){
            Object[] obj = (Object[])ob;
            ItemStack[] stacks = new ItemStack[obj.length];

            for(int i = 0; i < stacks.length; i++){
                stacks[i] = (ItemStack)GetObject(obj[i]);
            }

            return stacks;

        }


        return null;
    }

    private static boolean AreStacksEqual(ItemStack stack1, ItemStack stack2){


        return stack1 == null && stack2 == null ||
                stack1 != null && stack2 == null ? false :
                stack1 == null && stack2 != null ? false :

                        stack1.getItem() == stack2.getItem() && stack1.getItemDamage() == stack2.getItemDamage();

    }


    private static boolean ContainsStack(ItemStack stack){
        for(ItemStack r : Stacks){
            if(AreStacksEqual(r, stack))
                return true;
        }

        return false;
    }

    private static void RegisterValue(ItemStack stack, double Value){

        if(stack != null) {
            System.out.println(stack.getItem() + " | " + Value);

            List.add(new MaterialValue(stack, Value));
            Stacks.add(stack);
        }
    }

    public static MaterialValue GetValue(ItemStack stack){
        MaterialValue mat = null;

        if(stack == null || stack.getItem() == null)
            return null;


        for(Object r : List){
            if(r instanceof MaterialValue){
                MaterialValue value = (MaterialValue)r;

                if(AreStacksEqual(value.stack, stack)){
                    mat = value;
                    return mat;
                }


            }



        }


        return mat;
    }

    public static double GetValueFromRes(ItemStack stack, ArrayList<ItemStack> stacks){
        double i = 0;

        for(ItemStack r : stacks){
            MaterialValue val = GetValue(r);
            if(val != null){
                i += val.Value;
            }

        }

        return i;

    }

    public static void RegisterValueFromRes(ItemStack stack, ArrayList<ItemStack> stacks){
            RegisterValue(stack, GetValueFromRes(stack,stacks));
    }


    public static void RegisterManualValues(){


        RegisterValue(new ItemStack(Items.iron_ingot), 100);

    }


    public static void RegisterAutomaticValues(){

        for(Object r : Block.blockRegistry){
            if(r instanceof Block){
                Block bl = (Block)r;


                if(bl instanceof BlockAir || bl == Blocks.air)
                    continue;

                System.out.println(bl);

                    RegisterValueFromRes(GetObject(bl), RecipeUtil.GetTotalRecipeItems(GetObject(bl)));

            }
        }


        for(Object r : Item.itemRegistry){
            if(r instanceof Item){
                Item bl = (Item)r;
                    RegisterValueFromRes(GetObject(bl), RecipeUtil.GetTotalRecipeItems(GetObject(bl)));


            }
        }

    }



}
