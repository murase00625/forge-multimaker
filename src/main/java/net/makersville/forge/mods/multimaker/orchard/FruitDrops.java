package net.makersville.forge.mods.multimaker.orchard;

import java.util.Hashtable;
import java.util.Random;

import net.makersville.forge.mods.multimaker.MultiMakerItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FruitDrops {
	
	// The preferred biomes for custom fruit to be harvested from vanilla Leaves blocks.
	// Base biomes are preferred overall, but variant names are also acceptable.
	public static final String ORANGE_BIOMES[] =
		{"Plains", "Forest", "Swampland", "River", "Jungle", "Hills"};
	
	// The chances in each preferred biome, 10 < chance < 19
	public static final int ORANGE_CHANCES[] =
		{10, 14, 18, 18, 14, 10};
	
	// To deal with variant biomes, we use the temperature range.
	// The base chance for, and the bounds of, any acceptable temp range for the fruit
	private static final int ORANGE_BASE_CHANCE = 8;
	private static final float ORANGE_TEMP_MIN = 0.49f;
	private static final float ORANGE_TEMP_MAX = 0.91f;
	
	private static final float ORANGE_MIN_RAINFALL = 0.1f;
	
	private static final int RAND_MAX = 100;
	
	private Hashtable<String,Integer> orangeDrop = new Hashtable();
	
	public void setBiomeHashes(String fruitName, String[] biomes, int[] chances) {
		if (fruitName == OrangeFruit.NAME) {
			for (int i = 0; i < biomes.length; i++) {
				orangeDrop.put(biomes[i], chances[i]);
			}
		}
	}
	
	@SubscribeEvent
	public void dropFruit(BlockEvent.HarvestDropsEvent evt) {
		if (evt.state.getBlock() == Blocks.leaves) {
			
			Random rand = evt.world.rand;
			BiomeGenBase biome = evt.world.getBiomeGenForCoords(evt.pos);
			if (orangeDrop.containsKey(biome.biomeName)) {
				if (rand.nextInt(RAND_MAX) + 1 <= orangeDrop.get(biome.biomeName)) {
					evt.drops.add(new ItemStack(MultiMakerItems.orange));
				}
			} else {
				float temp = biome.temperature;
				if (temp >= ORANGE_TEMP_MIN && temp <= ORANGE_TEMP_MAX && biome.rainfall > ORANGE_MIN_RAINFALL) {
					if (rand.nextInt(RAND_MAX) + 1 <= ORANGE_BASE_CHANCE) {
						evt.drops.add(new ItemStack(MultiMakerItems.orange));
					}
				}
			}
				
		}
	}
}
