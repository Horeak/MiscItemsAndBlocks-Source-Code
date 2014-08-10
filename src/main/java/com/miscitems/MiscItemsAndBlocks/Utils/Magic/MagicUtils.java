package com.miscitems.MiscItemsAndBlocks.Utils.Magic;

import com.miscitems.MiscItemsAndBlocks.Network.Client.MagicReciveParticleEffects;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import com.miscitems.MiscItemsAndBlocks.Utils.Magic.Spells.SpellComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class MagicUtils {

    public static void ReceiveEnergy(TileEntity tile){
        PacketHandler.sendToDimension(new MagicReciveParticleEffects(tile.xCoord, tile.yCoord, tile.zCoord), tile.getWorldObj().provider.dimensionId);

    }


    public static SpellComponent[] GetSpellComponents(ItemStack stack){

        return null;
    }

}
