package com.miscitems.MiscItemsAndBlocks.Container.Electric;

import MiscUtils.GuiObjects.Slots.SlotOutput;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotChipSlot;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotChipSlotOut;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWirelessItemTrans;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerWirelessItemTransfer extends Container{

    private TileEntityWirelessItemTrans tile;
    
    int LastCardMode;
    
    int LastX;
    int LastY;
    int LastZ;
    
    public ContainerWirelessItemTransfer(InventoryPlayer InvPlayer, TileEntityWirelessItemTrans tile)
    {
    	this.tile = tile;
    	
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 222));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 164 + y * 18));
    		}
    		
    	}
    		
    		addSlotToContainer(new ModSlotChipSlot(tile, 0, 26, 7));
    		addSlotToContainer(new ModSlotChipSlotOut(tile, 1, 26, 50));
    		
    		addSlotToContainer(new ModSlotChipSlot(tile, 2, 61, 7));
    		
    		addSlotToContainer(new Slot(tile, 3, 26, 81));
    		
    		
    		
    		   for(int y = 0; y < 2; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new SlotOutput(tile, 4 + ((y * 9) + x), 8 + (x * 18), 108 + (y * 18)));
    			
    			
    		}
    		}
    		
    		   
    

}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}


    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {

        int m = 22;

        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 < m)
            {
                if (!this.mergeItemStack(itemstack1, m, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, m, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

	    public void addCraftingToCrafters(ICrafting par1ICrafting)
	    {
	        super.addCraftingToCrafters(par1ICrafting);
	        par1ICrafting.sendProgressBarUpdate(this, 1, this.tile.GetCardMode());
	        
	        par1ICrafting.sendProgressBarUpdate(this, 2, this.tile.GetX());
	        par1ICrafting.sendProgressBarUpdate(this, 3, this.tile.GetY());
	        par1ICrafting.sendProgressBarUpdate(this, 4, this.tile.GetZ());
	    }

	    public void detectAndSendChanges()
	    {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.crafters.size(); ++i)
	        {
	            ICrafting icrafting = (ICrafting)this.crafters.get(i);

	            

	            if (this.LastCardMode != this.tile.GetCardMode())
	            {
	                icrafting.sendProgressBarUpdate(this, 1, this.tile.GetCardMode());
	            }
	            
	            if (this.LastX != this.tile.GetX())
	            {
	                icrafting.sendProgressBarUpdate(this, 2, this.tile.GetX());
	            }
	            
	            if (this.LastY != this.tile.GetY())
	            {
	                icrafting.sendProgressBarUpdate(this, 3, this.tile.GetY());
	            }
	            
	            if (this.LastZ != this.tile.GetZ())
	            {
	                icrafting.sendProgressBarUpdate(this, 4, this.tile.GetZ());
	            }
	            
	            
	        }

	        this.LastCardMode = this.tile.GetCardMode();
	        
	        this.LastX = this.tile.GetX();
	        this.LastY = this.tile.GetY();
	        this.LastZ = this.tile.GetZ();
	        
	    }

	    @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int par1, int par2)
	    {

	        
	        if(par1 == 1){
	        	this.tile.SetCardMode(par2);
	        }
	        
	        
	        if(par1 == 2){
	        	this.tile.SetX(par2);
	        }
	        
	        if(par1 == 3){
	        	this.tile.SetY(par2);
	        }
	        
	        if(par1 == 4){
	        	this.tile.SetZ(par2);
	        }

	        

	    }
		  
	  
}