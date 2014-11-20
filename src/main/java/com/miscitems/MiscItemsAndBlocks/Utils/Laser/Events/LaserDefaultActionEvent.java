package com.miscitems.MiscItemsAndBlocks.Utils.Laser.Events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;

public class LaserDefaultActionEvent {


    //TODO Change damage/effects?
    @SubscribeEvent
    public void event(LaserActionEntityEvent event){

        if(event.entityHit == null || event.instance == null)
            return;

        if(event.entityHit instanceof EntityPlayer){
            EntityPlayer pl = (EntityPlayer)event.entityHit;
            if(pl.capabilities.isCreativeMode)
                return;
        }


        if(event.instance.Damage && event.instance.power > 1) {
            event.entityHit.setFire(event.instance.power);
            event.entityHit.attackEntityFrom(new DamageSource("laser.damage"), event.instance.power - 2);

        }
     }
}
