package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TileEntitySolarPanel extends TileEntityPowerGeneration{


	public TileEntitySolarPanel() {
		super(0, "Solar", 0);
	}

    public void updateEntity()
    {
        super.updateEntity();
    }

	int Meta = 0;
	
    
    public int GetMeta(){
    	return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    }
    
    public void SetMeta(int i){
    	this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
    }
    

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {
		if(!world.isRemote){
			
			if(world.isRaining()){
				world.setBlockMetadataWithNotify(X, Y, Z, 3, 2);
				return false;
			}
			
			if(!world.isDaytime()){
				world.setBlockMetadataWithNotify(X, Y, Z, 4, 2);
				return false;
			}
			
			
			
			if(!world.canBlockSeeTheSky(X, Y + 1, Z)){
				world.setBlockMetadataWithNotify(X, Y, Z, 2, 2);
				return false;
			}
			
			
			
			world.setBlockMetadataWithNotify(X, Y, Z, 0, 2);
			return world.canBlockSeeTheSky(X, Y + 1, Z) && world.isDaytime();
		}
		
		return false;
	}



	
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	        	
	            return true;
	        }
	        else
	        {
	        	
	        	
	        	
	        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 0, par1World, par2, par3, par4);
	            return true;
	        }
	    }


	@Override
	public double GeneratedPower() {
		return 3;
	}


}
