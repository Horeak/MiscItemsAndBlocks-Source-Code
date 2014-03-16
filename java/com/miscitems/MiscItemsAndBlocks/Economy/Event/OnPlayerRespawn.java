package com.miscitems.MiscItemsAndBlocks.Economy.Event;

// These are methods in the EventHandler class, in case you don't know that by now

// we need to add this new event - it is called for every living entity upon death

import com.miscitems.MiscItemsAndBlocks.Economy.Lib.MoneyStorage;
import com.miscitems.MiscItemsAndBlocks.Economy.Main.Economy;
import com.miscitems.MiscItemsAndBlocks.Economy.Network.Packets.SyncPlayerPropsPacket;
import com.miscitems.MiscItemsAndBlocks.Economy.Proxies.ServerProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class OnPlayerRespawn{

@SubscribeEvent
public void onLivingDeathEvent(LivingDeathEvent event)
        {

        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
        {

        NBTTagCompound playerData = new NBTTagCompound();
        ((MoneyStorage)(event.entity.getExtendedProperties(MoneyStorage.EXT_PROP_NAME))).saveNBTData(playerData);
        Economy.proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName(), playerData);
            ServerProxy.saveProxyData((EntityPlayer) event.entity);
        }



        }

// we already have this event, but we need to modify it some
@SubscribeEvent
public void onEntityJoinWorld(EntityJoinWorldEvent event)
        {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
        {

        NBTTagCompound playerData = Economy.proxy.getEntityData(((EntityPlayer) event.entity).getDisplayName());
        if (playerData != null) {
        ((MoneyStorage)(event.entity.getExtendedProperties(MoneyStorage.EXT_PROP_NAME))).loadNBTData(playerData);
        }
            Economy.packetPipeline.sendTo(new SyncPlayerPropsPacket((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);
        }

            if(event.world.getGameRules().getGameRuleBooleanValue("keepInventory") == false && !event.world.isRemote){

            if(event.world.difficultySetting == EnumDifficulty.HARD){
                if(event.entity instanceof EntityPlayer){
                    EntityPlayer player = (EntityPlayer)event.entity;
                    MoneyStorage.get(player).SetMoney(0);


                }

            }else if(event.world.difficultySetting == EnumDifficulty.NORMAL){
                if(event.entity instanceof EntityPlayer){
                    EntityPlayer player = (EntityPlayer)event.entity;

                    if(MoneyStorage.get(player).GetMoney() > 0)
                        MoneyStorage.get(player).SetMoney(MoneyStorage.get(player).GetMoney() - 500);

                }



            }else if(event.world.difficultySetting == EnumDifficulty.EASY){

                if(event.entity instanceof EntityPlayer){
                    EntityPlayer player = (EntityPlayer)event.entity;
                    if(MoneyStorage.get(player).GetMoney() > 0)
                        MoneyStorage.get(player).SetMoney(MoneyStorage.get(player).GetMoney() - 100);

                }




            }else{
                if(event.world.difficultySetting == EnumDifficulty.PEACEFUL)
                if(event.entity instanceof EntityPlayer){
                    EntityPlayer player = (EntityPlayer)event.entity;
                    if(MoneyStorage.get(player).GetMoney() > 0)
                        MoneyStorage.get(player).SetMoney(MoneyStorage.get(player).GetMoney() - 50);

                }


            }

        }

        }

}