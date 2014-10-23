package MiscItemsApi.Electric;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import javax.vecmath.Vector3d;

public class PacketUtils {

    public static int GetValidDirections(ForgeDirection exlclude, TileEntity tile){
        int i = 0 ;

        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS){
            if(dir != exlclude){

                TileEntity te = tile.getWorldObj().getTileEntity(tile.xCoord + dir.offsetX, tile.yCoord + dir.offsetY, tile.zCoord + dir.offsetZ);

                if(te instanceof IPowerTile){
                    IPowerTile pt = (IPowerTile)te;

                    if(pt.ConnectsToTile(tile) && pt.AcceptsPower()){
                        i += 1;

                    }
                }


            }

        }



        return i;
    }

    public static boolean SendPacket(PowerPacket packet, TileEntity tileFrom) {
        boolean t = false;

        for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
            if (dir != packet.SentFrom) {
                if(SendPacketToDir(packet, dir, tileFrom))
                    t = true;
            }
        }


        return t;
    }

    public static boolean SendPacketToDir(PowerPacket packet, ForgeDirection dir, TileEntity tileFrom) {
        boolean t = false;

        if (dir != packet.SentFrom && dir != ForgeDirection.UNKNOWN && packet != null && packet.Timedout == false) {
            if (tileFrom.getWorldObj().getTileEntity(tileFrom.xCoord + dir.offsetX, tileFrom.yCoord + dir.offsetY, tileFrom.zCoord + dir.offsetZ) instanceof IPowerTile) {
                TileEntity tile = tileFrom.getWorldObj().getTileEntity(tileFrom.xCoord + dir.offsetX, tileFrom.yCoord + dir.offsetY, tileFrom.zCoord + dir.offsetZ);

                if (tileFrom instanceof IEnergyEmitter) {
                    IEnergyEmitter em = (IEnergyEmitter)tileFrom;



                    if (tile instanceof IPowerTile) {
                        if (((IPowerTile) tile).ConnectsToTile(tileFrom) && ((IPowerTile) tileFrom).ConnectsToTile(tile) && ((IPowerTile) tile).AcceptsPower()) {
                            Vector3d vec = new Vector3d(tile.xCoord, tile.yCoord, tile.zCoord);

                            if (!packet.Vectors.contains(vec)) {


                                em.OnSendEnergy(packet);
                                PowerPacket sendPacket = new PowerPacket(packet.SentFrom, packet.Stored, packet.Timeout);

                                NBTTagCompound nbt = new NBTTagCompound();
                                packet.WriteToNBT(nbt);

                                sendPacket.LoadFromNBT(nbt);
                                sendPacket.SentFrom = dir.getOpposite();
                                sendPacket.OnResent();
                                sendPacket.Vectors = packet.Vectors;
                                sendPacket.Vectors.add(vec);


                                ((IPowerTile) tile).OnRecivedEnergyPacket(sendPacket);


                                em.SentEnergySuccessfully(sendPacket);

                                t = true;

                            }


                        }

                    }


                }


            }

        }
        return t;
    }
}
