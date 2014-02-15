package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;

import com.miscitems.MiscItemsAndBlocks.Network.IPacket;

public class ServerSetBlockPacket extends IPacket{
	
	
	int Dimension,  x,  y,  z;
	Block block;

	public ServerSetBlockPacket(){}
	public ServerSetBlockPacket(int Dimension, int x, int y, int z, Block block){
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.Dimension = Dimension;
		this.block = block;
		
	}

	@Override
	public void read(DataInputStream data) throws IOException {
		
		
		this.Dimension = data.readInt();
		this.x = data.readInt();
		this.y = data.readInt();
		this.z = data.readInt();
		
		block = Block.getBlockById(data.readInt());
			
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		
		data.writeInt(Dimension);
		data.writeInt(x);
		data.writeInt(y);
		data.writeInt(z);
		
		data.writeInt(block.getIdFromBlock(block));
	}

	@Override
	public void execute(EntityPlayer player) {
		if(player.worldObj.getWorldInfo().getVanillaDimension() == Dimension){
			player.worldObj.setBlock(x, y, z, block);
			
		}
		
		
	}

}
