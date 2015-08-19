package net.makersville.forge.mods.multimaker;

import net.makersville.forge.mods.multimaker.orchard.ChocolateLiquor;
import net.makersville.forge.mods.multimaker.orchard.CocoaNibs;
import net.makersville.forge.mods.multimaker.orchard.DarkChocolate;
import net.makersville.forge.mods.multimaker.orchard.DroppableFruit;
import net.makersville.forge.mods.multimaker.orchard.FruitDrops;
import net.makersville.forge.mods.multimaker.orchard.MilkChocolate;
import net.makersville.forge.mods.multimaker.orchard.OrangeFruit;
import net.makersville.forge.mods.multimaker.physics.LeadPb;
import net.makersville.forge.mods.multimaker.physics.Uranium;
import net.makersville.forge.mods.util.ForgeUtils;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MultiMakerItems {
	
	public static Item orange;
	public static Item uranium;
	public static Item plumbum;
	public static Item cocoaNibs;
	public static Item chocolateLiquor;
	public static Item darkChocolate;
	public static Item milkChocolate;
	
	public static void createItems() {
		uranium = new Uranium();
		plumbum = new LeadPb();
		orange = new OrangeFruit();
		cocoaNibs = new CocoaNibs();
		chocolateLiquor = new ChocolateLiquor();
		darkChocolate = new DarkChocolate();
		milkChocolate = new MilkChocolate();
	}

	public static void renderItems(String modid) {
		ForgeUtils.renderItem(modid, Uranium.NAME);
		ForgeUtils.renderItem(modid, LeadPb.NAME);
		ForgeUtils.renderItem(modid, OrangeFruit.NAME);
		ForgeUtils.renderItem(modid, CocoaNibs.NAME);
		ForgeUtils.renderItem(modid, ChocolateLiquor.NAME);
		ForgeUtils.renderItem(modid, DarkChocolate.NAME);
		ForgeUtils.renderItem(modid, MilkChocolate.NAME);
	}
	
	public static void assignFruit(FruitDrops fd) {
		fd.addFruit((DroppableFruit) orange);
	}
	
	public static void registerRecipes() {
		GameRegistry.addSmelting(new ItemStack(Items.dye, 1, EnumDyeColor.BROWN.getDyeDamage()),
				new ItemStack(cocoaNibs), 1f);
		
		GameRegistry.addShapelessRecipe(new ItemStack(chocolateLiquor),
				new Object[] {cocoaNibs});
		GameRegistry.addShapelessRecipe(new ItemStack(darkChocolate),
				new Object[] {chocolateLiquor, Items.sugar});
		GameRegistry.addShapelessRecipe(new ItemStack(milkChocolate, 4),
				new Object[] {chocolateLiquor, Items.sugar, Items.milk_bucket});
	}
	
}
