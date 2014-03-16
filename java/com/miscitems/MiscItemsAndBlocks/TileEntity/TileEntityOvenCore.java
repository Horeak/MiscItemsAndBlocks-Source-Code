package com.miscitems.MiscItemsAndBlocks.TileEntity;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.Random;

public class TileEntityOvenCore extends TileEntityInvBase implements ISidedInventory{

	public TileEntityOvenCore() {
		super(3, "PizzaOven", 64);
	}
	
	private static final int[] sidedSlotSides = new int[] { 0 };
	private static final int[] sidedSlotBottom = new int[] { 2, 1 };
	private static final int[] sidedSlotTop = new int[] { 1 };
	
	public int WorkTime = 0;
	public int Heat = 0;
	public int Fuel;
	public int FinishTime = 300;
	int Heatup = 20;
	int counter = 0;

	public boolean Working = false;
	
	Random rand = new Random();
	
	
	   @Override
   	public void writeToNBT(NBTTagCompound compound){
   		super.writeToNBT(compound);
   		this.nbt = compound;
   		
   		NBTTagList Items = new NBTTagList();
   		
   		for (int i = 0; i < getSizeInventory(); i++){
   			
   			ItemStack stack = getStackInSlot(i);
   			if(stack != null){
   				
   				NBTTagCompound item = new NBTTagCompound();
   				item.setByte("Slot", (byte)i);
   				stack.writeToNBT(item);
   				Items.appendTag(item);
   			}
   		}

   		
   		
   		compound.setInteger("WorkTime", this.WorkTime);
   		compound.setInteger("Heat", this.Heat);
   		compound.setTag("Items", Items);
   		compound.setInteger("Fuel", this.Fuel);
   		
   		
   		
   		
   	}
   	
   	@Override
   	public void readFromNBT(NBTTagCompound compound){
   		super.readFromNBT(compound);
   		this.nbt = compound;
   		

   		NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
   		
   		for(int i = 0; i < items.tagCount(); i++){
   			
   			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
   			int slot = item.getByte("Slot");
   			
   			if(slot >= 0 && slot < getSizeInventory()){
   				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
   				
   			}
   			
   		}
   		
   		WorkTime = compound.getInteger("WorkTime");
   		Heat = compound.getInteger("Heat");
   		Fuel = compound.getInteger("Fuel");
   		

   		
   	}
   	
    public void updateEntity()
    {
    	
    	
    	
    	if(this.getStackInSlot(1) == null || this.getStackInSlot(1).getItem() == null){
    		WorkTime = 0;
    	}
    
    	if(Heat > 100){
    		Heat = 100;
    	}
  
    	if(Fuel <= 0 && Heat <= 100){
    		if(IsFuel(this.getStackInSlot(0)) && Heat < 100){
    			
    			Fuel = Fuel + rand.nextInt(FuelValue(this.getStackInSlot(0)));
    			if(this.getStackInSlot(0).getItem() == Items.lava_bucket){
    				this.setInventorySlotContents(0, new ItemStack(Items.bucket));
    			}else{
    					this.decrStackSize(0, 1);
    			}
    			
    			if(Fuel > 20){
    				Fuel = 20;
    			}
    		}
    	

    }else if (Fuel > 0 && Heat <= 100){
    
    	if(Heat < 100)
    	if(this.worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Blocks.fire){
    		Heat = Heat + 1 + rand.nextInt(4);
    	}else{
    	Heat++;
    	}
    	if(Heat > 100){
    		Heat = 100;
    		
    	}else{
    	
    	Fuel--;
    	}
    }
    	

    		
    		if(Heat < 4 && counter == Heatup && this.worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Blocks.fire){
    			Heat++;
    			counter = 0;
    			if(Heat > 100){
    	    		Heat = 100;
    	    		
    	    	}
    		}else{
    			if(Heat > 100)
    	    		Heat = 100;
    			
    			if(Heat < 100)
    			if(this.worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Blocks.fire)
    		counter++;
    	    		

    			else
    				counter = 0;
    			
    			if(Heat > 100)
    	    		Heat = 100;
    			
    	    	if(Heat > 0){
    		if(rand.nextInt(100) == 5){
    			if(Fuel > 0){
    				Fuel--;
    			}else{
    		Heat--;
    			}
    		}
    		}
    		
    
    	}
    	
    	
    	
    	
    	if(Heat > 0){
    		if(this.getStackInSlot(1) != null){


    			if(Output() != null && !this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
    				
    				if(WorkTime >= FinishTime){
    					WorkTime = 0;
    					
    					
    					if(this.getStackInSlot(2) == null || Inv[2].stackSize <= 0){
    					this.setInventorySlotContents(2, Output());
    					}else{
    						Inv[2].stackSize = Inv[2].stackSize + 1;
    					}
    					this.decrStackSize(1, 1);
    				}else{


    		
    					if(Heat > 0 && Heat <= 25){
    						WorkTime++;
    						
    						
    					}else if(Heat > 25 && Heat <= 50){
    						WorkTime = WorkTime + 3;
    						
    					}else if(Heat > 50 && Heat <= 75){
    						WorkTime = WorkTime + 5;
    						
    					}else if(Heat > 75 && Heat <= 100){
    						WorkTime = WorkTime + 10;
    						
    						
    					}
    					
						if(WorkTime > FinishTime){
							WorkTime = FinishTime;
						}
    				}
    			}
    		}
    	}
    	
    	
    	
}
    	
    	
    	
    	
    	

    
    
    public int GetWorkTime(){
    	return WorkTime;
    }
    
    public boolean CanWork(){
    	return Heat > 0;
    }
    
    public void SetWorkTime(int i){
    	WorkTime = i;
    }
    
    public void SetHeat(int i){
    	Heat = i;
    }
    
    public int GetHeat(){
    	return Heat;
    }
    
    public int GetFuel(){
    	return Fuel;
    }
    
    
    public int FuelValue(ItemStack item){
    	
    	if(item != null){
    
    		
    	if(item.getItem() == Items.coal)return 7;
    	if(item == new ItemStack(Blocks.log))return 4;
    	if(item == new ItemStack(Blocks.planks))return 2;
    	if(item.getItem() == Items.lava_bucket)return 40;
    	
    	}

    	return 0;
    }
    
    public boolean IsFuel(ItemStack item){
    	
    	
    	return FuelValue(item) > 0;
    }
    
    
    
    public ItemStack Output(){
    	if(this.getStackInSlot(1) != null){
    	ItemStack itemU = this.getStackInSlot(1);
    	Item item = itemU.getItem();
    	
    	
//    	if(item == ModItems.PizzaRaw)return new ItemStack(ModItems.Pizza, 1, this.getStackInSlot(1).getItemDamage());
//    	if(item == Item.itemRegistry.getObject("beef"))return new ItemStack((Item)Item.itemRegistry.getObject("cooked_beef"));
//    	if(item == Item.itemRegistry.getObject("porkchop"))return new ItemStack((Item)Item.itemRegistry.getObject("cooked_porkchop"));
//    	if(item == Item.itemRegistry.getObject("fish"))return new ItemStack((Item)Item.itemRegistry.getObject("cooked_fish"));
//    	if(item == Item.itemRegistry.getObject("chicken"))return new ItemStack((Item)Item.itemRegistry.getObject("cooked_chicken"));
//    	if(item == ModItems.Flour)return new ItemStack(Items.bread);
//    	if(item == ModItems.RawPenguinMeat)return new ItemStack(ModItems.CookedPenguin);

            if(item instanceof ItemFood){
                if(FurnaceRecipes.smelting().getSmeltingResult(itemU) != null){

                    return FurnaceRecipes.smelting().getSmeltingResult(itemU);

                }

            }else if (FurnaceRecipes.smelting().getSmeltingResult(itemU) != null && FurnaceRecipes.smelting().getSmeltingResult(itemU).getItem() instanceof ItemFood){

                return FurnaceRecipes.smelting().getSmeltingResult(itemU);
            }
    	
    	}
    	
    	
    	return null;
    }

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? sidedSlotBottom : (var1 == 1 ? sidedSlotTop : sidedSlotSides);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}
    
    

}
