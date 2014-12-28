package com.miscitems.MiscItemsAndBlocks.TileEntity.Machines;

import MiscUtils.TileEntity.TileEntityInvBase;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;

public class TileEntityWirelessRedstone extends TileEntityInvBase {

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

					stack.stackTagCompound.setInteger("WirelessRedstone_world", worldObj.provider.dimensionId);
					
					this.setInventorySlotContents(1, stack);
					
					
				}
				}
				
			}

		}


		World world = null;
		
		if(CurrentUpdateTick >= UpdateTick){
		if(this.getStackInSlot(2) != null ){
			if(this.getStackInSlot(2).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(2).stackTagCompound != null){
			

					if(this.getStackInSlot(2).stackTagCompound.getString("DataType").equalsIgnoreCase("Wireless Redstone")){

						x = this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_x");
						y = this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_y");
						z = this.getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_z");

						int worldId = getStackInSlot(2).stackTagCompound.getInteger("WirelessRedstone_world");
						WorldProvider provider = DimensionManager.getProvider(worldId);

						if(provider != null){
							world = provider.worldObj;
						}

						if(world != null)
						if(world.getTileEntity(x,y,z)instanceof TileEntityWirelessRedstone){

						
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
			if(!world.isRemote) {
				Chunk chunk = world.getChunkFromBlockCoords(x, z);

				if(!chunk.isChunkLoaded)
					chunk.onChunkLoad();
			}

			if(Mode == 1 && CardMode == 1){
				if(world.getBlockMetadata(x,y,z) == 0 && worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
					world.setBlockMetadataWithNotify(x,y,z, 1, 3);
					world.notifyBlocksOfNeighborChange(x,y,z,world.getBlock(x,y,z));

				}else if(!worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && world.getBlockMetadata(x,y,z) == 1){
					world.setBlockMetadataWithNotify(x,y,z, 0, 3);
					world.notifyBlocksOfNeighborChange(x,y,z,world.getBlock(x,y,z));
				}

		
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
