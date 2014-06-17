package com.miscitems.MiscItemsAndBlocks.TileEntity;

import MiscItemsApi.Recipes.MillRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityMill extends TileEntityInvBase{

	public TileEntityMill() {
		super(2, "Mill", 16);
	}

	
	public int WorkTime = 0;
	public static int FinishTime = 300;
	

        @Override
    	public void writeToNBT(NBTTagCompound compound){
    		super.writeToNBT(compound);

    		 compound.setShort("Work", (short)this.WorkTime);

    	}
    	
    	@Override
    	public void readFromNBT(NBTTagCompound compound){
    		super.readFromNBT(compound);

    	        this.WorkTime = compound.getShort("Work");

    	}
    	
        public void updateEntity()
        {
        	
        	if(this.getStackInSlot(0) != null){
        		ItemStack result = MillRecipes.instance().GetResult(getStackInSlot(0));
        		
        		if(result != null){
        		if(this.getStackInSlot(1) == null || this.getStackInSlot(1).stackSize <= this.getInventoryStackLimit()){

        		
        		if(WorkTime == FinishTime){
        			WorkTime = 0;
        			ItemStack finishItem = result;
        			if(this.getStackInSlot(1) == null){
        				this.setInventorySlotContents(1, finishItem);
                        this.decrStackSize(0, 1);
                        return;

        			}else{
        				
        				Inv[1].stackSize += 1;
                        this.decrStackSize(0, 1);
                        return;
        			}

        		}else{

            		WorkTime++;
        		}

        	}
        	}else{
        	WorkTime = 0;
        	
        	
        	}
        	}
        		
        		
        }
        
        
        
        public int GetWorkTime(){
        	
        	return this.WorkTime;
        }
        
        public void setWorkTime(int amount){
        	
        	WorkTime = amount;
        }



}
