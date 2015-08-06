package net.makersville.forge.mods.multimaker;

import net.makersville.forge.mods.nuclear.LeadPb;
import net.makersville.forge.mods.nuclear.Uranium;
import net.makersville.forge.mods.util.ForgeUtils;
import net.minecraft.item.Item;

public class MultiMakerItems {
	
//	public static Item orange;
	public static Item uranium;
	public static Item plumbum;
	
	public static void createItems() {
		uranium = Uranium.getObject();
		plumbum = LeadPb.getObject();
	}
	
	public static void renderItems() {
		ForgeUtils.renderItem(MultiMaker.MODID, Uranium.NAME);
		ForgeUtils.renderItem(MultiMaker.MODID, LeadPb.NAME);
	}
}
