package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;

public class TileEntityWirelessItemTrans extends TileEntityInvBase implements ISidedInventory{

	public TileEntityWirelessItemTrans() {
		super(22, "Wireless Item Transfer", 64);
		}

	int CurrentUpdateTick = 0;
	int UpdateTick = 20;
	
	int SendingTick = 0;
	 int SendTick = 20;
	
	public void updateEntity(){
		
		if(IsLinked)
			Mode = 1;
		else 
			Mode = 0;
		
		
		
		if(this.getStackInSlot(0) != null ){
			if(this.getStackInSlot(0).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(0).stackTagCompound == null){
				if(this.getStackInSlot(1) == null){
					
					this.setInventorySlotContents(0, null);
					
					ItemStack stack = new ItemStack(ModItems.DataChip, 1, 1);
					
					stack.setTagCompound(new NBTTagCompound());
					
					stack.stackTagCompound.setString("DataType", "Wireless Item Transfer");
					
					stack.stackTagCompound.setInteger("ItemTrans_x", this.xCoord);
					stack.stackTagCompound.setInteger("ItemTrans_y", this.yCoord);
					stack.stackTagCompound.setInteger("ItemTrans_z", this.zCoord);
					
					this.setInventorySlotContents(1, stack);
					
					
				}
				}
				
			}

		}
		
		
		if(CurrentUpdateTick >= UpdateTick){
		if(this.getStackInSlot(2) != null ){
			if(this.getStackInSlot(2).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(2).stackTagCompound != null){
			

					if(this.getStackInSlot(2).stackTagCompound.getString("DataType").equalsIgnoreCase("Wireless Item Transfer")){
						

						
						if(this.worldObj.getTileEntity(this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_x"),
								this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_y"), this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_z")
								)instanceof TileEntityWirelessItemTrans){
						
						x = this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_x");
						y = this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_y");
						z = this.getStackInSlot(2).stackTagCompound.getInteger("ItemTrans_z");
						
						CardMode = 1;
						
						IsLinked = true;

						Mode = 1;
						
						}else{
							CardMode = 0;
							IsLinked = false;
							
							
							x = 0;
							y = 0;
							z = 0;
						}
					}else{
						CardMode = 2;
					}
			
					
		}else{
			CardMode = 2;
		}
				
			}
			
		}else{
			CardMode = 0;
			IsLinked = false;
			
			
			x = 0;
			y = 0;
			z = 0;
		}
		
			
		}else{
			CurrentUpdateTick++;
			
		}
		
		
		
		boolean Sent = false;
		
		if(!this.worldObj.isRemote)
		if(Mode == 1 && CardMode == 1 && IsLinked){
			
			
			if(SendingTick > SendTick || this.getStackInSlot(3) == null)
				SendingTick = 0;
			else{
			
			if(SendingTick >= SendTick){
				SendingTick = 0;
				
				
				
				TileEntityWirelessItemTrans tile_e = (TileEntityWirelessItemTrans)this.worldObj.getTileEntity(x, y, z);
				
				if(tile_e != null && this.getStackInSlot(3) != null){
					
					
					for(int i = 4; i < this.getSizeInventory(); i++){
						
						Sent = false;
							
							if(tile_e.getStackInSlot(i) != null && tile_e.getStackInSlot(i).getItem() == this.getStackInSlot(3).getItem()){
								
								if(tile_e.getStackInSlot(i).stackSize < this.getInventoryStackLimit()){
									
									

									
									ItemStack stack = tile_e.getStackInSlot(i).splitStack(tile_e.getStackInSlot(i).stackSize + 1);
									
									
									tile_e.setInventorySlotContents(i, stack);
									SendingTick = 0;
									
									Sent = true;
									break;
									
								}else{
									continue;
								}
								
								
							}else if (tile_e.getStackInSlot(i) == null){
								
						
								ItemStack stack = new ItemStack(this.getStackInSlot(3).getItem(), this.getStackInSlot(3).stackSize, this.getStackInSlot(3).getItemDamage());
								stack.stackTagCompound = this.getStackInSlot(3).stackTagCompound;
								stack.stackSize = 1;
								
								tile_e.setInventorySlotContents(i, stack);
								
								Sent = true;
								SendingTick = 0;
								break;
								
							}else{
								continue;
							}

			}

					
					if(Sent && this.getStackInSlot(3) != null){
						this.decrStackSize(3, 1);
					}
					
					
			}else{
				SendingTick = 0;
			}
			
				
				
				
		}else{
			SendingTick++;
		}
		
		}

		}else{
			SendingTick = 0;
		}
        
	}
	
	private static final int[] sidedSlotSides = new int[] { 3 };
	private static final int[] sidedSlotBottom = new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
	private static final int[] sidedSlotTop = new int[] { 3 };
	
	public int x = 0;
	public int y = 0;
	public int z = 0;
	
	
	public int GetX(){
		return x;
	}
	
	public int GetY(){
		return y;
	}
	
	public int GetZ(){
		return z;
	}
	
	
	public void SetX(int i){
		x = i;
	}
	
	public void SetY(int i){
		y = i;
	}
	
	public void SetZ(int i){
		z = i;
	}

	public int Mode = 0;
	
	//0 = empty
	//1 = valid
	//2 = invalid
	public int CardMode = 0;
	
	
	public int GetCardMode(){
		return CardMode;
	}
	
	public void SetCardMode(int i){
	
		if(i <= 2)
			CardMode = i;
		else
			CardMode = 0;
	}
	
	public boolean IsLinked;
	
	  public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);

		  Mode = NBT.getInteger("Mode");
		  CardMode = NBT.getInteger("CardMode");
		  SendingTick = NBT.getInteger("Tick");

	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);

	      NBT.setInteger("Mode", Mode);
	      NBT.setInteger("CardMode", CardMode);
	      NBT.setInteger("Tick", SendingTick);
	      
	    	
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
			return j != 0 || i != 1 ;
		}
}
