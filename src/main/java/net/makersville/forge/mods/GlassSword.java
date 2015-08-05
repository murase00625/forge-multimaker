package net.makersville.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GlassSword extends ItemSword {
	
	public static final String NAME = "glassSword";
	public static ToolMaterial GLASS =
			EnumHelper.addToolMaterial("GLASS", 1, 1, 3.0f, 36.0f, 15);
	
	public GlassSword() {
		super(GLASS);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(this, NAME);
		
		GameRegistry.addRecipe(
				new ItemStack(this),
				" g ",
				" g ",
				" w ",     
				'g', Blocks.glass_pane,
				'w', Items.wooden_sword
				);
	}
}
