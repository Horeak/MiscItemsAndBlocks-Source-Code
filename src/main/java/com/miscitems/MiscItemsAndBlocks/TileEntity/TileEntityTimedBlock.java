package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTimedBlock extends TileEntity{

	
	static int MaxTime = 140;
	int Time = 0;
	
	
	   @Override
		public void writeToNBT(NBTTagCompound compound){
			super.writeToNBT(compound);

			compound.setInteger("Time", Time);
		}
		
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);


			Time = compound.getInteger("Time");
			
		}
		
		public void updateEntity(){
			
			int Left = MaxTime - Time;
			
			if(Time >= MaxTime){
				Time = 0;
				
				this.worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air);
			}else{
				Time++;
			}
			
				
			
		}
}
