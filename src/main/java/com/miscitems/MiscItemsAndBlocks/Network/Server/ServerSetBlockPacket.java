package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

public class ServerSetBlockPacket extends AbstractPacket {
	
	
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
public void fromBytes(ByteBuf buf, Side side) {
		
		
		this.Dimension = buf.readInt();
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		
		block = Block.getBlockById(buf.readInt());
			
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

        buf.writeInt(Dimension);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        buf.writeInt(block.getIdFromBlock(block));
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {

		if(player.worldObj.getWorldInfo().getVanillaDimension() == Dimension){
            if(block == Blocks.air){
                if (!player.worldObj.isRemote)
                    player.worldObj.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(player.worldObj.getBlock(x, y, z)) + (player.worldObj.getBlockMetadata(x, y, z) << 12));
            }

			player.worldObj.setBlock(x, y, z, block);
			
		}

	}

}
