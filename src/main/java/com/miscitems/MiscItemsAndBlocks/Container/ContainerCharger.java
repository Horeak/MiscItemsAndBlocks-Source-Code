package com.miscitems.MiscItemsAndBlocks.Container;

import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.ModSlotArmor;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.SlotPowerStorage;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.SlotUpgrades;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityEnergyStorageCube;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCharger  extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    private TileEntityEnergyStorageCube tile;
    
    int LastPower;
    int LastMaxPower;

	
    public ContainerCharger(InventoryPlayer InvPlayer, TileEntityEnergyStorageCube tile)
    {
    	this.tile = tile;
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 142));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 84 + y * 18));
    		}
    		
    		addSlotToContainer(new SlotPowerStorage(tile, 0, 79, 14));
    		addSlotToContainer(new SlotPowerStorage(tile, 1, 79, 59));
    		
    		addSlotToContainer(new SlotUpgrades(tile, 2, 152, 8));
    		addSlotToContainer(new SlotUpgrades(tile, 3, 152, 26));
    		addSlotToContainer(new SlotUpgrades(tile, 4, 152, 44));
    		addSlotToContainer(new SlotUpgrades(tile, 5, 152, 62));
    		
    		
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 1, 8, 21, 0, InvPlayer.player));
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 2, 8, 39, 1, InvPlayer.player));
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 3, 26, 21, 2, InvPlayer.player));
    		addSlotToContainer(new ModSlotArmor(InvPlayer, InvPlayer.getSizeInventory() - 4, 26, 39, 3, InvPlayer.player));

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
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tile.GetPower());
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tile.GetMaxPower());
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
            
            if (this.LastMaxPower != this.tile.GetMaxPower())
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tile.GetMaxPower());
            }
            
        }

        this.LastPower = this.tile.GetPower();
        this.LastMaxPower = this.tile.GetMaxPower();
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
