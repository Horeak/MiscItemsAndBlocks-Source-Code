package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPillar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockPillar extends BlockContainer {

	protected ModBlockPillar() {
		super(Material.rock);
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityPillar();
	}

	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	@Override
	public boolean isOpaqueCube()
	{
	   return false;
	}


	
    @Override
    public int getRenderType() {
            return -1;
    }
	@Override
    public boolean renderAsNormalBlock() {
        return false;
}
	
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
    	
		 this.setBlockBounds(0.1F, 0.1F, 0.1F, 0.9F, 0.9F, 0.9F);
    	
    }

    
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	
        this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":BlankPillar");
        
    }
 
}
