package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class TileEntityElectricFurnace extends TileEntityPowerInv implements ISidedInventory{

	public TileEntityElectricFurnace() {
		super(3, "ElFurnace", 64);
	}
	
	private static final int[] sidedSlotSides = new int[] { 0 };
	private static final int[] sidedSlotBottom = new int[] { 2 };
	private static final int[] sidedSlotTop = new int[] { 0 };

	
	int WorkTime = 0;
	int MaxWorkTime = 100;
	
	public boolean Working;
	
    public void updateEntity()
    {
    	
    	if(this.GetPower() < this.GetMaxPower()){
    	if(this.getStackInSlot(1) != null){
    		if(this.getStackInSlot(1).getItemDamage() < this.getStackInSlot(1).getMaxDamage()){
    			this.getStackInSlot(1).attemptDamageItem(1, this.worldObj.rand);
    			this.SetPower(this.GetPower() + 1);
    		}
    	}
    	}
    	
    	if(this.GetPower() > this.GetMaxPower()){
    		this.SetPower(this.GetMaxPower());
    	}
    	
    	if(this.GetPower() > 2){
    		
    		
    		if(this.getStackInSlot(0) != null && FurnaceRecipes.smelting().getSmeltingResult(this.getStackInSlot(0)) != null){
    			if(this.getStackInSlot(2) != null && this.getStackInSlot(2).stackSize < this.getInventoryStackLimit() || this.getStackInSlot(2) == null){
    				
    			
    			
    			ItemStack smeltingItem = this.getStackInSlot(0);
    			if(!Working)
        			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    			
    			Working = true;
    			
    			if(WorkTime >= MaxWorkTime){
    				WorkTime = 0;
    				
    				if(FurnaceRecipes.smelting().getSmeltingResult(smeltingItem) != null){
    					
    					ItemStack resultItem = FurnaceRecipes.smelting().getSmeltingResult(smeltingItem);
    					
    					
    					if(this.getStackInSlot(2) == null){
    						this.decrStackSize(0, 1);
    						this.SetPower(this.GetPower() - 2);
    						this.setInventorySlotContents(2, resultItem);
    						
    					}else if (this.getStackInSlot(2).getItem() == resultItem.getItem() && this.getStackInSlot(2).stackSize < this.getInventoryStackLimit()){

    						this.decrStackSize(0, 1);
    						this.SetPower(this.GetPower() - 2);
    						this.getStackInSlot(2).stackSize += 1;
    						
    						
    					}
    					
    					
    				}
    				
    				
    			}else{
    				WorkTime += 3;
    			}
    		}else{
    			WorkTime = 0;
    			if(Working)
        			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        		Working = false;
    			
    		}
    	}else{
    		WorkTime = 0;

			if(Working)
    			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			
	   		Working = false;
    	}
    	
    	
    	}
    	
    }
    
    
    
    @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setInteger("Work", WorkTime);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);

		WorkTime = compound.getInteger("Work");

	}
	
	public int GetWorkTime(){
		return WorkTime;
	}
	
	public void SetWorkTime(int i){
		if(i <= MaxWorkTime)
		WorkTime = i;
		else
			WorkTime = MaxWorkTime;
			
	}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i != 2;
		
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
		return j != 0 || i != 1;
	}



	@Override
	public boolean CanAcceptPower() {
		return true;
	}



	@Override
	public int GetMaxPower() {
		return 250;
	}



	
	
}
