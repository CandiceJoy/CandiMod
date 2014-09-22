package com.candicejoy.candimod.world;

import java.util.Random;

import com.candicejoy.candimod.CandiBlock;
import com.candicejoy.candimod.CandiMod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class CandiWorldGenerator implements IWorldGenerator
{
	public void generate( Random random, int chunk_x, int chunk_z, World world, IChunkProvider chunk_generator,
			IChunkProvider chunk_provider )
	{
		if( world.provider.dimensionId == 0 )
		{
			// addOreSpawn( new CandiBlock(), world, random, chunk_x*16,
			// chunk_z*16, 1, 30, 60, 5, 100 );

			for( int i = 0; i < 50; i++ )
			{
				int oreX = chunk_x + random.nextInt( 16 );
				int oreY = random.nextInt( 100 );
				int oreZ = chunk_z + random.nextInt( 16 );
				new WorldGenMinable( CandiMod.CANDIBLOCK, 10, 100, Blocks.stone ).generate( world, random, oreX, oreY, oreZ );
			}
		}
	}

	public void addOreSpawn( Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize,
			int chancesToSpawn, int minY, int maxY )
	{
		WorldGenMinable minable = new WorldGenMinable( block, ( minVeinSize + random.nextInt( maxVeinSize - minVeinSize ) ), Blocks.stone );
		
		for( int i = 0; i < chancesToSpawn; i++ )
		{
			int posX = blockXPos + random.nextInt( 16 );
			int posY = minY + random.nextInt( maxY - minY );
			int posZ = blockZPos + random.nextInt( 16 );
			minable.generate( world, random, posX, posY, posZ );
		}
	}
}
