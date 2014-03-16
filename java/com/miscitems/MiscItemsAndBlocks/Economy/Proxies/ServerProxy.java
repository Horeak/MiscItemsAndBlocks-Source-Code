package com.miscitems.MiscItemsAndBlocks.Economy.Proxies;

import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyStorage;
import com.miscitems.MiscItemsAndBlocks.Economy.Main.Economy;
import com.miscitems.MiscItemsAndBlocks.Economy.Network.Packets.SyncPlayerPropsPacket;
import com.miscitems.MiscItemsAndBlocks.Economy.Tick.ClientTickHandler;
import com.miscitems.MiscItemsAndBlocks.Economy.Tick.ServerTickHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServerProxy {

    private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();



    public ServerTickHandler tickHandlerServer;
    public ClientTickHandler tickHandlerClient;


    public void RegisterClientTick(){

    }

    public void RegisterServerTick(){
        tickHandlerServer = new ServerTickHandler();
    }


    public static void storeEntityData(String name, NBTTagCompound compound)
    {
        extendedEntityData.put(name, compound);
    }

    public static NBTTagCompound getEntityData(String name)
    {
        return extendedEntityData.remove(name);
    }



    private static final String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + MoneyStorage.EXT_PROP_NAME;
    }

    public static void saveProxyData(EntityPlayer player) {
        MoneyStorage playerData = MoneyStorage.get(player);
        NBTTagCompound savedData = new NBTTagCompound();

        playerData.saveNBTData(savedData);
        ServerProxy.storeEntityData(getSaveKey(player), savedData);
    }


    public static final void loadProxyData(EntityPlayer player) {
        MoneyStorage playerData = MoneyStorage.get(player);
        NBTTagCompound savedData = ServerProxy.getEntityData(getSaveKey(player));
        if (savedData != null) { playerData.loadNBTData(savedData); }

        Economy.packetPipeline.sendTo(new SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
    }


}
