package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.HashMap;

public class ChannelUtils {

    public static ArrayList<ChatChannel> Channels = new ArrayList<ChatChannel>();
    public static HashMap<String, ChatChannel> ChannelIds = new HashMap<String, ChatChannel>();


    public static ChatChannel CreateChannel(String Name, EntityPlayer player){
        ChatChannel channel = ChannelUtils.GetChannel(Name);

        if (channel == null) {
            channel = new ChatChannel(Name, Name, true);
            channel.SetPlayerRank(player, ChatRanks.Owner);


            ChannelUtils.AddChannel(channel);
        }


        return channel;
    }

    public static ChatChannel GetChannel(String Name){

        for(ChatChannel channel : Channels){
            if(channel.ChannelName.equalsIgnoreCase(Name))
                return channel;

        }

        return null;
    }

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
        ChatChannel channel = new ChatChannel(ID, Name, CanClose);

        for(ChatChannel chan : Channels){
            if(chan.ChannelId.equalsIgnoreCase(channel.ChannelId))
                return false;

        }

        Channels.add(channel);
        ChannelIds.put(ID, channel);


        return true;
    }

    public static boolean AddChannel(String Name, String ID, boolean CanClose, boolean OpAdmins){
        ChatChannel channel = new ChatChannel(ID, Name, CanClose);

        for(ChatChannel chan : Channels){
            if(chan.ChannelId.equalsIgnoreCase(channel.ChannelId))
                return false;

        }

        channel.OpAdmins = OpAdmins;

        Channels.add(channel);
        ChannelIds.put(ID, channel);


        return true;
    }

    public static boolean CloseChannel(ChatChannel channel){
        if(channel.Close){
            Channels.remove(channel);
            ChannelIds.remove(channel.ChannelId, channel);
            return true;
        }

        return false;
    }

    public static boolean ConnectToChannel(String Id, EntityPlayer player){
        ChatChannel channel = ChannelIds.get(Id);

        if(!channel.Banned.contains(player)){
            channel.AddPlayer(player);
            channel.AddMessage(" * " + player.getDisplayName() + " Joined the channel.");

           // PacketHandler.sendToServer(new ChannelUpdatePlayer(Id, player, false), Main.Utils.channels);

            return true;
        }

        return false;
    }

    public static boolean DisconnectFromChannel(String Id, EntityPlayer player){
        ChatChannel channel = ChannelIds.get(Id);


        if(channel.ConnectedPlayers.contains(player)){
            channel.RemovePlayer(player);
            channel.AddMessage(" * " + player.getDisplayName() + " Left the channel.");

           // PacketHandler.sendToServer(new ChannelUpdatePlayer(Id, player, true), Main.Utils.channels);

            if(channel.Close){
                if(channel.ConnectedPlayers.size() <= 0){
                    CloseChannel(channel);
                }
            }

            return true;
        }



        return false;
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
