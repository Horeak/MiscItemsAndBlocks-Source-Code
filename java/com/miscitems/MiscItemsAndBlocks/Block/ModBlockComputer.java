package com.miscitems.MiscItemsAndBlocks.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.miscitems.MiscItemsAndBlocks.Gui.GuiHandler;
import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityComputer;

public class ModBlockComputer extends BlockContainer{

	protected ModBlockComputer() {
		super(Material.iron);
		this.setHardness(1);
		this.setBlockBounds(0, 0, 0, 1, 0.84F, 1);

	}
	
   


	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityComputer();
	}
	
	   public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
	    {
			player.openGui(Main.instance, GuiHandler.ComputerID, world, par2, par3, par4);
			
			return true;
	    }

	   
	    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	    {

	    	return par1World.isSideSolid(par2, par3 - 1, par4, ForgeDirection.UP);
	    }
	   
	    public void registerBlockIcons(IIconRegister icon) {
	        this.blockIcon = icon.registerIcon(Refrence.Mod_Id + ":Computer");
	}
	   
		public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
		{
		   return false;
		}

		public boolean isOpaqueCube()
		{
		   return false;
		}

		 private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
		    {
		        if (!p_149930_1_.isRemote)
		        {
		            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
		            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
		            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
		            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
		            byte b0 = 3;

		            if (block.func_149730_j() && !block1.func_149730_j())
		            {
		                b0 = 3;
		            }

		            if (block1.func_149730_j() && !block.func_149730_j())
		            {
		                b0 = 2;
		            }

		            if (block2.func_149730_j() && !block3.func_149730_j())
		            {
		                b0 = 5;
		            }

		            if (block3.func_149730_j() && !block2.func_149730_j())
		            {
		                b0 = 4;
		            }

		            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
		        }
		    }
		  
		    public void onBlockAdded(World par1World, int par2, int par3, int par4)
		    {
		        super.onBlockAdded(par1World, par2, par3, par4);
		        this.func_149930_e(par1World, par2, par3, par4);
		    }
		
	    @Override
	    public int getRenderType() {
	            return -1;
	    }
	    
	    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	    {
	        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
	        }

	        if (l == 1)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
	        }

	        if (l == 2)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
	        }

	        if (l == 3)
	        {
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
	        }

	    }


}
