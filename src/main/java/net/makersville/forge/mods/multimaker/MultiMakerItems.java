package net.makersville.forge.mods.multimaker;

import net.makersville.forge.mods.multimaker.orchard.OrangeFruit;
import net.makersville.forge.mods.multimaker.physics.LeadPb;
import net.makersville.forge.mods.multimaker.physics.Uranium;
import net.makersville.forge.mods.util.ForgeUtils;
import net.minecraft.item.Item;

public class MultiMakerItems {
	
	public static Item orange;
	public static Item uranium;
	public static Item plumbum;
	
	public static void createItems() {
		uranium = new Uranium();
		plumbum = new LeadPb();
		orange = new OrangeFruit();
	}
	
	public static void renderItems() {
		ForgeUtils.renderItem(MultiMaker.MODID, Uranium.NAME);
		ForgeUtils.renderItem(MultiMaker.MODID, LeadPb.NAME);
		ForgeUtils.renderItem(MultiMaker.MODID, OrangeFruit.NAME);
	}
}
