package com.miscitems.MiscItemsAndBlocks.Network;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;

public class PacketTileWithItemUpdate implements IMessage, IMessageHandler<PacketTileWithItemUpdate, IMessage> {

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
    public void toBytes(ByteBuf buf) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        ByteBufUtils.writeUTF8String(buf, customName);
        buf.writeInt(itemID);
        buf.writeInt(metaData);
        buf.writeInt(stackSize);
        buf.writeInt(color);
    }

    @Override
    public void fromBytes(ByteBuf buf) {

        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        orientation = buf.readByte();
        state = buf.readByte();
        customName = ByteBufUtils.readUTF8String(buf);
        itemID = buf.readInt();
        metaData = buf.readInt();
        stackSize = buf.readInt();
        color = buf.readInt();
    }

    @Override
    public IMessage onMessage(PacketTileWithItemUpdate message, MessageContext ctx) {

        Main.proxy.handleTileWithItemPacket(message.x, message.y, message.z, ForgeDirection.getOrientation(message.orientation), message.state, message.customName, Item.getItemById(message.itemID), message.metaData, message.stackSize, message.color);
        return null;
    }


}