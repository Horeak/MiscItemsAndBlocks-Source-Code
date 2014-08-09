package com.miscitems.MiscItemsAndBlocks.Block.Decorative;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class ModBlockPillar extends ModBlockContainer {

    public ModBlockPillar() {
		super(Material.rock);
		this.setHardness(1F);
	}

    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityPillar();
	}

	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	@Override
	public boolean isOpaqueCube()
	{
	   return false;
	}


	
    @Override
    public int getRenderType() {
            return -1;
    }
	@Override
    public boolean renderAsNormalBlock() {
        return false;
}
	
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
    	
		 this.setBlockBounds(0.1F, 0.1F, 0.1F, 0.9F, 0.9F, 0.9F);
    	
    }


    
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
    	
        this.blockIcon = par1IconRegister.registerIcon(Reference.Mod_Id + ":BlankPillar");
        
    }




    @Override
    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
    {

        TileEntity tile_e = World.getTileEntity(x, y, z);

        if(tile_e != null && tile_e instanceof TileEntityPillar){
            TileEntityPillar tile = (TileEntityPillar)tile_e;

            ItemStack stack = new ItemStack(ModBlocks.Pillar);
            stack.setTagCompound(new NBTTagCompound());

            stack.getTagCompound().setInteger("Bl", tile.ID);
            stack.setItemDamage(tile.me);

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
}
