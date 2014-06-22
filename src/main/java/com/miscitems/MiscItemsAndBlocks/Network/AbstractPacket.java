package com.miscitems.MiscItemsAndBlocks.Network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public abstract class AbstractPacket
{

    public abstract void toBytes(ByteBuf buffer, Side side);


    public abstract void fromBytes(ByteBuf buffer, Side side);


    public abstract void onMessage(Side side, EntityPlayer player);


}