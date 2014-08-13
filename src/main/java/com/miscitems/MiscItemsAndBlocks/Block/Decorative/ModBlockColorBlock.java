package com.miscitems.MiscItemsAndBlocks.Block.Decorative;

import MiscUtils.Block.ModBlockContainer;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityColorBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.awt.*;
import java.util.ArrayList;

public class ModBlockColorBlock extends ModBlockContainer {

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityColorBlock();
    }


    public ModBlockColorBlock() {
        super(Material.glass);
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase p_149689_5_, ItemStack stack) {
        if(!(world.getTileEntity(x,y,z) instanceof TileEntityColorBlock))
        world.setTileEntity(x,y,z, createNewTileEntity(world, world.getBlockMetadata(x,y,z)));

        if(world.getTileEntity(x,y,z) instanceof TileEntityColorBlock){
            TileEntityColorBlock tile = (TileEntityColorBlock)world.getTileEntity(x,y,z);
            tile.Color = stack.getItemDamage();

        }

    }

    public static int[] CustomColors = new int[]{new Color(0,0,0).getRGB()};
    public static String[] CustomColorsNames = new String[]{"Dark Black"};


    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        return ret;
    }

    @Override
    public void breakBlock(World World, int x, int y, int z, Block id, int meta)
    {

        TileEntity tile_e = World.getTileEntity(x, y, z);

        if(tile_e != null && tile_e instanceof TileEntityColorBlock){
            TileEntityColorBlock tile = (TileEntityColorBlock)tile_e;

            ItemStack stack = new ItemStack(ModBlocks.ColorBlock, 1, tile.Color);

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

        super.breakBlock(World, x, y, z, id, meta);

    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, java.util.List p_149666_3_)
    {
        for(int i = 0; i < ItemDye.field_150922_c.length + CustomColors.length; i++)
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        if (((world instanceof World)) &&
                (!((World)world).blockExists(x, y, z))) {
            return 0;
        }

        if (((world instanceof World)))
        if(((World)world).getTileEntity(x,y,z) instanceof TileEntityColorBlock){
            TileEntityColorBlock tile = (TileEntityColorBlock)((World)world).getTileEntity(x,y,z);
            return getLightLevel(tile.Color);

        }

        return 0;
    }

    public static int getLightLevel(int metadata)
    {
        Color c = null;

        if(metadata > 15){
            c = new Color(CustomColors[metadata - 16]);
        }else{
            c = new Color(ItemDye.field_150922_c[15 - metadata]);
        }

        return (int)(((float)(c.getRed() / 255) + (float)(c.getBlue() / 255) + (float)(c.getGreen() / 255)) / 3.0F * 15.0F);
    }


    @SideOnly(Side.CLIENT)
    public int getRenderColor(int Meta)
    {
        int m = 15 - Meta;

        if(m < 0)
            m = 0;

        if(Meta > 15) {
            return CustomColors[Meta - 16];
        }



        return new Color(ItemDye.field_150922_c[m]).getRGB();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
    {
        if (((world instanceof World)))
        if(((World)world).getTileEntity(x,y,z) instanceof TileEntityColorBlock){
            TileEntityColorBlock tile = (TileEntityColorBlock)((World)world).getTileEntity(x,y,z);
            return getRenderColor(tile.Color);

        }

        return 0;
    }

    public boolean isNormalCube(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    public int getRenderType()
    {
        return Main.proxy.RenderColorBlock;
    }
}
