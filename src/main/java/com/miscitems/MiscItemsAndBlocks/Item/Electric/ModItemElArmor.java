package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import MiscItemsApi.Electric.IPowerItem;
import cofh.api.energy.IEnergyContainerItem;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Optional;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

@Optional.InterfaceList( value =

        {@Optional.Interface(iface = "ic2.api.item.IElectricItem", modid =  "IC2", striprefs = true),
                @Optional.Interface(iface = "cofh.api.energy.IEnergyContainerItem", modid =  "CoFHCore", striprefs = true)

        })

public abstract class ModItemElArmor extends ItemArmor implements IPowerItem, IElectricItem, IEnergyContainerItem {



	public ModItemElArmor(int RenderIndex, int ArmorType) {
		super(ArmorMaterial.IRON, RenderIndex, ArmorType);
		this.canRepair = false;

	}

    public boolean IsCreative;



    @Override
    public void AddPower(ItemStack stack, double Amount) {

        if(Loader.isModLoaded("IC2")) {
            ElectricItem.manager.charge(stack, Amount, getTier(stack), false, false);
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

    @Override
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override
    public Item getChargedItem(ItemStack itemStack) {
        return itemStack.getItem();
    }

    @Override
    public Item getEmptyItem(ItemStack itemStack) {
        return itemStack.getItem();
    }

    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return MaxPower(itemStack);
    }

    @Override
    public int getTier(ItemStack itemStack) {
        return 1;
    }

    @Override
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


    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

        int energy = (int)CurrentPower(container);
        double Added = 0.01;

        if(energy < getMaxCharge(container)) {
            if (!simulate) {
                AddPower(container, Added);
            }

        }
        return 1;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {


        int energy = (int)CurrentPower(container);
        double Removed = 0.01;

        if(energy > 0.0) {

            if (!simulate) {

                RemovePower(container, Removed);
            }
        }else
            return 0;


        return 1;
    }

    @Override
    public int getEnergyStored(ItemStack container) {

        return (int)CurrentPower(container);
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {

        return (int)getMaxCharge(container);
    }
}
