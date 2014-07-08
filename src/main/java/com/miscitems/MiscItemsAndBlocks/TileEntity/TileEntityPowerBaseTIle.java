package com.miscitems.MiscItemsAndBlocks.TileEntity;

import MiscItemsApi.Electric.IPowerTile;
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
       {@Optional.Interface(iface = "ic2.api.energy.tile.IEnergyAcceptor",    modid = "IC2", striprefs = true),
        @Optional.Interface(iface = "ic2.api.energy.tile.IEnergySink",    modid = "IC2", striprefs = true)
})
public abstract class TileEntityPowerBaseTile extends ModTileEntity implements IPowerTile, IEnergySink, IEnergyAcceptor {

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
        return Power;
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

    @Override
    public double getDemandedEnergy() {
        return GetMaxPower() - GetPower();
    }

    @Override
    public int getSinkTier() {
        return 1;
    }

    @Override
    public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {

        amount /= (PowerUtils.IC2_For_MiscPower / 2);

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
}
