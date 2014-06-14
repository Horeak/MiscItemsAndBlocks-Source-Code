package com.miscitems.MiscItemsAndBlocks.Utils.RecipeUtils;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CrystalBladeUpgradeRecipe implements IRecipe {

    ItemStack UpgradeItem;
    ItemStack sword;
    String UpgradeString;

    public CrystalBladeUpgradeRecipe(ItemStack Sword, ItemStack UpgradeItem, String Upgrade){
        this.UpgradeItem = UpgradeItem;
        this.UpgradeString = Upgrade;
        this.sword = Sword;

    }



    @Override
    public boolean matches(InventoryCrafting inv, World var2) {



        boolean HasUpgradeItem = false, HasCrystals = false, HasSword = false;
        int Crystals = 0;


        ItemStack tmpStack = null;

        ItemStack Sword;

        for(int i = 0; i < inv.getSizeInventory(); i++) {
            if (inv.getStackInSlot(i) != null) {
                if (inv.getStackInSlot(i) instanceof ItemStack)
                    tmpStack = inv.getStackInSlot(i);
                else
                    tmpStack = new ItemStack(inv.getStackInSlot(i).getItem());




                if (tmpStack.getItem() == ModItems.CrystalBlade) {
                    HasSword = true;
                    Sword = tmpStack;
                }

                if (tmpStack.getItem() == UpgradeItem.getItem())
                    HasUpgradeItem = true;

                if (tmpStack.getItem() == ModItems.ChargedCrystal)
                    Crystals++;



                if (HasUpgradeItem && Crystals == 3 && HasSword) {
                    if(sword.getTagCompound() != null && sword.getTagCompound().hasKey(UpgradeString))
                        return false;

                    return true;
                }

            }
        }

        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {


        ItemStack CurrentSword = null;

        for(int i = 0; i < inv.getSizeInventory(); i++){
            if(inv.getStackInSlot(i) != null && inv.getStackInSlot(i).getItem() == ModItems.CrystalBlade)
                CurrentSword = inv.getStackInSlot(i);
        }


        if(CurrentSword != null) {

            ItemStack newItem = new ItemStack(CurrentSword.getItem(), CurrentSword.stackSize, CurrentSword.getItemDamage());

            if (CurrentSword.getTagCompound() != null)
                newItem.setTagCompound(CurrentSword.stackTagCompound);
            else
                newItem.setTagCompound(new NBTTagCompound());


            if (!newItem.getTagCompound().hasKey(UpgradeString))
                newItem.getTagCompound().setBoolean(UpgradeString, true);


            return newItem;

        }

        return sword;

    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return sword.copy();
    }
}
