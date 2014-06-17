package com.miscitems.MiscItemsAndBlocks.Utils.RecipeUtils;

import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CrystalToolUpgradeRecipe implements IRecipe {

    ItemStack UpgradeItem;
    ItemStack Tool;
    String UpgradeString;

    public CrystalToolUpgradeRecipe(ItemStack Tool, ItemStack UpgradeItem, String Upgrade){
        this.UpgradeItem = UpgradeItem;
        this.UpgradeString = Upgrade;
        this.Tool = Tool;

    }



    @Override
    public boolean matches(InventoryCrafting inv, World var2) {



        boolean HasUpgradeItem = false, HasCrystals = false, HasTool = false;
        int Crystals = 0;


        ItemStack tmpStack = null;


        for(int i = 0; i < inv.getSizeInventory(); i++) {
            if (inv.getStackInSlot(i) != null) {
                if (inv.getStackInSlot(i) instanceof ItemStack)
                    tmpStack = inv.getStackInSlot(i);
                else
                    tmpStack = new ItemStack(inv.getStackInSlot(i).getItem());




                if (tmpStack.getItem() == Tool.getItem()) {
                    HasTool = true;
                    Tool = tmpStack;
                }

                if (tmpStack.getItem() == UpgradeItem.getItem())
                    HasUpgradeItem = true;

                if (tmpStack.getItem() == ModItems.ChargedCrystal)
                    Crystals++;



                if (HasUpgradeItem && Crystals == 3 && HasTool) {
                    if(Tool.getTagCompound() != null && Tool.getTagCompound().hasKey(UpgradeString))
                        return false;

                    return true;
                }

            }
        }

        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {


        ItemStack CurrentTool = null;

        for(int i = 0; i < inv.getSizeInventory(); i++){
            if(inv.getStackInSlot(i) != null && inv.getStackInSlot(i).getItem() == Tool.getItem())
                CurrentTool = inv.getStackInSlot(i);
        }


        if(CurrentTool != null) {

            ItemStack newItem = new ItemStack(CurrentTool.getItem(), CurrentTool.stackSize, CurrentTool.getItemDamage());

            if (CurrentTool.getTagCompound() != null)
                newItem.setTagCompound(CurrentTool.stackTagCompound);
            else
                newItem.setTagCompound(new NBTTagCompound());


            if (!newItem.getTagCompound().hasKey(UpgradeString))
                newItem.getTagCompound().setBoolean(UpgradeString, true);


            if(newItem.getItem() == ModItems.CrystalBlade)
                if(UpgradeString == "Looting")
                    newItem.addEnchantment(Enchantment.looting, 10);



            return newItem;

        }

        return Tool;

    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return Tool.copy();
    }
}
