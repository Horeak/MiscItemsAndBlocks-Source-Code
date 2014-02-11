package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;

public class ModBlockLensBench extends Block{

	IIcon Top;
    IIcon Side;
    IIcon Bottom;
	
	protected ModBlockLensBench() {
		super(Material.rock);
	}

	
    public void registerBlockIcons(IIconRegister icon)
    {
    	Top = icon.registerIcon(Refrence.Mod_Id + ":" + "LensBenchTop");
    	Side = icon.registerIcon(Refrence.Mod_Id + ":" + "LensBenchSide");
    	Bottom = icon.registerIcon(Refrence.Mod_Id + ":" + "LensBenchBottom");
    	
    }
    
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? Top : (par1 == 0 ? Bottom : Side);
    }
}
