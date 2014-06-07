package com.miscitems.MiscItemsAndBlocks.Network.Packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class PacketRequestEvent implements IMessage, IMessageHandler<PacketRequestEvent, IMessage> {

    public byte eventType;
    public int originX, originY, originZ;
    public byte sideHit;
    public byte rangeX, rangeY, rangeZ;
    public String data;

    public PacketRequestEvent() {}

    public PacketRequestEvent(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

        this.eventType = eventType;
        this.originX = originX;
        this.originY = originY;
        this.originZ = originZ;
        this.sideHit = sideHit;
        this.rangeX = rangeX;
        this.rangeY = rangeY;
        this.rangeZ = rangeZ;
        this.data = data;
    }

    @Override
    public void toBytes(ByteBuf buf) {

        buf.writeByte(eventType);
        buf.writeInt(originX);
        buf.writeInt(originY);
        buf.writeInt(originZ);
        buf.writeByte(sideHit);
        buf.writeByte(rangeX);
        buf.writeByte(rangeY);
        buf.writeByte(rangeZ);

        ByteBufUtils.writeUTF8String(buf,this.data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {

        eventType = buf.readByte();
        originX = buf.readInt();
        originY = buf.readInt();
        originZ = buf.readInt();
        sideHit = buf.readByte();
        rangeX = buf.readByte();
        rangeY = buf.readByte();
        rangeZ = buf.readByte();
        this.data = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public IMessage onMessage(PacketRequestEvent message, MessageContext ctx) {

        return null;
    }


}