package net.makersville.forge.mods.nuclear;

import net.makersville.forge.mods.Main;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LeadBlock extends Block {
	
	public static final String NAME = "leadBlock";
	private Item plumbum;
	
	public LeadBlock(Item pb) {
		super(new LeadPb.LeadMaterial());
		this.plumbum = pb;
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, NAME);
		
		GameRegistry.addRecipe(new ItemStack(this),
				"pp",
				"pp",
				'p', plumbum);

		GameRegistry.addRecipe(new ItemStack(plumbum, 4), "b", 'b', this);
	}
	
	public LeadBlock() {
		this(LeadPb.getObject());
	}
}
