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
	
	public static void renderBlocks() {
		ForgeUtils.renderBlock(MultiMaker.MODID, UraniumOre.NAME, uraniumOre);
		ForgeUtils.renderBlock(MultiMaker.MODID, LeadBlock.NAME, leadBlock);
		ForgeUtils.renderBlock(MultiMaker.MODID, UraniumBlock.NAME, uraniumBlock);
		
	}
}
