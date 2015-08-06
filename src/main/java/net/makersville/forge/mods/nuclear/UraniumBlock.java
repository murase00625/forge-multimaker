package net.makersville.forge.mods.nuclear;

import net.makersville.forge.mods.Main;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UraniumBlock extends Block {
	
	public static final String NAME = "uraniumBlock";
	
	public UraniumBlock() {
		super(new Uranium.UraniumMaterial());
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(0.85f);
		
		GameRegistry.registerBlock(this, NAME);
		GameRegistry.addRecipe(new ItemStack(this),
				"uuu",
				"uuu",
				"uuu",
				'u', Uranium.getObject());
	}
	

}
