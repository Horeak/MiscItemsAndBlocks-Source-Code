package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemPaintBrush;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ServerPaintBrushChangePacket implements IMessage, IMessageHandler<ServerPaintBrushChangePacket, IMessage> {

	int Red;
	int Green;
	int Blue;
	
	public ServerPaintBrushChangePacket(){}
	
	public ServerPaintBrushChangePacket(int Red, int Green, int Blue){
		
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
	}
	@Override
public void fromBytes(ByteBuf buf) {
		Red = buf.readInt();
		Green = buf.readInt();
		Blue = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {

        buf.writeInt(Red);
        buf.writeInt(Green);
        buf.writeInt(Blue);
		
	}

	@Override
	  public IMessage onMessage(ServerPaintBrushChangePacket message, MessageContext ctx) {
        EntityPlayer player = ctx.getServerHandler().playerEntity;

		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ModItemPaintBrush){
			ModItemPaintBrush item = (ModItemPaintBrush)player.inventory.getCurrentItem().getItem();
			
			item.ReciveColors(message.Red, message.Green, message.Blue, player.inventory.getCurrentItem());
		}
		

        return null;
	}

}
