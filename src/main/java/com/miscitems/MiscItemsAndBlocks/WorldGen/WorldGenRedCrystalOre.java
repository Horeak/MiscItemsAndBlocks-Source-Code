package com.miscitems.MiscItemsAndBlocks.WorldGen;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenRedCrystalOre extends WorldGenerator {




    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {


                for(int g = 0; g < 3; g++) {
                    if (ConfigUtils.IsBlockEnabled(ModBlocks.RedCrystalOre)) {
                        int firstBlockXCoord = x + random.nextInt(16);
                        int firstBlockYCoord = random.nextInt(30);
                        int firstBlockZCoord = z + random.nextInt(16);


                        (new WorldGenMinable(ModBlocks.RedCrystalOre, 4)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

                        return true;
                    } else {
                        return false;
                    }
        }


        return false;
    }

}