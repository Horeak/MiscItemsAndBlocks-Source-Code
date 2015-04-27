package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IEnergyEmitter;
import MiscItemsApi.Electric.PacketUtils;
import MiscItemsApi.Electric.PowerPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCreativeEnergySource  extends TileEntityPowerBaseTile implements IEnergyEmitter {


    public double GetMaxPower(){
        return 9999;
    }

    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction){

        return false;
    }



    public void updateEntity()
    {

        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
            int PowerToSend = 100;

                PowerPacket packet = new PowerPacket(dir.getOpposite(), PowerToSend, -1);
                PacketUtils.SendPacketToDir(packet, dir, this);


        }
    }




    @Override
    public boolean CanAcceptPower() {
        return false;
    }





    @Override
    public void OnSendEnergy(PowerPacket packet) {

    }

    @Override
    public void SentEnergySuccessfully(PowerPacket packet) {

    }
}