package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ModBlockLenseBench extends Block{

	IIcon Top;
    IIcon Side;
    IIcon Bottom;
	
	protected ModBlockLenseBench() {
		super(Material.rock);
	}

	
    public void registerBlockIcons(IIconRegister icon)
    {
    	Top = icon.registerIcon(Refrence.Mod_Id + ":" + "LenseBenchTop");
    	Side = icon.registerIcon(Refrence.Mod_Id + ":" + "LenseBenchSide");
    	Bottom = icon.registerIcon("furnace_top");
    	
    }
    
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? Top : (par1 == 0 ? Bottom : Side);
    }
}
