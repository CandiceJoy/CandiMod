package com.candicejoy.candimod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CandiBlock extends Block
{
	private static final String NAME = "candiblock";
	
	public CandiBlock()
	{
		super( Material.craftedSnow );
		
		setHardness( 0.5F );
		setStepSound( Block.soundTypePiston );
		setBlockName( NAME );
		setCreativeTab( CreativeTabs.tabBlock );
		setHarvestLevel( "axe", 3 );
		setResistance( 3.0F );
		setBlockTextureName( CandiMod.MODID + ":" + NAME );
	}
	
	public Item getItemDropped( int metadata, Random random, int fortune ) 
	{
        return Item.getItemFromBlock( Blocks.dragon_egg );
    }
	
	public int quantityDropped( int meta, int fortune, Random random )
	{
		return 17;
	}
}