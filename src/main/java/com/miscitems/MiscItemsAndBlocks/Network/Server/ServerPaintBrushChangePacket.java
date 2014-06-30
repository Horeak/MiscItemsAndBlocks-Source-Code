package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemPaintBrush;
import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class ServerPaintBrushChangePacket extends AbstractPacket {

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
public void fromBytes(ByteBuf buf, Side side) {
		Red = buf.readInt();
		Green = buf.readInt();
		Blue = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {

        buf.writeInt(Red);
        buf.writeInt(Green);
        buf.writeInt(Blue);
		
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {

		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ModItemPaintBrush){
			ModItemPaintBrush item = (ModItemPaintBrush)player.inventory.getCurrentItem().getItem();
			
			item.ReciveColors(Red, Green, Blue, player.inventory.getCurrentItem());
		}
		

	}

}
