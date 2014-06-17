package com.miscitems.MiscItemsAndBlocks.Block;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.TileEntityStorageBlock;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockStorageBlock extends BlockContainer{

    public ModBlockStorageBlock() {
		super(Material.iron);
		this.setHardness(1.7F);

	}

    IIcon Side;
    IIcon Front;
	
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityStorageBlock();
	}


    @Override
    public IIcon getIcon(int side, int metadata)
    {

        return (side == 4 ? (Front) : (side == 1 ? Side : side == 0 ? Side : Side));
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        int Meta = world.getBlockMetadata(x, y, z);


            return (side == Meta ? Front : (side == 1 ? Side : side == 0 ? Side : Side));

    }
	
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        Side = par1IconRegister.registerIcon(Reference.Mod_Id + ":StorageBlockSide");
        Front = par1IconRegister.registerIcon(Reference.Mod_Id + ":StorageBlockFront");
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

    	TileEntity tile_e = World.getTileEntity(x, y, z);
    	
    	if(tile_e != null && tile_e instanceof TileEntityStorageBlock){
    		TileEntityStorageBlock tile = (TileEntityStorageBlock)tile_e;
    	
    		ItemStack stack = new ItemStack(ModBlocks.StorageBlock);
    		
    		stack.setTagCompound(new NBTTagCompound());


    			NBTTagList Items = new NBTTagList();
		

        		for (int i = 0; i < tile.getSizeInventory(); i++){
        			
        			ItemStack stack1 = tile.getStackInSlot(i);
        			if(stack1 != null){
        				
        			stack.stackTagCompound.setInteger("ItemsNumber", stack.stackTagCompound.getInteger("ItemsNumber") + 1);
        				
        				NBTTagCompound item = new NBTTagCompound();
        				item.setByte("Slot", (byte)i);
        				stack1.writeToNBT(item);
        				Items.appendTag(item);
        			}
        		}

		
				stack.stackTagCompound.setTag("Items", Items);
				stack.stackTagCompound.setInteger("MaxItems", tile.getSizeInventory());
				
		
				if(stack.stackTagCompound.getInteger("ItemsNumber") == 0)
					stack = new ItemStack(ModBlocks.StorageBlock);
    	
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
				super.breakBlock(World, x, y, z, id, meta);
			}
				
				
    }

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


}
