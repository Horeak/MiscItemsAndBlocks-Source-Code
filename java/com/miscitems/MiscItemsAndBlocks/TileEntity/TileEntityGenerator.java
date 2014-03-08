package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityGenerator extends TileEntityPowerGeneration{

	public TileEntityGenerator() {
		super(1, "CoalGenerator", 64);
	}
	
	
	int Power = 0;
	int TimeLeft = 0;
	int MaxTime = 80;
	
	
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

		
		compound.setInteger("Power", this.Power);
		compound.setInteger("TimeLeft", this.TimeLeft);
		isProvidingPower = compound.getBoolean("Providing");

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
		
		Power = compound.getInteger("Power");
		TimeLeft = compound.getInteger("TimeLeft");
		compound.setBoolean("Providing", isProvidingPower);

		

		
	}
	
    public void updateEntity()
    {
    
    	
    	if(Power < 1)
    	if(this.getStackInSlot(0) != null){
    		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    		if(this.getStackInSlot(0).getItem() == Items.coal){
    			if(TimeLeft == MaxTime){
    				TimeLeft = 0;
    				this.decrStackSize(0, 1);
    				Power++;
    				
    				
    			}else{
    				TimeLeft++;
    				
    			}
    			
    			
    		}
    	}
    	
    	else
    		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    	
    	super.updateEntity();
    	
    	
    }
    
    public int GetFuel(){
    	return Power;
    }
    
    public int GetTimeLeft(){
    	return TimeLeft;
    }
    
    public int GetMaxTime(){
    	return MaxTime;
    }
    
    
    
    public void SetFuel(int i){
    	Power = i;
    }
    
    public void SetTimeLeft(int i){
    	TimeLeft = i;
    }

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {


		return Power > 0;
	}


	@Override
	public int WorkTime() {
		return MaxTime + 10;
	}

    public void OnWork(World world, int x, int y, int z){
    	Power--;
    	
    	
    }

	@Override
	public int GeneratedPower() {
		return 1;
	}
	
   

}
