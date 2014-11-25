package com.miscitems.MiscItemsAndBlocks.Utils.Laser;

import com.miscitems.MiscItemsAndBlocks.Utils.Laser.Events.LaserActionEntityEvent;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import javax.vecmath.Vector3d;
import java.awt.*;

public class LaserInstance {

    //TODO Add invisible laser option and laser googles or something similar to allow you to see the lasers.

    public World world;
    public Vector3d Position;
	
    public double strength = 100D;
    public int side = -1;

    public int power = 0;

    public boolean Damage = false;
    public boolean Redstone = false;
    public boolean TransPower = false;

    public int red = 255;
    public int green = 0;
    public int blue = 0;



    public LaserInstance(World world, Vector3d pos, Color c){
        this.red = c.getRed();
        this.green = c.getGreen();
        this.blue = c.getBlue();

        this.world = world;

        this.Position = pos;
    }

    public LaserInstance(World world, Vector3d pos, Color c, int strength){
        this(world, pos, c);

        this.strength = strength;
    }


    public LaserInstance(World world, Vector3d pos, Color c, int strength, int side){
        this(world, pos, c, strength);

        this.side = side;
    }


    public LaserInstance setColor(Color color){
        int r = color.getRed(), g = color.getGreen(), b = color.getBlue();

        this.red = r;
        this.blue = b;
        this.green = g;

        return this;
    }


    public double GetPowerUsage(){
        return LaserUtil.GetLensPowerUsaeg(power, strength, Damage, TransPower, Redstone);
    }

    //TODO Change consumption rate?
    public double GetPowerTransferAmount(){
        return GetPowerUsage() / 180;
    }


    //TODO Add block mining functionality?
    public void ActionOn(Vector3d pos){

        if(world.getTileEntity((int)pos.x, (int)pos.y, (int)pos.z) != null){
            TileEntity te = world.getTileEntity((int)pos.x, (int)pos.y, (int)pos.z);

            if(te instanceof ILaserReciver){
                ILaserReciver res = (ILaserReciver)te;

                res.LaserReceiveOnSide(this, ForgeDirection.getOrientation(side));

            }
        }

    }

    public void ActionOnEntity(Entity ent){

        LaserActionEntityEvent event = new LaserActionEntityEvent(this, ent);

        if(!event.isCanceled()){
            MinecraftForge.EVENT_BUS.post(event);

        }
    }

}