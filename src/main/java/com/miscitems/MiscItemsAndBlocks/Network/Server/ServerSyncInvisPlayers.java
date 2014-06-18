package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientSyncInvisPlayers;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.InvisibilityUtils;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ServerSyncInvisPlayers extends AbstractPacket {

    int Mode;
    String player;


    public ServerSyncInvisPlayers(){}
    public ServerSyncInvisPlayers(int Mode, EntityPlayer player){
        this.Mode = Mode;
        this.player = player.getCommandSenderName();
    }


    @Override
    public void fromBytes(ByteBuf buf, Side side) {
        Mode = buf.readInt();
        player = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf, Side side) {

        buf.writeInt(Mode);
        ByteBufUtils.writeUTF8String(buf,player);
    }

    @Override
    public void onMessage(Side side, EntityPlayer pl) {
        EntityPlayer player = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(this.player);


        if (player != null) {
            if (Mode == 1) {
                InvisibilityUtils.AddInvisiblePlayer(player, false);
            } else if (Mode == 2) {
                InvisibilityUtils.RemoveInvisiblePlayer(player, false);
            }

        }

        PacketHandler.sendToAll(new ClientSyncInvisPlayers(Mode, player));

    }
}
