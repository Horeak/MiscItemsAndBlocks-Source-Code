package com.miscitems.MiscItemsAndBlocks.Laser;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface ILaser {

	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */
	
public void performActionOnEntitiesClient(List<Entity> entities, int direction, ILaserProvider laser);
public void performActionOnEntitiesServer(List<Entity> entities, int direction, boolean Redstone, boolean Power, boolean Safe, int LensPower);

public boolean shouldRenderLaser(EntityPlayer player, int direction);
}