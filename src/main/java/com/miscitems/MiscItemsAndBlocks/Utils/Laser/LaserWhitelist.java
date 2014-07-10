package com.miscitems.MiscItemsAndBlocks.Utils.Laser;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaserWhitelist {
	
	/**
	 * @author ProPercivalalb <https://github.com/ProPercivalalb/LaserMod>
	 */

public static int ALL_METADATA = -1;

public static List<List> WHITELIST = new ArrayList<List>();

//Convenience method
public static void addToWhiteList(Block block, int blockMeta) { addToWhiteList(Block.blockRegistry.getNameForObject(block), blockMeta); }
public static void addToWhiteList(int blockId, int blockMeta) { addToWhiteList(Block.blockRegistry.getNameForObject(Block.getBlockById(blockId)), blockMeta); }
public static void addToWhiteList(int blockId) { addToWhiteList(Block.blockRegistry.getNameForObject(Block.getBlockById(blockId)), -1); }
public static void addToWhiteList(Block block) { addToWhiteList(Block.blockRegistry.getNameForObject(block), -1); }


public static void addToWhiteList(String blockName, int blockMeta) {
if(blockMeta == ALL_METADATA)
for(int i = 0; i < 16; ++i)
WHITELIST.add(Arrays.asList(blockName, i));
else
WHITELIST.add(Arrays.asList(blockName, blockMeta));
}

//Convenience method
public static boolean canLaserPassThrought(World world, int x, int y, int z) {
Chunk chunk = world.getChunkFromBlockCoords(x, z);
if(chunk == null || !chunk.isChunkLoaded)
return false;

return canLaserPassThrought(world.getBlock(x, y, z), world.getBlockMetadata(x, y, z));
}


public static boolean canLaserPassThrought(Block block, int meta) {
return WHITELIST.contains(Arrays.asList(Block.blockRegistry.getNameForObject(block), meta));
}

static {
addToWhiteList(Blocks.air);
addToWhiteList(Blocks.ice);
addToWhiteList(Blocks.tallgrass);
addToWhiteList(Blocks.leaves);
addToWhiteList(Blocks.lever);
addToWhiteList(Blocks.torch);
addToWhiteList(Blocks.redstone_torch);
addToWhiteList(Blocks.unlit_redstone_torch);
addToWhiteList(Blocks.redstone_wire);
addToWhiteList(Blocks.glass);
addToWhiteList(Blocks.glass_pane);
addToWhiteList(Blocks.snow_layer);
addToWhiteList(Blocks.stained_glass);
addToWhiteList(Blocks.stained_glass_pane);
}
}