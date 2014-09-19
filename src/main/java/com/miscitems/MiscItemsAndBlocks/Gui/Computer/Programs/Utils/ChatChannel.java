package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.ComputerPrograms.Chat.PacketAddPlayerServerToClient;
import com.miscitems.MiscItemsAndBlocks.Network.ComputerPrograms.Chat.PacketChatMessagetoServer;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatChannel {

    public ArrayList<String> Messages = new ArrayList<String>();
    public ArrayList<EntityPlayer> ConnectedPlayers = new ArrayList<EntityPlayer>();
    public ArrayList<EntityPlayer> Banned = new ArrayList<EntityPlayer>();

    public HashMap<EntityPlayer, ChatRanks> UserRanks = new HashMap<EntityPlayer, ChatRanks>();


    public ChatChannel(String Id, String Name, boolean Close){
        ChannelId = Id;
        ChannelName = Name;
        this.Close = Close;
    }

    public String ChannelId;
    public String ChannelName;
    public boolean Close;


    //Make sure to sync this from the server to client when connecting to a new channel (other wise client-side free admin -.-)
    public boolean OpAdmins = false;

    public ChatRanks GetPlayerRank(EntityPlayer player){
        
        if(UserRanks.get(player) != null){
            return UserRanks.get(player);

        }

        return ChatRanks.User;
    }



    public void SetPlayerRank(EntityPlayer player, ChatRanks rank){
        UserRanks.remove(player);
        UserRanks.put(player, rank);

    }



    public void AddPlayer(EntityPlayer pl){

        ConnectedPlayers.add(pl);

        PacketHandler.sendToServer(new PacketAddPlayerServerToClient(ChannelName, pl.getCommandSenderName()), Main.Utils.channels);


        //Redo this in a way where it does not crash dedicated servers
//        if(OpAdmins){
//            if(pl!= null) {
//                    if (FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152607_e(pl.getGameProfile())) {
//
//                        SetPlayerRank(pl, ChatRanks.Admin);
//
//                    }
//
//
//            }
//        }
    }



    public void RemovePlayer(EntityPlayer pl){

        ConnectedPlayers.remove(pl);

        if(GetPlayerRank(pl) != null)
        UserRanks.remove(pl);

    }



    public void AddMessageFromPlayer(EntityPlayer player, String Message){
        AddMessage(player.getDisplayName() + ": " + Message);
    }


    //Add network sync code (only add on client side for sender. But sync to server and resend to other clients for others) (Or figure out a way to have chat log stored server side)
    public void AddMessage(String Message)
    {

        PacketHandler.sendToServer(new PacketChatMessagetoServer(ChannelName, Message), Main.Utils.channels);

    }


    public void ResendMessage(String Message){
        Messages.add(Message);
    }


    public void ClearChat(){
        Messages.clear();
    }




    public boolean IsPlayerConnected(EntityPlayer player){
        return ConnectedPlayers.contains(player);
    }

    public boolean CanConnectPlayer(EntityPlayer player){
        return !Banned.contains(player);
    }

    public void ConnectPlayer(EntityPlayer player){

       AddPlayer(player);
       AddMessage(" * " + player.getDisplayName() + " Joined the channel.");
    }



    public void DisconnectPlayer(EntityPlayer player){

        RemovePlayer(player);
        AddMessage(" * " + player.getDisplayName() + " Left the channel.");
    }



    public void KickPlayer(EntityPlayer player){

        AddMessage(player.getDisplayName() + " was kicked from the channel.");

        ChannelUtils.DisconnectFromChannel(ChannelId, player);
        ChannelUtils.ConnectToChannel("Default", player);
    }



    public void BanPlayer(EntityPlayer player){
        AddMessage(player.getDisplayName() + " was banned from the channel.");
        ChannelUtils.DisconnectFromChannel(ChannelId, player);

        Banned.add(player);
    }


    public void UnBanPlayer(EntityPlayer player){
        Banned.remove(player);
    }


}
