package com.miscitems.MiscItemsAndBlocks.Container;

import com.miscitems.MiscItemsAndBlocks.Container.Utils.ActiveContainer;
import com.miscitems.MiscItemsAndBlocks.Container.Utils.ActiveSlot;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Inventories.TileEntityStorageBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerStorageBlock extends ActiveContainer
{
    public InventoryPlayer playerInv;
    public int fuel = 0;
    int slotRow;
    
    TileEntityStorageBlock tile;

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

    @Override
    public ItemStack transferStackInSlot (EntityPlayer player, int slotID)
    {
        ItemStack stack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotID);

        if (slot != null && slot.getHasStack())
        {
            ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();

            if (slotID < tile.getSizeInventory())
            {
                if (!this.mergeItemStack(slotStack, tile.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(slotStack, 0, tile.getSizeInventory(), false))
            {
                return null;
            }

            if (slotStack.stackSize < tile.getInventoryStackLimit())
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return stack;
    }

    @Override
    protected boolean mergeItemStack (ItemStack inputStack, int startSlot, int endSlot, boolean flag)
    {
        boolean merged = false;
        int slotPos = startSlot;

        if (flag)
        {
            slotPos = endSlot - 1;
        }

        Slot slot;
        ItemStack slotStack;


        if (inputStack.isStackable() && startSlot >= tile.getSizeInventory())
        {
            while (inputStack.stackSize > tile.getInventoryStackLimit() && (!flag && slotPos < endSlot || flag && slotPos >= startSlot))
            {
                slot = (Slot) this.inventorySlots.get(slotPos);
                slotStack = slot.getStack();

                if (slotStack != null && slotStack == inputStack && (!inputStack.getHasSubtypes() || inputStack.getItemDamage() == slotStack.getItemDamage())&& ItemStack.areItemStackTagsEqual(inputStack, slotStack))
                {
                    int l = slotStack.stackSize + inputStack.stackSize;

                    if (l <= inputStack.getMaxStackSize())
                    {

                        slotStack.stackSize = inputStack.stackSize;
                        inputStack.stackSize = 0;
                        slot.onSlotChanged();
                        merged = true;
                    }
                    else if (slotStack.stackSize < inputStack.getMaxStackSize())
                    {
                        inputStack.stackSize -= inputStack.getMaxStackSize() - slotStack.stackSize;
                        slotStack.stackSize = inputStack.getMaxStackSize();
                        slot.onSlotChanged();
                        merged = true;
                    }
                }

                if (flag)
                {
                    --slotPos;
                }
                else
                {
                    ++slotPos;
                }
            }
        }

        if (inputStack.stackSize > 0)
        {
            if (flag)
            {
                slotPos = endSlot - 1;
            }
            else
            {
                slotPos = startSlot;
            }

            while (!flag && slotPos < endSlot || flag && slotPos >= startSlot)
            {
                slot = (Slot) this.inventorySlots.get(slotPos);
                slotStack = slot.getStack();

                if (slotStack == null)
                {
                    slot.putStack(inputStack.copy());
                    slot.onSlotChanged();
                    inputStack.stackSize -= 1;
                    merged = true;
                    break;
                }

                if (flag)
                {
                    --slotPos;
                }
                else
                {
                    ++slotPos;
                }
            }
        }

        return merged;
    }
}