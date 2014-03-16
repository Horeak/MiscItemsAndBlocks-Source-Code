package com.miscitems.MiscItemsAndBlocks.MiscItemsApi.Lib;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Items.ModItems;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ModCreativeTabs {



    public static net.minecraft.creativetab.CreativeTabs RandomTab = new net.minecraft.creativetab.CreativeTabs("tabMiscRandom")
    {


        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {

                return Items.redstone;

        }

    };

}
