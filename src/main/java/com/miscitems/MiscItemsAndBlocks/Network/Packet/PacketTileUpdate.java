package com.miscitems.MiscItemsAndBlocks.Network.Packet;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.common.util.ForgeDirection;

public class PacketTileUpdate implements IMessage, IMessageHandler<PacketTileUpdate, IMessage> {

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
    public void toBytes(ByteBuf buf) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        ByteBufUtils.writeUTF8String(buf,customName);
    }

    @Override
    public void fromBytes(ByteBuf buf) {

        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        orientation = buf.readByte();
        state = buf.readByte();
        customName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public IMessage onMessage(PacketTileUpdate message, MessageContext ctx) {

        Main.proxy.handleTileEntityPacket(message.x, message.y, message.z, ForgeDirection.getOrientation(message.orientation), message.state, message.customName);
        return null;
    }



}