package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileEntityWirelessRedstone extends TileEntityInvBase{

	public TileEntityWirelessRedstone() {
		super(3, "Wireless Redstone", 1);

	}
	int CurrentUpdateTick = 0;
	int UpdateTick = 20;

	
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
					
					stack.stackTagCompound.setString("DataType", "Wireless Redstone");
					
					stack.stackTagCompound.setInteger("WirelessRedstone_x", this.xCoord);
					stack.stackTagCompound.setInteger("WirelessRedstone_y", this.yCoord);
					stack.stackTagCompound.setInteger("WirelessRedstone_z", this.zCoord);
					
					this.setInventorySlotContents(1, stack);
					
					
				}
				}
				
			}

		}
		
		
		if(CurrentUpdateTick >= UpdateTick){
		if(this.getStackInSlot(2) != null ){
			if(this.getStackInSlot(2).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(2).stackTagCompound != null){
			

					if(this.getStackInSlot(2).stackTagCompound.getString("DataType").equalsIgnoreCase("Wireless Redstone")){
						

						
						if(this.worldObj.getTileEntity(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x"),
								this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z")
								)instanceof TileEntityWirelessRedstone){
						
						x = this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x");
						y = this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y");
						z = this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z");
						
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
		
		
      
		
		
		if(IsLinked){
			
			if(Mode == 1 && CardMode == 1){
				if(this.worldObj.getBlockMetadata(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x"),
						this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z")
						) == 0){
				
				
					if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
						
						this.worldObj.setBlockMetadataWithNotify(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x"),
						this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z"), 1, 1);
	
					
						this.worldObj.setBlockMetadataWithNotify(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x"),
						this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z"), 1, 2);
					}
					
					
					
				}else if(!this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && this.worldObj.getBlockMetadata(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x"),
						this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z")
						) == 1){
					

						this.worldObj.setBlockMetadataWithNotify(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x"),
						this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z"), 0, 1);

						
						this.worldObj.setBlockMetadataWithNotify(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x"),
						this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z"), 0, 2);

				}
				
				//this.worldObj.markBlockForUpdate(this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x") + 1,this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y"), this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z"));
			
		
				}
				
			}
			
			
		
		
		
		
        
	}
	
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

	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);

	      NBT.setInteger("Mode", Mode);
	      NBT.setInteger("CardMode", CardMode);
	      
	    	
	    }

}
