package com.miscitems.MiscItemsAndBlocks.Event;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Random;

public class OnEntityDeathCrystalBlade {

    @SubscribeEvent
    public void Event(LivingDeathEvent event){

        System.out.println("t");

        if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)event.source.getEntity();

            if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == ModItems.CrystalBlade){
                ItemStack Sword = player.inventory.getCurrentItem();


                if(Sword.getTagCompound() != null){
                    if(Sword.getTagCompound().hasKey("Looting")){
                        for(int i = 0; i < event.entity.capturedDrops.size(); i++){
                            ItemStack tmpStack = event.entity.capturedDrops.get(i).getEntityItem();
                            if(tmpStack != null && tmpStack.getItem() != null) {
                                tmpStack.stackSize += new Random().nextInt(10);

                                event.entity.entityDropItem(tmpStack, new Random().nextFloat());
                            }

                        }

                    }

                }else{
                    return;
                }
            }

        }

    }
}
