package com.miscitems.MiscItemsAndBlocks.Network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Main.Main;

public class PacketTileUpdate extends IPacket {

    public int x, y, z;
    public byte orientation;
    public byte state;
    public String customName;

    public PacketTileUpdate() {}

    public PacketTileUpdate(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.orientation = (byte) orientation.ordinal();
        this.state = state;
        this.customName = customName;
    }

    @Override
    public void write(DataOutputStream data) throws IOException {

        data.writeInt(x);
        data.writeInt(y);
        data.writeInt(z);
        data.writeByte(orientation);
        data.writeByte(state);
        data.writeUTF(customName);
    }

    @Override
    public void read(DataInputStream data) throws IOException {

        x = data.readInt();
        y = data.readInt();
        z = data.readInt();
        orientation = data.readByte();
        state = data.readByte();
        customName = data.readUTF();
    }

    @Override
    public void execute(EntityPlayer player) {

        Main.proxy.handleTileEntityPacket(x, y, z, ForgeDirection.getOrientation(orientation), state, customName);
    }



}