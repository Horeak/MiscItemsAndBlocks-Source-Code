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

public abstract class AbstractPacket extends Packet
{

    public abstract void toBytes(ByteBuf buffer, Side side);


    public abstract void fromBytes(ByteBuf buffer, Side side);


    public abstract void onMessage(Side side, EntityPlayer player);

    @Override
    public void readPacketData(PacketBuffer var1) throws IOException {
        fromBytes(var1, FMLCommonHandler.instance().getSide());
    }

    @Override
    public void writePacketData(PacketBuffer var1) throws IOException {
        toBytes(var1, FMLCommonHandler.instance().getSide());
    }

    @Override
    public void processPacket(INetHandler var1) {

        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT){
            onMessage(Side.CLIENT, FMLClientHandler.instance().getClient().thePlayer);
        }else if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER){
            if(var1 instanceof NetHandlerPlayServer) {
                NetHandlerPlayServer nt = (NetHandlerPlayServer)var1;
                onMessage(Side.SERVER, nt.playerEntity);

            }else{
                System.out.println("Server but not playHandler");
            }
        }
    }
}