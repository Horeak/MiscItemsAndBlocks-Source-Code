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
	
	public ServerLensBenchPacketDone(){}
	public ServerLensBenchPacketDone(boolean Color, int Red, int Green, int Blue, int Power, int Strength, int X, int Y, int Z){
		this.Color = Color;
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		this.Power = Power;
		this.Strength = Strength;
		x = X;
		y = Y;
		z = Z;
			
		
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
    		
    		if(Color){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Color", true);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Red", Red);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Green", Green);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Blue", Blue);
    		}else{
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Color", false);
    		}
    		
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Power", Power);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Strength", Strength);
    		
    		
    		if(tile.getStackInSlot(1) != null){
    			tile.decrStackSize(1, 1);
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("TransferPower", true);
    		}
    		
    		if(tile.getStackInSlot(2) != null){
    			tile.decrStackSize(2, 1);
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Redstone", true);
    		}
    		
    		if(tile.getStackInSlot(3) != null){
    			tile.decrStackSize(3, 1);
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Safe", true);
    		}
    		
    		
    		
    	}
			
		}
			
		}
	}
		
	}


