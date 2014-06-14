package com.miscitems.MiscItemsAndBlocks.WorldGen;

import com.miscitems.MiscItemsAndBlocks.Block.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Main.Main;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenRedCrystalOre extends WorldGenerator {




    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {


                for(int g = 0; g < 3; g++) {
                    if (Main.config.get("Blocks", "Enable " + ModBlocks.RedCrystalOre.getUnlocalizedName() + "?", true).getBoolean(true)) {
                        int firstBlockXCoord = x + random.nextInt(16);
                        int firstBlockYCoord = random.nextInt(15);
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