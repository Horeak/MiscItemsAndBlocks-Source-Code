package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import MiscItemsApi.Electric.IPowerItem;
import cpw.mods.fml.common.Optional;
import ic2.api.item.IElectricItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.Set;

@Optional.Interface(iface = "ic2.api.item.IElectricItem", modid =  "IC2", striprefs = true)
public abstract class ModItemPowerTool extends ItemTool implements IPowerItem, IElectricItem{

	public ModItemPowerTool(float damage, ToolMaterial material, Set blocks) {
		super(damage, material, blocks);
		this.canRepair = false;
	}
    //TODO Add method for better power handling for other machines with power items. (Add a function that is activated when the charge amount changes to update the current amount of power)
    //TODO Change all machines handling power items over to use the new current power function

    public int getItemEnchantability()
    {
        return 0;
    }


    public boolean IsCreative;
    
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }


    public int CurrentPower(ItemStack stack){return MaxPower(stack) - stack.getItemDamage();}

    @Override
    public int ChargeAmount(ItemStack stack) {
        return 0;
    }

    @Override
    public boolean CanBackpackRecharge(ItemStack stack) {
        return false;
    }



    public boolean canProvideEnergy(ItemStack itemStack) {
        return true;
    }

    public Item getChargedItem(ItemStack itemStack) {
        itemStack.setItemDamage(0);
        return itemStack.getItem();
    }


    public Item getEmptyItem(ItemStack itemStack) {
        itemStack.setItemDamage(itemStack.getMaxDamage());
        return itemStack.getItem();
    }


    public int getMaxCharge(ItemStack itemStack) {
        return this.MaxPower(itemStack);
    }


    public int getTransferLimit(ItemStack itemStack) {
        return 10;
    }

}