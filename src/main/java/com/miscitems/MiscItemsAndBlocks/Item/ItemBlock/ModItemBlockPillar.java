package com.miscitems.MiscItemsAndBlocks.Item.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.TileEntity.Decorative.TileEntityPillar;
import com.miscitems.MiscItemsAndBlocks.Utils.PillarUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ModItemBlockPillar extends ItemBlock{

	public ModItemBlockPillar(Block par1) {
		super(par1);
	}


    public String getItemStackDisplayName(ItemStack stack)
    {

        if(stack != null)
        if(stack.getTagCompound() != null){
            if(PillarUtils.BlU.get(stack.getTagCompound().getInteger("Bl")) != null)
            return StatCollector.translateToLocal(PillarUtils.BlU.get(stack.getTagCompound().getInteger("Bl")).getUnlocalizedName() + ".name") + " " + StatCollector.translateToLocal("tile.pillar.name");
        }

        return ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
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
