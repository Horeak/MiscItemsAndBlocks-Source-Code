package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockMachinePart extends Block{

	public ModBlockMachinePart() {
		super(Material.iron);
	}
	
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	return false;
    }
    
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "MachinePart");
		   
	   }

}
