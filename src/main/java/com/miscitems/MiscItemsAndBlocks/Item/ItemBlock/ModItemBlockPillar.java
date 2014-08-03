package com.miscitems.MiscItemsAndBlocks.Item.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.Utils.PillarUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ModItemBlockPillar extends ItemBlock{

	public ModItemBlockPillar(Block par1) {
		super(par1);
	}


    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {

        if(stack.getTagCompound() != null){


        if(stack.getTagCompound() != null){
            int i = stack.getTagCompound().getInteger("Bl");

            ItemStack st = new ItemStack(PillarUtils.BlU.get(i).getItem(), 1, stack.getItemDamage());

                list.add(EnumChatFormatting.DARK_BLUE + "" +  EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tile.pillar.name") + ": " +StatCollector.translateToLocal(st.getUnlocalizedName() + ".name"));


        }

        }
    }

    public String getItemStackDisplayName(ItemStack stack)
    {

        return StatCollector.translateToLocal("tile.pillar.name");
    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        if(stack.stackTagCompound != null){
            world.setBlock(x, y, z, ModBlocks.Pillar);
            if(world.getTileEntity(x, y, z) != null){
                TileEntityPillar tile = (TileEntityPillar)world.getTileEntity(x, y, z);

                tile.ID = stack.stackTagCompound.getInteger("Bl");
                tile.me = stack.getItemDamage();
            }


        }else{
            world.setBlock(x, y, z, ModBlocks.Pillar);
        }
        return true;
    }


}
