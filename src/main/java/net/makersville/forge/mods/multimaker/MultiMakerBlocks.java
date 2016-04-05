package net.makersville.forge.mods.multimaker;

import net.makersville.forge.mods.multimaker.physicalscience.LeadBlock;
import net.makersville.forge.mods.multimaker.physicalscience.Uranium;
import net.makersville.forge.mods.multimaker.physicalscience.UraniumBlock;
import net.makersville.forge.mods.multimaker.physicalscience.UraniumOre;
import net.makersville.forge.mods.util.ForgeUtils;
import net.minecraft.block.Block;

public class MultiMakerBlocks {
	
	public static Block uraniumOre;
	public static Block leadBlock;
	public static Block uraniumBlock;
		
	public static void createBlocks() {
		uraniumOre = new UraniumOre((Uranium) MultiMakerItems.uranium);
		leadBlock = new LeadBlock(MultiMakerItems.plumbum);
		uraniumBlock = new UraniumBlock((Uranium) MultiMakerItems.uranium);
	}
	
	public static void renderBlocks(String modid) {
		ForgeUtils.renderBlock(modid, UraniumOre.NAME, uraniumOre);
		ForgeUtils.renderBlock(modid, LeadBlock.NAME, leadBlock);
		ForgeUtils.renderBlock(modid, UraniumBlock.NAME, uraniumBlock);
	}
}
