package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

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
