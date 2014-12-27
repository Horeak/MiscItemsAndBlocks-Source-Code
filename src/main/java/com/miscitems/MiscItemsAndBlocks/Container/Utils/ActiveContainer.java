package com.miscitems.MiscItemsAndBlocks.Container.Utils;

import MiscUtils.Utils.ContainerBase;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public abstract class ActiveContainer extends ContainerBase
{
    public List<ActiveSlot> activeInventorySlots = new ArrayList<ActiveSlot>();

    @Override
    public boolean canInteractWith (EntityPlayer entityplayer)
    {
        return false;
    }

    protected ActiveSlot addDualSlotToContainer (ActiveSlot slot)
    {
        slot.activeSlotNumber = this.activeInventorySlots.size();
        this.activeInventorySlots.add(slot);
        this.addSlotToContainer(slot);
        return slot;
    }


}