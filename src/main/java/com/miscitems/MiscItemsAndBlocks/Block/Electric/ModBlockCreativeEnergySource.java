package com.miscitems.MiscItemsAndBlocks.Block.Electric;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityCreativeEnergySource;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockCreativeEnergySource extends ModBlockContainer {


    public ModBlockCreativeEnergySource() {
        super(Material.rock);
        setBlockUnbreakable();
        setResistance(600000000000.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCreativeEnergySource();
    }
}
