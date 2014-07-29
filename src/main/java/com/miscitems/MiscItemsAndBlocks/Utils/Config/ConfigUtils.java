package com.miscitems.MiscItemsAndBlocks.Utils.Config;

import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.HashMap;

public class ConfigUtils {


    public static final String CATEGORY_CLIENT_SETTINGS = "Client Settings";
    public static final String CATEGORY_SERVER_SETTINGS = "Server Settings";
    public static final String CATEGORY_BLOCKS = "Blocks";
    public static final String CATEGORY_ITEMS = "Items";

    public static boolean SpawnParticles;
    public static boolean AllowPowerArmorEffects;
    public static boolean HDTextures;
    public static boolean DisableCustomItemModels;
    public static boolean AllowCustomPillars;

    public static int LeveOfLogging;


    public static HashMap<Block, String> BlockConfigNames = new HashMap<Block, String>();
    public static HashMap<Item, String> ItemConfigNames = new HashMap<Item, String>();



    private static Configuration config;


    public static void InitConfig(String FileLoc){

        config = new Configuration(new File(FileLoc + "/tm1990's mods/MiscItemsAndBlocksConfig.cfg"));

        config.addCustomCategoryComment(CATEGORY_CLIENT_SETTINGS, "Client side only settings. Settings that does not affect gameplay");
        config.addCustomCategoryComment(CATEGORY_SERVER_SETTINGS, "Server side settings which can affect gameplay");

        config.addCustomCategoryComment(CATEGORY_BLOCKS, "This allows you to enabled/disable the different blocks from the mod");
        config.addCustomCategoryComment(CATEGORY_ITEMS, "This allows you to enabled/disable the different items from the mod");

        config.setCategoryRequiresMcRestart(CATEGORY_BLOCKS, true);
        config.setCategoryRequiresMcRestart(CATEGORY_ITEMS, true);



        LoadConfig();

    }

    public static void LoadConfig(){


        //Client side configs
        HDTextures = !config.getBoolean("Should HD textures be used for some blocks?", CATEGORY_CLIENT_SETTINGS, true,  "Disable the use of textures bigger then 16x16");
        SpawnParticles = config.getBoolean("Spawn particles?", CATEGORY_CLIENT_SETTINGS, true, "Should the mod use partciles for some things");
        DisableCustomItemModels = config.getBoolean("Disable custom item models?",CATEGORY_CLIENT_SETTINGS, false, "Disable the use of custom models on some items");

        LeveOfLogging = config.get(CATEGORY_CLIENT_SETTINGS, "What level of debug out should the mod have? 1/2/3", 1).getInt();



        //Server side configs
        AllowPowerArmorEffects = config.getBoolean("Enable Powerarmor effects?", CATEGORY_SERVER_SETTINGS, true, "Disable the effects the power armor gives");
        AllowCustomPillars = config.getBoolean("Enable pillars for all vanilla blocks?", CATEGORY_SERVER_SETTINGS, true, "Enable the use of pillars of all blocks");




        if(config.hasChanged())
            config.save();


    }


    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if(event.modID.equalsIgnoreCase(Reference.Mod_Id)) {
            LoadConfig();
        }
    }

    public static Configuration GetConfigFile(){
        return config;
    }


    public static boolean IsBlockEnabled(Block block){
        boolean bl = config.get(CATEGORY_BLOCKS, "Enable " + BlockConfigNames.get(block).replace("tile.", "").replace(".name", ""), true).getBoolean(true);

        if(config.hasChanged())
        config.save();

        return bl;
    }



    public static boolean IsItemEnabled(Item item){
        boolean bl = config.get(CATEGORY_ITEMS, "Enable " + ItemConfigNames.get(item).replace("item.", "").replace(".name", ""), true).getBoolean(true);

        if(config.hasChanged())
        config.save();

        return bl;
    }
}
