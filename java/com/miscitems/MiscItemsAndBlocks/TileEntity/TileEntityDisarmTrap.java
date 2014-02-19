package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityDisarmTrap extends TileEntity{

	
	public static int MaxTime = 20;
	public int Time = 0;

	
	   @Override
		public void writeToNBT(NBTTagCompound compound){
			super.writeToNBT(compound);


		}
	   
		@Override
		public void readFromNBT(NBTTagCompound compound){
			super.readFromNBT(compound);
			
		
		}
		
		
	    public void updateEntity()
	    {
	    	int x = this.xCoord;
	    	int y = this.yCoord;
	    	int z = this.zCoord;
	    	
	    	World world = this.worldObj;
	    	
	    	
	    	if(world.getBlockMetadata(x, y, z) >= 1){
	    	if(Time >= MaxTime){
	    		Time = 0;
	    		
	    		if(world.getBlockMetadata(x, y, z) >= 1){
	                world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "random.click", 0.3F, 0.6F);
	                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
	         	
	         }
	    		
	    		
	    		
	    	}else{
	    		Time++;
	    	}
	    	}
	    	
	    }
	    
	
}


