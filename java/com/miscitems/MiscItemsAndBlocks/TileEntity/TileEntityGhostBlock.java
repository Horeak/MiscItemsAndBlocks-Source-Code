package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Misc.ItemHelper;
import com.miscitems.MiscItemsAndBlocks.Network.Packet.Client.ClientGhostBlockPacket;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.PacketTileWithItemUpdate;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityGhostBlock extends TileEntity{


	public int Meta;
    public int Id;
    public boolean Locked;
    public String Placer = "";
	
	
	//TODO //FIXME Try to find a way to encode block id in meta data

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
            return Main.NETWORK_MANAGER.populatePacket(new ClientGhostBlockPacket(xCoord, yCoord, zCoord, Id, Meta, Placer));
        else
            return super.getDescriptionPacket();
    }


}
