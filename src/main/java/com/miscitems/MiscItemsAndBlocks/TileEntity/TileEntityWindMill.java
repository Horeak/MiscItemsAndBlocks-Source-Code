package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.world.World;

public class TileEntityWindMill extends TileEntityPowerGeneration{

	public TileEntityWindMill() {
		super(0, "Wind", 0);
	}

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {
		return Y > 80;
	}




	@Override
	public double GeneratedPower() {
		if(this.yCoord > 80){
			return 1 + ((this.yCoord - 80) / 10);
		}
			
		
		return 0;
	}



}
