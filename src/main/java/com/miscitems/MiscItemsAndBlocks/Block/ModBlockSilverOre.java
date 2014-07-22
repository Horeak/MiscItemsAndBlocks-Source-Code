package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ModBlockSilverOre extends ModBlock {

	public ModBlockSilverOre() {
		super(Material.rock);
		this.setHardness(46);
	}
	
	
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":SilverOre");
		   
	   }
	   
	    public int getHarvestLevel(int metadata)
	    {
	        return 3;
	    }

}
