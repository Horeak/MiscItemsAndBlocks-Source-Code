package com.miscitems.MiscItemsAndBlocks.Block.Electric;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class ModBlockMachinePart extends ModBlock{

	public ModBlockMachinePart() {
		super(Material.iron);
	}

    
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "MachinePart" + (ConfigUtils.HDTextures ? "_16" : ""));
		   
	   }

}
