package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientMetalPressPacketUpdate extends IPacket{

	
	int x;
	int y;
	int z;
	int WorkTime;
	boolean PlaySound;
	
	public ClientMetalPressPacketUpdate(){}
	public ClientMetalPressPacketUpdate(int x, int y, int z, int WorkTime, boolean PlaySound){
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.WorkTime = WorkTime;
		this.PlaySound = PlaySound;
		
		
	}
	
	@Override
	public void read(DataInputStream data) throws IOException {
		
		x = data.readInt();
		y = data.readInt();
		z = data.readInt();
		
		WorkTime = data.readInt();
		PlaySound = data.readBoolean();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		
		data.writeInt(x);
		data.writeInt(y);
		data.writeInt(z);
		
		data.writeInt(WorkTime);
		data.writeBoolean(PlaySound);
	}

	@Override
	public void execute(EntityPlayer player) {
	     if (FMLCommonHandler.instance().getEffectiveSide().isClient()){
		World world = player.worldObj;
    	
        TileEntity tile_e = world.getTileEntity(x, y, z);
        
        if(tile_e != null){
        	
        	if(tile_e instanceof TileEntityMetalPress){
        		TileEntityMetalPress tile = (TileEntityMetalPress)tile_e;
        		
        		tile.SetWorkTime(WorkTime);

        		if(PlaySound)
        			world.playSound(x, y, z, "random.anvil_land", 0.3F, 1.5F, false);
        		
        	}
        }
	}
	}

}
