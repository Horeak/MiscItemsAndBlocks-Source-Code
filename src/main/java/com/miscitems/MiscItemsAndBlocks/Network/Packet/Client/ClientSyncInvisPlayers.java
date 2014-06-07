package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import com.miscitems.MiscItemsAndBlocks.Utils.InvisibilityUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientSyncInvisPlayers implements IMessage, IMessageHandler<ClientSyncInvisPlayers, IMessage> {

    int Mode;
    String player;


    public ClientSyncInvisPlayers(){}
    public ClientSyncInvisPlayers(int Mode, EntityPlayer player){
        this.Mode = Mode;
        if(player != null)
        this.player = player.getDisplayName();
    }


    @Override
    public void fromBytes(ByteBuf buf) {
        Mode = buf.readInt();
        player = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {

        buf.writeInt(Mode);
        if(player != null)
        ByteBufUtils.writeUTF8String(buf,player);
    }

    @Override
    public IMessage onMessage(ClientSyncInvisPlayers message, MessageContext ctx) {
        if(message.player != null) {
            EntityPlayer player = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(message.player);

            if (player != null) {
                if (message.Mode == 1) {
                    InvisibilityUtils.AddInvisiblePlayer(player, false);
                } else if (message.Mode == 2) {
                    InvisibilityUtils.RemoveInvisiblePlayer(player, false);
                }

            }

        }
        return null;
    }
}
