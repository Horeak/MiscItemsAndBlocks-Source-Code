package com.miscitems.MiscItemsAndBlocks.Container.Machines;

import MiscUtils.GuiObjects.Slots.ModSlotArmor;
import com.miscitems.MiscItemsAndBlocks.GuiObjects.Slots.SlotCraftingInv;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Machines.TileEntityWorktable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCraftingInv extends Container
{
public TileEntityWorktable tileEntity;

public IInventory craftSupplyMatrix;
public int craftResultSlot = 0;
private boolean containerChanged;
private boolean netEditingContainer = false;

public ContainerCraftingInv(InventoryPlayer invPlayer, TileEntityWorktable tpb)
{
tileEntity = tpb;
craftSupplyMatrix = tileEntity.craftSupplyMatrix;
addSlotToContainer(new SlotCraftingInv(this, invPlayer.player, tileEntity, tileEntity.craftResult,
tileEntity, craftResultSlot, 128, 31, tileEntity));
layoutContainer(invPlayer, tileEntity);
bindPlayerInventory(invPlayer);
containerChanged = true;
detectAndSendChanges();
}
private void layoutContainer(InventoryPlayer invPlayer, TileEntityWorktable tpb)
{
int row;
int col;
int index = -1;
int counter = 0;
Slot slot = null;

for(row = 0; row < 3; row++)
{
for(col = 0; col < 3; col++)
{
slot = new Slot(tileEntity, ++index, 34 + col * 18, 13 + row * 18);
addSlotToContainer(slot);
counter++;
}
}

for(row = 0; row < 2; row++)
{
for(col = 0; col < 9; col++)
{
if(row == 1)
{
slot = new Slot(tileEntity, 18 + col, 8 + 18 * col, 70);
addSlotToContainer(slot);
} else
{
slot = new Slot(tileEntity, 9 + col, 8 + col * 18, 88);
addSlotToContainer(slot);
}
counter++;
}
}


addSlotToContainer(new ModSlotArmor(invPlayer, invPlayer.getSizeInventory() - 1, 177, 18, 0, invPlayer.player));
addSlotToContainer(new ModSlotArmor(invPlayer, invPlayer.getSizeInventory() - 2, 177, 36, 1, invPlayer.player));
addSlotToContainer(new ModSlotArmor(invPlayer, invPlayer.getSizeInventory() - 3, 177, 54, 2, invPlayer.player));
addSlotToContainer(new ModSlotArmor(invPlayer, invPlayer.getSizeInventory() - 4, 177, 72, 3, invPlayer.player));

}
protected void bindPlayerInventory(InventoryPlayer invPlayer)
{
for(int i = 0; i < 3; i++)
{
for(int j = 0; j < 9; j++)
{
addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + 18 * j, 115 + i * 18));
}
}
for(int i = 0; i < 9; i++)
{
addSlotToContainer(new Slot(invPlayer, i, 8 + 18 * i, 173));
}
}
public void updateCrafting(boolean flag){
tileEntity.markShouldUpdate();
}

@Override
public ItemStack slotClick(int slot, int clickType, int clickMeta, EntityPlayer player)
{
if(slot <= 9 && slot > -1)
updateCrafting(true);
ItemStack stack = super.slotClick(slot, clickType, clickMeta, player);
return stack;
}
@Override
public boolean canInteractWith(EntityPlayer player)
{
return tileEntity.isUseableByPlayer(player);
}
@Override
public void putStacksInSlots(ItemStack[] par1ArrayOfItemStack) {
tileEntity.containerInit = true;
super.putStacksInSlots(par1ArrayOfItemStack);
tileEntity.containerInit = false;
//tileEntity.onInventoryChanged();
}
@Override
public void putStackInSlot(int slot, ItemStack itemStack) {
tileEntity.containerInit = true;
super.putStackInSlot(slot, itemStack);
tileEntity.containerInit = false;
}
@Override
public ItemStack transferStackInSlot(EntityPlayer player, int numSlot)
    {
        ItemStack stack = null;
        Slot slot = (Slot)this.inventorySlots.get(numSlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack stack2 = slot.getStack();
            stack = stack2.copy();
            
            if (numSlot == 0)
            {
                if (!this.mergeItemStack(stack2, 10, 55, true))
                {
                    return null;
                }
                updateCrafting(true);
            }
            else if(numSlot > 0 && numSlot <= 9)
            {
             if(!this.mergeItemStack(stack2, 10, 28, false))
             {
             if(!this.mergeItemStack(stack2, 28, 64, false))
             {
                 return null;
             }
             }
             updateCrafting(true);
            }
            else if (numSlot >= 10 && numSlot <= 27)
            {
                if (!this.mergeItemStack(stack2, 28, 64, false))
                {
                    return null;
                }
            }
            else if (numSlot >= 28 && numSlot < 64)
            {
                if (!this.mergeItemStack(stack2, 10, 28, false))
                {
                    return null;
                }
            }

            if (stack2.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (stack2.stackSize == stack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, stack2);
        }

        return stack;
    }
}

