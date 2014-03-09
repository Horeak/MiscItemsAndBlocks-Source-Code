package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Recipes.MillRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

public class TileEntityMill extends TileEntityInvBase{

	public TileEntityMill() {
		super(2, "Mill", 16);
	}

	
	public int WorkTime = 0;
	public static int FinishTime = 300;
	public static int Original = 300;
	
	Random rand = new Random();
	

	

        
        @Override
    	public void writeToNBT(NBTTagCompound compound){
    		super.writeToNBT(compound);
    		
    		NBTTagList Items = new NBTTagList();
    		
    		for (int i = 0; i < getSizeInventory(); i++){
    			
    			ItemStack stack = getStackInSlot(i);
    			if(stack != null){
    				
    				NBTTagCompound item = new NBTTagCompound();
    				item.setByte("Slot", (byte)i);
    				stack.writeToNBT(item);
    				Items.appendTag(item);
    			}
    		}
    		 compound.setShort("Work", (short)this.WorkTime);
    		
    		compound.setTag("Items", Items);
    		
    		
    		
    		
    	}
    	
    	@Override
    	public void readFromNBT(NBTTagCompound compound){
    		super.readFromNBT(compound);
    		

    		NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
    		
    		for(int i = 0; i < items.tagCount(); i++){
    			
    			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
    			int slot = item.getByte("Slot");
    			
    			if(slot >= 0 && slot < getSizeInventory()){
    				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
    				
    			}
    			
    	        this.WorkTime = compound.getShort("Work");
    		}
    		
    		
    		
    	}
    	
    	
        public void updateEntity()
        {
        	
        	if(this.getStackInSlot(0) != null){
        		ItemStack result = MillRecipes.instance().GetResult(getStackInSlot(0));
        		
        		if(result != null){
        		if(this.getStackInSlot(1) == null || this.getStackInSlot(1).stackSize <= 0 || this.getStackInSlot(1).stackSize < 16){

        		
        		if(WorkTime == FinishTime){
        			WorkTime = 0;
        			
        			ItemStack finishItem = result;

        			
        			this.decrStackSize(0, 1);
        			
        			if(this.getStackInSlot(1) == null || Inv[1].stackSize <= 0){
        				this.setInventorySlotContents(1, finishItem);
        			}else{
        				
        				Inv[1].stackSize = Inv[1].stackSize + 1;
        				
        				FinishTime = Original + rand.nextInt(50);
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
