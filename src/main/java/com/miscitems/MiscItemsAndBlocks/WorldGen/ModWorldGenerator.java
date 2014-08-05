package com.miscitems.MiscItemsAndBlocks.WorldGen;

import com.miscitems.MiscItemsAndBlocks.Main.ModBlocks;
import com.miscitems.MiscItemsAndBlocks.Utils.Config.ConfigUtils;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.ArrayList;
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

            RegisterWorldGenerator(new WorldGenOrangeTree(false, 6, 0, 0, false), ModBlocks.OrangeLog, "OrangeTree", 1, new BiomeGenBase[]{BiomeGenBase.plains}, world, random, ChunkX + random.nextInt(16), random.nextInt(90), ChunkZ + random.nextInt(16));
            RegisterWorldGenerator(new WorldGenMinable(ModBlocks.SilverOre, 2, Blocks.stone), ModBlocks.SilverOre, "SilverOre", 3, null, world, random, ChunkX, 0, ChunkZ);
            RegisterWorldGenerator(new WorldGenMinable(ModBlocks.BlueCrystalOre, 8), ModBlocks.BlueCrystalOre, "BlueCrystalOre", 23, null, world, random, ChunkX, 0, ChunkZ);
            RegisterWorldGenerator(new WorldGenMinable(ModBlocks.GreenCrystalOre, 5), ModBlocks.GreenCrystalOre, "GreenCrystalOre", 12, null, world, random, ChunkX, 0, ChunkZ);
            RegisterWorldGenerator(new WorldGenMinable(ModBlocks.RedCrystalOre, 4), ModBlocks.RedCrystalOre, "RedCrystalOre", 8, null, world, random, ChunkX, 0, ChunkZ);

    			
	}
    
    
    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}

    public void RegisterWorldGenerator(WorldGenerator gen, Block bl, String Name, int Chance,  BiomeGenBase[] Biomes, World world, Random rand, int x, int y, int z){
        if(ConfigUtils.IsWorldGeneratorEnabled(Name) && ConfigUtils.IsBlockEnabled(bl)){

            int Ch = ConfigUtils.GetWorldGenerationChance(Name, Chance);

            ArrayList<BiomeGenBase> list = new ArrayList<BiomeGenBase>();

            if(Biomes != null)
            for(int i = 0; i < Biomes.length; i++)
                list.add(Biomes[i]);


            if(list.contains(world.getBiomeGenForCoords(x, y)) || list.size() <= 0)
            for(int j = 0; j < Ch; j++)
            gen.generate(world,rand,x,y,z);


        }
    }
}
