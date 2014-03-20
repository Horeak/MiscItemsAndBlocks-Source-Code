package com.miscitems.MiscItemsAndBlocks.Lib;

import net.minecraftforge.common.config.Configuration;


public class ModConfig {

	
	public static Configuration configuration;
	



	/** Booleans **/
	
	public static boolean SpawnParticles;
	public static boolean AllowPowerArmorEffects;

	

	
	
	
	
	
	
	
	
	public static void Init(Configuration config){
		
		configuration = config;
		
        config.load();
	
        SpawnParticles = config.get("Client Settings", "Spawn particles?", true).getBoolean(true);
        AllowPowerArmorEffects = config.get("Server Settings", "Enable Powerarmor effects?", true).getBoolean(true);
        
        
        config.save();
		
	}

	
}
