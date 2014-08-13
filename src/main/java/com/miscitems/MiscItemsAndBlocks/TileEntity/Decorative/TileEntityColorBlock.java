package com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative;

import MiscUtils.TileEntity.ModTileEntity;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityColorBlock extends ModTileEntity {
    public int Color = 0;

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        Color = nbtTagCompound.getInteger("Col");

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setInteger("Col", Color);

    }
}
