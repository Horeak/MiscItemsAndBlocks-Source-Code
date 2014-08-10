package com.miscitems.MiscItemsAndBlocks.Block.Plants;

import MiscUtils.Block.ModBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ModBlockOrangePlanks extends ModBlock{

	public ModBlockOrangePlanks() {
		super(Material.wood);
		this.setHardness(0.4F);
		this.setStepSound(soundTypeWood);
	}
	
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {

    	this.blockIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "OrangePlanks");

        
    }

}
