package com.miscitems.MiscItemsAndBlocks.Block.Electric;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Electric.TileEntitySolarPanel;
import com.miscitems.MiscItemsAndBlocks.Utils.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ModBlockSolarPanel extends ModBlockContainer {

	public IIcon TopIcon;
	public IIcon SideIcon;

    public ModBlockSolarPanel() {
		super(Material.iron);
		this.setHardness(2);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntitySolarPanel();
	}


	
	
	   @SideOnly(Side.CLIENT)
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	   {
		   this.TopIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "SolarPanelTop" + (ConfigUtils.HDTextures ? "_16" : ""));
		   this.SideIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "ModuleBlank" + (ConfigUtils.HDTextures ? "_16" : ""));
		   
	   }
	   
	    public IIcon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? TopIcon : (par1 == 0 ? SideIcon : (par1 != 2 && par1 != 4 ? this.SideIcon : SideIcon) );
	    }
	    
	    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	        	
	            return true;
	        }
	        else
	        {
	        	
	        	
	        	
	        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 0, par1World, par2, par3, par4);
	            return true;
	        }
	    }

}
