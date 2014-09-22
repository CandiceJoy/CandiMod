package com.candicejoy.candimod;

import com.candicejoy.candimod.world.CandiWorldGenerator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod( modid = CandiMod.MODID, version = CandiMod.VERSION )
public class CandiMod
{
	public static final String MODID = "candimod";
	public static final String VERSION = "0.01 pre-alpha";
	public static final Block CANDIBLOCK = new CandiBlock();

	@EventHandler
	public void init( FMLInitializationEvent event )
	{		
		GameRegistry.registerBlock( CANDIBLOCK, "candiblock" );
		
		ItemStack candiblock_stack = new ItemStack( CANDIBLOCK );
		ItemStack anvil = new ItemStack( Blocks.anvil );
		ItemStack wool = new ItemStack( Blocks.wool );
		ItemStack diamond = new ItemStack( Blocks.diamond_block );
		
		GameRegistry.addRecipe( candiblock_stack, "aaa", "bbb", "ccc", 'a', anvil, 'b', wool, 'c', diamond );
		GameRegistry.registerWorldGenerator( new CandiWorldGenerator(), 3 );
	}
}
