package com.miscitems.MiscItemsAndBlocks.TileEntity;


public abstract class TileEntityLaserBase extends TileEntityPowerInv{

	
	public TileEntityLaserBase(int Slots, String Name, int Size, int PowerMax) {
		super(Slots, Name, Size, PowerMax);
	}

	private boolean needsUpdate;

public boolean requiresUpdate() {
return this.needsUpdate;
}

public void setNeedsUpdate() {
this.needsUpdate = true;
}

public void setNoUpdate() {
this.needsUpdate = false;
}
}
