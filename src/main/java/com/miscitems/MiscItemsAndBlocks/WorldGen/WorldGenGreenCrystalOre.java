package com.miscitems.MiscItemsAndBlocks.WorldGen;

import com.miscitems.MiscItemsAndBlocks.Main.Main;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenGreenCrystalOre extends WorldGenerator {




    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {



            for(int h = 0; h < 3; h++) {
                if (Main.config.get("Blocks", "Enable " + ModBlocks.GreenCrystalOre.getUnlocalizedName() + "?", true).getBoolean(true)) {
                    int firstBlockXCoord = x + random.nextInt(16);
                    int firstBlockYCoord = random.nextInt(24);
                    int firstBlockZCoord = z + random.nextInt(16);


                    (new WorldGenMinable(ModBlocks.GreenCrystalOre, 3)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

                    return true;
                } else {
                    return false;
                }


            }


        return false;
    }

}