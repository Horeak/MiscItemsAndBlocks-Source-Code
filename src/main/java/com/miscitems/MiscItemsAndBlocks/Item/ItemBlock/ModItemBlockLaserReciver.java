package com.miscitems.MiscItemsAndBlocks.Item.ItemBlock;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModItemBlockLaserReciver extends ItemBlock{

	public ModItemBlockLaserReciver(Block p_i45328_1_) {
		super(p_i45328_1_);
	}

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {

        ForgeDirection dir = ForgeDirection.getOrientation(side).getOpposite();
            dir = dir.getOpposite();

        int xCord = x + dir.offsetX, yCord = y - dir.offsetY, zCord = z + dir.offsetZ;

        if(dir == ForgeDirection.DOWN){
            xCord = x;
            yCord = y - 1;
            zCord = z;
        }else if(dir == ForgeDirection.UP){
            xCord = x;
            yCord = y + 1;
            zCord = z;
        }

        if(world.isSideSolid(x, y, z, dir) && ModBlocks.LaserReciver.canPlaceBlockAt(world, xCord, yCord, zCord)){
            world.setBlock(xCord, yCord, zCord, ModBlocks.LaserReciver, dir.ordinal(), 2);
            world.playSoundEffect((double)((float)xCord + 0.5F), (double)((float)yCord + 0.5F), (double)((float)zCord + 0.5F), this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);



            if(!player.capabilities.isCreativeMode)
                player.inventory.getCurrentItem().stackSize -= 1;

            return true;

        }

        return false;
    }

}
