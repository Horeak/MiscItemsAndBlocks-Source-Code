package com.miscitems.MiscItemsAndBlocks.TileEntity;


import MiscItemsApi.Electric.IPowerCable;
import MiscItemsApi.Electric.IPowerItem;
import MiscItemsApi.Electric.IPowerTile;
import MiscItemsApi.Electric.IWrenchAble;
import com.miscitems.MiscItemsAndBlocks.Items.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserUtil;
import cpw.mods.fml.common.Optional.Method;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;


public class TileEntityEnergyStorageCube extends TileEntityPowerInv implements IWrenchAble{

	public TileEntityEnergyStorageCube() {
		super(6, "Charger", 64);
	}

	int Ticks = 3;
	int CurrentTick = 0;
	public int PrimePower = 5000;
	public int MaxPower = PrimePower;
	
	public int UpgradeAmount = 100;
	


	
	public int GetMaxPower(){
		return this.MaxPower;
	}
	
	
	
	   @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		



		compound.setInteger("Tick", CurrentTick);
           compound.setInteger("MaxPower", MaxPower);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);


		
		CurrentTick = compound.getInteger("Tick");
        MaxPower = compound.getInteger("MaxPower");
		

		

		
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
    		SetMaxPower(PrimePower + Bigger);
    		Bigger = 0;
    	}else{
            SetMaxPower(PrimePower);
    	}
    	
    	
    	
    	
    	
    	

    	ItemStack itemStack = this.getStackInSlot(0);
    	
    	if(itemStack != null){
		
		if(itemStack.getItem() instanceof IPowerItem ){
			if(itemStack.getItemDamage() > 0 && GetPower() > 0){
				SetPower(GetPower() - 1);
				itemStack.setItemDamage(itemStack.getItemDamage() - 1);
			}
		}
    	}
    	
    	if( GetPower() < GetMaxPower()){
    	ItemStack emptyStack = this.getStackInSlot(1);
    	
    	if(emptyStack != null){

    		
    		if(emptyStack.getItem() instanceof IPowerItem){
    			if ((((ModItemPowerTool)emptyStack.getItem()).IsCreative))
    				this.SetPower(this.GetMaxPower());
    			else{
    			int i = ((ModItemPowerTool)emptyStack.getItem()).CurrentPower(emptyStack);
    			if(i > 0){
    				emptyStack.setItemDamage(emptyStack.getItemDamage() + 1);
    				AddPower(1);
    				
    			}
    			}
    			
    		}
    		
    		
    	}
    	
    	

    	
    	if( GetPower() > GetMaxPower()){
    		SetPower(GetMaxPower());
    	}
    	
    	}
    	
    	
      	
    	if(CurrentTick >= Ticks){
    		CurrentTick = 0;


            if(!worldObj.isRemote){
            if(this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) instanceof IPowerCable){
                IPowerCable tile = (IPowerCable)this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ);

                if(this.worldObj.getBlockMetadata(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) != 1){
                    if( GetPower() > 0){
                        if(tile.GetPower() < tile.GetMaxPower()){
                            SetPower(GetPower() - 1);
                            tile.AddPower(1);
                        }

                    }
                }
    		
            }

            else if(this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) instanceof IPowerTile){
    			IPowerTile tile = (IPowerTile)this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ);
    			if( GetPower() > 0){
    				if(tile.GetPower() < tile.GetMaxPower()){
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


    @Override
    public void OnWrenched(EntityPlayer player, int x, int y, int z) {


    }



    @Method(modid = "IC2")
    @Override
    public double demandedEnergyUnits() {
        return 1;
    }

    @Method(modid = "IC2")
    @Override
    public double injectEnergyUnits(ForgeDirection directionFrom, double amount) {
        if(GetPower() + (int)amount < MaxPower)
            AddPower((int)amount);
        else
        SetPower(GetMaxPower());

        return GetPower();
    }

    @Method(modid = "IC2")
    @Override
    public int getMaxSafeInput() {
        return this.GetMaxPower();
    }

    @Method(modid = "IC2")
    @Override
    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
        return this.worldObj.getBlockMetadata(xCoord,yCoord,zCoord) != direction.ordinal();
    }
}
