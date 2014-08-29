package com.miscitems.MiscItemsAndBlocks.Utils;

import MiscUtils.Config.ConfigBase;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config extends ConfigBase {

    public static boolean SpawnParticles;
    public static boolean AllowPowerArmorEffects;
    public static boolean DisableCustomItemModels;
    public static boolean AllowCustomPillars;

    public static final String CATEGORY_CLIENT_SETTINGS = "Client Settings";
    public static final String CATEGORY_SERVER_SETTINGS = "Server Settings";

    public Config(String Loc){
        super(new Configuration(new File(Loc + "/tm1990's mods/MiscItemsAndBlocks.cfg")));
        InitConfig();
    }


    @Override
    public void InitConfig() {

        RegisterCategory( CATEGORY_SERVER_SETTINGS, "Client side only settings. Settings that does not affect gameplay");
        RegisterCategory(CATEGORY_SERVER_SETTINGS, "Server side settings which can affect gameplay");


        LoadConfig();
    }

    @Override
    public void LoadConfig() {

        //Client side configs
        SpawnParticles = GetConfigFile().getBoolean("Spawn particles?", CATEGORY_CLIENT_SETTINGS, true, "Should the mod use partciles for some things");
        DisableCustomItemModels = GetConfigFile().getBoolean("Disable custom item models?",CATEGORY_CLIENT_SETTINGS, false, "Disable the use of custom models on some items");


        //Server side configs
        AllowPowerArmorEffects = GetConfigFile().getBoolean("Enable Powerarmor effects?", CATEGORY_SERVER_SETTINGS, true, "Disable the effects the power armor gives");
        AllowCustomPillars = GetConfigFile().getBoolean("Enable pillars for all vanilla blocks?", CATEGORY_SERVER_SETTINGS, true, "Enable the use of pillars of all blocks");

        if(GetConfigFile().hasChanged())
            GetConfigFile().save();
    }



    public boolean CanSpawnParticles(){
        return GetConfigFile().getBoolean("Can Spawn Particles", CATEGORY_CLIENT_SETTINGS, true, "Should particles be enabled?");
    }

}
