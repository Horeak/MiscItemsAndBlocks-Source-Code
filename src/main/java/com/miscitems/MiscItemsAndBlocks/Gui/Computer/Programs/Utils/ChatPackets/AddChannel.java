package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatPackets;

import MiscUtils.Network.AbstractPacket;
import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChannelUtils;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatChannel;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class AddChannel extends AbstractPacket {

    String name, id;
    boolean canClose, opAdmins;

    public AddChannel(){}
    public AddChannel(String name, String id, boolean canClose, boolean opAdmins){
        this.name = name;
        this.id = id;
        this.canClose = canClose;
        this.opAdmins = opAdmins;
    }

    @Override
    public void toBytes(ByteBuf buffer, Side side) {
        ByteBufUtils.writeUTF8String(buffer, name);
        ByteBufUtils.writeUTF8String(buffer, id);

        buffer.writeBoolean(canClose);
        buffer.writeBoolean(opAdmins);

    }

    @Override
    public void fromBytes(ByteBuf buffer, Side side) {
        name = ByteBufUtils.readUTF8String(buffer);
        id = ByteBufUtils.readUTF8String(buffer);

        canClose = buffer.readBoolean();
        opAdmins = buffer.readBoolean();

    }

    @Override
    public void onMessage(Side side, EntityPlayer player) {

        ChatChannel channel = new ChatChannel(id, name, canClose);

        boolean t = true;
        for(ChatChannel chan : ChannelUtils.Channels){
            if(chan.ChannelId.equalsIgnoreCase(channel.ChannelId))
                t = false;


        }

        if(!t){

            channel.OpAdmins = opAdmins;

            ChannelUtils.Channels.add(channel);
            ChannelUtils.ChannelIds.put(id, channel);


            if(side == Side.SERVER){
                PacketHandler.sendToAll(new AddChannel(name, id, canClose, opAdmins), Main.Utils.channels);
            }
        }


    }
}
