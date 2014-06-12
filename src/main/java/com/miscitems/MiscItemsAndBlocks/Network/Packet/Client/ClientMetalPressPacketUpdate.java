package com.miscitems.MiscItemsAndBlocks.Network.Packet.Client;

import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityMetalPress;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ClientMetalPressPacketUpdate implements IMessage, IMessageHandler<ClientMetalPressPacketUpdate, IMessage> {

	
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
public void fromBytes(ByteBuf buf) {
		
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		
		WorkTime = buf.readInt();
		PlaySound = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        buf.writeInt(WorkTime);
        buf.writeBoolean(PlaySound);
	}

	@Override
	  public IMessage onMessage(ClientMetalPressPacketUpdate message, MessageContext ctx) {
	     if (FMLCommonHandler.instance().getEffectiveSide().isClient()){
		World world = Minecraft.getMinecraft().thePlayer.worldObj;
    	
        TileEntity tile_e = world.getTileEntity(message.x, message.y, message.z);
        
        if(tile_e != null){
        	
        	if(tile_e instanceof TileEntityMetalPress){
        		TileEntityMetalPress tile = (TileEntityMetalPress)tile_e;
        		
        		tile.SetWorkTime(message.WorkTime);

        		if(message.PlaySound)
        			world.playSound(message.x, message.y, message.z, "random.anvil_land", 0.3F, 1.5F, false);
        		
        	}
        }
	}
        return null;
	}

}
