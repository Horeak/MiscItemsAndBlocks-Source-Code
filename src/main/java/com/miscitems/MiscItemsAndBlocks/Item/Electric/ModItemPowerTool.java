package com.miscitems.MiscItemsAndBlocks.Item.Electric;

import MiscItemsApi.Electric.IPowerItem;
import cofh.api.energy.IEnergyContainerItem;
import cpw.mods.fml.common.Optional;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import universalelectricity.api.item.IEnergyItem;

import java.util.List;
import java.util.Set;

@Optional.InterfaceList( value =

        {@Optional.Interface(iface = "ic2.api.item.IElectricItem", modid =  "IC2", striprefs = true),
        @Optional.Interface(iface = "cofh.api.energy.IEnergyContainerItem", modid =  "CoFHCore", striprefs = true),
        @Optional.Interface(iface = "universalelectricity.api.item.IEnergyItem", modid =  "UniversalElectricity", striprefs = true)

        })

public abstract class ModItemPowerTool extends ItemTool implements IPowerItem,  IEnergyContainerItem, IEnergyItem{

	public ModItemPowerTool(float damage, ToolMaterial material, Set blocks) {
		super(damage, material, blocks);
		this.canRepair = false;
	}

    public int getItemEnchantability()
    {
        return 0;
    }


    public void AddPower(ItemStack stack, double Amount) {

        if(Amount > getMaxCharge(stack))
            Amount = getMaxCharge(stack);



        if(stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setDouble("Power", Amount);
        }else{
            stack.getTagCompound().setDouble("Power", stack.getTagCompound().getDouble("Power") + Amount);
        }



    }

    public void RemovePower(ItemStack stack, double Amount) {

        if(Amount > getMaxCharge(stack))
            Amount = getMaxCharge(stack);


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



    public double ChargeAmount(ItemStack stack) {
        return 1;
    }

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


        list.add(stack);

    }

    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

        int energy = (int)CurrentPower(container);
        double Added = 1;

        if(energy < getMaxCharge(container) && maxReceive >= 1000) {
            if (!simulate) {
                AddPower(container, Added);
            }
        }
        return 1000;
    }

    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {


        int energy = (int)CurrentPower(container);
        double Removed = 1;
        if(energy > 0.0 && maxExtract >= 1000) {

            if (!simulate) {

                RemovePower(container, Removed);
            }

        }else
                return 0;


        return 1000;
    }

    public int getEnergyStored(ItemStack container) {

        return (int)CurrentPower(container);
    }

    public int getMaxEnergyStored(ItemStack container) {

        return (int)getMaxCharge(container);
    }

    public double recharge(ItemStack itemStack, double energy, boolean doRecharge) {
        double t = (MaxPower(itemStack) - CurrentPower(itemStack));
        double accept = t - (t - energy) ;

        if(doRecharge){
            AddPower(itemStack, energy);
        }

        if(t >= energy)
            return t;

        return accept;
    }

    public double discharge(ItemStack itemStack, double energy, boolean doDischarge) {
        double cn = CurrentPower(itemStack);

        if(doDischarge){
            RemovePower(itemStack, energy);
        }

        if(cn >= energy)
            return energy;

        return MathHelper.clamp_double(cn - energy, 0, MaxPower(itemStack));
    }

    public double getEnergy(ItemStack theItem) {
        return CurrentPower(theItem);
    }

    public double getEnergyCapacity(ItemStack theItem) {
        return getMaxCharge(theItem);
    }

    public void setEnergy(ItemStack itemStack, double energy) {
          RemovePower(itemStack, CurrentPower((itemStack)));

        AddPower(itemStack, energy);

    }

    public double getVoltage(ItemStack theItem) {
        return Integer.MAX_VALUE;
    }
}
