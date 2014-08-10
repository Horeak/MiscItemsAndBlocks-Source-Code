package com.miscitems.MiscItemsAndBlocks.WorldGen;

import MiscUtils.Utils.WorldGen.WorldGenUtils;
import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Utils.ConfigUtils;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class ModWorldGenerator extends WorldGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
    }

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		return false;
	}
	
    private void generateSurface(World world, Random random, int ChunkX, int ChunkZ) {

        WorldGenUtils.RegisterWorldGeneratorOld(new WorldGenOrangeTree(false, 6, 0, 0, false), "OrangeTree", 1, 90, new BiomeGenBase[]{BiomeGenBase.plains}, world, random, ChunkX, 0, ChunkZ, ConfigUtils.GetConfigFile());
        WorldGenUtils.RegisterWorldGeneratorOld(new WorldGenMinable(ModBlocks.SilverOre, 2), "SilverOre", 3, 14, null, world, random, ChunkX, 0, ChunkZ,  ConfigUtils.GetConfigFile());

    			
	}
    
    
    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}

}
