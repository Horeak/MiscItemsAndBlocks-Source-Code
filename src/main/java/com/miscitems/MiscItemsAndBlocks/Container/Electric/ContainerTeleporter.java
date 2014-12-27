package com.miscitems.MiscItemsAndBlocks.Container.Electric;

import MiscUtils.Utils.ContainerBase;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotChipSlot;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotChipSlotOut;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityTeleporter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerTeleporter extends ContainerBase {

    private TileEntityTeleporter tile;
    
    int LastPower;
    int LastCardMode;
    int LastMaxPower;
    
    int LastX;
    int LastY;
    int LastZ;
    
    public ContainerTeleporter(InventoryPlayer InvPlayer, TileEntityTeleporter tile)
    {
    	this.tile = tile;
    	
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    	}
    		
    		
    		addSlotToContainer(new ModSlotChipSlot(tile, 0, 26, 7));
    		addSlotToContainer(new ModSlotChipSlotOut(tile, 1, 26, 50));
    		
    		addSlotToContainer(new ModSlotChipSlot(tile, 2, 61, 7));
    		
    		
    	

}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}


	@Override
	public IInventory getTile() {
		return tile;
	}



	    public void addCraftingToCrafters(ICrafting par1ICrafting)
	    {
	        super.addCraftingToCrafters(par1ICrafting);
	        par1ICrafting.sendProgressBarUpdate(this, 0, (int)this.tile.GetPower());
	        par1ICrafting.sendProgressBarUpdate(this, 1, this.tile.GetCardMode());
	        
	        par1ICrafting.sendProgressBarUpdate(this, 2, this.tile.GetX());
	        par1ICrafting.sendProgressBarUpdate(this, 3, this.tile.GetY());
	        par1ICrafting.sendProgressBarUpdate(this, 4, this.tile.GetZ());
	        par1ICrafting.sendProgressBarUpdate(this, 5, (int)this.tile.GetMaxPower());
	    }

	    public void detectAndSendChanges()
	    {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.crafters.size(); ++i)
	        {
	            ICrafting icrafting = (ICrafting)this.crafters.get(i);

	            if (this.LastPower != this.tile.GetPower())
	            {
	                icrafting.sendProgressBarUpdate(this, 0, (int)this.tile.GetPower());
	            }
	            

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
	            if (this.LastMaxPower != this.tile.GetMaxPower())
	            {
	                icrafting.sendProgressBarUpdate(this, 5, (int)this.tile.GetMaxPower());
	            }
	            
	            
	        }

	        this.LastPower = (int)this.tile.GetPower();
	        this.LastCardMode = this.tile.GetCardMode();
	        
	        this.LastX = this.tile.GetX();
	        this.LastY = this.tile.GetY();
	        this.LastZ = this.tile.GetZ();
	        this.LastMaxPower = (int)this.tile.GetMaxPower();
	        
	    }

	    @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int par1, int par2)
	    {
	        if (par1 == 0)
	        {
	            this.tile.SetPower(par2);
	        }
	        
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

	        if (par1 == 5)
        {
            this.tile.SetMaxPower(par2);
        }
	        

	    }
		  
	  
}