package net.makersville.forge.mods.multimaker.orchard;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OrangeFruit extends ItemFood {
	
	public static final String NAME = "orangeFruit";
	
	public OrangeFruit() {
		super(5, 1.0f, false);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName(NAME);
		
		GameRegistry.registerItem(this, NAME);
	}
	
}
