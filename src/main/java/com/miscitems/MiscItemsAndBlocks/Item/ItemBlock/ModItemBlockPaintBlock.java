package com.miscitems.MiscItemsAndBlocks.Item.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPaintBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.awt.*;
import java.util.List;

public class ModItemBlockPaintBlock extends ItemBlock {
    public ModItemBlockPaintBlock(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {

        if(stack.getTagCompound() != null){
            Color c = new Color(stack.getTagCompound().getInteger("Red"), stack.getTagCompound().getInteger("Green"), stack.getTagCompound().getInteger("Blue"));
            list.add("Color: " + EnumChatFormatting.BLUE + c.getRGB());
        }

    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {

        if(stack.stackTagCompound != null){
            world.setBlock(x, y, z, ModBlocks.PaintBlock);
            if(world.getTileEntity(x, y, z) != null) {
                TileEntityPaintBlock tile = (TileEntityPaintBlock) world.getTileEntity(x, y, z);
                Color c = new Color(stack.getTagCompound().getInteger("Red"), stack.getTagCompound().getInteger("Green"), stack.getTagCompound().getInteger("Blue"));

                tile.SetRed(c.getRed());
                tile.SetGreen(c.getGreen());
                tile.SetBlue(c.getBlue());


            }


        }else{
            world.setBlock(x, y, z, ModBlocks.PaintBlock);
        }
        return true;
    }

}
