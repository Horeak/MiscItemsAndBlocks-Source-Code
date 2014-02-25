package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerLensBench;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLensBench;

public class ServerLensBenchPacketDone extends IPacket{

	boolean Color;
	int Red, Green, Blue, Power, Strength, x, y, z;
	boolean TransferPower, Damage, Redstone;
	
	public ServerLensBenchPacketDone(){}
	public ServerLensBenchPacketDone(boolean Color, int Red, int Green, int Blue, int Power, int Strength, boolean TransferPower, boolean Damage, boolean Redstone, int X, int Y, int Z){
		
		
		if(Strength <= 0)
			Strength = 1;
		
		this.Color = Color;
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		this.Power = Power;
		this.Strength = Strength;
		x = X;
		y = Y;
		z = Z;
		this.TransferPower = TransferPower;
		this.Damage = Damage;
		this.Redstone = Redstone;
		
			
		
	}
	
	@Override
	public void read(DataInputStream data) throws IOException {
		
		Color = data.readBoolean();
		if(Color){
			Red = data.readInt();
			Green = data.readInt();
			Blue = data.readInt();
		}
		
		Power = data.readInt();
		Strength = data.readInt();
		
		x = data.readInt();
		y = data.readInt();
		z = data.readInt();
		
		TransferPower = data.readBoolean();
		Damage = data.readBoolean();
		Redstone = data.readBoolean();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		data.writeBoolean(Color);
		if(Color){
			data.writeInt(Red);
			data.writeInt(Green);
			data.writeInt(Blue);
			
		}
		
		data.writeInt(Power);
		data.writeInt(Strength);
		
		data.writeInt(x);
		data.writeInt(y);
		data.writeInt(z);
		
		data.writeBoolean(TransferPower);
		data.writeBoolean(Damage);
		data.writeBoolean(Redstone);
		
		
	}

	@Override
	public void execute(EntityPlayer player) {
		
		
		if(player.openContainer instanceof ContainerLensBench){
			ContainerLensBench container = (ContainerLensBench)player.openContainer;
			
			TileEntityLensBench tile = container.tile;
			
			
			if(tile.xCoord == x && tile.yCoord == y && tile.zCoord == z){
			if(tile.getStackInSlot(0) != null && tile.getStackInSlot(0).getItem() == ModItems.Lens){
			if(tile.getStackInSlot(0).stackTagCompound == null)
    			tile.getStackInSlot(0).setTagCompound(new NBTTagCompound());
			
			tile.getStackInSlot(0).stackTagCompound.setBoolean("Color", Color);
    		
    		if(Color){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Color", true);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Red", Red);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Green", Green);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Blue", Blue);
    		}
    		
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Power", Power);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Strength", Strength);
    		
    		tile.getStackInSlot(0).stackTagCompound.setInteger("PowerUse", (((Power) * 3) + ((Strength / 4))) + (Damage ? 5 : 0) + (TransferPower ? 2 : 0) + (Redstone ? 1 : 0));
    		
    		if(tile.getStackInSlot(0).stackTagCompound.getInteger("PowerUse") < 0){
        		tile.getStackInSlot(0).stackTagCompound.setInteger("PowerUse", 0);
    		}

    		
    		if(TransferPower){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("TransferPower", true);
    		}else{
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("TransferPower", false);
    		}
    			
    		
    		
    		
    		if(Redstone){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Redstone", true);
    		}else{
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Redstone", false);
    		}
    		
    		
    		if(!Damage){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Safe", true);
    		}else{
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Safe", false);
    		}
    			
    		
    		
    		
    	}
			
		}
			
		}
	}
		
	}


