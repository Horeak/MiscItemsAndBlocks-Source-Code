package com.miscitems.MiscItemsAndBlocks.Economy.Events;

import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyUtils;
import com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ServerProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class FirstJoinEvent {


    @SubscribeEvent
    public void PlayerJoin(EntityJoinWorldEvent event){


        if(!event.world.isRemote){
            if(event.entity instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer)event.entity;

                System.out.println("t");

                if(!ServerProxy.JoinedPlayers.contains(player)){

                   ServerProxy.JoinedPlayers.add(player);
                    MoneyUtils.SetMoneyForPlayer(player, 1000);




                    }


                }

            }
        }

}
