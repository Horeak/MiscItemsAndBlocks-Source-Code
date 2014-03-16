package com.miscitems.MiscItemsAndBlocks.Economy.Main;


import com.miscitems.MiscItemsAndBlocks.Economy.Event.EntityConstructingEvent;
import com.miscitems.MiscItemsAndBlocks.Economy.Event.JoinWorld;
import com.miscitems.MiscItemsAndBlocks.Economy.Event.OnPlayerRespawn;
import com.miscitems.MiscItemsAndBlocks.Economy.Gui.MoneyOverlay;
import com.miscitems.MiscItemsAndBlocks.Economy.Lib.ModInfo;
import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyUtils;
import com.miscitems.MiscItemsAndBlocks.Economy.Network.PacketPipeline;
import com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ServerProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
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

    public static final PacketPipeline packetPipeline = new PacketPipeline();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        config = new Configuration(new File(event.getModConfigurationDirectory() + "/tm1990's mods/MiscItemsAndBlocks_Economy.cfg"));


        MoneyUtils.MoneyMark = config.get("Client Settings", "What sign should be used for money?", "$").getString();
        MoneyUtils.TextArea = config.get("Client Settings", "Where on the screen should the money be showed?  top_right = 1  top_left = 2  bottom_right = 3  bottom_left = 4  Mode", 1).getInt();

        MoneyUtils.Multiplier = config.get("Server Settings", "What should be the multiplier for money? (used for changing currency)", 0).getInt();
        MoneyUtils.StarterMoney = config.get("Server Settings", "What amount of money should new players start with?", 1000).getInt();



        config.save();


        proxy.RegisterClientTick();
        proxy.RegisterServerTick();


        MinecraftForge.EVENT_BUS.register(new EntityConstructingEvent());
        MinecraftForge.EVENT_BUS.register(new JoinWorld());
        MinecraftForge.EVENT_BUS.register(new OnPlayerRespawn());

        if(event.getSide() == Side.SERVER)
            RegisterServerEvents();

        if(event.getSide() == Side.CLIENT)
            RegisterClientEvents();



    }




    @EventHandler
    public void Init(FMLInitializationEvent event){

        packetPipeline.initialise();




    }



    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {

        packetPipeline.postInitialise();


    }


    public void RegisterServerEvents(){


        FMLCommonHandler.instance().bus().register(proxy.tickHandlerServer);




    }

    public void RegisterClientEvents(){


        MinecraftForge.EVENT_BUS.register((new MoneyOverlay()));

        FMLCommonHandler.instance().bus().register(proxy.tickHandlerClient);

    }

    }
