package com.miscitems.MiscItemsAndBlocks.TileEntity;

import MiscItemsApi.Electric.IPowerTile;
import cofh.api.energy.IEnergyStorage;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.Optional.Method;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;


@Optional.InterfaceList(    value =
       {@Optional.Interface(iface = "IEnergyStorage", modid = "CoFHCore"),
        @Optional.Interface(iface = "IEnergySink",    modid = "IC2")})
public abstract class TileEntityPowerTile extends ModTileEntity implements IPowerTile, IEnergyStorage, IEnergySink {

    private int Power;
    private int PowerMax;



    /* IEnergyStorage */
    @Method(modid = "CoFHCore")
    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {

        int energyReceived = Math.min(PowerMax - Power, Math.min(10, maxReceive));

        if (!simulate) {
            Power += energyReceived;
        }
        return energyReceived;
    }

    @Method(modid = "CoFHCore")
    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {

        int energyExtracted = Math.min(Power, Math.min(10, maxExtract));

        if (!simulate) {
            Power -= energyExtracted;
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored() {

        return Power;
    }

    @Override
    public int getMaxEnergyStored() {

        return PowerMax;
    }


    public void SetPower(int i){
        Power = i;
    }

    public int GetPower(){
        return Power;
    }


    public abstract boolean CanAcceptPower();





    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);

        compound.setInteger("Power", Power);
        compound.setInteger("MaxPower", PowerMax);





    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);


        Power = compound.getInteger("Power");
        PowerMax = compound.getInteger("MaxPower");



    }


    @Override
    public void AddPower(int Amount) {
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
    public boolean ConnectsToCables() {
        return AcceptsPower();
    }


    @Override
    public void SetMaxPower(int i) {
        if(i > 0)
            PowerMax = i;
    }


    @Method(modid = "IC2")
    @Override
    public double demandedEnergyUnits() {
        return 1;
    }

    @Method(modid = "IC2")
    @Override
    public double injectEnergyUnits(ForgeDirection directionFrom, double amount) {
        if(GetPower() + (int)amount < GetMaxPower())
            AddPower((int)amount);
        else
            SetPower(GetMaxPower());

        return GetPower();
    }

    @Method(modid = "IC2")
    @Override
    public int getMaxSafeInput() {
        return this.GetMaxPower();
    }

    @Method(modid = "IC2")
    @Override
    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
        return true;
    }
}
