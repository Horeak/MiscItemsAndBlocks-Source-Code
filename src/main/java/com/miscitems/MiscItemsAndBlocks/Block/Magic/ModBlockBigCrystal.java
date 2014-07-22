package com.miscitems.MiscItemsAndBlocks.Block.Magic;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityBigCrystal;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Automatic file template
 * File was created 22.07.2014 at 12:18
 * Class is located in package com.miscitems.MiscItemsAndBlocks.Block.Magic
 *
 * @author tm1990
 */
public class ModBlockBigCrystal extends ModBlockContainer {

    public ModBlockBigCrystal(){
        super(Material.glass);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityBigCrystal();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l){
        return false;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }
}
