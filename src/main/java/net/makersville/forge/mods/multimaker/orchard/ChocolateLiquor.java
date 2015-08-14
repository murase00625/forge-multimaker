package net.makersville.forge.mods.multimaker.orchard;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ChocolateLiquor extends ItemFood {

	public static final String NAME = "chocolateLiquor";
	
	public ChocolateLiquor() {
		super(3, 1, false);
		
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(PotionSelect.SPEED, 240, 3, 1f);
		this.setAlwaysEdible();
		
		GameRegistry.registerItem(this, NAME);
	}
	
	
}
