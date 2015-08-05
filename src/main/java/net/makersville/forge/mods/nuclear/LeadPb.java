package net.makersville.forge.mods.nuclear;

import net.makersville.forge.mods.Main;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LeadPb extends Item {
	public static final String NAME = "plumbum";
	
	private static LeadPb singleton_lead;
	private static boolean singleton_created = false;
	
	public static LeadPb get_lead() {
		if (!singleton_created) {
			singleton_lead = new LeadPb();
		}
		return singleton_lead;
	}
	
	public static ToolMaterial LEAD =
			EnumHelper.addToolMaterial("LEAD", 1, 50, 2f, 1f, 1);
	
	public LeadPb() {
		super();
		singleton_created = true;
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(this, NAME);
	}
	
	public static class LeadMaterial extends Material {
		public LeadMaterial() {
			super(MapColor.stoneColor);
			this.setRequiresTool();
		}
	}
}
