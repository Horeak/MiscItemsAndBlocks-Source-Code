package com.miscitems.MiscItemsAndBlocks.Block;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityTimedBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockTimedBlock extends ModBlockContainer {

	public ModBlockTimedBlock() {
		super(Material.glass);
		this.setHardness(-1);
		this.setBlockTextureName(Reference.Mod_Id + ":TimedBlock");
	}
	
    public boolean isOpaqueCube()
    {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		
		return new TileEntityTimedBlock();
	}
	
    public int getRenderBlockPass()
    {
        return 1;
    }
    

   public boolean renderAsNormalBlock()
   {
       return false;
   }
	
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	return false;
    }

   
   public int idPicked(World par1World, int par2, int par3, int par4)
   {
       return 0;
   }
   
   
}
