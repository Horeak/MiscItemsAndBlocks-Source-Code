package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;


import MiscItemsApi.Electric.IPowerCable;
import MiscItemsApi.Electric.IPowerTile;
import MiscItemsApi.Electric.IWrenchAble;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserUtil;
import com.miscitems.MiscItemsAndBlocks.Utils.PowerUtils;
import cpw.mods.fml.common.Loader;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
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
	public double PrimePower = 5000;
	public double MaxPower = PrimePower;
	
	public double UpgradeAmount = 100;
	


	
	public double GetMaxPower(){
		return this.MaxPower;
	}
	
	
	
	   @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);

           compound.setDouble("MaxPower", MaxPower);

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);

        MaxPower = compound.getDouble("MaxPower");
		

		

		
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
    	
    	
    	
    	
    	
    	

    	ItemStack chargeStack = this.getStackInSlot(0);
        ItemStack dischargeStack = this.getStackInSlot(1);


    	if(chargeStack != null){
		if(chargeStack.getItem() instanceof ModItemPowerTool ){
                if(GetPower() >= 0.1 && ((ModItemPowerTool)chargeStack.getItem()).CurrentPower(chargeStack) < ((ModItemPowerTool)chargeStack.getItem()).MaxPower(chargeStack)) {
                    ((ModItemPowerTool) chargeStack.getItem()).AddPower(chargeStack, 0.1);
                    SetPower(GetPower() - 0.1);
                }


            }else if (chargeStack.getItem() instanceof ModItemElArmor){
            if(GetPower() >= 0.1 && ((ModItemElArmor)chargeStack.getItem()).CurrentPower(chargeStack) < ((ModItemElArmor)chargeStack.getItem()).MaxPower(chargeStack)) {
                ((ModItemElArmor) chargeStack.getItem()).AddPower(chargeStack, 0.1);
                SetPower(GetPower() - 0.1);
            }


        }else {


            if(Loader.isModLoaded("IC2")){
                if(chargeStack.getItem() instanceof IElectricItem){
                    if(GetPower() >= 1) {

                        if (ElectricItem.manager.getCharge(chargeStack) < ((IElectricItem) chargeStack.getItem()).getMaxCharge(chargeStack)) {
                            ElectricItem.manager.charge(chargeStack, PowerUtils.IC2_For_MiscPower, ((IElectricItem) chargeStack.getItem()).getTier(chargeStack), false, false);
                            SetPower(GetPower() - PowerUtils.MiscPower_For_IC2);
                        }

                    }else if (GetPower() > 0.0){
                        if (ElectricItem.manager.getCharge(chargeStack) < ((IElectricItem) chargeStack.getItem()).getMaxCharge(chargeStack)) {
                            ElectricItem.manager.charge(chargeStack, PowerUtils.IC2_For_MiscPower / 10, ((IElectricItem) chargeStack.getItem()).getTier(chargeStack), false, false);
                            SetPower(GetPower() - PowerUtils.MiscPower_For_IC2 / 10);
                        }
                    }


                }
            }
        }

		}

        if(dischargeStack != null && GetPower() < GetMaxPower()){

            if(dischargeStack.getItem() instanceof ModItemPowerTool ){
                if(((ModItemPowerTool)dischargeStack.getItem()).CurrentPower(dischargeStack) > 0) {
                    ((ModItemPowerTool) dischargeStack.getItem()).RemovePower(dischargeStack, 1);
                    AddPower(1);
                }


            }else if (dischargeStack.getItem() instanceof ModItemElArmor){
                if(((ModItemElArmor)dischargeStack.getItem()).CurrentPower(dischargeStack) > 0) {
                    ((ModItemElArmor) dischargeStack.getItem()).RemovePower(dischargeStack, 1);
                    AddPower(1);
                }


            }else {
                if(Loader.isModLoaded("IC2")){
                    if(dischargeStack.getItem() instanceof IElectricItem){
                        if(ElectricItem.manager.getCharge(dischargeStack) > 10) {
                            ElectricItem.manager.discharge(dischargeStack, PowerUtils.IC2_For_MiscPower, ((IElectricItem)dischargeStack.getItem()).getTier(dischargeStack), false, false, false);
                            AddPower(PowerUtils.MiscPower_For_IC2);

                        }else if (ElectricItem.manager.getCharge(dischargeStack) > 0){
                            ElectricItem.manager.discharge(dischargeStack, PowerUtils.IC2_For_MiscPower / 10, ((IElectricItem)dischargeStack.getItem()).getTier(dischargeStack), false, false, false);
                            AddPower(PowerUtils.MiscPower_For_IC2 / 10);
                        }


                    }
                }
            }
        }


    	

    	
    	if( GetPower() > GetMaxPower()){
    		SetPower(GetMaxPower());
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
                if (tile.equals(this))
                  return;

                if( GetPower() > 0){
    				if(tile.GetPower() < tile.GetMaxPower()){
    					SetPower(GetPower() - 1);
    					tile.SetPower(tile.GetPower() + 1);
    				}
    			}
    		}else{
                if(Loader.isModLoaded("IC2")){
                     if(this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ) instanceof IEnergySink) {
                         IEnergySink tile = (IEnergySink) this.worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetX, yCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetY, zCoord + ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)).offsetZ);
                         if (GetPower() > 0) {
                           int t = 1;
                             if(GetPower() > 100)
                                  t = 100;
                             else if (GetPower() > 10)
                                 t = 10;



                             if(tile.getDemandedEnergy() > 0) {
                                 tile.injectEnergy(ForgeDirection.getOrientation(LaserUtil.getOrientation(this.blockMetadata)), (t / 10) * PowerUtils.IC2_For_MiscPower, 10);
                                 SetPower(GetPower() - t);
                             }

                         }
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



    @Override
    public double demandedEnergyUnits() {
        return 1;
    }

    @Override
    public double injectEnergyUnits(ForgeDirection directionFrom, double amount) {
        if(GetPower() + (int)amount < MaxPower)
            AddPower((int)amount);
        else
        SetPower(GetMaxPower());

        return GetPower();
    }

    @Override
    public int getMaxSafeInput() {
        return (int)this.GetMaxPower();
    }

    @Override
    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
        return this.worldObj.getBlockMetadata(xCoord,yCoord,zCoord) != direction.ordinal();
    }
}
