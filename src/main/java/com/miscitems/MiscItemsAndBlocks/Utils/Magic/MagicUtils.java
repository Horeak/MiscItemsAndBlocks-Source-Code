package com.miscitems.MiscItemsAndBlocks.Utils.Magic;

import com.miscitems.MiscItemsAndBlocks.Network.Client.MagicReciveParticleEffects;
import com.miscitems.MiscItemsAndBlocks.Network.PacketHandler;
import net.minecraft.tileentity.TileEntity;

public class MagicUtils {

    public static void ReceiveEnergy(TileEntity tile){
        PacketHandler.sendToDimension(new MagicReciveParticleEffects(tile.xCoord, tile.yCoord, tile.zCoord), tile.getWorldObj().provider.dimensionId);

    }

}
