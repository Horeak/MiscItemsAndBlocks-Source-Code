package com.miscitems.MiscItemsAndBlocks.Item.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityCardboardBox;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ModItemBlockBox extends ItemBlock {

	public ModItemBlockBox(Block par1) {
		super(par1);
	}

	
	 public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	    {
	      
		 if(stack.stackTagCompound != null){
			 world.setBlock(x, y, z, ModBlocks.Box);
			 if(world.getTileEntity(x, y, z) != null){
				 TileEntityCardboardBox tile = (TileEntityCardboardBox)world.getTileEntity(x, y, z);
				 
				 NBTTagList nbttaglist = stack.stackTagCompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
			        for (int i = 0; i < nbttaglist.tagCount(); i++)
			        {
			            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			            int j = nbttagcompound1.getByte("Slot") & 0xff;
			            if (j >= 0 && j < tile.getSizeInventory())
			            {
			            	tile.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
			            }
			        }
			 }
			 
			 
		 }else{
			 world.setBlock(x, y, z, ModBlocks.Box); 
		 }
	       return true;
	    }
	 
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    
	    	
	    	if(Keyboard.isKeyDown(42)){
	    	if(itemstack.stackTagCompound != null){


	    		
				NBTTagList items = itemstack.stackTagCompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
	    		if(items.tagCount() > 0)
	    		list.add("Contains: ");
	    		else
	    			list.add("Cardboard box is empty");
	    		for(int i = 0; i < items.tagCount(); i++){
	    			
	    			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);

	    			list.add("- " + ItemStack.loadItemStackFromNBT(item).getDisplayName() + " x" + ItemStack.loadItemStackFromNBT(item).stackSize);
	    			
    				ItemStack stack = ItemStack.loadItemStackFromNBT(item);
    				
    				if(stack.getItem() instanceof ItemTool){
    					list.remove(list.size() - 1);
    	    			list.add("- " + stack.getDisplayName() + " x" + stack.stackSize + " Dur.:" + (stack.getMaxDamage() - stack.getItemDamage() + "/" + stack.getItemDamage()));
    				}
	    				
	    				if(stack.stackTagCompound != null && stack.stackTagCompound.hasKey("ench")){
	    					
		    				list.add("  - Enchantments: ");
	    					
	    					 NBTTagList nbttaglist = (NBTTagList)stack.stackTagCompound.getTag("ench");

	    				        if (nbttaglist != null)
	    				        {
	    				            for (int j = 0; j < nbttaglist.tagCount(); ++j)
	    				            {
	    				                short short1 = ((NBTTagCompound)nbttaglist.getCompoundTagAt(j)).getShort("id");
	    				                short short2 = ((NBTTagCompound)nbttaglist.getCompoundTagAt(j)).getShort("lvl");

	    				                if (Enchantment.enchantmentsList[short1] != null)
	    				                {
	    				                    list.add("    - " + Enchantment.enchantmentsList[short1].getTranslatedName(short2));
	    				                }
	    				            }
	    				        }
	    				}

	    				
	    			
	    			

	    		}
	    		
	    		
	    	}else{
    			list.add("Cardboard box is empty");
	    	}
	    	
	    	}else{
	    		list.add("< Hold Shift for info >");
	    	}
	    }
}
