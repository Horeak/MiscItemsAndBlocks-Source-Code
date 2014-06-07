package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;


import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientLaserUpdatePacket implements IMessage, IMessageHandler<ClientLaserUpdatePacket, IMessage> {


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
    public void fromBytes(ByteBuf buf) {
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
    public void toBytes(ByteBuf buf) {

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
      public IMessage onMessage(ClientLaserUpdatePacket message, MessageContext ctx) {

        if(Minecraft.getMinecraft().thePlayer.worldObj.getTileEntity(message.x,message. y, message.z) instanceof TileEntityLaser){
            TileEntityLaser tile = (TileEntityLaser)Minecraft.getMinecraft().thePlayer.worldObj.getTileEntity(message.x, message.y, message.z);

            tile.Red = message.red;
            tile.Green = message.green;
            tile.Blue = message.blue;

            tile.Strength = message.strength;
            tile.Power = message.power;


            tile.Valid = true;


             }
        return null;
    }
}
