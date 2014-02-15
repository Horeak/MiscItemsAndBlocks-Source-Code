package com.miscitems.MiscItemsAndBlocks.LibMisc;

import net.minecraft.world.World;

public interface ILaserProvider {

	
public int getX();
public int getY();
public int getZ();
public World getWorld();
public LaserInGame getOutputLaser(int side);

public int GetLensStrength();
public int GetLensPower();

public boolean TransfersPower();
public boolean EmitsRedstone();


public boolean isSendingSignalFromSide(World world, int askerX, int askerY, int askerZ, int side);
}