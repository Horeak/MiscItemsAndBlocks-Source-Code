package com.miscitems.MiscItemsAndBlocks.Block.Electric;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityPowerCable;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockPowerCable extends ModBlockContainer {

    public ModBlockPowerCable() {
        super(Material.iron);
        this.setHardness(2);
        this.setBlockBounds(0.23F, 0.23F, 0.23F, 0.75F, 0.75F, 0.75F);
    }


    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }


    @Override
    public int getRenderType() {
        return -1;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityPowerCable();
    }


    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "PowerCable");

    }

}
    	


