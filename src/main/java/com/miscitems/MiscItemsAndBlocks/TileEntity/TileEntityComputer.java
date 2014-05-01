package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.awt.*;

public class TileEntityComputer extends TileEntity{
	
	
	public int RedValue = 0;
	public int GreenValue = 0;
	public int BlueValue = 0;
	
	
	public int GetColor(){
		Color col = new Color(RedValue, GreenValue, BlueValue);
		
		return col.getRGB();
	}
	
	
	  public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);
		  RedValue = NBT.getInteger("Red");
		  GreenValue = NBT.getInteger("Green");
		  BlueValue = NBT.getInteger("Blue");

	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);
	      NBT.setInteger("Red", RedValue);
	      NBT.setInteger("Green", GreenValue);
	      NBT.setInteger("Blue", BlueValue);
	      
	    	
	    }
}