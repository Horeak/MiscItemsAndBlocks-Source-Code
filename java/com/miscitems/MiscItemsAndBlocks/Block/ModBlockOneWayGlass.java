package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockOneWayGlass extends BlockRotatedPillar {

	protected ModBlockOneWayGlass() {
		super(Material.glass);
		this.setHardness(2);
	}

	
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    
    @SideOnly(Side.CLIENT)
    private IIcon sideIcon;
    
	
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    protected IIcon getTopIcon(int i)
    {
        return topIcon;
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int i)
    {
        return sideIcon;
    }
    
    
    public IIcon getIcon(int par1, int par2)
    {
        int k = getOrientation(par2);
        return k > 5 ? this.topIcon : (par1 == k ? (this.topIcon ) : (sideIcon));
    }
    
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = determineOrientation(par1World, par2, par3, par4, par5EntityLivingBase);
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

    }
    
    public static int getOrientation(int par0)
    {
        return par0 & 7;
    }
    
    public static int determineOrientation(World par0World, int par1, int par2, int par3, EntityLivingBase par4EntityLivingBase)
    {
        if (MathHelper.abs((float)par4EntityLivingBase.posX - (float)par1) < 2.0F && MathHelper.abs((float)par4EntityLivingBase.posZ - (float)par3) < 2.0F)
        {
            double d0 = par4EntityLivingBase.posY + 1.82D - (double)par4EntityLivingBase.yOffset;

            if (d0 - (double)par2 > 2.0D)
            {
                return 1;
            }

            if ((double)par2 - d0 > 0.0D)
            {
                return 0;
            }
        }

        int l = MathHelper.floor_double((double)(par4EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {

    		topIcon = par1IconRegister.registerIcon("glass");

    		sideIcon = par1IconRegister.registerIcon("stone");
    	
    		
    }

}
