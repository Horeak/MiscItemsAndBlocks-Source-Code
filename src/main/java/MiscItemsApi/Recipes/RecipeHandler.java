package MiscItemsApi.Recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipeHandler {

    private static ArrayList craftingRecipes = new ArrayList();

    private static List getCraftingRecipes()
    {
        return craftingRecipes;
    }


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








    public static InfusionRecipe RegisterInfusionRecipe(Object rg, ItemStack input, Object[] recipe, double Energy)
    {
        ItemStack result = GetObject(rg);

        ItemStack[] stacks = new ItemStack[recipe.length];

        for(int i = 0; i < recipe.length; i++){
            ItemStack stack = (ItemStack)GetObject(recipe[i]);

            stacks[i] = stack;
        }

        InfusionRecipe r = new InfusionRecipe(result, input, stacks, Energy);
        craftingRecipes.add(r);
        return r;
    }

    public static InfusionRecipe GetInfusionRecipe(ArrayList<ItemStack> items, ItemStack input)
    {
        InfusionRecipe var13 = null;
        for (Object var11 : getCraftingRecipes()) {
            if (((var11 instanceof InfusionRecipe)))
            {
                if(AreStacksEqual(((InfusionRecipe) var11).item, input)){

                    if(items.size() == ((InfusionRecipe) var11).stacks.length){


                        boolean HasAllItems = false;
                        for(int i = 0; i < ((InfusionRecipe) var11).stacks.length; i++){
                            boolean t = false;

                            for(int g = 0; g < items.size(); g++){
                                if(AreStacksEqual(items.get(g), ((InfusionRecipe) var11).stacks[i])){
                                    t = true;
                                }
                            }
                            HasAllItems = t;

                            if(HasAllItems == false)
                                return null;

                        }

                        if(HasAllItems) {
                            var13 = (InfusionRecipe) var11;
                            return var13;
                        }




                    }

                }

            }
        }
        return var13;
    }



    public static MetalPressRecipe RegisterMetalPressRecipe(ItemStack Output, Object[] stacks, int Mode){


        MetalPressRecipe res = new MetalPressRecipe((ItemStack[])GetMultiObject(stacks), Output, Mode);
        craftingRecipes.add(res);
        return res;

    }


    public static MetalPressRecipe GetMetalPressRecipe(ItemStack[] Input, int Mode){

        MetalPressRecipe var13 = null;
        for (Object var11 : getCraftingRecipes()) {
            if (((var11 instanceof MetalPressRecipe))) {
                boolean t = false;

                if(((MetalPressRecipe) var11).Mode == Mode) {
                    if (Input.length == ((MetalPressRecipe) var11).Items.length) {
                        for (int i = 0; i < Input.length; i++)
                            t = AreStacksEqual(((MetalPressRecipe) var11).Items[i], Input[i]);

                        if (t) {
                            var13 = (MetalPressRecipe) var11;
                            return var13;
                        }


                    }
                }
                else
                    break;
            }

        }

        return var13;
    }




    public static MillRecipe RegisterMillRecipe(Object Input, Object Output)
    {
        MillRecipe r = new MillRecipe((ItemStack)GetObject(Input), (ItemStack)GetObject(Output));
        craftingRecipes.add(r);
        return r;
    }


    public static MillRecipe GetMillRecipe(ItemStack Input){

        MillRecipe var13 = null;
        for (Object var11 : getCraftingRecipes()) {
            if (((var11 instanceof MillRecipe))) {

                if(AreStacksEqual(((MillRecipe) var11).Input, Input)){
                    var13 = (MillRecipe) var11;
                    return var13;
                }
                }

            }



        return var13;
    }



    public static OvenRecipe RegisterOvenRecipe(Object Input, Object Output)
    {
        OvenRecipe r = new OvenRecipe((ItemStack)GetObject(Input), (ItemStack)GetObject(Output));
        craftingRecipes.add(r);
        return r;
    }


    public static OvenRecipe GetOvenRecipe(ItemStack Input){

        OvenRecipe var13 = null;
        for (Object var11 : getCraftingRecipes()) {
            if (((var11 instanceof OvenRecipe))) {

                if(AreStacksEqual(((OvenRecipe) var11).Input, Input)){
                    var13 = (OvenRecipe) var11;
                    return var13;
                }
            }

        }



        return var13;
    }




    public static SqueezerRecipe RegisterSqueezerRecipe(Object Input, Object... Items)
    {
        SqueezerRecipe r = new SqueezerRecipe(GetMultiObject(Items), GetObject(Input));
        craftingRecipes.add(r);
        return r;
    }


    public static SqueezerRecipe GetSqueezerRecipe(ItemStack[] Input){

        SqueezerRecipe var13 = null;
        for (Object var11 : getCraftingRecipes()) {
            if (((var11 instanceof SqueezerRecipe))) {
                boolean t = false;

                if (((SqueezerRecipe) var11).Items.length == Input.length) {

                    for (int i = 0; i < Input.length; i++)
                        t =  AreStacksEqual(((SqueezerRecipe) var11).Items[i], Input[i]);


                    if (t) {
                        var13 = (SqueezerRecipe) var11;
                        return var13;
                    }



                }else
                    break;
            }

        }



        return var13;
    }

}
