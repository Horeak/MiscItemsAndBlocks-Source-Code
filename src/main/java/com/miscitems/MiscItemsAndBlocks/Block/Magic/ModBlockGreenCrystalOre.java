package com.miscitems.MiscItemsAndBlocks.Block.Magic;

import com.miscitems.MiscItemsAndBlocks.Block.Utils.ModBlock;
import com.miscitems.MiscItemsAndBlocks.Main.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class ModBlockGreenCrystalOre extends ModBlock {


    public ModBlockGreenCrystalOre() {
        super(Material.rock);
        this.setHardness(8);
    }





    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)

    {

        return ModItems.GreenCrystal;
    }


    public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_)
    {

        return this.quantityDropped(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 1);
    }

    public int quantityDropped(Random p_149745_1_)
    {
        return 1 + p_149745_1_.nextInt(3);
    }


}