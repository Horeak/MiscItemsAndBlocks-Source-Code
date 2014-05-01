package com.miscitems.MiscItemsAndBlocks.Network;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketTileWithItemUpdate extends IPacket {

    public int x, y, z;
    public byte orientation;
    public byte state;
    public String customName;
    public int itemID, metaData, stackSize, color;

    public PacketTileWithItemUpdate() {}

    public PacketTileWithItemUpdate(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.orientation = (byte) orientation.ordinal();
        this.state = state;
        this.customName = customName;
        this.itemID = itemID;
        this.metaData = metaData;
        this.stackSize = stackSize;
        this.color = color;
    }

    @Override
    public void write(DataOutputStream data) throws IOException {

        data.writeInt(x);
        data.writeInt(y);
        data.writeInt(z);
        data.writeByte(orientation);
        data.writeByte(state);
        data.writeUTF(customName);
        data.writeInt(itemID);
        data.writeInt(metaData);
        data.writeInt(stackSize);
        data.writeInt(color);
    }

    @Override
    public void read(DataInputStream data) throws IOException {

        x = data.readInt();
        y = data.readInt();
        z = data.readInt();
        orientation = data.readByte();
        state = data.readByte();
        customName = data.readUTF();
        itemID = data.readInt();
        metaData = data.readInt();
        stackSize = data.readInt();
        color = data.readInt();
    }

    @Override
    public void execute(EntityPlayer player) {

        Main.proxy.handleTileWithItemPacket(x, y, z, ForgeDirection.getOrientation(orientation), state, customName, Item.getItemById(itemID), metaData, stackSize, color);
    }


}