package com.miscitems.MiscItemsAndBlocks.Network.ComputerPrograms.Chat;

import MiscUtils.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChannelUtils;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatChannel;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketChatMessagetoServer extends AbstractPacket {

    String Id, Msg;

    public PacketChatMessagetoServer(){}
    public PacketChatMessagetoServer(String ChannelId, String Message){
        this.Id = ChannelId;
        this.Msg = Message;
    }

    @Override
    public void toBytes(ByteBuf buffer, Side side) {

        ByteBufUtils.writeUTF8String(buffer, Id);
        ByteBufUtils.writeUTF8String(buffer, Msg);

    }

    @Override
    public void fromBytes(ByteBuf buffer, Side side) {

        Id = ByteBufUtils.readUTF8String(buffer);
        Msg = ByteBufUtils.readUTF8String(buffer);
    }

    @Override
    public void onMessage(Side side, EntityPlayer player) {

        ChatChannel channel = ChannelUtils.GetChannel(Id);

        if(channel != null){
            channel.ResendMessage(Msg);

        }

    }
}
