package com.miscitems.MiscItemsAndBlocks.Block.Decorative;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.PillarUtils;
import com.miscitems.MiscItemsAndBlocks.Utils.References.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class ModBlockPillar extends ModBlockContainer {

    public ModBlockPillar() {
		super(Material.rock);
		this.setHardness(1F);
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

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List l)
    {


        if(ConfigUtils.AllowCustomPillars)
        for (int i = 0; i < PillarUtils.BlU.size(); ++i)
        {
            Block bl = Block.getBlockFromItem(PillarUtils.BlU.get(i).getItem());
            ItemStack stack = null;

            if(Item.getItemFromBlock(bl) != null && Item.getItemFromBlock(bl) instanceof ItemBlock && Item.getItemFromBlock(bl).getHasSubtypes()) {
                stack = new ItemStack(ModBlocks.Pillar, 1, PillarUtils.BlU.get(i).getItemDamage());
            }else {
                stack = new ItemStack(ModBlocks.Pillar);
            }

            if(bl instanceof BlockAir || bl == null || bl == Blocks.air)
                continue;


            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setInteger("Bl", i);

            l.add(stack);
        }

        else{
            Block bl = Blocks.quartz_block;
            ItemStack stack = new ItemStack(ModBlocks.Pillar);

            stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setInteger("Bl", 0);

            l.add(stack);
        }
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
