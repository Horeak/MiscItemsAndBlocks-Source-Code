package com.miscitems.MiscItemsAndBlocks.Utils.Handlers;

import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import net.minecraft.world.World;

public class ParticleHelper {


    boolean SpawnParticle = true;
    World world;

    public ParticleHelper(World world){

        this.world = world;
        SpawnParticle = ConfigUtils.SpawnParticles;
    }

    public void SpawnParticle(String particleName, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed){

        if(SpawnParticle){
            world.spawnParticle(particleName, x, y, z, xSpeed, ySpeed, zSpeed);
            LogHandler.Debug("Spawned Particle: " + particleName, 3);
        }
    }


}
