package net.makersville.forge.mods.nuclear;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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
	}
	
	
	
}
