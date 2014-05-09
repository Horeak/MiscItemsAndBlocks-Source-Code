package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Utils.Refrence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ModBlockOrangePlanks extends Block{

	public ModBlockOrangePlanks() {
		super(Material.wood);
		this.setHardness(0.4F);
		this.setStepSound(soundTypeWood);
	}
	
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {

    	this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "OrangePlanks");

        
    }

}
