package com.miscitems.MiscItemsAndBlocks.Economy.Tick;

import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyStorage;
import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyUtils;
import com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ServerProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;

public class ServerTickHandler {




    //DEBUG! this is a debug feature to test the Economy system. Hold shift to give that amount of money specified below
    @SubscribeEvent
    public void PlayerTick(TickEvent.PlayerTickEvent event){
        if(event.type == TickEvent.Type.PLAYER){
            if(!event.player.worldObj.isRemote)

            if(event.player.isSneaking()){

                MoneyStorage.get(event.player).SetMoney(1000);


            }


        }

    }

    }

