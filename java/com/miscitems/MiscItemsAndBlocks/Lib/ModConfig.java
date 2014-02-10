package com.miscitems.MiscItemsAndBlocks.Lib;

import net.minecraftforge.common.config.Configuration;


public class ModConfig {

	
	public static Configuration configuration;
	



	/** Booleans **/
	public static boolean BlastProofOverRe;
	
	public static boolean SpawnParticles;
	public static boolean AllowFlightChest;

	

	
	
	
	
	
	
	
	
	public static void Init(Configuration config){
		
		configuration = config;
		
        config.load();
	
        SpawnParticles = config.get("Settings", "Spawn particles?", true).getBoolean(true);
        AllowFlightChest = config.get("Settings", "Enable flight chestplate?", true).getBoolean(true);
        
        
        config.save();
		
	}
	
    public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }
	
	
}
