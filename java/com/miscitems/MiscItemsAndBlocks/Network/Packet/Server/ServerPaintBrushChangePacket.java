package com.miscitems.MiscItemsAndBlocks.Network.Packet.Server;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemPaintBrush;
import com.miscitems.MiscItemsAndBlocks.Network.IPacket;
import net.minecraft.entity.player.EntityPlayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerPaintBrushChangePacket extends IPacket{

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
	public void read(DataInputStream data) throws IOException {
		Red = data.readInt();
		Green = data.readInt();
		Blue = data.readInt();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {

		data.writeInt(Red);
		data.writeInt(Green);
		data.writeInt(Blue);
		
	}

	@Override
	public void execute(EntityPlayer player) {
		if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ModItemPaintBrush){
			ModItemPaintBrush item = (ModItemPaintBrush)player.inventory.getCurrentItem().getItem();
			
			item.ReciveColors(Red, Green, Blue, player.inventory.getCurrentItem());
		}
		
		
	}

}
