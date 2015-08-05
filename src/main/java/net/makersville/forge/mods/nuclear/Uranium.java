package net.makersville.forge.mods.nuclear;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Uranium extends Item {
	public static final String NAME = "uranium";
	
	public static ToolMaterial URANIUM = 
			EnumHelper.addToolMaterial("URANIUM", 3, 1234, 10f, 3.6f, 6);
	
	private static boolean singleton_created = false;
	private static Item singleton;
	
	public static Item getObject() {
		if (!singleton_created) {
			singleton = new Uranium();
			singleton_created = true;
		}
		return singleton;
	}
	
	protected Uranium() {
		super();
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(this, NAME);
	}
	
	public static class UraniumMaterial extends Material {
		public UraniumMaterial() {
			super(MapColor.obsidianColor);
			this.setRequiresTool();
		}
	}
	
}
