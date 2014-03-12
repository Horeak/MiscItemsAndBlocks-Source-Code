package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Laser.LaserUtil;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerCable;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerGeneration;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerTile;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityPowerCable extends TileEntity implements IPowerCable {


	
       
      private int Power = 0;
    private int MaxPower = 4;

       
       
       
       
	   @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("Power", this.Power);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
	
		
		Power = compound.getInteger("Power");

		
		
		

		
	}
	
	
	boolean Top, Bottom, Left, Right, Front, Back;
	
    public void updateEntity()
    {
    	
    	
    	if(Power > MaxPower)
    		Power = MaxPower;
    	
 	   World world = this.worldObj;
       int X = this.xCoord;
       int Y = this.yCoord;
       int Z = this.zCoord;
  
    	
    	boolean Top, Bottom, Left, Right, Front, Back;
        Front = IsPowerBlock(world, X, Y, Z + 1);
        Back = IsPowerBlock(world, X, Y, Z - 1);
        Right = IsPowerBlock(world, X - 1, Y, Z);
        Left = IsPowerBlock(world, X + 1, Y, Z);
        Bottom = IsPowerBlock(world, X, Y - 1, Z);
        
        Top = IsPowerBlock(world, X, Y + 1, Z);
        
        
        
        if(Top)
        	SendPowerToPowerReciver(world, X, Y + 1, Z);
        
        if(Front)
        	SendPowerToPowerReciver(world, X, Y, Z + 1);
        
        if(Back)
        	SendPowerToPowerReciver(world, X, Y, Z - 1);
        
        if(Right)
        	SendPowerToPowerReciver(world, X - 1, Y, Z);
        
        if(Left)
        	SendPowerToPowerReciver(world, X + 1, Y, Z);
        
        if(Bottom)
        	SendPowerToPowerReciver(world, X, Y - 1, Z);
        

        
  
        		
        		
        	}
        

    
    
    public int GetPower(){
    	return Power;
    }
    
    public int GetMaxPower(){
    	return Power;
    }

    @Override
    public void SetMaxPower(int i) {
        MaxPower = i;
    }

    public int GetPowerSpaceLeft(){
    	return MaxPower - Power;
    }
    
    public void SetPower(int i){
    	Power = i;
    }

    @Override
    public void AddPower(int Amount) {

        if(Power + Amount <= MaxPower)
            Power += Amount;
        else
            Power = MaxPower;
    }

    public boolean IsPowerBlock(World world, int x, int y, int z){
    	
    	Block block = world.getBlock(x, y, z);
    	TileEntity tile = world.getTileEntity(x, y, z);
    	int Meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

    	if(Meta != 1)
    	if(tile instanceof IPowerTile)return true;
    	if(Meta != 1)
    	if(tile instanceof IPowerGeneration)return true;
    	if(Meta != 2)
    	if(tile instanceof IPowerCable)return true;
    	
    	// 1 No Machines
    	// 2 No Cables

    	
    	return false;
    }
 public void SendPowerToPowerReciver(World world, int x, int y, int z){
	 
 	int Meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    int BMeta = world.getBlockMetadata(x, y, z);
    
    
    if(Meta != 1){
    	if(world.getTileEntity(x, y, z) instanceof TileEntityCharger){
		if(this.xCoord != x + ForgeDirection.getOrientation(LaserUtil.getOrientation(BMeta)).offsetX || this.yCoord != y + ForgeDirection.getOrientation(LaserUtil.getOrientation(BMeta)).offsetY || this.zCoord != z + ForgeDirection.getOrientation(LaserUtil.getOrientation(BMeta)).offsetZ){
			if(world.getTileEntity(x, y, z) instanceof IPowerTile){
				IPowerTile tile = (IPowerTile)world.getTileEntity(x, y, z);
	    		
	    		if(tile.GetPower() < tile.GetMaxPower()){
	    			if(Power > 0){
	    				tile.AddPower(1);
	    				Power--;
	    			}
	    		}else{
	    			tile.SetPower(tile.GetMaxPower());
	    		}
	    		
	    	}
		}
    	
    	
    


    }else if(world.getTileEntity(x, y, z) instanceof IPowerTile){
			IPowerTile tile = (IPowerTile)world.getTileEntity(x, y, z);
    		
    		if(tile.GetPower() < tile.GetMaxPower()){
    			if(Power > 0){
    				tile.SetPower(tile.GetPower() + 1);
    				Power--;
    			}
    		}else{
    			tile.SetPower(tile.GetMaxPower());
    		}
    		
    	}

		
    }
	 

	 int Meta2 = world.getBlockMetadata(x, y, z);

	 
	 if(Meta == 4 && Meta2 == 4)
		 Cable(world, x, y, z);
	 else if (Meta == 4 && Meta2 == 5)
		 Cable(world, x, y, z);
	 else if (Meta == 5)
		 Cable(world, x, y, z);
	 else 
		 if (Meta != 2 && Meta != 4 && Meta2 != 4)
		 Cable(world, x, y, z);


	 
	
 }
 


	 
 
 
 
   
 
   public void Cable(World world, int x, int y, int z){
	   if(world.getTileEntity(x, y, z) instanceof TileEntityPowerCable){
			TileEntityPowerCable tile = (TileEntityPowerCable)world.getTileEntity(x, y, z);
			
			
			if(Power > tile.GetPower()){
				tile.SetPower(tile.GetPower() + 1);
				Power--;

			}
   }
   }
   

}


