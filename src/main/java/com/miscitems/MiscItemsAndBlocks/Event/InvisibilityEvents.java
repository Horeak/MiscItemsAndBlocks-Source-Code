package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Utils.InvisibilityUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

public class InvisibilityEvents {



    @SubscribeEvent
         public void CancelRenderEvent(RenderPlayerEvent.Pre event){
        if(InvisibilityUtils.GetList().contains(event.entityPlayer)){
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void CancelRenderEvent(RenderPlayerEvent.Post event){
        if(InvisibilityUtils.GetList().contains(event.entityPlayer)){
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void CancelMobAttack(LivingSetAttackTargetEvent event){
        if(event.target != null && event.target instanceof EntityPlayer && event.entity instanceof EntityMob){
            EntityPlayer player = (EntityPlayer)event.target;
            if(InvisibilityUtils.GetList().contains(player)){
                ((EntityMob) event.entity).setAttackTarget(null);
            }
        }
    }

    @SubscribeEvent
    public void CorrectTargetIfInvis(LivingEvent.LivingUpdateEvent event){
        if(event.entity instanceof EntityMob){
            EntityMob mob = (EntityMob)event.entity;
            if(mob.getAttackTarget() != null && mob.getAttackTarget() instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer)mob.getAttackTarget();
                if(InvisibilityUtils.GetList().contains(player))
                    mob.setAttackTarget(null);
            }
        }
        }


}
