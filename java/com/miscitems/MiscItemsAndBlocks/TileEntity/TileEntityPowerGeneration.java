package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerGeneration;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract  class TileEntityPowerGeneration extends TileEntityInvBase implements IPowerGeneration{

	public TileEntityPowerGeneration(int Slots, String Name, int Size) {
		super(Slots, Name, Size);
	}
	
	public abstract boolean CanWork(World world, int X, int Y, int Z);
	public abstract int WorkTime();
	
	public int Produced;
	
    public void OnWork(World world, int x, int y, int z){}
    
    public boolean isProvidingPower = false;
    
    int Time = 0;
    
    
	
	
	public int GetX(){
		return this.xCoord;
	}
	
	public int GetY(){
		return this.yCoord;
	}
	
	public int GetZ(){
		return this.zCoord;
	}
    
    @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setBoolean("Providing", isProvidingPower);
		compound.setInteger("Time", Time);
		compound.setInteger("Prod", Produced);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		isProvidingPower = compound.getBoolean("Providing");
		Time = compound.getInteger("Time");
		Produced = compound.getInteger("Prod");

	}
	
	int ActiveSides = 0;
	Boolean[] Sides = new Boolean[6];
	
    public void updateEntity()
    {
  	   World world = this.worldObj;
       int X = this.xCoord;
       int Y = this.yCoord;
       int Z = this.zCoord;
    	


       if(CanWork(worldObj, xCoord, yCoord, zCoord)){
       
    	Sides[0] = AceptsPower(X, Y, Z + 1); // Front
    	Sides[1] = AceptsPower(X, Y, Z - 1); // Back
    	Sides[2] = AceptsPower(X - 1, Y, Z); // Right
    	Sides[3] = AceptsPower(X + 1, Y, Z); // Left
    	Sides[4] = AceptsPower(X, Y - 1, Z); // Bottom
    	Sides[5] = AceptsPower(X, Y + 1, Z); // Top


    	


    	ActiveSides = 0;
    	
    	for(int h = 0; h < Sides.length; h++){
    		if(Sides[h] == true)
    			ActiveSides++;
    	}


    	
    	if(ActiveSides > 0)
    	if(Time >= this.WorkTime()){
    	Time = 0;
    	
    	for(int h = 0; h < 6; h++){
    		if(Sides[h] == true){
    			SendPower(this.worldObj ,GetXCord(h), GetYCord(h), GetZCord(h), Produced / ActiveSides);
}
    	}
    	
       
       
       if(ActiveSides > 0 && CanWork(worldObj, xCoord, yCoord, zCoord))
           this.OnWork(worldObj, xCoord, yCoord, zCoord);
       
       }else{
    	   Time++;
       }
       }
    	
    }
    
    public int GetXCord(int h){
    	
    	int x = this.GetX();
    	
    	
    	switch(h){
    	
    	
    	case 0:
    		return x;
    		
    	case 1:
    		return x;
    		
    	case 2:
    		return x - 1;
    		
    	case 3:
    		return x + 1;
    		
    	case 4:
    		return x;
    		
    	case 5:
    		return x;
    		
    	}
    	
    	return 0;
    }
    
    public int GetZCord(int h){
    	
    	int z = this.GetZ();
    	
    	switch(h){
    	
    	
    	case 0:
    		return z + 1;
    		
    	case 1:
    		return z - 1;
    		
    	case 2:
    		return z;
    		
    	case 3:
    		return z;
    		
    	case 4:
    		return z;
    		
    	case 5:
    		return z;
    		
    	}
    	
    	return 0;
    }
    
    public int GetYCord(int h){
    	
    	int y = this.GetY();
    	
    	switch(h){
    	
    	
    	case 0:
    		return y;
    		
    	case 1:
    		return y;
    		
    	case 2:
    		return y;
    		
    	case 3:
    		return y;
    		
    	case 4:
    		return y - 1;
    		
    	case 5:
    		return y + 1;
    		
    	}
    	
    	return 0;
    }
    
    
    public void SendPower(World world, int x, int y, int z, int Amount){
    	
    	TileEntity tile_e = world.getTileEntity(x, y, z);
    	
    	
    	
    	if(tile_e instanceof IPowerTile){
    		IPowerTile tile = (IPowerTile)tile_e;
    		
    		if(tile.AcceptsPower()){
    		if(tile.GetPower() < tile.GetMaxPower() && tile.GetPower() + Amount <= tile.GetMaxPower()){
    			tile.SetPower(tile.GetPower() + Amount);
    		}
    			return;
    		}else{
    			tile.SetPower(tile.GetMaxPower());
    			return;
    		}

    		
    	}else if (tile_e instanceof TileEntityPowerCable){
    		TileEntityPowerCable tile = (TileEntityPowerCable)tile_e;
    		
    		if(tile.GetPower() < tile.MaxPower && tile.GetPower() + Amount <= tile.MaxPower){
    			tile.SetPower(tile.GetPower() + Amount);
    			return;
    		}else{
    			tile.SetPower(tile.MaxPower);
    			return;
    		}
    		
    	}
   
    	
    }
    
    public boolean AceptsPower(int x, int y, int z){
    	
    	TileEntity tile_e = this.worldObj.getTileEntity(x, y, z);
    	if(tile_e instanceof IPowerTile){
    		 if (tile_e instanceof TileEntityPowerCable){
    			int Meta = this.worldObj.getBlockMetadata(x, y, z);
    			TileEntityPowerCable tile = (TileEntityPowerCable)tile_e;
    			
    			return Meta != 1 && tile.GetPower() < tile.MaxPower;

    		}else if (tile_e instanceof IPowerTile){
    			IPowerTile tile = (IPowerTile)tile_e;
    			
    			return tile.GetPower() < tile.GetMaxPower();
    		}
    		
    		return true;
    	}

    	return false;
    	

    }


	@Override
	public void SetGeneratedPower(int i) {
		Produced = i;
	}


}
