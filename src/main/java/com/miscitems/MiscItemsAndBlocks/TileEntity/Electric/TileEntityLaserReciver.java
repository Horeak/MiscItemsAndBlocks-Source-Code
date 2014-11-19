package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IPowerTile;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.ILaserReciver;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserInstance;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityLaserReciver extends TileEntity implements ILaserReciver{

	public boolean Redstone;

	
	int ResetTime = 0;
	int Reset = 2;
	
	public void updateEntity(){
		if(ResetTime < Reset)
			ResetTime++;
		else{
             SetState(false);
		}
		
	}

    public void SetState(boolean state){
        if(Redstone != state) {
            Redstone = state;
            worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlock(xCoord, yCoord, zCoord));
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

	@Override
	public boolean CanLaserPass(LaserInstance instance, ForgeDirection dir) {

        int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
        ForgeDirection dirr = ForgeDirection.getOrientation(meta);

        return dir != dirr && dir != dirr.getOpposite();

	}


    @Override
    public void LaserReceiveOnSide(LaserInstance instance, ForgeDirection side) {

        if(instance.Redstone){
            SetState(true);
            ResetTime = 0;
        }

        if(instance.TransPower){
            ForgeDirection dir = side;


            int xTemp = xCoord + dir.offsetX;
            int yTemp = yCoord + dir.offsetY;
            int zTemp = zCoord + dir.offsetZ;

            if(worldObj.getTileEntity(xTemp, yTemp, zTemp) != null){
                TileEntity te = worldObj.getTileEntity(xTemp, yTemp, zTemp);

                if(te instanceof IPowerTile){
                    IPowerTile tee = (IPowerTile)te;

                    if(tee.AcceptsPower()){
                        tee.AddPower(instance.GetPowerTransferAmount());


                    }

                }

            }

        }
    }
}
