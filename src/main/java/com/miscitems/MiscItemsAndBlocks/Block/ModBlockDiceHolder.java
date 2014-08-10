package com.miscitems.MiscItemsAndBlocks.Block;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityDiceHolder;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockDiceHolder extends ModBlockContainer {

    public ModBlockDiceHolder() {
		super(Material.rock);
		this.setHardness(1);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityDiceHolder();
	}

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    
    	
    	Random rand = new Random();
    	
    	if(!world.isRemote)
    	world.setBlockMetadataWithNotify(x, y, z, rand.nextInt(7), 2);
    	
        return true;
    }
	 
		public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
		{
		   return false;
		}

		public boolean isOpaqueCube()
		{
		   return false;
		}


		
	    @Override
	    public int getRenderType() {
	            return -1;
	    }
	    
	    public boolean renderAsNormalBlock() {
	        return false;
	}
	    
	    public void registerBlockIcons(IIconRegister icon) {
	        this.blockIcon = icon.registerIcon(Reference.Mod_Id + ":DiceStand");
	}
	    
	    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
	    {
	        return side != -1;
	    }
	    
	    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
	    	
	    	
	    	if(!world.isRemote){
	    		
	    		if(world.isBlockIndirectlyGettingPowered(x, y, z)){
	    			if(block == Blocks.redstone_block || block  == Blocks.redstone_wire || block == Blocks.redstone_torch || block == Blocks.unpowered_repeater){
	    				
	    				

	    		    	Random rand = new Random();
	    		    	
	    		    	world.setBlockMetadataWithNotify(x, y, z, rand.nextInt(7), 2);
	    			}
	    			
	    		}
	    		
	    		
	    		
	    	}
	    	
	    }
}
