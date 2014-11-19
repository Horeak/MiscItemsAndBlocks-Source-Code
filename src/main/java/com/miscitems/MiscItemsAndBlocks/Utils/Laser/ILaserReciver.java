package com.miscitems.MiscItemsAndBlocks.Utils.Laser;


import net.minecraftforge.common.util.ForgeDirection;

public interface ILaserReciver {

    public void LaserReceiveOnSide(LaserInstance instance, ForgeDirection side);
    public boolean CanLaserPass(LaserInstance instance, ForgeDirection dir);

}