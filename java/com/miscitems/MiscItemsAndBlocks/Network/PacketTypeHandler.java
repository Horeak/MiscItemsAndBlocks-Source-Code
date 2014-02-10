package com.miscitems.MiscItemsAndBlocks.Network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.Packet;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

public enum PacketTypeHandler {

    ITEM_UPDATE(PacketItemUpdate.class),
    REQUEST_EVENT(PacketRequestEvent.class),
    TILE(PacketTileUpdate.class),
    TILE_WITH_ITEM(PacketTileWithItemUpdate.class);

    private Class<? extends ModPacket> clazz;

    PacketTypeHandler(Class<? extends ModPacket> clazz) {

        this.clazz = clazz;
    }

    public static ModPacket buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        ModPacket packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static ModPacket buildPacket(PacketTypeHandler type) {

        ModPacket packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(ModPacket ModPacket) {

        byte[] data = ModPacket.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = Refrence.Channel;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = ModPacket.isChunkDataPacket;

        return packet250;
    }
}