package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Client.SyncPlayerPropsPacket;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.Magic.MagicInfoStorage;
import com.miscitems.MiscItemsAndBlocks.Utils.Proxies.ServerProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class OnPlayerRespawn{

@SubscribeEvent
public void onLivingDeathEvent(LivingDeathEvent event)
        {

        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
        {



        NBTTagCompound playerData = new NBTTagCompound();
        ((MagicInfoStorage)(event.entity.getExtendedProperties(MagicInfoStorage.EXT_PROP_NAME))).saveNBTData(playerData);
            Main.proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName(), playerData);
            ServerProxy.saveProxyData((EntityPlayer) event.entity);
        }



        }

@SubscribeEvent
public void onEntityJoinWorld(EntityJoinWorldEvent event)
        {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
        {

        NBTTagCompound playerData = Main.proxy.getEntityData(((EntityPlayer) event.entity).getDisplayName());
        if (playerData != null) {
        ((MagicInfoStorage)(event.entity.getExtendedProperties(MagicInfoStorage.EXT_PROP_NAME))).loadNBTData(playerData);
        }
            PacketHandler.sendToPlayer(new SyncPlayerPropsPacket((EntityPlayer) event.entity), (EntityPlayer) event.entity);
        }


        }

}