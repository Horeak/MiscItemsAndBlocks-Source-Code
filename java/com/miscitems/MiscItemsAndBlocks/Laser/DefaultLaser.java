package com.miscitems.MiscItemsAndBlocks.Laser;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;

public class DefaultLaser implements ILaser {

	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */
	
@Override
public void performActionOnEntitiesServer(List<Entity> entities, int direction, boolean Redstone, boolean Power, boolean Damage, int LensPower) {
	
	if(Damage && LensPower > 1){
		if(entities.size() > 0)
		for(int i = 0; i < entities.size(); i++){
			entities.get(i).setFire(5);
			entities.get(i).attackEntityFrom(new DamageSource("laser.damage"), LensPower - 2);
			
			
		}
		
		
		
	}
	
	
}

@Override
public void performActionOnEntitiesClient(List<Entity> entities, int direction, ILaserProvider laser) {
	
}


@Override
public boolean shouldRenderLaser(EntityPlayer player, int direction) {
return true;
}

}