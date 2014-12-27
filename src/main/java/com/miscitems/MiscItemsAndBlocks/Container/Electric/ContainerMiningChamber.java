package com.miscitems.MiscItemsAndBlocks.Container.Electric;

import MiscUtils.Utils.ContainerBase;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityMiningStation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

public class ContainerMiningChamber  extends ContainerBase {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
    private TileEntityMiningStation tile;
    
    int LastPower;
    int LastBlocksMined;
    int LastY;
    int LastLastY;
    int LastHoleSize;
    int LastState;
    int LastMaxPower;

	
    public ContainerMiningChamber(InventoryPlayer InvPlayer, TileEntityMiningStation tile)
    {
    	this.tile = tile;
    	
    	for(int x = 0; x < 9; x++){
    		
    		addSlotToContainer(new Slot(InvPlayer, x, 8 + 18 * x, 211));
    	}
    	
    	for(int y = 0; y < 3; y++){
    		for(int x = 0; x < 9; x++){
    			
    			addSlotToContainer(new Slot(InvPlayer, x + y * 9 + 9, 8 + 18 * x, 153 + y * 18));
    		}

    }
    	
    	
    	
    	
    	addSlotToContainer(new Slot(tile, tile.ToolSlot, 24, 24));

}




    
 
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, (int)this.tile.GetPower());
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tile.GetMinedY());
        par1ICrafting.sendProgressBarUpdate(this, 2, this.tile.GetLastY());
        par1ICrafting.sendProgressBarUpdate(this, 3, this.tile.GetSize());
        par1ICrafting.sendProgressBarUpdate(this, 4, this.tile.GetValue());
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
            
            
            if (this.LastY != this.tile.GetMinedY())
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tile.GetMinedY());
            }
            
            if (this.LastLastY != this.tile.GetLastY())
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tile.GetLastY());
            }
            
            if (this.LastHoleSize != this.tile.GetSize())
            {
                icrafting.sendProgressBarUpdate(this, 3, this.tile.GetSize());
            }
            
            if (this.LastState != this.tile.GetValue())
            {
                icrafting.sendProgressBarUpdate(this, 4, this.tile.GetValue());
            }
            
            if (this.LastMaxPower != this.tile.GetMaxPower())
{
    icrafting.sendProgressBarUpdate(this, 5, (int)this.tile.GetMaxPower());
}
            
        }

        this.LastPower = (int)this.tile.GetPower();
        this.LastY = this.tile.GetMinedY();
        this.LastLastY = this.tile.GetLastY();
        this.LastHoleSize = this.tile.GetSize();
        this.LastState = this.tile.GetValue();
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
            this.tile.SetMinedY(par2);
        }
        
        if (par1 == 2)
        {
            this.tile.SetLastY(par2);
        }
        
        if (par1 == 3)
        {
            this.tile.SetSize(par2);
        }
        
        if (par1 == 4)
        {
            this.tile.SetValue(par2);
        }
        if (par1 == 5)
    {
        this.tile.SetMaxPower(par2);
    }
        

    }
    
	public TileEntityMiningStation getTile() {
		return tile;
	}
}
