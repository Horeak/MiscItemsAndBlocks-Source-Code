package com.miscitems.MiscItemsAndBlocks.Network.Packet;

import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.*;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Server.*;
import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleChannelHandlerWrapper;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {


    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Refrence.Channel);

    public static void RegisterPackets(){


        Register(ClientChatMessageRecivedPacket.class, Side.CLIENT);
        Register(ClientGamePacketBegin.class, Side.CLIENT);
        Register(ClientGamePacketChange.class, Side.CLIENT);
        Register(ClientGamePacketInviteRecived.class, Side.CLIENT);
        Register(ClientGamePacketRestart.class, Side.CLIENT);
        Register(ClientGhostBlockPacket.class, Side.CLIENT);
        Register(ClientLaserUpdatePacket.class, Side.CLIENT);
        Register(ClientMetalPressPacketUpdate.class, Side.CLIENT);
        Register(ClientSyncInvisPlayers.class, Side.CLIENT);

        Register(ServerButtonPacket.class, Side.SERVER);
        Register(ServerChatMessagePacket.class, Side.SERVER);
        Register(ServerGamePacketAccept.class, Side.SERVER);
        Register(ServerGamePacketChange.class, Side.SERVER);
        Register(ServerGamePacketClosed.class, Side.SERVER);
        Register(ServerGamePacketInvite.class, Side.SERVER);
        Register(ServerLensBenchPacketDone.class, Side.SERVER);
        Register(ServerPaintBrushChangePacket.class, Side.SERVER);
        Register(ServerSetBlockPacket.class, Side.SERVER);
        Register(ServerSyncInvisPlayers.class, Side.SERVER);

        Register(PacketRequestEvent.class, Side.SERVER);
        Register(PacketTileUpdate.class, Side.SERVER);
        Register(PacketTileWithItemUpdate.class, Side.SERVER);




    }

    public static byte i = 0;

    public static void Register(Class c, Side side){
        INSTANCE.registerMessage(c,c,i,side);
        i++;
    }

}
