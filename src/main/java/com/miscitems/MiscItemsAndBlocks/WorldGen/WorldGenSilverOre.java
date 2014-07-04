package com.miscitems.MiscItemsAndBlocks.WorldGen;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenSilverOre extends WorldGenerator {
	



	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {

        if(ConfigUtils.IsBlockEnabled(ModBlocks.SilverOre)) {
            int firstBlockXCoord = x + random.nextInt(16);
            int firstBlockYCoord = random.nextInt(14);
            int firstBlockZCoord = z + random.nextInt(16);


            (new WorldGenMinable(ModBlocks.SilverOre, 2, Blocks.stone)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

            return true;
        }else{
            return false;
        }
	}

}