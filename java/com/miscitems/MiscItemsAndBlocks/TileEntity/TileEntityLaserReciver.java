package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Laser.ILaserReciver;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserInGame;
import com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Electric.IPowerTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityLaserReciver extends TileEntity implements ILaserReciver{

	public boolean Redstone;
	
	@Override
	public int getX() {
		return xCoord;
	}

	@Override
	public int getY() {
		return yCoord;
	}

	@Override
	public int getZ() {
		return zCoord;
	}

	@Override
	public World getWorld() {
		return worldObj;
	}
	
	
	int ResetTime = 0;
	int Reset = 2;
	
	public void updateEntity(){
		if(ResetTime <= Reset)
			ResetTime++;
		else{
			Redstone = false;
			
			worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlock(xCoord, yCoord, zCoord));
			
		}
		
	}

	@Override
	public boolean canPassOnSide(World world, int orginX, int orginY, int orginZ, int side, LaserInGame laserInGame) {
		

		TileEntity tile_e = world.getTileEntity(orginX, orginY, orginZ);
		if(tile_e instanceof TileEntityLaser){
			TileEntityLaser tile = (TileEntityLaser)tile_e;
			//z+
			
			
			ResetTime = 0;
			
			if(tile.getStackInSlot(0) != null){
				if(tile.getStackInSlot(0).stackTagCompound != null){
				boolean Redstone = tile.getStackInSlot(0).stackTagCompound.getBoolean("Redstone");
				boolean Power = tile.getStackInSlot(0).stackTagCompound.getBoolean("TransferPower");
				
				this.Redstone = Redstone;
				
				world.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, world.getBlock(xCoord, yCoord, zCoord));
				
		if(side == 4){
			
			if(Power)
			if(world.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof IPowerTile){
				if(world.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof IPowerTile){
					IPowerTile tilePow = (IPowerTile)world.getTileEntity(xCoord + 1, yCoord, zCoord);
					if(tile.GetPower() > 0 && tilePow.GetPower() < tilePow.GetMaxPower()){
					tile.SetPower(tile.GetPower() - 1);
					tilePow.SetPower(tilePow.GetPower() + 1);
					
					}
				}
			}
			
			
		

		
		}else if(side == 3){

			if(Power)
			if(world.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof IPowerTile){
				if(world.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof IPowerTile){
					IPowerTile tilePow = (IPowerTile)world.getTileEntity(xCoord, yCoord, zCoord - 1);
					if(tile.GetPower() > 0 && tilePow.GetPower() < tilePow.GetMaxPower()){
					tile.SetPower(tile.GetPower() - 1);
					tilePow.SetPower(tilePow.GetPower() + 1);
					
					}
				}
			}
			
			
		
			

		
		}else if (side == 2){
			
			
			if(Power)
			if(world.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof IPowerTile ){
				if(world.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof IPowerTile){
					IPowerTile tilePow = (IPowerTile)world.getTileEntity(xCoord, yCoord, zCoord + 1);
					if(tile.GetPower() > 0 && tilePow.GetPower() < tilePow.GetMaxPower()){
					tile.SetPower(tile.GetPower() - 1);
					tilePow.SetPower(tilePow.GetPower() + 1);
					
					}
				}
			
			
		}
			
			

			
		}else if (side == 5){
			
			if(Power)
				if(world.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof IPowerTile){
					if(world.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof IPowerTile){
						IPowerTile tilePow = (IPowerTile)world.getTileEntity(xCoord - 1, yCoord, zCoord);
						if(tile.GetPower() > 0 && tilePow.GetPower() < tilePow.GetMaxPower()){
						tile.SetPower(tile.GetPower() - 1);
						tilePow.SetPower(tilePow.GetPower() + 1);
						
						}
					}
				
				
			}
			

			
		}
		
		
		
				
				
				}
		}
		
		}
		return false;
	}

	@Override
	public void passLaser(World world, int orginX, int orginY, int orginZ, int side, LaserInGame laserInGame) {

	}

	@Override
	public void removeLasersFromSide(World world, int orginX, int orginY, int orginZ, int side) {
	}

	

}
