package com.miscitems.MiscItemsAndBlocks.TileEntity.Magic;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic.MagicReceiver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic.MagicSender;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Utils.ModTileEntity;
import com.miscitems.MiscItemsAndBlocks.Utils.Handlers.ParticleHelper;
import com.miscitems.MiscItemsAndBlocks.Utils.MagicUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEnergyBattery extends ModTileEntity implements MagicReceiver, MagicSender {

    public double Power;

    public static double MaxPower = 400;

    int g = 0;


    public void updateEntity(){


        if(worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
            if (g >= 50) {
                g = 0;

                MagicUtils.SendPower(this, this);
            } else
                g += 1;

        }else
            g = 0;
    }

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
    public double GetEnergyOffered() {
        return Power;
    }

    @Override
    public double GetEnergyPacketSize() {
        return 1;
    }

    @Override
    public boolean CanSendEnergy() {
        return Power > 0 && worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord);
    }

    @Override
    public boolean CanSendEnergyAmount(double i) {
        return CanSendEnergy() && Power >= i;
    }

    @Override
    public void DecreaseEnergy(double i) {
        if(Power >= i)
            Power -= i;
        else
            Power = 0;
    }

    @Override
    public void SendEnergy(MagicReceiver receiver, double i) {
        if(CanSendEnergyAmount(i)){
            if(receiver.CanReceiveEnergyAmount(i)){
                DecreaseEnergy(i);
                receiver.ReceiveEnergy(i);

            }
        }

    }

    @Override
    public void OnSendEnergyPacket(TileEntity tile, MagicReceiver receiver) {
        ParticleHelper helper = new ParticleHelper(worldObj);

        if(receiver.CanReceiveEnergy() && CanSendEnergyAmount(GetEnergyPacketSize())){

            receiver.ReceiveEnergy(GetEnergyPacketSize());
            DecreaseEnergy(GetEnergyPacketSize());

 }
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
