package net.makersville.forge.mods.multimaker.orchard;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DarkChocolate extends ItemFood {
	
	public static final String NAME = "darkChocolate";
	
	public DarkChocolate() {
		super(6, 3, false);
		
		this.setAlwaysEdible();
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName(NAME);
		this.setPotionEffect(Potion.digSpeed.id, 480, 3, 1f);
		
		GameRegistry.registerItem(this, NAME);
	}
}
