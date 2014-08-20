package com.miscitems.MiscItemsAndBlocks.Utils;

import MiscUtils.Config.ConfigBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config extends ConfigBase {
    protected Configuration config;

    public static boolean SpawnParticles;
    public static boolean AllowPowerArmorEffects;
    public static boolean DisableCustomItemModels;
    public static boolean AllowCustomPillars;


    public Config(String Loc){

        config = new Configuration(new File(Loc + "/tm1990's mods/MiscItemsAndBlocks.cfg"));
        InitConfig();
    }

    @Override
    public Configuration GetConfigFile() {
        return config;
    }

    @Override
    public void InitConfig() {

        config.addCustomCategoryComment(CATEGORY_CLIENT_SETTINGS, "Client side only settings. Settings that does not affect gameplay");
        config.addCustomCategoryComment(CATEGORY_SERVER_SETTINGS, "Server side settings which can affect gameplay");

        config.addCustomCategoryComment(CATEGORY_BLOCKS, "This allows you to enabled/disable the different blocks from the mod");
        config.addCustomCategoryComment(CATEGORY_ITEMS, "This allows you to enabled/disable the different items from the mod");

        config.addCustomCategoryComment(CATEGORY_WORLDGEN, "This allows you to disable and change different world generation types");

        config.setCategoryRequiresMcRestart(CATEGORY_BLOCKS, true);
        config.setCategoryRequiresMcRestart(CATEGORY_ITEMS, true);

        config.setCategoryRequiresMcRestart(CATEGORY_WORLDGEN, true);

        LoadConfig();
    }

    @Override
    public void LoadConfig() {

        //Client side configs
        SpawnParticles = config.getBoolean("Spawn particles?", CATEGORY_CLIENT_SETTINGS, true, "Should the mod use partciles for some things");
        DisableCustomItemModels = config.getBoolean("Disable custom item models?",CATEGORY_CLIENT_SETTINGS, false, "Disable the use of custom models on some items");


        //Server side configs
        AllowPowerArmorEffects = config.getBoolean("Enable Powerarmor effects?", CATEGORY_SERVER_SETTINGS, true, "Disable the effects the power armor gives");
        AllowCustomPillars = config.getBoolean("Enable pillars for all vanilla blocks?", CATEGORY_SERVER_SETTINGS, true, "Enable the use of pillars of all blocks");

        if(config.hasChanged())
            config.save();
    }

    public  boolean IsBlockEnabled(Block block){
        if(BlockConfigNames.get(block) == null)
            return false;


        boolean bl = GetConfigFile().get(CATEGORY_BLOCKS, "Enable " + BlockConfigNames.get(block).replace("tile.", "").replace(".name", ""), true).getBoolean(true);

        if(GetConfigFile().hasChanged())
            GetConfigFile().save();

        return bl;
    }



    public  boolean IsItemEnabled(Item item){
        if(ItemConfigNames.get(item) == null)
            return false;

        boolean bl = GetConfigFile().get(CATEGORY_ITEMS, "Enable " + ItemConfigNames.get(item).replace("item.", "").replace(".name", ""), true).getBoolean(true);

        if(GetConfigFile().hasChanged())
            GetConfigFile().save();

        return bl;
    }


    public  boolean IsWorldGeneratorEnabled(String WorldGen){
        boolean bl = GetConfigFile().get(CATEGORY_WORLDGEN, "Enable Worldgen: " + WorldGen, true).getBoolean(true);

        if(GetConfigFile().hasChanged())
            GetConfigFile().save();

        return bl;
    }

    public  int GetWorldGenerationChance(String WorldGen, int def){
        if(IsWorldGeneratorEnabled(WorldGen)){
            int t = GetConfigFile().get(CATEGORY_WORLDGEN, "The amount of times it will try to spawn in a chunk: " + WorldGen, def).getInt(def);

            if(GetConfigFile().hasChanged())
                GetConfigFile().save();

            return t;


        }
        return 0;
    }

    public boolean CanSpawnParticles(){
        return GetConfigFile().getBoolean("Can Spawn Particles", CATEGORY_CLIENT_SETTINGS, true, "Should particles be enabled?");
    }

}
