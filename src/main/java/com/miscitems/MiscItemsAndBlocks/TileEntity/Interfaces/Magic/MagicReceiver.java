package com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic;

public interface MagicReceiver {


    public double GetStoredEnergy();
    public double GetMaxEnergy();

    public boolean CanReceiveEnergy();
    public boolean CanReceiveEnergyAmount(double i);

    public void ReceiveEnergy(double i);




}
