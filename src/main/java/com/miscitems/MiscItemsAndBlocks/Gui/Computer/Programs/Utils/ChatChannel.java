package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

public class ChatChannel {

    public ArrayList<String> Messages = new ArrayList<String>();
    public ArrayList<EntityPlayer> ConnectedPlayers = new ArrayList<EntityPlayer>();
    public ArrayList<EntityPlayer> Admins = new ArrayList<EntityPlayer>();
    public ArrayList<EntityPlayer> Banned = new ArrayList<EntityPlayer>();

    public ChatChannel(String Id, String Name, boolean Close){
        ChannelId = Id;
        ChannelName = Name;
        this.Close = Close;
    }

    public String ChannelId;
    public String ChannelName;
    public boolean Close;

    public void AddMessageFromPlayer(EntityPlayer player, String Message){
        Messages.add(player.getDisplayName() + ": " + Message);
    }

    public void AddMessage(String Message){
        Messages.add(Message);
    }

    public void ClearChat(){
        Messages.clear();
    }


    public void BanPlayer(EntityPlayer player){
        Banned.add(player);
    }

    public void MakePlayerAdmin(EntityPlayer player){
        Admins.add(player);
    }




}
