package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Block.Plants.ModBlockOrangeSapling;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BoneMealEvent
{



        @EventHandler
        public void bonemealUsed(BonemealEvent event)
        {

        if(event.world.getBlock(event.x, event.y, event.z) == ModBlocks.OrangeSapling)
        {
        ((ModBlockOrangeSapling)ModBlocks.OrangeSapling).markOrGrowMarked(event.world, event.x, event.x, event.z, event.world.rand);
        event.setResult(Result.ALLOW);
        }

        }
}