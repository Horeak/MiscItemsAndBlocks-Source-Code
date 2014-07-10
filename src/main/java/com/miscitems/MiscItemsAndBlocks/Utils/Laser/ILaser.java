package com.miscitems.MiscItemsAndBlocks.Utils.Laser;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public interface ILaser {

	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */
	
public void performActionOnEntitiesClient(List<Entity> entities, int direction, ILaserProvider laser);
public void performActionOnEntitiesServer(List<Entity> entities, int direction, ILaserProvider laser);
public void performActionOnBoth(List<Entity> entities, int direction, ILaserProvider laser);



public boolean shouldRenderLaser(EntityPlayer player, int direction);
}