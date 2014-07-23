package com.miscitems.MiscItemsAndBlocks.Utils;

import com.miscitems.MiscItemsAndBlocks.Network.Client.MagicReciveParticleEffects;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic.MagicReceiver;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Interfaces.Magic.MagicSender;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;

import java.util.List;

public class MagicUtils {

    static int Radius = 50;

    public static void SendPower(MagicSender sender, TileEntity tile){

            if (!tile.getWorldObj().isRemote) {
                WorldServer world = (WorldServer) tile.getWorldObj();

                double Rad = 0;
                MagicReceiver recc = null;

                List list = world.func_147486_a(tile.xCoord - Radius, tile.yCoord - Radius, tile.zCoord - Radius, tile.xCoord + Radius, tile.yCoord + Radius, tile.zCoord + Radius);

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) instanceof TileEntity) {
                        TileEntity tilee = (TileEntity) list.get(i);

                        if (tilee instanceof MagicReceiver) {
                            MagicReceiver rec = (MagicReceiver) tilee;

                            if (rec.CanReceiveEnergyAmount(sender.GetEnergyPacketSize())) {

                                if(tilee.xCoord != tile.xCoord || tilee.yCoord != tile.yCoord || tilee.zCoord != tile.zCoord) {

                                    if (Rad == 0) {
                                        Rad = tilee.getDistanceFrom(tile.xCoord, tile.yCoord, tile.zCoord);
                                        recc = rec;

                                    } else if (Rad > 0 && tilee.getDistanceFrom(tile.xCoord, tile.yCoord, tile.zCoord) < Rad) {
                                        Rad = tilee.getDistanceFrom(tile.xCoord, tile.yCoord, tile.zCoord);
                                        recc = rec;

                                    }
                                }else
                                continue;

                                break;

                            }else
                                continue;


                        } else
                            continue;

                    }

                }



                if(recc != null){
                    if(sender.CanSendEnergyAmount(sender.GetEnergyPacketSize())) {
                        sender.SendEnergy(recc, sender.GetEnergyPacketSize());
                    }
                }


            }
        }


    public static void ReceiveEnergy(TileEntity tile){
        PacketHandler.sendToDimension(new MagicReciveParticleEffects(tile.xCoord, tile.yCoord, tile.zCoord), tile.getWorldObj().provider.dimensionId);

    }

}
