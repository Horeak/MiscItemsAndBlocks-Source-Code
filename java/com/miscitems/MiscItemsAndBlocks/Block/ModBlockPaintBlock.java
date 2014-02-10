package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityPaintBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockPaintBlock extends BlockContainer{

	
	protected ModBlockPaintBlock() {
		super(Material.cloth);
		this.setStepSound(soundTypeCloth);
		this.setHardness(1);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityPaintBlock();
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":PaintBlock");
		   
	   }
	   

	   
	   
	    public int colorMultiplier(IBlockAccess block, int x, int y, int z)
	    {
	    	//(Red)(Red)(Green)(Green)(Blue)(Blue)
	    	//0xrrggbb
	    	// Defualt : 0xFFFFFF
	    	
	    	TileEntity tile_e = block.getTileEntity(x, y, z);
	    	
	    	if(tile_e instanceof TileEntityPaintBlock){
	    		TileEntityPaintBlock tile = (TileEntityPaintBlock)tile_e;
	    		
	    		if(tile.GetRed() == 0 && tile.GetBlue() == 0 && tile.GetGreen() == 0){

	    		}else{
	    			return tile.GetHex();
	    		}
	    	}
	    	return 0xFFFFFF;
	    	
	    }
	    
	    







	    

	    


}
