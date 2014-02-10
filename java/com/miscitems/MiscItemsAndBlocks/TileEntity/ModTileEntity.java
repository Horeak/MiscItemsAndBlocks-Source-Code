package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Network.PacketTileUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTypeHandler;

public class ModTileEntity extends TileEntity {

    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;

    public ModTileEntity() {

        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
    }

    public ForgeDirection getOrientation() {

        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    public void setOrientation(int orientation) {

        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState() {

        return state;
    }

    public void setState(byte state) {

        this.state = state;
    }

    public boolean hasCustomName() {

        return customName != null && customName.length() > 0;
    }

    public String getCustomName() {

        return customName;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {

        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);


    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

    }
    //TODO

//    @Override
//    public Packet getDescriptionPacket() {
//
//        return PacketTypeHandler.populatePacket(new PacketTileUpdate(xCoord, yCoord, zCoord, orientation, state, customName));
//    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();


        return stringBuilder.toString();
    }

}