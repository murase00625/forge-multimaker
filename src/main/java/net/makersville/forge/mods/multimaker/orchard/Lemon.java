package net.makersville.forge.mods.multimaker.orchard;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Lemon extends ItemFood implements DroppableFruit {

	public static final String NAME = "lemon";
	
	// The drop probability settings for this fruit from a vanilla Leaves block.
	// { base chance, deviation, optimal temp, min temp, max temp, min rainfall,
	//   max rainfall, max number of drops }
	private float DROP_SETTINGS[] =
		{1.0f, 2.0f, 0.8f, 0.39f, 0.95f, 0.2f, 0.9f, 2f};
	
	@Override
	public float[] getDropStats() {
		return DROP_SETTINGS;
	}
	
	public Lemon() {
		super(3, 1.0f, false);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName(NAME);
		
		GameRegistry.registerItem(this, NAME);
	}

}
