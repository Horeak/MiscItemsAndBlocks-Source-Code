package com.miscitems.MiscItemsAndBlocks.TileEntity;

import MiscItemsApi.Electric.IPowerCable;
import MiscItemsApi.Electric.IPowerGeneration;
import MiscItemsApi.Electric.IPowerTile;
import MiscItemsApi.Electric.IWrenchAble;
import com.miscitems.MiscItemsAndBlocks.Block.ModBlockPowerCable;
import com.miscitems.MiscItemsAndBlocks.Laser.LaserUtil;
import com.miscitems.MiscItemsAndBlocks.Utils.Handlers.ChatMessageHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityPowerCable extends TileEntity implements IPowerCable, IWrenchAble {


	
       
    private int Power;
    private int MaxPower = 4;


    @Override
    public void OnWrenched(EntityPlayer player, int x, int y, int z) {


        World world = player.worldObj;
            if (!world.isRemote) {


                int Meta = world.getBlockMetadata(x, y, z);


                if (player.isSneaking()) {
                    if (Meta > 0) {
                        world.setBlockMetadataWithNotify(x, y, z, Meta - 1, 2);
                        Meta = world.getBlockMetadata(x, y, z);
                    }

                    ChatMessageHandler.sendChatToPlayer(player, ModBlockPowerCable.messages[Meta]);


                }
            }
        }

       
       
       
	   @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setInteger("Power", this.Power);

           compound.setInteger("MaxPower", this.MaxPower);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
	
		
		Power = compound.getInteger("Power");
        MaxPower = compound.getInteger("MaxPower");

		
		
		

		
	}
	
	
	boolean Top, Bottom, Left, Right, Front, Back;
	
    public void updateEntity()
    {
    	
    	
    	if(Power > MaxPower)
    		Power = MaxPower;
    	
 	   World world = this.worldObj;
       int X = this.xCoord;
       int Y = this.yCoord;
       int Z = this.zCoord;
  
    	
    	boolean Top, Bottom, Left, Right, Front, Back;
        Front = IsPowerBlock(world, X, Y, Z + 1);
        Back = IsPowerBlock(world, X, Y, Z - 1);
        Right = IsPowerBlock(world, X - 1, Y, Z);
        Left = IsPowerBlock(world, X + 1, Y, Z);
        Bottom = IsPowerBlock(world, X, Y - 1, Z);
        
        Top = IsPowerBlock(world, X, Y + 1, Z);
        
        
        
        if(Top)
        	SendPowerToPowerReciver(world, X, Y + 1, Z);
        
        if(Front)
        	SendPowerToPowerReciver(world, X, Y, Z + 1);
        
        if(Back)
        	SendPowerToPowerReciver(world, X, Y, Z - 1);
        
        if(Right)
        	SendPowerToPowerReciver(world, X - 1, Y, Z);
        
        if(Left)
        	SendPowerToPowerReciver(world, X + 1, Y, Z);
        
        if(Bottom)
        	SendPowerToPowerReciver(world, X, Y - 1, Z);
        

        
  
        		
        		
        	}
        

    
    
    public int GetPower(){
    	return Power;
    }
    
    public int GetMaxPower(){
    	return MaxPower;
    }

    @Override
    public void SetMaxPower(int i) {
        MaxPower = i;
    }

    public int GetPowerSpaceLeft(){
    	return MaxPower - Power;
    }
    
    public void SetPower(int i){
    	Power = i;
    }

    @Override
    public void AddPower(int Amount) {

        if(Power + Amount <= MaxPower)
            Power += Amount;
        else
            Power = MaxPower;
    }

    public boolean IsPowerBlock(World world, int x, int y, int z){
    	
    	Block block = world.getBlock(x, y, z);
    	TileEntity tile = world.getTileEntity(x, y, z);
    	int Meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

    	if(Meta != 1)
    	if(tile instanceof IPowerTile && ((IPowerTile)tile).ConnectsToCables())return true;
    	if(Meta != 1)
    	if(tile instanceof IPowerGeneration)return true;
    	if(Meta != 2)
    	if(tile instanceof IPowerCable)return true;
    	
    	// 1 No Machines
    	// 2 No Cables

    	
    	return false;
    }
 public void SendPowerToPowerReciver(World world, int x, int y, int z){
	 
 	int Meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    int BMeta = world.getBlockMetadata(x, y, z);
    
    
    if(Meta != 1){
    	if(world.getTileEntity(x, y, z) instanceof TileEntityEnergyStorageCube){
		if(this.xCoord != x + ForgeDirection.getOrientation(LaserUtil.getOrientation(BMeta)).offsetX || this.yCoord != y + ForgeDirection.getOrientation(LaserUtil.getOrientation(BMeta)).offsetY || this.zCoord != z + ForgeDirection.getOrientation(LaserUtil.getOrientation(BMeta)).offsetZ){

            if(world.getTileEntity(x, y, z) instanceof IPowerTile){
				IPowerTile tile = (IPowerTile)world.getTileEntity(x, y, z);
	    		
	    		if(tile.GetPower() < tile.GetMaxPower()){
	    			if(GetPower() > 0){
	    				tile.AddPower(1);
                        SetPower(GetPower() - 1);
	    			}
	    		}else{
	    			tile.SetPower(tile.GetMaxPower());
	    		}
	    		
	    	}
		}
    }else if(world.getTileEntity(x, y, z) instanceof IPowerTile){
			IPowerTile tile = (IPowerTile)world.getTileEntity(x, y, z);
    		
    		if(tile.GetPower() < tile.GetMaxPower()){
    			if(GetPower() > 0){
    				tile.SetPower(tile.GetPower() + 1);
                    SetPower(GetPower() - 1);
    			}
    		}else{
    			tile.SetPower(tile.GetMaxPower());
    		}
    		
    	}else if (world.getTileEntity(x, y, z) instanceof IPowerCable){
            int Meta2 = world.getBlockMetadata(x, y, z);


            if(GetPower() > 0){
            if(Meta == 4 && Meta2 == 4)
                Cable(world, x, y, z);
            else if (Meta == 4 && Meta2 == 5)
                Cable(world, x, y, z);
            else if (Meta == 5)
                Cable(world, x, y, z);
            else
            if (Meta != 2 && Meta != 4 && Meta2 != 4)
                Cable(world, x, y, z);
        }

        }
    }

 }



	 


   public void Cable(World world, int x, int y, int z){
	   if(world.getTileEntity(x, y, z) instanceof IPowerCable){

           IPowerCable tile = (IPowerCable)world.getTileEntity(x, y, z);

           if(tile.GetPower() < tile.GetMaxPower() && tile.GetPower() < GetPower()){
               if(GetPower() > 0){
                   tile.SetPower(tile.GetPower() + 1);
                   SetPower(GetPower() - 1);
               }
           }else if(tile.GetPower() > tile.GetMaxPower()){
               tile.SetPower(tile.GetMaxPower());
           }


       }

}
}


