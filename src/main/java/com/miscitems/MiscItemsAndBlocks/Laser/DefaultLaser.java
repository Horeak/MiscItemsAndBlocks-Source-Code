package com.miscitems.MiscItemsAndBlocks.Laser;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;

import java.util.List;

public class DefaultLaser implements ILaser {

	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */
	
@Override
public void performActionOnEntitiesServer(List<Entity> entities, int direction, ILaserProvider laser) {
	
	
}

@Override
public void performActionOnEntitiesClient(List<Entity> entities, int direction, ILaserProvider laser) {
	
}

@Override
public void performActionOnBoth(List<Entity> entities, int direction, ILaserProvider laser) {
	
	
	
	if(laser.DoesDamage() && laser.GetLensPower() > 1){
		if(entities.size() > 0)
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).setFire(laser.GetLensPower());
			entities.get(i).attackEntityFrom(new DamageSource("laser.damage"), laser.GetLensPower() - 2);
			
			
		}
		
		
		
	}
}



@Override
public boolean shouldRenderLaser(EntityPlayer player, int direction) {
return true;
}

}