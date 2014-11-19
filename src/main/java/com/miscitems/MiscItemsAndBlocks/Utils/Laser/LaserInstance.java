package com.miscitems.MiscItemsAndBlocks.Utils.Laser;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.util.ForgeDirection;

import javax.vecmath.Vector3d;
import java.awt.*;

public class LaserInstance {

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

    public LaserInstance setColor(int r, int g, int b){
        this.red = r;
        this.blue = b;
        this.green = g;

        return this;
    }

    public double GetPowerUsage(){
        return LaserUtil.GetLensPowerUsaeg(power, strength, Damage, TransPower, Redstone);
    }

    public double GetPowerTransferAmount(){
        return GetPowerUsage() / 250;
    }



public LaserInstance readFromNBT(NBTTagCompound tag) {
    strength = tag.getDouble("strength");
    side = tag.getInteger("side");

    power = tag.getInteger("power");

    Damage = tag.getBoolean("Damage");
    Redstone = tag.getBoolean("Redstone");
    TransPower = tag.getBoolean("TransPower");

    red = tag.getInteger("red");
    green = tag.getInteger("green");
    blue = tag.getInteger("blue");

    double x = tag.getDouble("xCord");
    double y = tag.getDouble("yCord");
    double z = tag.getDouble("zCord");

    Position = new Vector3d(x,y,z);

    int id = tag.getInteger("dimId");
    WorldProvider prov = WorldProvider.getProviderForDimension(id);

    if(prov != null)
        world = prov.worldObj;

return this;
}



public NBTTagCompound writeToNBT(NBTTagCompound tag) {
    tag.setDouble("strength", strength);
    tag.setInteger("side", side);

    tag.setInteger("power", power);

    tag.setBoolean("Damage", Damage);
    tag.setBoolean("Redstone", Redstone);
    tag.setBoolean("TransPower", TransPower);

    tag.setInteger("red", red);
    tag.setInteger("green", green);
    tag.setInteger("blue", blue);

    tag.setDouble("xCord", Position.x);
    tag.setDouble("yCord", Position.y);
    tag.setDouble("zCord", Position.z);

    tag.setInteger("dimId", world.provider.dimensionId);

return tag;
}


public LaserInstance copy() {
    LaserInstance laser = new LaserInstance(world, Position, new Color(red, green, blue));
    NBTTagCompound tag = new NBTTagCompound();
    writeToNBT(tag);
    laser.readFromNBT(tag);
    return laser;
}
    //TODO Add block mining functionality and entity ignite
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


    }

}