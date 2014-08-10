package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IPowerTile;
import MiscUtils.TileEntity.ModTileEntity;
import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyStorage;
import com.miscitems.MiscItemsAndBlocks.Utils.PowerUtils;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Optional;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergyTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;


@Optional.InterfaceList(    value =
       {@Optional.Interface(iface = "ic2.api.energy.tile.IEnergyAcceptor",    modid = "IC2"),
        @Optional.Interface(iface = "ic2.api.energy.tile.IEnergySink",    modid = "IC2"),
        @Optional.Interface(iface = "ic2.api.energy.tile.IEnergyTile",    modid = "IC2"),
        @Optional.Interface(iface = "cofh.api.energy.IEnergyStorage",    modid = "CoFHCore"),
        @Optional.Interface(iface = "cofh.api.energy.IEnergyConnection",    modid = "CoFHCore"),
        @Optional.Interface(iface = "cofh.api.energy.IEnergyHandler",    modid = "CoFHCore")
})
public abstract class TileEntityPowerBaseTile extends ModTileEntity implements IPowerTile, IEnergySink, IEnergyAcceptor, IEnergyTile, IEnergyStorage, IEnergyConnection, IEnergyHandler {

    private double Power;
    private double PowerMax;




    public void validate()
    {
      super.validate();
        if(Loader.isModLoaded("IC2"))
        MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
    }

    public void invalidate()
    {
        super.invalidate();
        if(Loader.isModLoaded("IC2"))
        MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
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
    public boolean ConnectsToCables() {
        return AcceptsPower();
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

        if(Loader.isModLoaded("IC2"))
            return emitter instanceof IEnergyTile;

        return false;
    }

    @Override
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

    @Override
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

    @Override
    public int getEnergyStored() {
        return (int)GetPower();
    }

    @Override
    public int getMaxEnergyStored() {
        return (int)GetMaxPower();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return getMaxEnergyStored();
    }
}
