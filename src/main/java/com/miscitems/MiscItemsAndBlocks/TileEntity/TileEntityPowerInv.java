package com.miscitems.MiscItemsAndBlocks.TileEntity;

import MiscItemsApi.Electric.IPowerTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public abstract class TileEntityPowerInv  extends TileEntityInvBase implements IInventory, IPowerTile{
	

	public TileEntityPowerInv(int Slots, String Name, int Size) {
		super(Slots, Name, Size);

	}

	private int Power;
    private int PowerMax;
	
	
	
	public void SetPower(int i){
		Power = i;
	}
	
	public int GetPower(){
		return Power;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}


	
	public abstract boolean CanAcceptPower();

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
		
	}
	
	

        
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
    		compound.setInteger("Power", Power);
    		compound.setInteger("MaxPower", PowerMax);
    		
    		
    		
    		
    		
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
    		PowerMax = compound.getInteger("MaxPower");
    		
    		
    		
    	}


		@Override
		public void AddPower(int Amount) {
			if(GetPower() + Amount < GetMaxPower())
				SetPower(GetPower() + Amount);
			else
				SetPower(GetMaxPower());
		}

		@Override
		public boolean AcceptsPower() {
			return CanAcceptPower();
		}

		@Override
		public boolean ConnectsToCables() {
			return AcceptsPower();
		}


		@Override
		public void SetMaxPower(int i) {
			if(i > 0)
				PowerMax = i;
		}
}