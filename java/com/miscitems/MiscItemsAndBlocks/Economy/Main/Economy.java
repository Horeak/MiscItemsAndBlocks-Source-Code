package com.miscitems.MiscItemsAndBlocks.Economy.Main;


import com.miscitems.MiscItemsAndBlocks.Economy.Events.FirstJoinEvent;
import com.miscitems.MiscItemsAndBlocks.Economy.Gui.MoneyOverlay;
import com.miscitems.MiscItemsAndBlocks.Economy.Lib.ModInfo;
import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyUtils;
import com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ServerProxy;
import com.miscitems.MiscItemsAndBlocks.Economy.Network.NetworkManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;


@Mod(modid = ModInfo.ModId, name = ModInfo.ModName, version = ModInfo.ModVersion)
public class Economy {

    @Mod.Instance(ModInfo.ModId)
    public static Economy instance = new Economy();


    @SidedProxy(clientSide = "com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ClientProxy", serverSide = "com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ServerProxy")
    public static ServerProxy proxy;


    public static Configuration config;
    public static NetworkManager NETWORK_MANAGER;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        config = new Configuration(new File(event.getModConfigurationDirectory() + "/tm1990's mods/MiscItemsAndBlocks_Economy.cfg"));


        MoneyUtils.MoneyMark = config.get("Client Settings", "What sign should be used for money?", "$").getString();

        MoneyUtils.Multiplier = config.get("Server Settings", "What should be the multiplier for money? (used for changing currency)", 0).getInt();


        config.save();

        proxy.RegisterClientTick();
        proxy.RegisterServerTick();




    }




    @EventHandler
    public void Init(FMLInitializationEvent event){



        if(event.getSide() == Side.SERVER)
            RegisterServerEvents();

        if(event.getSide() == Side.CLIENT)
            RegisterClientEvents();



    }



    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {



    }


    public void RegisterServerEvents(){

        MinecraftForge.EVENT_BUS.register(new FirstJoinEvent());

        FMLCommonHandler.instance().bus().register(proxy.tickHandlerServer);


    }

    public void RegisterClientEvents(){


        MinecraftForge.EVENT_BUS.register((new MoneyOverlay()));

        FMLCommonHandler.instance().bus().register(proxy.tickHandlerClient);

    }

    }
