package com.miscitems.MiscItemsAndBlocks.LibMisc;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class DefaultLaser implements ILaser {

@Override
public void performActionOnEntitiesServer(List<Entity> entities, int direction) {

}

@Override
public void performActionOnEntitiesClient(List<Entity> entities, int direction) {

}

@Override
public void performActionOnEntitiesBoth(List<Entity> entities, int direction) {

}

@Override
public boolean shouldRenderLaser(EntityPlayer player, int direction) {
return true;
}

}