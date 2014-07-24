package com.miscitems.MiscItemsAndBlocks.Container.Electric;

import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotBatterySlot;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotItemsOnly;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityLaser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerLaser  extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    int LastPower;
    int LastMaxPower;
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

        int m = 2;

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
        par1ICrafting.sendProgressBarUpdate(this, 0, (int)this.tile.GetPower());
        par1ICrafting.sendProgressBarUpdate(this, 1, (int)this.tile.GetMaxPower());
		
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
            
            if (this.LastMaxPower != this.tile.GetMaxPower())
{
    icrafting.sendProgressBarUpdate(this, 1, (int)this.tile.GetMaxPower());
}
            
            
            
            
        }

        this.LastPower = (int)this.tile.GetPower();
        this.LastMaxPower = (int)this.tile.GetMaxPower();
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tile.SetPower(par2);
        }

        if (par1 == 1)
    {
        this.tile.SetMaxPower(par2);
    }
        
        

    }
}