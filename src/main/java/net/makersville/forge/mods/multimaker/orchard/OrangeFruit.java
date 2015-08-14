package net.makersville.forge.mods.multimaker.orchard;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OrangeFruit extends ItemFood implements DroppableFruit {
	
	public static final String NAME = "orangeFruit";
	
	// The drop probability settings for this fruit from a vanilla Leaves block.
	// { base chance, deviation, optimal temp, min temp, max temp, min rainfall,
	//   max rainfall, max number of drops }
	private float DROP_SETTINGS[] =
		{14.0f, 4.0f, 0.7f, 0.49f, 0.91f, 0.2f, 0.9f, 2f};
	
	@Override
	public float[] getDropStats() {
		return DROP_SETTINGS;
	}
	
	public OrangeFruit() {
		super(5, 1.0f, false);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName(NAME);
		
		GameRegistry.registerItem(this, NAME);
	}
	
}
