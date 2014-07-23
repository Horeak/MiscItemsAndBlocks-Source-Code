package com.miscitems.MiscItemsAndBlocks.TileEntity.Magic;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic.MagicReceiver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Utils.ModTileEntity;
import com.miscitems.MiscItemsAndBlocks.Utils.MagicUtils;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityMagicalInfuser extends ModTileEntity implements MagicReceiver {

    double Power = 0;
    static double MaxPower = 1000;


    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        Power = nbtTagCompound.getDouble("Power");

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setDouble("Power", Power);

    }

    @Override
    public double GetStoredEnergy() {
        return Power;
    }

    @Override
    public double GetMaxEnergy() {
        return MaxPower;
    }

    @Override
    public boolean CanReceiveEnergy() {
        return Power < MaxPower;
    }

    @Override
    public boolean CanReceiveEnergyAmount(double i) {
        return Power + i <= MaxPower;
    }

    @Override
    public void ReceiveEnergy(double i) {
        Power += i;
        MagicUtils.ReceiveEnergy(this);
    }
}
