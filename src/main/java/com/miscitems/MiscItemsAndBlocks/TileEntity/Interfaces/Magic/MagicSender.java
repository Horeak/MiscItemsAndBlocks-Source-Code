package com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic;

import net.minecraft.tileentity.TileEntity;

public interface MagicSender {

    public double GetStoredEnergy();
    public double GetEnergyOffered();
    public double GetEnergyPacketSize();

    public boolean CanSendEnergy();
    public boolean CanSendEnergyAmount(double i);

    public void DecreaseEnergy(double i);

    public void SendEnergy(MagicReceiver receiver, double i);

    public void OnSendEnergyPacket(TileEntity tile, MagicReceiver receiver);
}
