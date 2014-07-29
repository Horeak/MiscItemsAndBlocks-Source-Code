package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import MiscItemsApi.Electric.IPowerItem;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Optional;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;
import java.util.Set;

@Optional.Interface(iface = "ic2.api.item.IElectricItem", modid =  "IC2", striprefs = true)
public abstract class ModItemPowerTool extends ItemTool implements IPowerItem, IElectricItem{

	public ModItemPowerTool(float damage, ToolMaterial material, Set blocks) {
		super(damage, material, blocks);
		this.canRepair = false;
	}

    public int getItemEnchantability()
    {
        return 0;
    }


    @Override
    public void AddPower(ItemStack stack, double Amount) {

        if(Loader.isModLoaded("IC2")) {
            ElectricItem.manager.charge(stack, Amount, getTier(stack), true, false);
            return;
        }

        if(stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setDouble("Power", Amount);
        }else{
            stack.getTagCompound().setDouble("Power", stack.getTagCompound().getDouble("Power") + Amount);
        }


    }

    @Override
    public void RemovePower(ItemStack stack, double Amount) {

        if(Loader.isModLoaded("IC2")) {
            ElectricItem.manager.discharge(stack, Amount, getTier(stack), false, true, false);
            return;
        }

        if(stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setDouble("Power", 0);
        }else{
            stack.getTagCompound().setDouble("Power", stack.getTagCompound().getDouble("Power") - Amount);
        }

    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(StatCollector.translateToLocal("words.power") + ": " +  CurrentPower(stack) + "/" + MaxPower(stack));
        if (CurrentPower(stack) <= 0)
            list.add(EnumChatFormatting.RED + StatCollector.translateToLocal("items.desc.string.outofpowerrecharge"));

    }

    public double CurrentPower(ItemStack stack){

        if(Loader.isModLoaded("IC2"))
            return ElectricItem.manager.getCharge(stack);

        if(stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setDouble("Power", 0);
        }else
        return stack.getTagCompound().getDouble("Power");

        return 0;
    }

    public boolean IsCreative;
    
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }



    @Override
    public double ChargeAmount(ItemStack stack) {
        return 1;
    }

    @Override
    public boolean CanBackpackRecharge(ItemStack stack) {
        return false;
    }



    public boolean canProvideEnergy(ItemStack itemStack) {
        return true;
    }

    public Item getChargedItem(ItemStack itemStack) {

        if(itemStack.getTagCompound() == null) {
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setDouble("Power", MaxPower(itemStack));
        }else{
            itemStack.getTagCompound().setDouble("Power", MaxPower(itemStack));
        }


        return itemStack.getItem();
    }


    public Item getEmptyItem(ItemStack itemStack) {


        if(itemStack.getTagCompound() == null) {
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setDouble("Power", 0);
        }else{
            itemStack.getTagCompound().setDouble("Power", 0);
        }


        return itemStack.getItem();
    }


    public double getMaxCharge(ItemStack itemStack) {
        return this.MaxPower(itemStack);
    }


    public double getTransferLimit(ItemStack itemStack) {
        return 10;
    }

    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List list)
    {

        ItemStack stack = new ItemStack(par1, 1);
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setDouble("Power", MaxPower(stack));

        if(Loader.isModLoaded("IC2"))
            ElectricItem.manager.charge(stack, MaxPower(stack), getTier(stack), true, false);


        list.add(stack);

    }

}
