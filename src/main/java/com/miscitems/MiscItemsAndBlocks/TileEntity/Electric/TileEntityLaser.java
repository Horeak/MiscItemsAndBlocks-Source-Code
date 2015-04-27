package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemLens;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserInstance;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.LaserUtil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

import javax.vecmath.Vector3d;

public class TileEntityLaser extends TileEntityPowerInv {

	
public TileEntityLaser() {
		super(2, "Laser Block", 1);
	}

    public boolean Valid = false;
    public boolean Enabled = false;

@Override
public void updateEntity() {


    //Use battery
    ItemStack dischargeStack = this.getStackInSlot(1);
    if (dischargeStack != null && GetPower() < GetMaxPower()) {

        if (dischargeStack.getItem() instanceof ModItemPowerTool) {
            if (((ModItemPowerTool) dischargeStack.getItem()).CurrentPower(dischargeStack) > 0) {
                ((ModItemPowerTool) dischargeStack.getItem()).RemovePower(dischargeStack, 1);
                AddPower(1);
            }


        } else if (dischargeStack.getItem() instanceof ModItemElArmor) {
            if (((ModItemElArmor) dischargeStack.getItem()).CurrentPower(dischargeStack) > 0) {
                ((ModItemElArmor) dischargeStack.getItem()).RemovePower(dischargeStack, 1);
                AddPower(1);
            }


        }
    }



    ItemStack lens = this.getStackInSlot(0);

    if(lens != null && lens.getItem() instanceof ModItemLens && lens.stackTagCompound != null){
        if(GetPower() >= lens.stackTagCompound.getInteger("PowerUse")){
            Valid = true;
        }else{
            Valid = false;
        }

    }else{
        Valid = false;
    }


    boolean Redstone = worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord);
    if (Redstone && !Enabled && Valid) {
        UpdateState(true);

    } else if (!Redstone && Enabled || !Valid) {
        UpdateState(false);
    }

    if (Enabled) {
        LaserInstance laser = GetLaser();


        Vector3d BLPos = LaserUtil.getFirstBlockPos(laser);
        if(BLPos != null){
            laser.ActionOn(BLPos);
        }

        LaserUtil.updateForEntities(laser);


        SetPower(GetPower() - (laser.GetPowerUsage() / (20 * 5)));
    }
}


    public LaserInstance GetLaser(){

        if(!Valid || !Enabled)
            return null;

        ItemStack lens = this.getStackInSlot(0);

        ForgeDirection dir = ForgeDirection.getOrientation(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
        LaserInstance laser = new LaserInstance(worldObj, new Vector3d(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ), ModItemLens.GetLensColor(lens), ModItemLens.GetLensStrength(lens), dir.ordinal());

        laser.power = ModItemLens.GetLensPower(lens);

        laser.Damage = ModItemLens.DoesDamage(lens);
        laser.Redstone = ModItemLens.EmitsRedstone(lens);
        laser.TransPower = ModItemLens.TransfersPower(lens);

        return laser;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
     return INFINITE_EXTENT_AABB;
    }

   @Override
   @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared() {
        return 65536.0D;
    }



    
    @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);

		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);

		
	}

	@Override
	public boolean CanAcceptPower() {
		return true;
	}


	@Override
	public double GetMaxPower() {
		return 1000;
	}


    public void UpdateState(boolean state){
        Enabled = state;
        worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlock(xCoord, yCoord, zCoord));
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

    }
	
}

