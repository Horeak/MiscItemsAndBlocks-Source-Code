package com.miscitems.MiscItemsAndBlocks.Container;

import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGenerator  extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    private TileEntityGenerator tile;


    int LastTime;
    
    public ContainerGenerator(InventoryPlayer InvPlayer, TileEntityGenerator tile)
    {
    	this.tile = tile;
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    		addSlotToContainer(new Slot(tile, 0, 80, 30));
    	
    }

}
    

    
    @Override
	  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {

		  return null;
	    }
    
    
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tile.GetTimeLeft());
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);


            
            if (this.LastTime != this.tile.GetTimeLeft())
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tile.GetTimeLeft());
            }
            
        }

        this.LastTime = this.tile.GetTimeLeft();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        
        if (par1 == 1)
        {
            this.tile.SetTimeLeft(par2);
        }
        
    }

}

