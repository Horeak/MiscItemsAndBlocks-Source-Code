package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

import com.miscitems.MiscItemsAndBlocks.Laser.LaserRegistry;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;

public class ServerLaserPacketEntities extends IPacket{

	
	double x1, y1, z1;
	double x2, y2, z2;
	int Direction, LensPower;
	
	boolean Redstone, Safe, Power;
	
	public ServerLaserPacketEntities(){}
	
	public ServerLaserPacketEntities(double x1, double y1, double z1, double x2, double y2, double z2, boolean Redstone, boolean Safe, boolean Power, int Direction, int LensPower){
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		
		
		this.Redstone = Redstone;
		this.Safe = Safe;
		this.Power = Power;
		this.Direction = Direction;
		this.LensPower = LensPower;
		
	}
	
	
	@Override
	public void read(DataInputStream data) throws IOException {
		x1 = data.readDouble();
		y1 = data.readDouble();
		z1 = data.readDouble();
		
		x2 = data.readDouble();
		y2 = data.readDouble();
		z2 = data.readDouble();
		
		Redstone = data.readBoolean();
		Power = data.readBoolean();
		Safe = data.readBoolean();
		
		Direction = data.readInt();
		LensPower = data.readInt();
		
		
		
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		data.writeDouble(x1);
		data.writeDouble(y1);
		data.writeDouble(z1);
		
		data.writeDouble(x2);
		data.writeDouble(y2);
		data.writeDouble(z2);
		
		data.writeBoolean(Redstone);
		data.writeBoolean(Power);
		data.writeBoolean(Safe);
		
		data.writeInt(Direction);
		data.writeInt(LensPower);
		
		
	}

	@Override
	public void execute(EntityPlayer player) {

		
		
		AxisAlignedBB boundingBox = AxisAlignedBB.getAABBPool().getAABB(x1, y1, z1, x2, y2, z2);
        List entities = player.getEntityWorld().getEntitiesWithinAABB(Entity.class, boundingBox);
        
        
		LaserRegistry.getLaserFromId("default").performActionOnEntitiesServer(entities, Direction, Redstone, Power, Safe, LensPower);
		
		
	}

}
