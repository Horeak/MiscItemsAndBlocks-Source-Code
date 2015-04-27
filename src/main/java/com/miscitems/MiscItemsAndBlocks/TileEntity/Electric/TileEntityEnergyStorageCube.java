package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;


import MiscItemsApi.Electric.IEnergyEmitter;
import MiscItemsApi.Electric.IWrenchAble;
import MiscItemsApi.Electric.PacketUtils;
import MiscItemsApi.Electric.PowerPacket;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;


public class TileEntityEnergyStorageCube extends TileEntityPowerInv implements IWrenchAble, IEnergyEmitter{

	public TileEntityEnergyStorageCube() {
		super(6, "Charger", 64);
	}

	int Ticks = 3;
	int CurrentTick = 0;
	public double PrimePower = 5000;
	public double MaxPower = PrimePower;
    
    public ForgeDirection forgeDirection;
	
	public double UpgradeAmount = 100;
	


	
	public double GetMaxPower(){
		return this.MaxPower;
	}

    @Override
    public void OnRecivedEnergyPacket(PowerPacket packet) {

        AddPower(packet.Stored);
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


        forgeDirection = ForgeDirection.getOrientation(worldObj.getBlockMetadata(xCoord,yCoord,zCoord));

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


            }
        }


    	

    	if( GetPower() > GetMaxPower()){
    		SetPower(GetMaxPower());
    	}



    	if(CurrentTick >= Ticks){
    		CurrentTick = 0;



            int PowerToSend  = 0;

            if (GetPower() > 0) {
                PowerToSend = 1;

                if (GetPower() > 100)
                    PowerToSend = 100;

                else if (GetPower() > 10)
                    PowerToSend = 10;
            }




            if(PowerToSend > 0) {

                    PowerPacket packet = new PowerPacket(forgeDirection.getOpposite(), PowerToSend, -1);
                    PacketUtils.SendPacketToDir(packet, forgeDirection, this);



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


    @Override
    public void OnSendEnergy(PowerPacket packet) {

    }

    @Override
    public void SentEnergySuccessfully(PowerPacket packet) {
        SetPower(GetPower() - packet.Stored);

    }
}
