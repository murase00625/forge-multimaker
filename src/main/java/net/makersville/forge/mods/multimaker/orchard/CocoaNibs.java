package net.makersville.forge.mods.multimaker.orchard;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CocoaNibs extends ItemFood {
	
	public static final String NAME="cocoaNibs";
	
	public CocoaNibs() {
		super(2, 1, false);
		
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(PotionSelect.SPEED, 120, 0, 0.5f);
		this.setAlwaysEdible();
		
		GameRegistry.registerItem(this, NAME);
		
	}
	
}
