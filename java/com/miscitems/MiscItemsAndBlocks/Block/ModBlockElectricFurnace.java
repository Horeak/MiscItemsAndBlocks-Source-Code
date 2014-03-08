package com.miscitems.MiscItemsAndBlocks.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.miscitems.MiscItemsAndBlocks.Lib.Refrence;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityElectricFurnace;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityOvenCore;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockElectricFurnace extends BlockContainer{

	protected ModBlockElectricFurnace() {
		super(Material.iron);
	}
	
	IIcon IconSide;
	IIcon IconFront;
	IIcon IconFrontLit;
	

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityElectricFurnace();
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
    
    @Override
    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
    {
    	TileEntity tile = World.getTileEntity(x, y, z);
    	
    	if(tile != null && tile instanceof IInventory){
    		IInventory inv = (IInventory)tile;
    		
    		for(int i = 0; i < inv.getSizeInventory(); i++){
    			ItemStack stack = inv.getStackInSlotOnClosing(i);
    			
    			if(stack != null){
    				float spawnX = x + World.rand.nextFloat();
    				float spawnY = y + World.rand.nextFloat();
    				float spawnZ = z + World.rand.nextFloat();
    				
    				
    				EntityItem droppedItem = new EntityItem(World, spawnX, spawnY, spawnZ, stack);
    				
    				float mult = 0.05F;
    				
    				droppedItem.motionX = (-0.5 + World.rand.nextFloat()) * mult;
    				droppedItem.motionY = (4 + World.rand.nextFloat()) * mult;
    				droppedItem.motionZ = (-0.5 + World.rand.nextFloat()) * mult;
    				
    				
    				World.spawnEntityInWorld(droppedItem);

    			}
    			
    		}
    	}
    	
		super.breakBlock(World, x, y, z, id, meta);
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
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	
        
    	if(par1World.getTileEntity(par2, par3, par4) instanceof TileEntityElectricFurnace){
    		TileEntityElectricFurnace tile = (TileEntityElectricFurnace)par1World.getTileEntity(par2, par3, par4);
    	
    	
    	if(tile.Working || tile.GetWorkTime() > 0)
    	
        {
            int l = par1World.getBlockMetadata(par2, par3, par4);
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.52F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }
    }
	
    
  
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.func_149930_e(par1World, par2, par3, par4);
    }

	
	   public void registerBlockIcons(IIconRegister par1IconRegister)
	    {
	    	
	        this.IconSide = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ElFurnaceSide");
	        this.IconFront = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ElFurnaceFront");
	        this.IconFrontLit = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ElFurnaceFrontLit");
	        
	    }
	    
		@Override
		public IIcon getIcon(int side, int metadata)
		{
			
			return (side == 4 ? (IconFront) : (side == 1 ? this.IconSide : side == 0 ? IconSide : this.IconSide));
		}
		
		@Override
		public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
		{
			int Meta = world.getBlockMetadata(x, y, z);
			
			if(world.getTileEntity(x, y, z) instanceof TileEntityElectricFurnace){
				TileEntityElectricFurnace tile = (TileEntityElectricFurnace)world.getTileEntity(x, y, z);
			
				boolean Running = tile.Working || tile.GetWorkTime() > 0;
			
			
			return (side == Meta ? (Running ?  IconFrontLit : IconFront) : (side == 1 ? this.IconSide : side == 0 ? IconSide : this.IconSide));
			}
			return getIcon(side, Meta);
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
