package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IEnergyEmitter;
import MiscItemsApi.Electric.PacketUtils;
import MiscItemsApi.Electric.PowerPacket;
import com.miscitems.MiscItemsAndBlocks.Utils.PowerUtils;
import cpw.mods.fml.common.Loader;
import ic2.api.energy.tile.IEnergySink;
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

            if (Loader.isModLoaded("IC2") && this.worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ) instanceof IEnergySink) {
                IEnergySink tile = (IEnergySink) this.worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);

                if (tile.getDemandedEnergy() > 0) {
                    tile.injectEnergy(dir, (PowerToSend / 10) * PowerUtils.ModPower_For_MiscPower, 10);
                    SetPower(GetPower() - PowerToSend);
                }


            } else {

                PowerPacket packet = new PowerPacket(dir.getOpposite(), PowerToSend, -1);
                PacketUtils.SendPacketToDir(packet, dir, this);
            }


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