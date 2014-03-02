package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Main.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerFirstJoinEvent {

	
	@SubscribeEvent 
	public void PlayerJoin(EntityJoinWorldEvent event){

		if(!event.world.isRemote){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			
			if(!Main.proxy.JoinedPlayers.contains(player)){
		
				Main.proxy.JoinedPlayers.add(player);
			if(!player.inventory.hasItem(ModItems.GuideBook)){
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.GuideBook));
			}
			
			
		}

		}
		}
	}
}
