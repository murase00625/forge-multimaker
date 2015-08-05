package net.makersville.forge.mods;

import net.makersville.forge.mods.nuclear.*;
import net.makersville.forge.mods.util.ForgeUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Main.MODID, name="Makersville Mods", version = Main.VERSION)
public class Main {
	public static final String MODID = "makersville";
	public static final String VERSION = "1.0";
	
	public static Item bacon;
	public static Item donut;
	public static Item glassSword;
	public static Item uranium;
	public static Item plumbum;
	
	public static Block uraniumBlock;
	public static Block leadBlock;
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
		//MinecraftForge.EVENT_BUS.register(new BigBooms());
		
		bacon = new Bacon();
		donut = new Donut();
		uranium = Uranium.getObject();
		glassSword = new GlassSword();
		uraniumBlock = new UraniumBlock();
		plumbum = LeadPb.get_lead();
		leadBlock = new LeadBlock();
		
		if (event.getSide() == Side.CLIENT) {
			ForgeUtils.renderItem(MODID, Bacon.NAME);
			ForgeUtils.renderItem(MODID, Donut.NAME);
			ForgeUtils.renderItem(MODID, Uranium.NAME);
			ForgeUtils.renderItem(MODID, GlassSword.NAME);
			ForgeUtils.renderBlock(MODID, UraniumBlock.NAME, uraniumBlock);
			ForgeUtils.renderItem(MODID, LeadPb.NAME);
			ForgeUtils.renderBlock(MODID, LeadBlock.NAME, leadBlock);
		}
		
		
		GameRegistry.addSmelting(new ItemStack(Blocks.gravel), new ItemStack(Blocks.stone), 1);
		
	}

}
