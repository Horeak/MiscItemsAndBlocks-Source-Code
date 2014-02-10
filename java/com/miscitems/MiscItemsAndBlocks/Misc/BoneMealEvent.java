package com.miscitems.MiscItemsAndBlocks.Misc;

import net.minecraftforge.event.entity.player.BonemealEvent;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlockOrangeSapling;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;

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