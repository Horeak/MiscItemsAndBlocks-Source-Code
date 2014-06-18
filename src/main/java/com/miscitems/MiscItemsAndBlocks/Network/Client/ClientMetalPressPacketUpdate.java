package com.miscitems.MiscItemsAndBlocks.Network.Client;

import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.io.IOException;

public class ClientMetalPressPacketUpdate extends AbstractPacket {

	
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
public void fromBytes(ByteBuf buf, Side side) {
		
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		
		WorkTime = buf.readInt();
		PlaySound = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        buf.writeInt(WorkTime);
        buf.writeBoolean(PlaySound);
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {
		World world = Minecraft.getMinecraft().thePlayer.worldObj;
    	
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
