package com.miscitems.MiscItemsAndBlocks.WorldGen;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenBlueCrystalOre extends WorldGenerator {




    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {

        for(int i = 0; i < 8; i++) {
            if (ConfigUtils.IsBlockEnabled(ModBlocks.BlueCrystalOre)) {
                int firstBlockXCoord = x + random.nextInt(16);
                int firstBlockYCoord = random.nextInt(48);
                int firstBlockZCoord = z + random.nextInt(16);


                (new WorldGenMinable(ModBlocks.BlueCrystalOre, 8)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

                return true;
            } else {
                return false;
            }

        }




        return false;
    }

}