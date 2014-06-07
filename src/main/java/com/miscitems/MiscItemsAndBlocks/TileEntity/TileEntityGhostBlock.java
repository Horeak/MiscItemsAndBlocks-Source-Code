package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGhostBlockPacket;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.PacketHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGhostBlock extends TileEntity{


	public int Meta;
    public int Id;
    public boolean Locked;
    public String Placer = "";
	


	 public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);

            Id = NBT.getInteger("ID");
		  
		  Meta = NBT.getInteger("Meta");
            Locked = NBT.getBoolean("Locked");

            Placer = NBT.getString("Pl");

	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);

            NBT.setInteger("ID", Id);
	      
	      NBT.setInteger("Meta", Meta);

            NBT.setBoolean("Locked", Locked);
            NBT.setString("Pl", Placer);

	    }

    @Override
    public Packet getDescriptionPacket() {


        if (Id > 0 || Placer != null)
            return PacketHandler.INSTANCE.getPacketFrom(new ClientGhostBlockPacket(xCoord, yCoord, zCoord, Id, Meta, Placer));
        else
            return super.getDescriptionPacket();
    }


}
