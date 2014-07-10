package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemElArmor;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerStorage;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemPowerTool;
import com.miscitems.MiscItemsAndBlocks.Utils.Laser.*;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.Network.Client.ClientLaserUpdatePacket;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.PowerUtils;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class TileEntityLaser extends TileEntityLaserBase implements ILaserProvider{

	
public TileEntityLaser() {
		super(2, "Laser Block", 1);
	}

public boolean Powered = false;
private int lagReduce = -1;

public int Red = 0;
public int Blue = 0;
public int Green = 0;

public int Power = 0;
public int Strength = 0;

public int BreakTime = 0;
public int MaxTime = 2000;

public boolean Valid = false;


LaserInGame laser = new LaserInGame(LaserRegistry.getLaserFromId("default"));

@Override
public void updateEntity() {


    ItemStack dischargeStack = this.getStackInSlot(1);

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

	
	
	boolean hasSignal = this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord);
ILaserReciver reciver = LaserUtil.getFirstReciver(this, this.getBlockMetadata());
if(reciver != null) {
if(!hasSignal) {
reciver.removeLasersFromSide(worldObj, this.xCoord, this.yCoord, this.zCoord, Facing.oppositeSide[this.getBlockMetadata()]);
}
else if(reciver.canPassOnSide(worldObj, this.xCoord, this.yCoord, this.zCoord, Facing.oppositeSide[this.getBlockMetadata()], laser)) {
reciver.passLaser(worldObj, this.xCoord, this.yCoord, this.zCoord, Facing.oppositeSide[this.getBlockMetadata()], laser);
}
}

if(hasSignal) {
AxisAlignedBB boundingBox = getLaserBox(this.xCoord, this.yCoord, this.zCoord);
List<Entity> entities = this.worldObj.getEntitiesWithinAABB(Entity.class, boundingBox);
for(ILaser la : laser.getLaserType()) {
la.performActionOnBoth(entities, this.getBlockMetadata(), this);
if(this.worldObj.isRemote)
la.performActionOnEntitiesClient(entities, this.getBlockMetadata(), this);
else
la.performActionOnEntitiesServer(entities, this.getBlockMetadata(), this);
}
}
	
	this.lagReduce += 1;
	if(this.lagReduce % LaserUtil.TICK_RATE != 0) return;
	


Valid = false;

Power = 0;
Strength = 0;
	
	if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.Lens){
		if(this.getStackInSlot(0).stackTagCompound != null){
			
			if(this.getStackInSlot(0).stackTagCompound.getBoolean("Color")){
			Red = this.getStackInSlot(0).stackTagCompound.getInteger("Red");
			Green = this.getStackInSlot(0).stackTagCompound.getInteger("Green");
			Blue = this.getStackInSlot(0).stackTagCompound.getInteger("Blue");
			}else{
				Red = 255;
				Blue = 255;
				Green = 255;
			}
			
			
			
			
			if(this.GetPower() >= this.getStackInSlot(0).stackTagCompound.getInteger("PowerUse")){
				
				Valid = true;
				

				
				
			}else{
				Valid = false;
			}
			
			
			
			
			
		}else{
			Valid = false;
		}
		
		
	}else{
		Valid = false;
	}
	
	if(this.worldObj.isRemote)
	Powered = (this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord)) && Valid;
	
if(this.worldObj.isRemote) return;


if(this.GetPower() < this.GetMaxPower())
if(this.getStackInSlot(1) != null && this.getStackInSlot(1).getItem() instanceof ModItemPowerStorage){
	if(((ModItemPowerStorage)this.getStackInSlot(1).getItem()).IsCreative)
		this.SetPower(GetMaxPower());
	else if (((ModItemPowerStorage)this.getStackInSlot(1).getItem()).CurrentPower(this.getStackInSlot(1)) > 0){
		this.getStackInSlot(1).attemptDamageItem(1, worldObj.rand);
		this.SetPower(this.GetPower() + 1);
        System.out.println(((ModItemPowerStorage)this.getStackInSlot(1).getItem()).CurrentPower(this.getStackInSlot(1)) > 0);
	}
	
	
}


if(Valid && (this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord)))
	this.SetPower(this.GetPower() - this.getStackInSlot(0).stackTagCompound.getInteger("PowerUse"));

if(Valid){
if(reciver != null) {
Powered = hasSignal && Valid;

LaserInGame laserInGame = this.getOutputLaser(this.getBlockMetadata());

if(!hasSignal) {
reciver.removeLasersFromSide(this.worldObj, this.xCoord, this.yCoord, this.zCoord, Facing.oppositeSide[this.getBlockMetadata()]);
}
else if(reciver.canPassOnSide(this.worldObj, this.xCoord, this.yCoord, this.zCoord, Facing.oppositeSide[this.getBlockMetadata()], laserInGame) && Valid) {
reciver.passLaser(this.worldObj, this.xCoord, this.yCoord, this.zCoord, Facing.oppositeSide[this.getBlockMetadata()], laserInGame);
}
}
this.lagReduce += 1;
}
}

@Override
public LaserInGame getOutputLaser(int side) {
return Valid ? new LaserInGame(LaserRegistry.getLaserFromId("default")).setSide(Facing.oppositeSide[side]) : null;
}

@Override
public int getX() { return this.xCoord; }
@Override
public int getY() { return this.yCoord; }
@Override
public int getZ() { return this.zCoord; }

@Override
public World getWorld() {
return this.worldObj;
}

@Override
public boolean isSendingSignalFromSide(World world, int askerX, int askerY, int askerZ, int side) {
return this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord) && this.getBlockMetadata() == side && Valid;
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
		
		compound.setInteger("Red", Red);
		compound.setInteger("Green", Green);
		compound.setInteger("Blue", Blue);

		compound.setInteger("Power", Power);
		compound.setInteger("Strength", Strength);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
	
		Red = compound.getInteger("Red");
		Green = compound.getInteger("Green");
		Blue = compound.getInteger("Blue");
		
		Power = compound.getInteger("Power");
		Strength = compound.getInteger("Strength");
		
	}

	@Override
	public boolean CanAcceptPower() {
		return true;
	}

	@Override
	public int GetLensStrength() {
		
		if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.Lens){
			if(this.getStackInSlot(0).stackTagCompound != null)
				return this.getStackInSlot(0).stackTagCompound.getInteger("Strength");
			
			
		}
		
		return 0;
	}

	@Override
	public int GetLensPower() {
		
		if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.Lens){
			if(this.getStackInSlot(0).stackTagCompound != null)
				return this.getStackInSlot(0).stackTagCompound.getInteger("Power");
			
			
		}
		return 0;
	}

	@Override
	public boolean TransfersPower() {
		if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.Lens){
			if(this.getStackInSlot(0).stackTagCompound != null)
				return this.getStackInSlot(0).stackTagCompound.getBoolean("TransferPower");
			
			
		}
		return false;
	}

	@Override
	public boolean EmitsRedstone() {
		if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.Lens){
			if(this.getStackInSlot(0).stackTagCompound != null)
				return this.getStackInSlot(0).stackTagCompound.getBoolean("Redstone");
			
			
		}
		return false;
	}

	@Override
	public boolean DoesDamage() {
		if(this.getStackInSlot(0) != null && this.getStackInSlot(0).getItem() == ModItems.Lens){
			if(this.getStackInSlot(0).stackTagCompound != null)
				return !this.getStackInSlot(0).stackTagCompound.getBoolean("Safe");
			
			
		}
		return true;
	}


	public AxisAlignedBB getLaserBox(double x, double y, double z) {
int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
double laserSize = 0.4D;
AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(x + 0.5D - laserSize / 2, y + 0.5D - laserSize / 2, z + 0.5D - laserSize / 2, x + 0.5D + laserSize / 2, y + 0.5D + laserSize / 2, z + 0.5D + laserSize / 2);

double extraMinX = 0.0D;
double extraMinY = 0.0D;
double extraMinZ = 0.0D;

double extraMaxX = 0.0D;
double extraMaxY = 0.0D;
double extraMaxZ = 0.0D;

        if (meta == ForgeDirection.DOWN.ordinal()) {
         for(int i = this.yCoord - 1; this.yCoord - i >= 0; --i) {
         if(LaserWhitelist.canLaserPassThrought(this.worldObj, this.xCoord, i, this.zCoord)) {
         extraMinY++;
         }
         else {
         extraMinY += 1.0D - laserSize;
         break;
         }
         }
        }
        else if (meta == ForgeDirection.UP.ordinal()) {
         for(int i = this.yCoord + 1; i < this.yCoord + this.GetLensStrength(); ++i) {
         if(LaserWhitelist.canLaserPassThrought(this.worldObj, this.xCoord, i, this.zCoord)) {
         extraMaxY++;
         }
         else {
         extraMaxY += 1.0D - laserSize;
         break;
         }
         }
        }
        else if (meta == ForgeDirection.NORTH.ordinal()) {
         for(int i = 1; i < this.GetLensStrength(); ++i) {
         if(LaserWhitelist.canLaserPassThrought(this.worldObj, this.xCoord, this.yCoord, this.zCoord - i)) {
         extraMinZ++;
         }
         else {
         extraMinZ += 1.0D - laserSize;
         break;
         }
         }
        }
        else if (meta == ForgeDirection.SOUTH.ordinal()) {
         for(int i = 1; i < this.GetLensStrength(); ++i) {
         if(LaserWhitelist.canLaserPassThrought(this.worldObj, this.xCoord, this.yCoord, this.zCoord + i)) {
         extraMaxZ++;
         }
         else {
         extraMaxZ += 1.0D - laserSize;
         break;
         }
         }
        }
        else if (meta == ForgeDirection.WEST.ordinal()) {
         for(int i = 1; i < this.GetLensStrength(); ++i) {
         if(LaserWhitelist.canLaserPassThrought(this.worldObj, this.xCoord - i, this.yCoord, this.zCoord)) {
         extraMinX++;
         }
         else {
         extraMinX += 1.0D - laserSize;
         break;
         }
         }
        }
        else if (meta == ForgeDirection.EAST.ordinal()) {
         for(int i = 1; i < this.GetLensStrength(); ++i) {
         if(LaserWhitelist.canLaserPassThrought(this.worldObj, this.xCoord + i, this.yCoord, this.zCoord)) {
         extraMaxX++;
         }
         else {
         extraMaxX += 1.0D - laserSize;
         break;
         }
         }
        }
        boundingBox.setBounds(boundingBox.minX - extraMinX, boundingBox.minY - extraMinY, boundingBox.minZ - extraMinZ, boundingBox.maxX + extraMaxX, boundingBox.maxY + extraMaxY, boundingBox.maxZ + extraMaxZ);
        
        return boundingBox;
}

	@Override
	public double GetMaxPower() {
		return 1000;
	}

    @Override
    public Packet getDescriptionPacket() {

        if(this.getStackInSlot(0) != null)
        if(Red > 0 || Green > 0 || Blue > 0 || Strength > 1 || Power > 0 || Valid)
            return PacketHandler.GetPacket(new ClientLaserUpdatePacket(xCoord, yCoord, zCoord, Red, Green, Blue, Strength, Power));

        else
            return super.getDescriptionPacket();

        else
            return super.getDescriptionPacket();

    }
	
}

