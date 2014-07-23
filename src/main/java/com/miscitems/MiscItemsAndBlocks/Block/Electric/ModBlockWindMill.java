package com.miscitems.MiscItemsAndBlocks.Block.Electric;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntityWindMill;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ModBlockWindMill extends ModBlockContainer {

	public ModBlockWindMill() {
		super(Material.iron);
		this.setHardness(2);
	}
	
	IIcon IconTop;
	IIcon IconSide;

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityWindMill();
	}


	
    @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.IconSide = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "WindMillSide" + (ConfigUtils.HDTextures ? "_16" : ""));
		   this.IconTop = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "ModuleBlank");
		   
	   }
    
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		
		return (side == 0 ? (IconTop) : (side == 1 ? IconTop : side == 0 ? IconSide : IconSide));
	}
    

}
