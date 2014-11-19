package com.miscitems.MiscItemsAndBlocks.Utils.Laser.Events;

import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserInstance;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.Entity;

@Cancelable
public class LaserActionEntityEvent extends Event {

    public LaserInstance instance;
    public Entity entityHit;

    public LaserActionEntityEvent(LaserInstance laser, Entity ent){
       this.instance = laser;
       this.entityHit = ent;

    }
}
