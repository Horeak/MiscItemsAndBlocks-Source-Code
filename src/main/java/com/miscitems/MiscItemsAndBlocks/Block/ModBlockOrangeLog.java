package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockOrangeLog extends BlockRotatedPillar {

    public ModBlockOrangeLog() {
		super(Material.wood);
		this.setStepSound(soundTypeWood);
		this.setHardness(0.4F);
	}
	
    @SideOnly(Side.CLIENT)
    private IIcon tree_side;
    @SideOnly(Side.CLIENT)
    private IIcon tree_top;
    
    IIcon[] tree_sides = new IIcon[2];


    public int quantityDropped(Random par1Random)
    {
        return 1;
    }


    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return new ItemStack(ModBlocks.OrangeLog).getItem();
    }


    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
    		
    	
        byte b0 = 1;
        int j1 = b0 + 1;

        if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
        {
            for (int k1 = -b0; k1 <= b0; ++k1)
            {
                for (int l1 = -b0; l1 <= b0; ++l1)
                {
                    for (int i2 = -b0; i2 <= b0; ++i2)
                    {
                        Block j2 = par1World.getBlock(par2 + k1, par3 + l1, par4 + i2);

                        if (j2 != null)
                        {
                        	j2.beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
                        }
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int par1)
    {
        return this.tree_sides[par1];
    }
    
    protected IIcon getTopIcon(int par1)
    {
        return tree_top;
    }



    public static int limitToValidMetadata(int par0)
    {
        return par0 & 3;
    }



    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {

    		tree_top = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "OrangeLog_top");

    		tree_side = par1IconRegister.registerIcon(Reference.Mod_Id + ":" + "OrangeLog");
    	
    		tree_sides[0] = tree_side;
    		tree_sides[1] = tree_side;
    		
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

}
