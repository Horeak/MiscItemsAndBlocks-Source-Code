package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IPowerTile;
import MiscItemsApi.Electric.PowerPacket;
import MiscUtils.TileEntity.ModTileEntity;
import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyStorage;
import com.miscitems.MiscItemsAndBlocks.Utils.PowerUtils;
import cpw.mods.fml.common.Optional;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import universalelectricity.api.core.grid.electric.IEnergyContainer;


@Optional.InterfaceList(    value =
        {
                @Optional.Interface(iface = "cofh.api.energy.IEnergyStorage",    modid = "CoFHCore", striprefs = true),
                @Optional.Interface(iface = "cofh.api.energy.IEnergyConnection",    modid = "CoFHCore", striprefs = true),
                @Optional.Interface(iface = "cofh.api.energy.IEnergyHandler",    modid = "CoFHCore", striprefs = true),
        @Optional.Interface(iface = "universalelectricity.api.core.grid.electric.IEnergyContainer",    modid = "UniversalElectricity", striprefs = true)
        })
public abstract class TileEntityPowerBaseTile extends ModTileEntity implements IPowerTile,   IEnergyStorage, IEnergyConnection, IEnergyHandler, IEnergyContainer {

    private double Power;
    private double PowerMax;


    public void OnRecivedEnergyPacket(PowerPacket packet) {
        AddPower(packet.Stored);
    }



    public void SetPower(double i){
        Power = i;
    }

    public double GetPower(){
        return this.Power;
    }


    public abstract boolean CanAcceptPower();





    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);

        compound.setDouble("Power", Power);
        compound.setDouble("MaxPower", PowerMax);





    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);


        Power = compound.getDouble("Power");
        PowerMax = compound.getDouble("MaxPower");



    }


    @Override
    public void AddPower(double Amount) {
        if(GetPower() + Amount < GetMaxPower())
            SetPower(GetPower() + Amount);
        else
            SetPower(GetMaxPower());
    }

    @Override
    public boolean AcceptsPower() {
        return CanAcceptPower();
    }



    @Override
    public void SetMaxPower(double i) {
        if(i > 0)
            PowerMax = i;
    }


    public double demandedEnergyUnits() {
        return 1;
    }

    public double injectEnergyUnits(ForgeDirection directionFrom, double amount) {
        if(GetPower() + (int)amount < GetMaxPower())
            AddPower((int)amount);
        else
            SetPower(GetMaxPower());

        return GetPower();
    }

    public int getMaxSafeInput() {
        return (int)this.GetMaxPower();
    }

    public double getDemandedEnergy() {
        return GetMaxPower() - GetPower();
    }

    public int getSinkTier() {
        return 1;
    }

    public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {

        amount /= (PowerUtils.ModPower_For_MiscPower / 2);

        if(GetPower() < GetMaxPower())
        AddPower(amount);
        else
        SetPower(GetMaxPower());
        return 0;

    }


    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction){

        if(emitter instanceof  IPowerTile)
            return true;


        return false;
    }

    public int receiveEnergy(int maxReceive, boolean simulate) {

        int energy = (int)GetPower();
        double Added = 0.1;

        if(energy < GetMaxPower()) {
            if (!simulate) {
                AddPower(Added);
            }

        }else
        return 0;


        return 100;
    }

    public int extractEnergy(int maxExtract, boolean simulate) {


        int energy = (int)GetPower();
        double Removed = 1 / 1000;

        if(energy > 0.0) {
            if (!simulate) {
                SetPower(GetPower() - Removed);
            }

        }else
            return 0;


        return 1;
    }

    public boolean ConnectsToTile(TileEntity tile) {
        return true;
    }


    public int getEnergyStored() {
        return (int)GetPower();
    }

    public int getMaxEnergyStored() {
        return (int)GetMaxPower();
    }

    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return receiveEnergy(maxReceive, simulate);
    }

    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return extractEnergy(maxExtract, simulate);
    }

    public int getEnergyStored(ForgeDirection from) {
        return getEnergyStored();
    }

    public int getMaxEnergyStored(ForgeDirection from) {
        return getMaxEnergyStored();
    }

    public void setEnergy(ForgeDirection from, double energy) {
        Power = energy;

        if(Power > PowerMax)
            Power = PowerMax;

    }

    public double getEnergy(ForgeDirection from) {
        return Power;
    }

    public double getEnergyCapacity(ForgeDirection from) {
        return PowerMax;
    }
}
