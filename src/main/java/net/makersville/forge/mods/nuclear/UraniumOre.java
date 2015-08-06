package net.makersville.forge.mods.nuclear;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UraniumOre extends Block {
	private Item uraniumDrop;
	private int meta=0;
	private int least=1;
	private int most=1;
	
	public static final String NAME = "uraniumOre";
	
	private static boolean singleton_created = false;
	private static Block singleton;
	
	public static Block getObject() {
		if (!singleton_created) {
			singleton = new UraniumOre();
			singleton_created = true;
		}
		return singleton;
	}
	
	protected UraniumOre() {
		super(Material.rock);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.uraniumDrop = Uranium.getObject();
		this.setHardness(15f);
		this.setResistance(20f);
		this.setHarvestLevel("pickaxe", 2);
		
		GameRegistry.registerBlock(this, NAME);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.uraniumDrop;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return this.meta;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return this.least;
	}
	
	
	
	
	
}
