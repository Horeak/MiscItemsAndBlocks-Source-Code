package com.miscitems.MiscItemsAndBlocks.Network;

import MiscUtils.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

public class PacketTileUpdate extends AbstractPacket {

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
    public void toBytes(ByteBuf buf, Side side) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
//        buf.writeBoolean(customName != null);
//        ByteBufUtils.writeUTF8String(buf,customName);
    }

    @Override
    public void fromBytes(ByteBuf buf, Side side) {

        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        orientation = buf.readByte();
        state = buf.readByte();
//        if(buf.readBoolean())
//        customName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void onMessage(Side side, EntityPlayer player) {

        Main.proxy.handleTileEntityPacket(x, y, z, ForgeDirection.getOrientation(orientation), state, customName);
    }



}