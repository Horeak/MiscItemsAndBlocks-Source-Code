package com.miscitems.MiscItemsAndBlocks.TileEntity;

import MiscItemsApi.Recipes.SqueezerRecipes;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class TileEntitySquezer extends TileEntityInvBase implements ISidedInventory {

	public TileEntitySquezer() {
		super(3, "Squezer", 16);
	}
	
	private static final int[] sidedSlotSides = new int[] { 0 };
	private static final int[] sidedSlotBottom = new int[] { 2, 1 };
	private static final int[] sidedSlotTop = new int[] { 1 };
	
	public int WorkTime = 0;
	public int FinishTime = 400;
	
    @Override
  	public void writeToNBT(NBTTagCompound compound){
  		super.writeToNBT(compound);
  		this.nbt = compound;
  		
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

  		
  		compound.setTag("Items", Items);
  		
  		
  		
  		
  	}
  	
  	@Override
  	public void readFromNBT(NBTTagCompound compound){
  		super.readFromNBT(compound);
  		this.nbt = compound;
  		

		NBTTagList nbttaglist = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		Inv = new ItemStack[getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xff;
            if (j >= 0 && j < Inv.length)
            {
                this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
            }
        }
  	}
  	
    public void updateEntity()
    {
    	
    	
    	if(this.getStackInSlot(0) != null && this.getStackInSlot(1) != null){
    		
			ItemStack finishItem = SqueezerRecipes.instance().GetResult(getStackInSlot(0), getStackInSlot(1));
			
			
			
			if(finishItem != null){
    		if(WorkTime >= FinishTime){
    			WorkTime = 0;

    			
    			
    			if(finishItem != null){
    			this.decrStackSize(0, 1);
    			this.decrStackSize(1, 1);
    			
    			if(this.getStackInSlot(2) == null || Inv[2].stackSize <= 0){
    				this.setInventorySlotContents(2, finishItem);
    			}else{
    				
    				Inv[2].stackSize = Inv[2].stackSize + 1;

    			}
    			
    		}
    		
    	}else{
			WorkTime++;
		}
    	
    	}else{
    		WorkTime = 0;
    	}
			
			
    	}else{
    		WorkTime = 0;
    	}
    }
    
    
    
    
    
    public int GetWorkTime(){
    	
    	return this.WorkTime;
    }
    
    public void setWorkTime(int amount){
    	
    	WorkTime = amount;
    }
    
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? sidedSlotBottom : (var1 == 1 ? sidedSlotTop : sidedSlotSides);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}
    
    
    
  	

}
