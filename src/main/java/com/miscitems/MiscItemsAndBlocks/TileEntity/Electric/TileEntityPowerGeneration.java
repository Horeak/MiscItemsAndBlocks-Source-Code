package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IPowerCable;
import MiscItemsApi.Electric.IPowerGeneration;
import MiscItemsApi.Electric.IPowerTile;
import com.miscitems.MiscItemsAndBlocks.Utils.PowerUtils;
import cpw.mods.fml.common.Loader;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergyTile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract  class TileEntityPowerGeneration extends TileEntityPowerInv implements IPowerGeneration{


    //TODO Rewrite/Fix power gen system (Stopping to send power on world reload, Some times sending power to a machine with already full power, not send power from the sending direction....) (Interact in a network)
    //TODO Change power system from interacting with it self and neighbours only and make power interact in a network
    //TODO Change power gen method. Spread over time instead of multiple energy units at the time

	public TileEntityPowerGeneration(int Slots, String Name, int Size) {
		super(Slots, Name, Size);
	}
	
	public abstract boolean CanWork(World world, int X, int Y, int Z);

    private double Produced;
	
    public void OnWork(World world, int x, int y, int z){}
    
    public boolean isProvidingPower = false;



    @Override
    public boolean CanAcceptPower() {
        return false;
    }

    @Override
    public double GetMaxPower() {
        return 0;
    }
	
	
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
		compound.setDouble("Prod", Produced);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		isProvidingPower = compound.getBoolean("Providing");
		Produced = compound.getDouble("Prod");

	}
	
	int ActiveSides = 0;
	Boolean[] Sides = new Boolean[6];

    public boolean SendPower(double Amount){

        if(!worldObj.isRemote){
            World world = this.worldObj;
            int X = this.xCoord;
            int Y = this.yCoord;
            int Z = this.zCoord;




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



                if(ActiveSides > 0) {

                    for (int h = 0; h < 6; h++) {
                        if (Sides[h] == true) {
                            SendPower(this.worldObj, GetXCord(h), GetYCord(h), GetZCord(h), (Amount / ActiveSides));

                        }
                    }
                }

            if(ActiveSides > 0)
                return true;






        }
        return false;
    }
	
    public void updateEntity()
    {
        Produced = GeneratedPower();

        if(!worldObj.isRemote){
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



                if(ActiveSides > 0) {

                    for (int h = 0; h < 6; h++) {
                        if (Sides[h] == true) {
                            SendPower(this.worldObj, GetXCord(h), GetYCord(h), GetZCord(h), (Produced / ActiveSides) / 30);

                        }
                    }
                    this.OnWork(worldObj, xCoord, yCoord, zCoord);
                }


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
    
    
    public void SendPower(World world, int x, int y, int z, double Amount){
    	
    	TileEntity tile_e = world.getTileEntity(x, y, z);


        if (tile_e instanceof IPowerCable){
            IPowerCable tile = (IPowerCable)tile_e;

            if(tile.GetPower() + Amount <= tile.GetMaxPower()){
                tile.AddPower(Amount);
                return;
            }else{
                tile.SetPower(tile.GetMaxPower());
                return;
            }

        }
        if(tile_e instanceof IPowerTile){
    		IPowerTile tile = (IPowerTile)tile_e;
    		
    		if(tile.AcceptsPower()){
    		if(tile.GetPower() < tile.GetMaxPower() && tile.GetPower() + Amount <= tile.GetMaxPower()){
                tile.AddPower(Amount);
    		}
    			return;
    		}else{
    			tile.SetPower(tile.GetMaxPower());
    			return;
    		}
    	}


        if(Loader.isModLoaded("IC2"))
            if(tile_e instanceof IEnergySink)
                ((IEnergySink)tile_e).injectEnergy(ForgeDirection.UP, Amount * PowerUtils.IC2_For_MiscPower / 3, 1);



    	
    }

    
    public boolean AceptsPower(int x, int y, int z){
    	
    	TileEntity tile_e = this.worldObj.getTileEntity(x, y, z);
        if(tile_e instanceof TileEntityPowerCable || tile_e instanceof IPowerTile){
    	if(tile_e instanceof TileEntityPowerCable){
    			int Meta = this.worldObj.getBlockMetadata(x, y, z);
    			TileEntityPowerCable tile = (TileEntityPowerCable)tile_e;
    			
    			return Meta != 1 && tile.GetPower() < tile.GetMaxPower();

    		}else if (tile_e instanceof IPowerTile){
    			IPowerTile tile = (IPowerTile)tile_e;
    			
    			return tile.GetPower() < tile.GetMaxPower();
    		}


            return true;
        }


        if(Loader.isModLoaded("IC2"))
            return tile_e instanceof IEnergyTile;

    		return false;

    	

    }


	@Override
	public void SetGeneratedPower(double i) {
		Produced = i;
	}


}
