package com.miscitems.MiscItemsAndBlocks.LibMisc;

import net.minecraft.world.World;

public interface ILaserReciver {

public int getX();
public int getY();
public int getZ();
public World getWorld();

public boolean canPassOnSide(World world, int orginX, int orginY, int orginZ, int side, LaserInGame laserInGame);

public void passLaser(World world, int orginX, int orginY, int orginZ, int side, LaserInGame laserInGame);

public void removeLasersFromSide(World world, int orginX, int orginY, int orginZ, int side);
}