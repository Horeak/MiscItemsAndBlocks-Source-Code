package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscItemsApi.Electric.IPowerGeneration;
import MiscItemsApi.Electric.IEnergyEmitter;
import MiscItemsApi.Electric.PacketUtils;
import MiscItemsApi.Electric.PowerPacket;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract  class TileEntityPowerGeneration extends TileEntityPowerInv implements IPowerGeneration, IEnergyEmitter{



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
	

    public boolean SendPower(double Power){

        int j = PacketUtils.GetValidDirections(ForgeDirection.UNKNOWN, this);
        PowerPacket packet = new PowerPacket(ForgeDirection.UNKNOWN, Produced / j, -1);

        PacketUtils.SendPacket(packet, this);
        this.OnWork(worldObj, xCoord, yCoord, zCoord);

        return j > 0;
    }
	
    public void updateEntity()
    {
        Produced = GeneratedPower();
        if(!worldObj.isRemote){

        int j = PacketUtils.GetValidDirections(ForgeDirection.UNKNOWN, this) + 80;
        boolean g = CanWork(worldObj, xCoord, yCoord, zCoord);

        PowerPacket packet = new PowerPacket(ForgeDirection.UNKNOWN, Produced / (double)j, -1);

       if(g){

           PacketUtils.SendPacket(packet, this);
           this.OnWork(worldObj, xCoord, yCoord, zCoord);

       }
    	
    }
    }



	@Override
	public void SetGeneratedPower(double i) {
		Produced = i;
	}



    @Override
    public void OnSendEnergy(PowerPacket packet) {

    }

    @Override
    public void SentEnergySuccessfully(PowerPacket packet) {

    }
}
