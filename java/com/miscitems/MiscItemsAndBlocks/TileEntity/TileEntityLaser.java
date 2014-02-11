package com.miscitems.MiscItemsAndBlocks.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.LibMisc.ILaserProvider;
import com.miscitems.MiscItemsAndBlocks.LibMisc.ILaserReciver;
import com.miscitems.MiscItemsAndBlocks.LibMisc.LaserInGame;
import com.miscitems.MiscItemsAndBlocks.LibMisc.LaserRegistry;
import com.miscitems.MiscItemsAndBlocks.LibMisc.LaserUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityLaser extends TileEntityLaserBase implements ILaserProvider{

	
public TileEntityLaser() {
		super(1, "Laser Block", 1, 1000);
	}

public boolean Powered = false;
private int lagReduce = -1;

public int Red = 0;
public int Blue = 0;
public int Green = 0;

public int Power = 0;
public int Strength = 0;

public boolean Valid = false;

@Override
public void updateEntity() {
	
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






if(Valid){
ILaserReciver reciver = LaserUtil.getFirstReciver(this, this.getBlockMetadata());
if(reciver != null) {
boolean hasSignal = (this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord));
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

}

