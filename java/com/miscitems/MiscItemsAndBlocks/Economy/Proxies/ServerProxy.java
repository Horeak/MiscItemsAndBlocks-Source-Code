package com.miscitems.MiscItemsAndBlocks.Economy.Proxies;

import com.miscitems.MiscItemsAndBlocks.Economy.Tick.ClientTickHandler;
import com.miscitems.MiscItemsAndBlocks.Economy.Tick.ServerTickHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.HashMap;

public class ServerProxy {

    public static HashMap<EntityPlayer, Integer> MoneyStorage = new HashMap();
    public static ArrayList<EntityPlayer> JoinedPlayers = new ArrayList<EntityPlayer>();


    public ServerTickHandler tickHandlerServer;
    public ClientTickHandler tickHandlerClient;


    public void RegisterClientTick(){

    }

    public void RegisterServerTick(){
        tickHandlerServer = new ServerTickHandler();
    }


}
