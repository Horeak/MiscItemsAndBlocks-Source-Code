package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserUtil;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerItem;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerTile;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCharger extends TileEntityPowerInv{

	public TileEntityCharger() {
		super(6, "Charger", 64);
	}
	
	int Power = 0;
	int Ticks = 3;
	int GenerateTime = 0;
	int CurrentTick = 0;
	public int PrimePower = 5000;
	public int MaxPower = PrimePower;
	
	public int UpgradeAmount = 100;
	
	
	public int GetPower(){
		return this.Power;
	}
	
	
	public void SetPower(int i){
		this.Power = i;
	}
	
	public int GetMaxPower(){
		return this.MaxPower;
	}
	
	
	
	   @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		

		
		compound.setInteger("Power", Power);
		compound.setInteger("MaxPower", MaxPower);
		
		compound.setInteger("Tick", CurrentTick);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);

		
		Power = compound.getInteger("Power");
		MaxPower = compound.getInteger("MaxPower");
		
		CurrentTick = compound.getInteger("Tick");
		

		

		
	}
	
	
    public void updateEntity()
    {
    	


    	int Bigger = 0;
    	
    	if(this.getStackInSlot(2) != null){
    		if(this.getStackInSlot(2).getItemDamage() == 0){
    			Bigger += this.getStackInSlot(2).stackSize * UpgradeAmount;
    		}
    	}
    	
    	if(this.getStackInSlot(3) != null){
    		if(this.getStackInSlot(3).getItemDamage() == 0){
    			Bigger += this.getStackInSlot(3).stackSize * UpgradeAmount;
    		}
    	}
    	
    	if(this.getStackInSlot(4) != null){
    		if(this.getStackInSlot(4).getItemDamage() == 0){
    			Bigger += this.getStackInSlot(4).stackSize * UpgradeAmount;
    		}
    	}
    	
    	if(this.getStackInSlot(5) != null){
    		if(this.getStackInSlot(5).getItemDamage() == 0){
    			Bigger += this.getStackInSlot(5).stackSize * UpgradeAmount;
    		}
    	}
    	
    	if(Bigger > 0){
    		MaxPower = PrimePower + Bigger;
    		Bigger = 0;
    	}else{
    		MaxPower = PrimePower;
    	}
    	
    	
    	
    	
    	
    	

    	ItemStack itemStack = this.getStackInSlot(0);
    	
    	if(itemStack != null){
		
		if(itemStack.getItem() instanceof IPowerItem ){
			if(itemStack.getItemDamage() > 0 && Power > 0){
				Power--;
				itemStack.setItemDamage(itemStack.getItemDamage() - 1);
			}
		}
    	}
    	
    	if(Power < MaxPower){
    	ItemStack emptyStack = this.getStackInSlot(1);
    	
    	if(emptyStack != null){

    		
    		if(emptyStack.getItem() instanceof IPowerItem){
    			if (emptyStack.getItem() == ModItems.CreativeBattery)
    				this.SetPower(this.GetMaxPower());
    			else{
    			int i = emptyStack.getMaxDamage() - emptyStack.getItemDamage();
    			if(i > 0){
    				emptyStack.setItemDamage(emptyStack.getItemDamage() + 1);
    				Power++;
    				
    			}
    			}
    			
    		}
    		
    		
    	}
    	
    	

    	
    	if(Power > MaxPower){
    		Power = MaxPower;
    	}
    	
    	}
    	
    	
      	
    	if(CurrentTick >= Ticks){
    		CurrentTick = 0;
    		
    		

    		
    		if(this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) instanceof IPowerTile){
    			IPowerTile tile = (IPowerTile)this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ);
    			if(Power > 0){
    				if(tile.GetPower() < tile.GetMaxPower()){
    					this.SetPower(this.GetPower() - 1);
    					tile.SetPower(tile.GetPower() + 1);
    				}
    			}
    		}
    		
    		
    		if(this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) instanceof TileEntityPowerCable){
    			TileEntityPowerCable tile = (TileEntityPowerCable)this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ);
    			if(this.worldObj.getBlockMetadata(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) != 1 && this.worldObj.getBlockMetadata(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) != 3){
    				if(Power > 0){
    				if(tile.GetPower() < tile.MaxPower){
    					SetPower(GetPower() - 1);
    					tile.SetPower(tile.GetPower() + 1);
    				}
    			
    			}
    			}
    		}
    		
    		
    		
    		
    		

    	

    		
    		
    	}else{
    		CurrentTick++;
    	}
    	

    	
    }




	@Override
	public boolean CanAcceptPower() {
		return true;
	}
	
	
	

}
