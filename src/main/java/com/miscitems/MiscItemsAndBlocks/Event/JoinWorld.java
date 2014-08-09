package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Network.Client.SyncPlayerPropsPacket;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class JoinWorld {


    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event)
    {

        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
            PacketHandler.sendToPlayer(new SyncPlayerPropsPacket(((EntityPlayer) event.entity)), (EntityPlayer) event.entity);
    }
}
