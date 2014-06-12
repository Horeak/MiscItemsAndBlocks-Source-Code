package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

public class ServerSetBlockPacket implements IMessage, IMessageHandler<ServerSetBlockPacket, IMessage> {
	
	
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
public void fromBytes(ByteBuf buf) {
		
		
		this.Dimension = buf.readInt();
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		
		block = Block.getBlockById(buf.readInt());
			
	}

	@Override
	public void toBytes(ByteBuf buf) {

        buf.writeInt(Dimension);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        buf.writeInt(block.getIdFromBlock(block));
	}

	@Override
	  public IMessage onMessage(ServerSetBlockPacket message, MessageContext ctx) {
        EntityPlayer player = ctx.getServerHandler().playerEntity;

		if(player.worldObj.getWorldInfo().getVanillaDimension() == Dimension){
            if(message.block == Blocks.air){
                if (!player.worldObj.isRemote)
                    player.worldObj.playAuxSFX(2001, message.x, message.y, message.z, Block.getIdFromBlock(player.worldObj.getBlock(message.x, message.y, message.z)) + (player.worldObj.getBlockMetadata(message.x, message.y, message.z) << 12));
            }

			player.worldObj.setBlock(message.x, message.y, message.z, message.block);
			
		}
		
		return null;
	}

}
