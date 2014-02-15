package com.miscitems.MiscItemsAndBlocks.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Slots.ModSlotBatterySlot;
import com.miscitems.MiscItemsAndBlocks.Slots.ModSlotItemsOnly;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityLaser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerLaser  extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    int LastPower;
    public TileEntityLaser tile;

	
    public ContainerLaser(InventoryPlayer InvPlayer, TileEntityLaser tile)
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
    	
    	
    	addSlotToContainer(new ModSlotItemsOnly(tile, 0, 80, 30, new Item[]{ModItems.Lens}));

    	addSlotToContainer(new ModSlotBatterySlot(tile, 1, 146, 29));

}
    

    
    @Override
	  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {

		  return null;
	    }
    
    
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tile.GetPower());
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.LastPower != this.tile.GetPower())
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tile.GetPower());
            }
            
            
            
            
        }

        this.LastPower = this.tile.GetPower();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tile.SetPower(par2);
        }

        
        

    }
}