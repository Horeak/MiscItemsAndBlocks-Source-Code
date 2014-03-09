package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Items.ModItemPowerStorage;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Laser.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
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

public int[] reciverCords = new int[3];

LaserInGame laser = new LaserInGame(LaserRegistry.getLaserFromId("default"));

@Override
public void updateEntity() {
	
	
	
	if(!this.worldObj.isRemote){
			if(BreakTime < MaxTime){
				BreakTime++;
			}else{
				if(BreakTime >= MaxTime){
					BreakTime = 0;
					
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


if(this.GetPower() < this.PowerMax)
if(this.getStackInSlot(1) != null && this.getStackInSlot(1).getItem() instanceof ModItemPowerStorage){
	if(this.getStackInSlot(1).getItem() == ModItems.CreativeBattery)
		this.SetPower(PowerMax);
	else if (this.getStackInSlot(1).getItemDamage() < this.getStackInSlot(1).getMaxDamage()){
		this.getStackInSlot(1).damageItem(1, worldObj.getClosestPlayer(xCoord, yCoord, zCoord, -1));
		this.SetPower(this.GetPower() + 1);
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
	public int GetMaxPower() {
		return 1000;
	}
	
	
}

