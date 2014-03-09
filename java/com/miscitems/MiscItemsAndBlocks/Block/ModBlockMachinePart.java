package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

public class ModBlockMachinePart extends Block{

	public ModBlockMachinePart() {
		super(Material.iron);
	}

    
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "MachinePart");
		   
	   }

}
