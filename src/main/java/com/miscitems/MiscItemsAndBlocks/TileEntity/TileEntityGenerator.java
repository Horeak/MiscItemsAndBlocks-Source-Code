package com.miscitems.MiscItemsAndBlocks.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityGenerator extends TileEntityPowerGeneration{

	public TileEntityGenerator() {
		super(1, "CoalGenerator", 64);
	}


    int TimeLeft = 0;
	int MaxTime = 80;
    boolean CanSend = true;



    @Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
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


		compound.setInteger("TimeLeft", this.TimeLeft);
		isProvidingPower = compound.getBoolean("Providing");

	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		

		NBTTagList nbttaglist = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		Inv = new ItemStack[getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xff;
            if (j >= 0 && j < Inv.length)
            {
                this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
            }
        }

		TimeLeft = compound.getInteger("TimeLeft");
		compound.setBoolean("Providing", isProvidingPower);

		

		
	}


    public void updateEntity()
    {

    	if(this.getStackInSlot(0) != null){
    		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    		if(IsFuel(this.getStackInSlot(0)) && CanSend){
    			if(TimeLeft == MaxTime){
    				TimeLeft = 0;
                    CanSend = SendPower(getItemBurnTime(this.getStackInSlot(0)) / 380);
                    this.decrStackSize(0, 1);
    				
    			}else{
    				TimeLeft++;
    				
    			}
    			
    			
    		}else if(!CanSend){
                CanSend = SendPower(0);
            }
    	}
    	
    	else {
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            if(TimeLeft > 0)
                TimeLeft = 0;
        }

    	
    	
    }

    public int GetTimeLeft(){
    	return TimeLeft;
    }
    
    public int GetMaxTime(){
    	return MaxTime;
    }
    

    
    public void SetTimeLeft(int i){
    	TimeLeft = i;
    }

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {
        return false;
	}


    public void OnWork(World world, int x, int y, int z){

    }

	@Override
	public double GeneratedPower() {
		return 1;
	}

    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }



    public boolean IsFuel(ItemStack item){
        return getItemBurnTime(item) > 0;
    }

}
