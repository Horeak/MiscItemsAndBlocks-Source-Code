package com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative;

import MiscUtils.TileEntity.ModTileEntity;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityPillar extends ModTileEntity{

    public int ID, me;

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        ID = nbtTagCompound.getInteger("I");
        me = nbtTagCompound.getInteger("META");

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);


        nbtTagCompound.setInteger("I", ID);
        nbtTagCompound.setInteger("META", me);
    }
}
