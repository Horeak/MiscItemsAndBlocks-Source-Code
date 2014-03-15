package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;


import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;
import net.minecraft.entity.player.EntityPlayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientLaserUpdatePacket extends IPacket {


    int x, y ,z;
    int red, blue, green;
    int strength, power;

    public ClientLaserUpdatePacket(){}
    public ClientLaserUpdatePacket(int x, int  y, int z, int red, int green, int blue, int strength, int power){
        this.x = x;
        this.y = y;
        this.z = z;

        this.red = red;
        this.green = green;
        this.blue = blue;

        this.strength = strength;
        this.power = power;

    }

    @Override
    public void read(DataInputStream data) throws IOException {
        x = data.readInt();
        y = data.readInt();
        z = data.readInt();

        red = data.readInt();
        green = data.readInt();
        blue = data.readInt();

        strength = data.readInt();
        power = data.readInt();
    }

    @Override
    public void write(DataOutputStream data) throws IOException {

        data.writeInt(x);
        data.writeInt(y);
        data.writeInt(z);

        data.writeInt(red);
        data.writeInt(green);
        data.writeInt(blue);

        data.writeInt(strength);
        data.writeInt(power);
    }

    @Override
    public void execute(EntityPlayer player) {

        if(player.worldObj.getTileEntity(x, y, z) instanceof TileEntityLaser){
            TileEntityLaser tile = (TileEntityLaser)player.worldObj.getTileEntity(x, y, z);

            tile.Red = red;
            tile.Green = green;
            tile.Blue = blue;

            tile.Strength = strength;
            tile.Power = power;




        }

    }
}
