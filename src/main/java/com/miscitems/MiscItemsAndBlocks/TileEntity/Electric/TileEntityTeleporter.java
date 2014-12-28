package com.miscitems.MiscItemsAndBlocks.TileEntity.Electric;

import MiscUtils.Utils.TeleportUtil;
import com.miscitems.MiscItemsAndBlocks.Item.Electric.ModItemDataChip;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;

import java.util.List;
import java.util.Random;

public class TileEntityTeleporter extends TileEntityPowerInv{

	
	public TileEntityTeleporter() {
		super(3, "Teleporter", 1);
	}
	
	int CurrentUpdateTick = 0;
	int UpdateTick = 20;


	public void updateEntity(){
		
		if(this.GetPower() >= 100 && IsLinked)
			Mode = 1;
		else if (this.GetPower() >= 100 && !IsLinked || this.GetPower() <= 0 && IsLinked)
			Mode = 2;
		else 
			Mode = 0;
		
		
		
		if(this.getStackInSlot(0) != null ){
			if(this.getStackInSlot(0).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(0).stackTagCompound == null){
				if(this.getStackInSlot(1) == null){
					
					this.setInventorySlotContents(0, null);
					
					ItemStack stack = new ItemStack(ModItems.DataChip, 1, 1);
					
					stack.setTagCompound(new NBTTagCompound());
					stack.stackTagCompound.setString("DataType", "Teleporter");
					stack.stackTagCompound.setInteger("Teleport_x", this.xCoord);
					stack.stackTagCompound.setInteger("Teleport_y", this.yCoord);
					stack.stackTagCompound.setInteger("Teleport_z", this.zCoord);

					stack.stackTagCompound.setInteger("Teleport_world", worldObj.provider.dimensionId);
					
					this.setInventorySlotContents(1, stack);

				}
				}
			}

		}

		World world = null;
		
		if(CurrentUpdateTick >= UpdateTick){
		if(this.getStackInSlot(2) != null ){
			if(this.getStackInSlot(2).getItem() instanceof ModItemDataChip){
				if(this.getStackInSlot(2).stackTagCompound != null){
			

					if(this.getStackInSlot(2).stackTagCompound.getString("DataType").equalsIgnoreCase("Teleporter")){

						x = this.getStackInSlot(2).stackTagCompound.getInteger("Teleport_x");
						y = this.getStackInSlot(2).stackTagCompound.getInteger("Teleport_y");
						z = this.getStackInSlot(2).stackTagCompound.getInteger("Teleport_z");

						int worldId = getStackInSlot(2).stackTagCompound.getInteger("Teleport_world");
						WorldProvider provider = DimensionManager.getProvider(worldId);


						if(provider != null){
							world = provider.worldObj;
						}



						if(world == null) {
							CardMode = 0;
							IsLinked = false;

							x = 0;
							y = 0;
							z = 0;

						}


						if(world != null)
						if(world.getTileEntity(x,y,z)instanceof TileEntityTeleporter){
						CardMode = 1;
						IsLinked = true;
						
						if(GetPower() >= 100)
						Mode = 1;
						else
							Mode = 2;


						}else{
							CardMode = 0;
							IsLinked = false;

							x = 0;
							y = 0;
							z = 0;
						}
					}else{
						CardMode = 2;
					}
			
					
		}else{
			CardMode = 2;
		}
				
			}
			
		}else{
			CardMode = 0;
			IsLinked = false;

			x = 0;
			y = 0;
			z = 0;
		}
		
			
		}else{
			CurrentUpdateTick++;
		}


        AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(xCoord + 0.2, yCoord, zCoord + 0.2, xCoord + 0.9, yCoord + 0.8, zCoord + 0.9);
        List list = worldObj.getEntitiesWithinAABB(Entity.class, aabb);
		
        
        for(int i = 0; i < list.size(); i++){
        	Entity ent = (Entity)list.get(i);

        	if(ent instanceof EntityPlayer){
        		EntityPlayer player = (EntityPlayer)ent;
        		if(player.isSneaking()){
        			
        			if(Mode == 1 && CardMode == 1 && IsLinked){
        				if(!world.isBlockIndirectlyGettingPowered(x, y, z)){
							worldObj.playSound(xCoord, yCoord, zCoord, "portal.trigger", 0.2F, 0.4F, true);
							world.playSound(x, y, z, "portal.trigger", 0.2F, 0.4F, true);


        			for(int g = 0; g < 20; g++){
        				Random rand = new Random();
						worldObj.spawnParticle("smoke", xCoord + rand.nextFloat(), (yCoord + 2), zCoord  + rand.nextFloat(), 0, -0.2, 0);
						world.spawnParticle("smoke", x + rand.nextFloat(), (y + 2), z  + rand.nextFloat(), 0, -0.2, 0);

        			}

							if(!world.isRemote) {
								Chunk chunk = world.getChunkFromBlockCoords(x, z);

								if(!chunk.isChunkLoaded)
								chunk.onChunkLoad();
							}

							if(!worldObj.isRemote) {
								TeleportUtil teleportUtils = new TeleportUtil((WorldServer) worldObj);
								teleportUtils.teleport(player, world);
							}

							player.setLocationAndAngles(x + 0.5, y + 1, z + 0.5, player.rotationYaw, player.rotationPitch);
							SetPower(GetPower() - 100);

        			}
        			
        			
        		}
        	}
        	}
        }
        
	}
	
	public int x = 0;
	public int y = 0;
	public int z = 0;
	
	
	public int GetX(){
		return x;
	}
	
	public int GetY(){
		return y;
	}
	
	public int GetZ(){
		return z;
	}
	
	
	public void SetX(int i){
		x = i;
	}
	
	public void SetY(int i){
		y = i;
	}
	
	public void SetZ(int i){
		z = i;
	}

	public int Mode = 0;
	
	//0 = empty
	//1 = valid
	//2 = invalid
	public int CardMode = 0;
	
	
	public int GetCardMode(){
		return CardMode;
	}
	
	public void SetCardMode(int i){
	
		if(i <= 2)
			CardMode = i;
		else
			CardMode = 0;
	}
	
	public boolean IsLinked;
	
	  public void readFromNBT(NBTTagCompound NBT)
	    {
		  super.readFromNBT(NBT);

		  Mode = NBT.getInteger("Mode");
		  CardMode = NBT.getInteger("CardMode");

	    }


	    public void writeToNBT(NBTTagCompound NBT)
	    {
	      super.writeToNBT(NBT);

	      NBT.setInteger("Mode", Mode);
	      NBT.setInteger("CardMode", CardMode);
	      
	    	
	    }


		@Override
		public boolean CanAcceptPower() {
			return true;
		}

		@Override
		public double GetMaxPower() {
			return 500;
		}
}
