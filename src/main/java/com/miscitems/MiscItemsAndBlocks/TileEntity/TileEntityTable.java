package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTable extends TileEntity{


    public int Color = 1;


    @Override
    public void writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);

        compound.setInteger("Col", Color);


    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

        Color = compound.getInteger("Col");

    }
}
