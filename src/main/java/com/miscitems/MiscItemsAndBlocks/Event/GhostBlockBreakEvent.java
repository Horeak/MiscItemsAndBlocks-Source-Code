package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityGhostBlock;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

public class GhostBlockBreakEvent {


    @SubscribeEvent
    public void Event(BlockEvent.BreakEvent event){

        if(event.block == ModBlocks.GhostBlock){
        if(event.world.getTileEntity(event.x, event.y, event.z) instanceof TileEntityGhostBlock){
            TileEntityGhostBlock tile =  (TileEntityGhostBlock)event.world.getTileEntity(event.x, event.y, event.z);


            if(tile.Locked){
            if(tile.Placer != "" && !event.getPlayer().getDisplayName().equalsIgnoreCase(tile.Placer) && !event.getPlayer().capabilities.isCreativeMode){
                event.setCanceled(true);

            }
            }




        }
        }

    }
}
