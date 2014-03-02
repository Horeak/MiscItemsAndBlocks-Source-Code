package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DisarmStickEvent {

	@SubscribeEvent
	public void event(EntityItemPickupEvent event){

		if(event.item.getEntityItem().getItem() == ModItems.DisarmStick){
			if(!event.entityPlayer.capabilities.isCreativeMode){
				event.setCanceled(true);
			}
		}
		
	}
}
