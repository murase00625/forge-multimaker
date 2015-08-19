package net.makersville.forge.mods.multimaker.orchard;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MilkChocolate extends ItemFood {

	public static final String NAME = "milkChocolate";
	
	public MilkChocolate() {
		super(8, 4f, false);
		
		this.setAlwaysEdible();
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName(NAME);
		this.setPotionEffect(PotionSelect.JUMP, 480, 2, 1f);
		
		GameRegistry.registerItem(this, NAME);
	}
	
}
