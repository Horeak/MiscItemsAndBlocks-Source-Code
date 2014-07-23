package com.miscitems.MiscItemsAndBlocks.Network.Server;

import com.miscitems.MiscItemsAndBlocks.Container.ContainerLensBench;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.Network.AbstractPacket;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLensBench;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class ServerLensBenchPacketDone extends AbstractPacket {

	boolean Color;
	int Red, Green, Blue, Power, Strength, x, y, z;
	boolean TransferPower, Damage, Redstone;
	
	public ServerLensBenchPacketDone(){}
	public ServerLensBenchPacketDone(boolean Color, int Red, int Green, int Blue, int Power, int Strength, boolean TransferPower, boolean Damage, boolean Redstone, int X, int Y, int Z){
		
		
		if(Strength <= 0)
			Strength = 1;
		
		this.Color = Color;
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		this.Power = Power;
		this.Strength = Strength;
		x = X;
		y = Y;
		z = Z;
		this.TransferPower = TransferPower;
		this.Damage = Damage;
		this.Redstone = Redstone;
		
			
		
	}
	
	@Override

    public void fromBytes(ByteBuf buf, Side side) {
		
		Color = buf.readBoolean();
		if(Color){
			Red = buf.readInt();
			Green = buf.readInt();
			Blue = buf.readInt();
		}
		
		Power = buf.readInt();
		Strength = buf.readInt();
		
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		
		TransferPower = buf.readBoolean();
		Damage = buf.readBoolean();
		Redstone = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf, Side side) {
        buf.writeBoolean(Color);
		if(Color){
            buf.writeInt(Red);
            buf.writeInt(Green);
            buf.writeInt(Blue);
			
		}

        buf.writeInt(Power);
        buf.writeInt(Strength);

        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);

        buf.writeBoolean(TransferPower);
        buf.writeBoolean(Damage);
        buf.writeBoolean(Redstone);
		
		
	}

	@Override
    public void onMessage(Side side, EntityPlayer player) {

		
		if(player.openContainer instanceof ContainerLensBench){
			ContainerLensBench container = (ContainerLensBench)player.openContainer;
			
			TileEntityLensBench tile = container.tile;
			
			
			if(tile.xCoord == x && tile.yCoord == y && tile.zCoord == z){
			if(tile.getStackInSlot(0) != null && tile.getStackInSlot(0).getItem() == ModItems.Lens){
			if(tile.getStackInSlot(0).stackTagCompound == null)
    			tile.getStackInSlot(0).setTagCompound(new NBTTagCompound());
			
			tile.getStackInSlot(0).stackTagCompound.setBoolean("Color", Color);
    		
    		if(Color){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Color", true);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Red", Red);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Green", Green);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Blue", Blue);
    		}
    		
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Power", Power);
    		tile.getStackInSlot(0).stackTagCompound.setInteger("Strength", Strength);
    		
    		tile.getStackInSlot(0).stackTagCompound.setInteger("PowerUse", (((Power) * 3) + ((Strength / 4))) + (Damage ? 5 : 0) + (TransferPower ? 2 : 0) + (Redstone ? 1 : 0));
    		
    		if(tile.getStackInSlot(0).stackTagCompound.getInteger("PowerUse") < 0){
        		tile.getStackInSlot(0).stackTagCompound.setInteger("PowerUse", 0);
    		}

    		
    		if(TransferPower){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("TransferPower", true);
    		}else{
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("TransferPower", false);
    		}
    			
    		
    		
    		
    		if(Redstone){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Redstone", true);
    		}else{
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Redstone", false);
    		}
    		
    		
    		if(!Damage){
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Safe", true);
    		}else{
    			tile.getStackInSlot(0).stackTagCompound.setBoolean("Safe", false);
    		}
    			
    		
    		
    		
    	}
			
		}
			
		}

	}
		
	}


