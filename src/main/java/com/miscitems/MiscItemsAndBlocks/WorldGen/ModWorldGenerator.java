package com.miscitems.MiscItemsAndBlocks.WorldGen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
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

    	
    	for(int i = 0; i < 1; i++){
    		if(world.getBiomeGenForCoords(ChunkX, ChunkZ) == BiomeGenBase.plains){

    		int Xcoord1 = ChunkX + random.nextInt(16);
    		int Ycoord1 = random.nextInt(90);
    		int Zcoord1 = ChunkZ + random.nextInt(16);
    		
    		(new WorldGenOrangeTree(false, 6, 0, 0, false)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
    	}
    	}
    	
    	for(int x = 0; x < 2; x++){

            (new ModSilverWorldGen()).generate(world, random, ChunkX, 0, ChunkZ);
        
    	}
    			
    		}
    
    
    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
}
