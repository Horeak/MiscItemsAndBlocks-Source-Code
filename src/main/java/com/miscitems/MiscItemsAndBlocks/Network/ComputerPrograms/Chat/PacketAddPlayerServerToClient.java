package com.miscitems.MiscItemsAndBlocks.Network.ComputerPrograms.Chat;

import MiscUtils.Network.AbstractPacket;
import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChannelUtils;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatChannel;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class PacketAddPlayerServerToClient extends AbstractPacket {

    String id, player;

    public PacketAddPlayerServerToClient(){}
    public PacketAddPlayerServerToClient(String id, String player){
        this.id = id;
        this.player = player;
    }

    @Override
    public void toBytes(ByteBuf buffer, Side side) {

        ByteBufUtils.writeUTF8String(buffer, id);
        ByteBufUtils.writeUTF8String(buffer, player);

    }

    @Override
    public void fromBytes(ByteBuf buffer, Side side) {

        this.id = ByteBufUtils.readUTF8String(buffer);
        this.player = ByteBufUtils.readUTF8String(buffer);

    }

    @Override
    public void onMessage(Side side, EntityPlayer pla) {

        ChatChannel channel = ChannelUtils.GetChannel(id);

        if(channel != null) {



            String name = player;

            EntityPlayer pl = null;

            if(name != null){
                pl = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152612_a(name);

            }


            if(pl != null){
                if(!channel.ConnectedPlayers.contains(pl)) {
                    channel.ConnectedPlayers.add(pl);


                    PacketHandler.SendPacketToPlayerListExcept(new PacketAddPlayerOld(id, pl.getCommandSenderName()), Main.Utils.channels, channel.ConnectedPlayers, pl);
                    PacketHandler.sendToPlayer(new PacketAddPlayerNew(id, channel.ConnectedPlayers), pl, Main.Utils.channels);
                }

            }




         }



    }
}
