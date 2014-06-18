package com.miscitems.MiscItemsAndBlocks.Network;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Client.*;
import com.miscitems.MiscItemsAndBlocks.Network.Server.*;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

import java.util.EnumMap;

public class PacketHandler {



    public static void RegisterPackets(){


        Main.handler.RegisterPacket(1, ClientChatMessageRecivedPacket.class);
        Main.handler.RegisterPacket(2, ClientGamePacketBegin.class);
        Main.handler.RegisterPacket(3, ClientGamePacketChange.class);
        Main.handler.RegisterPacket(4, ClientGamePacketInviteRecived.class);
        Main.handler.RegisterPacket(5, ClientGamePacketRestart.class);
        Main.handler.RegisterPacket(6, ClientGhostBlockPacket.class);
        Main.handler.RegisterPacket(7, ClientLaserUpdatePacket.class);
        Main.handler.RegisterPacket(8, ClientMetalPressPacketUpdate.class);
        Main.handler.RegisterPacket(9, ClientSyncInvisPlayers.class);

        Main.handler.RegisterPacket(10, ServerButtonPacket.class);
        Main.handler.RegisterPacket(11, ServerChatMessagePacket.class);
        Main.handler.RegisterPacket(12, ServerGamePacketAccept.class);
        Main.handler.RegisterPacket(13, ServerGamePacketChange.class);
        Main.handler.RegisterPacket(14, ServerGamePacketClosed.class);
        Main.handler.RegisterPacket(15, ServerGamePacketInvite.class);
        Main.handler.RegisterPacket(16, ServerLensBenchPacketDone.class);
        Main.handler.RegisterPacket(17, ServerPaintBrushChangePacket.class);
        Main.handler.RegisterPacket(18, ServerSetBlockPacket.class);
        Main.handler.RegisterPacket(19, ServerSyncInvisPlayers.class);

        Main.handler.RegisterPacket(20, PacketTileUpdate.class);
        Main.handler.RegisterPacket(21, PacketTileWithItemUpdate.class);

    }

    public static Packet GetPacket(AbstractPacket packet){
        return Main.channels.get(Side.SERVER).generatePacketFrom(packet);
    }

    public static void sendToAll(AbstractPacket packet)
    {
        Main.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
        Main.channels.get(Side.SERVER).writeAndFlush(packet);
    }

    public static void sendToPlayer(AbstractPacket packet, EntityPlayer player)
    {
        Main.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
        Main.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
        Main.channels.get(Side.SERVER).writeAndFlush(packet);
    }

    public static void sendToAllAround(AbstractPacket packet, NetworkRegistry.TargetPoint point)
    {
        Main.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
        Main.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
        Main.channels.get(Side.SERVER).writeAndFlush(packet);
    }

    public static void sendToDimension(AbstractPacket packet, int dimension)
    {
        Main.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
        Main.channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimension);
        Main.channels.get(Side.SERVER).writeAndFlush(packet);
    }

    public static void sendToServer(AbstractPacket packet)
    {
        Main.channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
        Main.channels.get(Side.CLIENT).writeAndFlush(packet);
    }

    public static void sendToAllExcept(AbstractPacket packet, EntityPlayer player)
    {
        for(int i = 0; i < FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().playerEntityList.size(); i++)
        {
            EntityPlayer player1 = (EntityPlayer)FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().playerEntityList.get(i);

            if(player.getCommandSenderName().equalsIgnoreCase(player1.getCommandSenderName()))
            {
                continue;
            }

            PacketHandler.sendToPlayer(packet, player1);
        }
    }




}
