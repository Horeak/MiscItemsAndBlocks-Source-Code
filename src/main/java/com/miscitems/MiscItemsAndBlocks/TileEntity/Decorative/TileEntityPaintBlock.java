package com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.awt.*;

public class TileEntityPaintBlock extends TileEntity{
	
	


	public int Red = 0;
	public int Green = 0;
	public int Blue = 0;
	
	//16.581.375 Color combinations
	
	public static int Max = 255;

    public void UpdateColor(){

        worldObj.markBlockForUpdate(xCoord,yCoord, zCoord);
        worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlock(xCoord, yCoord, zCoord));

    }


	  
      public void SetRed(int i){
    	  if(i < Max + 1 && i > 0)
    	  Red = i;
    	  else if (i >= Max + 1)
    		  Red = Max;
    	  else
    		  Red = 0;
      }
      
      public void SetGreen(int i){
    	  if(i < Max + 1 && i > 0)
    	 Green = i;
    	  else if (i >= Max + 1)
    		  Green = Max;
    	  else
    		  Green = 0;
      }
      
      public void SetBlue(int i){
    	  if(i < Max + 1 && i > 0)
    	  Blue = i;
    	  else if (i >= Max + 1)
    		  Blue = Max;
    	  else
    		  Blue = 0;
      }
      
      
      
      
      public int GetRed(){
    	 return Red;
      }
      
      public int GetGreen(){
    	  return Green;
      }
      
      public int GetBlue(){
    	  return Blue;
      }
      
      public int GetHex(){
    	  Color color = new Color(Red, Green, Blue);
        	  return color.getRGB();

      }
      
      

      @Override
  	public void writeToNBT(NBTTagCompound compound){
  		super.writeToNBT(compound);
  		
  		compound.setInteger("Red", Red);
  		compound.setInteger("Blue", Blue);
  		compound.setInteger("Green", Green);

  		
  	}
  	
  	@Override
  	public void readFromNBT(NBTTagCompound compound){
  		super.readFromNBT(compound);

  		Red = compound.getInteger("Red");
  		Blue = compound.getInteger("Blue");
  		Green = compound.getInteger("Green");
  		
  	}

  	@Override
  	public Packet getDescriptionPacket()
  	{
  	 NBTTagCompound var1 = new NBTTagCompound();
  	 this.writeToNBT(var1);
  	 return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 2, var1);
  	}
  	        
  	@Override
  	public void onDataPacket(NetworkManager netManager, S35PacketUpdateTileEntity packet)
  	{
  		
  	 readFromNBT(packet.func_148857_g());
  	}







}
