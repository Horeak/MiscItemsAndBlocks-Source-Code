package com.miscitems.MiscItemsAndBlocks.TileEntity;

import MiscItemsApi.Recipes.MetalPressRecipes;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientMetalPressPacketUpdate;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityMetalPress extends TileEntityPowerInv implements ISidedInventory{

	
	
	
	public TileEntityMetalPress() {
		super(6, "Metal Press", 16);
	}

	public int WorkTime = 1;
	public int MaxWorkTime = 50;
	
	//1 = Mode 1x1
	//2 = Mode 4x4
	public int Mode = 1;
	
	
	private final int[] sidedSlotSides = new int[] { 1 };
	private final int[] sidedSlotBottom = new int[] { 0 };
	private final int[] sidedSlotTop = new int[] { 1 };
	
	public int GetMode(){
		return Mode;
	}
	
	public void SetMode(int i){
		if(i == 1 || i == 2){
			Mode = i;
		}else{
			
			Mode = 1;
		}
		
	}
	
	public int GetWorkTime(){
	return WorkTime;
}
	
	public void SetWorkTime(int i){
		if(i >= MaxWorkTime){
			WorkTime = MaxWorkTime;
		}else{
			WorkTime = i;
		}
	}
	
	
	
	
	public void updateEntity(){

		
		if(!this.worldObj.isRemote){
			
			if(Mode == 1 ? GetPower() > 10 : GetPower() > 20){
		if(WorkTime <= MaxWorkTime ){
		if(Mode == 1){
			ItemStack finishItem_1 = MetalPressRecipes.instance().GetResultMode_1(this.getStackInSlot(1));

           if(finishItem_1 != null && this.getStackInSlot(0) == null || finishItem_1 != null && this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == finishItem_1.getItem() && this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()) {
            WorkTimeAdd();

			}else if (this.getStackInSlot(1) == null && Mode == 1 || finishItem_1 == null && Mode == 1){
				SetWorkTimeUpdate(0);
				
			}

			
		}else if (Mode == 2){

            ItemStack finishItem_4 = MetalPressRecipes.instance().GetResultMode_4(this.getStackInSlot(2), this.getStackInSlot(3), this.getStackInSlot(4), this.getStackInSlot(5));

            if(finishItem_4 != null && this.getStackInSlot(0) == null || finishItem_4 != null && this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == finishItem_4.getItem() && this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()) {
                WorkTimeAdd();

            }else if (this.getStackInSlot(2) == null && Mode == 2 || this.getStackInSlot(3) == null && Mode == 2 || this.getStackInSlot(4) == null && Mode == 2 || this.getStackInSlot(5) == null && Mode == 2 || finishItem_4 == null && Mode == 2){
                SetWorkTimeUpdate(0);

            }
			

			
		}
		
		
		}else{
			
			WorkTimeReset();
			
			
			
			if(Mode == 1){

                ItemStack FinishItem = MetalPressRecipes.instance().GetResultMode_1(this.getStackInSlot(1));

				this.decrStackSize(1, 1);
				this.SetPower(this.GetPower() - 10);
				
				if(this.getStackInSlot(0) == null){
					this.setInventorySlotContents(0, FinishItem);
					
				}else if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == FinishItem.getItem() && this.getStackInSlot(0).getItemDamage() == FinishItem.getItemDamage()){

					if(this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()){
						this.setInventorySlotContents(0, new ItemStack(this.getStackInSlot(0).getItem(), this.getStackInSlot(0).stackSize + 1, this.getStackInSlot(0).getItemDamage()));
					}
					
				}
				
			}else if (Mode == 2){
				this.SetPower(this.GetPower() - 20);

                ItemStack finishItem_4 = MetalPressRecipes.instance().GetResultMode_4(this.getStackInSlot(2), this.getStackInSlot(3), this.getStackInSlot(4), this.getStackInSlot(5));


                this.decrStackSize(2, 1);
				this.decrStackSize(3, 1);
				this.decrStackSize(4, 1);
				this.decrStackSize(5, 1);
				
				if(this.getStackInSlot(0) == null){
					this.setInventorySlotContents(0, finishItem_4);
					
				}else if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == finishItem_4.getItem() && this.getStackInSlot(0).getItemDamage() == finishItem_4.getItemDamage()){
				
					if(this.getStackInSlot(0).stackSize < this.getInventoryStackLimit()){
						this.setInventorySlotContents(0, new ItemStack(this.getStackInSlot(0).getItem(), this.getStackInSlot(0).stackSize + 1, this.getStackInSlot(0).getItemDamage()));
					}
					
				}
				
			}
			
		}
		
		
		}
		
	}
	}
	
		
		
	
	
	
	 public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);


		  WorkTime = NBT.getInteger("WorkTime");
		  Mode = NBT.getInteger("Mode");
	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);
	      
	    	
	      NBT.setInteger("WorkTime", WorkTime);
	      NBT.setInteger("Mode", Mode);
	    }
	    
	    
	    
		public void receiveButtonEvent(byte buttonId) {
			
			if(buttonId == 1){
				
				if(Mode == 1)
					Mode = 2;
				else if (Mode == 2)
					Mode = 1;
			}
			
		}
	    
			@Override
			public int[] getAccessibleSlotsFromSide(int var1) {
				
				if(Mode == 1)
					return var1 == 0 ? sidedSlotBottom : new int[]{ 1 };
				else if (Mode == 2)
					return var1 == 0 ? sidedSlotBottom : new int[]{ 2, 3, 4, 5 };
					
					
				return var1 == 0 ? sidedSlotBottom : (var1 == 1 ? sidedSlotTop : sidedSlotSides);
			}

			@Override
			public boolean canInsertItem(int i, ItemStack itemstack, int j) {
				return this.isItemValidForSlot(i, itemstack);
			}

			@Override
			public boolean canExtractItem(int i, ItemStack itemstack, int j) {
				return j != 0 || i != 1 ;
			}
			
			public void WorkTimeAdd(){
				WorkTime++;


                PacketHandler.INSTANCE.sendToAllAround(new ClientMetalPressPacketUpdate(this.xCoord, this.yCoord, this.zCoord, WorkTime, false), new NetworkRegistry.TargetPoint(this.worldObj.getWorldInfo().getVanillaDimension(), xCoord, yCoord, zCoord, 100));
	    	}
			
			
			
			public void WorkTimeReset(){
				WorkTime = 0;




                PacketHandler.INSTANCE.sendToAllAround(new ClientMetalPressPacketUpdate(this.xCoord, this.yCoord, this.zCoord, WorkTime, true), new NetworkRegistry.TargetPoint(this.worldObj.getWorldInfo().getVanillaDimension(), xCoord, yCoord, zCoord, 100));
	    	
	    	}

			@Override
			public boolean CanAcceptPower() {
				return true;
			}
			
			
			public void SetWorkTimeUpdate(int i){
			
				WorkTime = i;


                PacketHandler.INSTANCE.sendToAllAround(new ClientMetalPressPacketUpdate(this.xCoord, this.yCoord, this.zCoord, WorkTime, false), new NetworkRegistry.TargetPoint(this.worldObj.getWorldInfo().getVanillaDimension(), xCoord, yCoord, zCoord, 100));
	    	
			}

			@Override
			public int GetMaxPower() {
				return 1000;
			}
			
			}

