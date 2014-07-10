package com.miscitems.MiscItemsAndBlocks.Utils.Handlers;

import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import net.minecraft.world.World;

import java.util.Random;

public class ParticleHelper {


    World world;

    public ParticleHelper(World world){

        this.world = world;
    }

    public void SpawnParticle(String particleName, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed){

        if(ConfigUtils.SpawnParticles){
            world.spawnParticle(particleName, x, y, z, xSpeed, ySpeed, zSpeed);
            LogHandler.Debug("Spawned Particle: " + particleName, 3);
        }
    }


    public void SpawnParticleAroundBlock(String Name, double x, double y, double z, double rn){
        Random rand = new Random();
        float f1 = (float) y + 0.6F + rand.nextFloat() * 6.0F / 16.0F;
        double remove = rn - 0.2;

        SpawnParticle(Name, (x + (rand.nextFloat() - remove)),f1,(z + (rand.nextFloat() - remove)), 0,0,0);

    }

}
