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
	public void generate( Random random, int chunk_x, int chunk_z, World world, IChunkProvider chunk_generator, IChunkProvider chunk_provider )
	{
		if( world.provider.dimensionId == 0 )
		{
			int x = chunk_x * 16;
			int z = chunk_z * 16;
			int min_vein_size = 1;
			int max_vein_size = 4;
			int chances_to_spawn = 1;
			int min_y = 0;
			int max_y = 100;

			addOreSpawn( CandiMod.CANDIBLOCK, world, random, x, z, min_vein_size, max_vein_size, chances_to_spawn, min_y, max_y );
		}
	}

	public void addOreSpawn( Block block, World world, Random random, int block_x_pos, int block_z_pos, int min_vein_size, int max_vein_size, int chances_to_spawn, int min_y, int max_y )
	{
		WorldGenMinable minable = new WorldGenMinable( block, ( min_vein_size + random.nextInt( max_vein_size - min_vein_size ) ), Blocks.stone );

		for( int i = 0; i < chances_to_spawn; i++ )
		{
			int x = block_x_pos + random.nextInt( 16 );
			int y = min_y + random.nextInt( max_y - min_y );
			int z = block_z_pos + random.nextInt( 16 );

			minable.generate( world, random, x, y, z );
		}
	}
}