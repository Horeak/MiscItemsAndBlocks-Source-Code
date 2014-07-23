package com.miscitems.MiscItemsAndBlocks.TileEntity.Machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTrashBin extends TileEntity implements IInventory{

	private ItemStack[] Items;
	
	int Time;
	int FinishTime = 10;
	
	public TileEntityTrashBin(){
		
		Items = new ItemStack[1];
	}
	
	@Override
	public int getSizeInventory() {
		return Items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return Items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack itemstack = getStackInSlot(i);
		
		if(itemstack != null){
			
			if(itemstack.stackSize <= j){
				
				setInventorySlotContents(i, null);
			}else{
				
				itemstack = itemstack.splitStack(j);
				
			}
			
		}
		
		return itemstack;
	}


	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		Items[i] = itemstack;
		
	}



	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}


	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	
	
	
    public void updateEntity()
    {
    	
    	
    	
    		
    	if(this.getStackInSlot(0) != null){
    	if(Time == FinishTime){
    		Time = 0;

    		this.decrStackSize(0, 1);
    	}else{
    		Time++;
    	}

    		}else{
    			Time = 0;
    		}
    	
    	
    	}

	@Override
	public String getInventoryName() {
		return "TrashBin";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}
    	
    	
    	
    	
    
	

        

        

        
        
        
}
