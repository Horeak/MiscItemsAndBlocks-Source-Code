package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IEnergyEmitter;
import MiscItemsApi.Electric.IPowerCable;
import MiscItemsApi.Electric.PacketUtils;
import MiscItemsApi.Electric.PowerPacket;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public class TileEntityPowerCable extends TileEntityPowerBaseTile implements IPowerCable, IEnergyEmitter {



    @Override
    public boolean CanAcceptPower() {
        return true;
    }

    public double GetMaxPower(){
    	return 0;
    }

    public ArrayList<PowerPacket> packets = new ArrayList<PowerPacket>();

    @Override
    public void OnRecivedEnergyPacket(PowerPacket packet) {
           PowerPacket sendPacket = new PowerPacket(packet.SentFrom, packet.Stored, packet.Timeout);

            NBTTagCompound nbt = new NBTTagCompound();
            packet.WriteToNBT(nbt);
            sendPacket.LoadFromNBT(nbt);

            int g = PacketUtils.GetValidDirections(packet.SentFrom, this);
            sendPacket.Stored = packet.Stored / (double) g;

        PacketUtils.SendPacket(sendPacket, this);


    }



    @Override
    public void OnSendEnergy(PowerPacket packet) {

    }

    @Override
    public void SentEnergySuccessfully(PowerPacket packet) {
        packet.Timeout();

    }


}


