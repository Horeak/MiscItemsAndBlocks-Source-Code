package com.miscitems.MiscItemsAndBlocks.Network.Client;


import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaser;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientLaserUpdatePacket extends AbstractPacket {


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
    public void fromBytes(ByteBuf buf, Side side) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();

        red = buf.readInt();
        green = buf.readInt();
        blue = buf.readInt();

        strength = buf.readInt();
        power = buf.readInt();

    }

    @Override
    public void toBytes(ByteBuf buf, Side side) {

            buf.writeInt(x);
            buf.writeInt(y);
            buf.writeInt(z);

            buf.writeInt(red);
            buf.writeInt(green);
            buf.writeInt(blue);

            buf.writeInt(strength);
            buf.writeInt(power);

    }

    @Override
    public void onMessage(Side side, EntityPlayer player) {

        if(Minecraft.getMinecraft().thePlayer.worldObj.getTileEntity(x, y, z) instanceof TileEntityLaser){
            TileEntityLaser tile = (TileEntityLaser)Minecraft.getMinecraft().thePlayer.worldObj.getTileEntity(x, y, z);

            tile.Red = red;
            tile.Green = green;
            tile.Blue = blue;

            tile.Strength = strength;
            tile.Power = power;


            tile.Valid = true;


             }
    }
}
