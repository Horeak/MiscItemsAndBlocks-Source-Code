package com.miscitems.MiscItemsAndBlocks.Sounds;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class sounds {

	public static void onEntityPlay(String name,World world,Entity entityName,float volume ,float pitch){
        world.playSoundAtEntity(entityName,("miscitems:" + name), (float)volume,(float) pitch);
}
		
	
		
	}