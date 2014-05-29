package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

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
