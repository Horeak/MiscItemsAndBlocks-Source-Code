package com.miscitems.MiscItemsAndBlocks.Utils.Laser.Events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.DamageSource;

public class LaserDefaultActionEvent {

    @SubscribeEvent
    public static void event(LaserActionEntityEvent event){

        if(event.instance.Damage && event.instance.power > 1) {
            event.entityHit.setFire(event.instance.power);
            event.entityHit.attackEntityFrom(new DamageSource("laser.damage"), event.instance.power - 2);

        }
     }
}
