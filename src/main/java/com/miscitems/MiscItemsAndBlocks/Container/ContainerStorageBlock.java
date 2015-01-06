package com.miscitems.MiscItemsAndBlocks.Container;

import com.miscitems.MiscItemsAndBlocks.Container.Utils.ActiveContainer;
import com.miscitems.MiscItemsAndBlocks.Container.Utils.ActiveSlot;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityStorageBlock;
import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

@ChestContainer
public class ContainerStorageBlock extends ActiveContainer
{
    public InventoryPlayer playerInv;
    public int fuel = 0;
    int slotRow;
    
    TileEntityStorageBlock tile;

    @Override
    public IInventory getTile() {
        return tile;
    }

    public ContainerStorageBlock(InventoryPlayer inventoryplayer, TileEntityStorageBlock tile)
    {
        playerInv = inventoryplayer;
        slotRow = 0;
        this.tile = tile;


        int height = tile.getSizeInventory() / 8;
        
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < 8; x++)
            {
            	
                this.addDualSlotToContainer(new ActiveSlot(tile, x + y * 8, 8 + x * 18, 6 + y * 18, y < 8));
            }
        }
        int leftovers = tile.getSizeInventory() % 8;
        for (int x = 0; x < leftovers; x++)
        {
            this.addDualSlotToContainer(new ActiveSlot(tile, x + height * 8, 8 + x * 22, 6 + height * 18, height < 8));
        }

        /* Player inventory */
        for (int column = 0; column < 3; column++)
        {
            for (int row = 0; row < 9; row++)
            {
                this.addSlotToContainer(new Slot(inventoryplayer, row + column * 9 + 9, 8 + row * 18, 153 + column * 18));
            }
        }

        for (int column = 0; column < 9; column++)
        {
            this.addSlotToContainer(new Slot(inventoryplayer, column, 8 + column * 18, 211));
        }
    }

    public int updateRows (int invRow)
    {
        if (invRow != slotRow)
        {
            slotRow = invRow;
            int basePos = invRow * 8;
            for (int iter = 0; iter < activeInventorySlots.size(); iter++)
            {
                ActiveSlot slot = (ActiveSlot) activeInventorySlots.get(iter);
                if (slot.activeSlotNumber >= basePos && slot.activeSlotNumber < basePos + 64)
                {
                    slot.setActive(true);
                }
                else
                {
                    slot.setActive(false);
                }
                int xPos = (iter - basePos) % 8;
                int yPos = (iter - basePos) / 8;
                slot.xDisplayPosition = 8 + 18 * xPos;
                slot.yDisplayPosition = 6 + 18 * yPos;
            }
            return slotRow;
        }
        return -1;
    }

    public int scrollTo (float scrollPos)
    {
        float total = (tile.getSizeInventory() - 72) / 8;
        int rowPos = (int) (total * scrollPos);
        return updateRows(rowPos);
    }

    public void updateProgressBar (int id, int value)
    {

    }

    @Override
    public boolean canInteractWith (EntityPlayer entityplayer)
    {
        return tile.isUseableByPlayer(entityplayer);
    }



}