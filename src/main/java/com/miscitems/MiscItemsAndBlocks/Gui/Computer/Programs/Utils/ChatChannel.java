package com.miscitems.MiscItemsAndBlocks.Gui.Computer.Programs.Utils;

import MiscUtils.Network.AbstractPacket;
import MiscUtils.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.FMLCommonHandler;
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

        if(OpAdmins){
            if(pl!= null) {
                if(FMLCommonHandler.instance().getMinecraftServerInstance().isDedicatedServer()) {
                    if (FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().func_152607_e(pl.getGameProfile())) {

                        SetPlayerRank(pl, ChatRanks.Admin);

                    }

                }else if (FMLCommonHandler.instance().getMinecraftServerInstance().isSinglePlayer()){
                    SetPlayerRank(pl, ChatRanks.Admin);
                }
            }
        }
    }

    public void RemovePlayer(EntityPlayer pl){

        ConnectedPlayers.remove(pl);

        if(GetPlayerRank(pl) != null)
        UserRanks.remove(pl);

    }

    public void AddMessageFromPlayer(EntityPlayer player, String Message){
        AddMessage(player.getDisplayName() + ": " + Message);
    }

    public void AddServerSideMessage(String Message){
        Messages.add(Message);
    }

    public void AddMessage(String Message)
    {
        Messages.add(Message);
    }

    public void ClearChat(){
        Messages.clear();
    }


    public void BanPlayer(EntityPlayer player){
        Banned.add(player);
    }

    public void SendPacketToAllConnectedPlayers(AbstractPacket packet){

        for(EntityPlayer pl : ConnectedPlayers){
                PacketHandler.sendToPlayer(packet, pl, Main.Utils.channels);

        }

    }

}
