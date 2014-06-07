package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientSyncInvisPlayers;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.InvisibilityUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ServerSyncInvisPlayers implements IMessage, IMessageHandler<ServerSyncInvisPlayers, IMessage> {

    int Mode;
    String player;


    public ServerSyncInvisPlayers(){}
    public ServerSyncInvisPlayers(int Mode, EntityPlayer player){
        this.Mode = Mode;
        this.player = player.getCommandSenderName();
    }


    @Override
    public void fromBytes(ByteBuf buf) {
        Mode = buf.readInt();
        player = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {

        buf.writeInt(Mode);
        ByteBufUtils.writeUTF8String(buf,player);
    }

    @Override
    public IMessage onMessage(ServerSyncInvisPlayers message, MessageContext ctx) {
        EntityPlayer player = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(message.player);


        if (player != null) {
            if (message.Mode == 1) {
                InvisibilityUtils.AddInvisiblePlayer(player, false);
            } else if (message.Mode == 2) {
                InvisibilityUtils.RemoveInvisiblePlayer(player, false);
            }

        }

        PacketHandler.INSTANCE.sendToAll(new ClientSyncInvisPlayers(message.Mode, player));

        return null;
    }
}
