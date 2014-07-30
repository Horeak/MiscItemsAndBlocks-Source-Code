package com.miscitems.MiscItemsAndBlocks.Utils;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class PillarUtils {

    public static ArrayList<ItemStack> BlU = new ArrayList<ItemStack>();
    public static ArrayList<Block> BlackList = new ArrayList<Block>();

    public static void RegisterBlackList(){

        BlackList.add(Blocks.skull);
        BlackList.add(Blocks.grass);
        BlackList.add(Blocks.leaves);
        BlackList.add(Blocks.leaves2);
        BlackList.add(Blocks.fire);
        BlackList.add(Blocks.water);
        BlackList.add(Blocks.flowing_water);
        BlackList.add(Blocks.lava);
        BlackList.add(Blocks.flowing_lava);
        BlackList.add(Blocks.portal);
        BlackList.add(Blocks.end_portal);
        BlackList.add(Blocks.end_portal_frame);
        BlackList.add(Blocks.monster_egg);
        BlackList.add(Blocks.mob_spawner);
        BlackList.add(Blocks.redstone_lamp);
        BlackList.add(Blocks.coal_ore);
        BlackList.add(Blocks.diamond_ore);
        BlackList.add(Blocks.emerald_ore);
        BlackList.add(Blocks.gold_ore);
        BlackList.add(Blocks.iron_ore);
        BlackList.add(Blocks.lapis_ore);
        BlackList.add(Blocks.lit_redstone_ore);
        BlackList.add(Blocks.quartz_ore);
        BlackList.add(Blocks.redstone_ore);
        BlackList.add(Blocks.sponge);
        BlackList.add(Blocks.lit_pumpkin);
        BlackList.add(Blocks.mycelium);
        BlackList.add(Blocks.bookshelf);
        BlackList.add(Blocks.crafting_table);
        BlackList.add(Blocks.brown_mushroom_block);
        BlackList.add(Blocks.red_mushroom_block);
        BlackList.add(Blocks.stained_hardened_clay);
        BlackList.add(Blocks.command_block);
        BlackList.add(Blocks.wooden_slab);
        BlackList.add(Blocks.air);
    }


    public static void RegisterBlocks(){
        for(Object r : Block.blockRegistry) {
            Block bl = (Block) r;

            if (GameRegistry.findUniqueIdentifierFor(bl).modId.equals("minecraft") && !(bl instanceof BlockAir)) {

                if (bl.isOpaqueCube() && bl.getRenderType() == 0 && !BlackList.contains(bl)) {

                    if (Item.getItemFromBlock(bl) != null && Item.getItemFromBlock(bl) instanceof ItemBlock && Item.getItemFromBlock(bl).getHasSubtypes()) {


                        ArrayList e = new ArrayList();
                        Item.getItemFromBlock(bl).getSubItems(Item.getItemFromBlock(bl), null, e);

                        int Length = e.size();

                        for (int i = 0; i < Length; i++) {
                            if (!bl.hasTileEntity(i)) {
                                BlU.add(new ItemStack(bl, 1, i));

                            }

                        }

                    } else {
                        if (!bl.hasTileEntity(0)) {
                            BlU.add(new ItemStack(bl));

                        }
                    }
                }
            }
        }
    }
}
