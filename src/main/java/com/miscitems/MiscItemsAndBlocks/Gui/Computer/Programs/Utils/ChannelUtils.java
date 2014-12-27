package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatPackets.AddChannel;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatPackets.CloseChannel;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatPackets.ConnectToChannel;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatPackets.CreateChannel;
import com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils.ChatPackets.DisconnectFromChannel;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.HashMap;

public class ChannelUtils {

    public static ArrayList<ChatChannel> Channels = new ArrayList<ChatChannel>();
    public static HashMap<String, ChatChannel> ChannelIds = new HashMap<String, ChatChannel>();


    public static ChatChannel CreateChannel(String Name, EntityPlayer player){
        PacketHandler.sendToServer(new CreateChannel(Name), Main.Utils.channels);
        ChatChannel channel = GetChannel(Name);

        if(player != null)
        channel.SetPlayerRank(player, ChatRanks.Owner);

        return channel;
    }

    public static ChatChannel GetChannel(String Name){

        for(ChatChannel channel : Channels){
            if(channel.ChannelName.equalsIgnoreCase(Name))
                return channel;

        }

        return null;
    }

    //Should not be called outside of packets!
    public static boolean AddChannel(ChatChannel channel){
        for(ChatChannel chan : Channels){
            if(chan.ChannelId.equalsIgnoreCase(channel.ChannelId))
                return false;
        }
        Channels.add(channel);
        ChannelIds.put(channel.ChannelId, channel);

        return true;
    }


    public static boolean AddChannel(String Name, String ID, boolean CanClose){
        return AddChannel(Name, ID, CanClose, false);
    }

    public static boolean AddChannel(String Name, String ID, boolean CanClose, boolean OpAdmins){
        ChatChannel channel = new ChatChannel(ID, Name, CanClose);

        for(ChatChannel chan : Channels){
            if(chan.ChannelId.equalsIgnoreCase(channel.ChannelId))
                return false;

        }

        PacketHandler.sendToServer(new AddChannel(Name, ID, CanClose, OpAdmins), Main.Utils.channels);

        return true;
    }



    public static boolean CloseChannel(ChatChannel channel){

        PacketHandler.sendToServer(new CloseChannel(channel.ChannelName), Main.Utils.channels);

        return GetChannel(channel.ChannelName) == null;
    }

    public static boolean ConnectToChannel(String Id, EntityPlayer player){
        ChatChannel channel = ChannelIds.get(Id);

        PacketHandler.sendToServer(new ConnectToChannel(Id, player.getCommandSenderName()), Main.Utils.channels);
        return channel.ConnectedPlayers.contains(player);
    }

    public static boolean DisconnectFromChannel(String Id, EntityPlayer player){
        ChatChannel channel = ChannelIds.get(Id);

        PacketHandler.sendToServer(new DisconnectFromChannel(Id, player.getCommandSenderName()), Main.Utils.channels);
        return channel.Close || channel == null || !channel.ConnectedPlayers.contains(player);
    }


    public static ChatChannel GetChannelFromPlayer(EntityPlayer player){
        for(ChatChannel channel : Channels){
            if(channel.ConnectedPlayers.contains(player)){
                return channel;
            }
        }


            return null;
    }
}
