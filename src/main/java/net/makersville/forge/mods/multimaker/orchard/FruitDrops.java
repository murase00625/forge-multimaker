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
	
	// The indices for the various data values used to calculate drop rate
	// based on biome temp and rainfall.
	private static final int BASE_CHANCE = 0;
	private static final int DEVIATION = 1;
	private static final int OPTIMAL_TEMP = 2;
	private static final int TEMP_MIN = 3;
	private static final int TEMP_MAX = 4;
	private static final int RAIN_MIN = 5;
	private static final int RAIN_MAX = 6;
	private static final int MAX_DROP = 7;
	
	// New way: Always go with the biome's temperature and rainfall values.
	// If the temp is close to the optimal temp (3rd value), make it more likely
	// to drop the fruit.
	public static final float ORANGE_SETTINGS[] =
		{14.0f, 4.0f, 0.7f, 0.49f, 0.91f, 0.2f, 0.9f, 2f};
	
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
			
			if (fruitDropped(ORANGE_SETTINGS, biome, rand)) {
				int drop = rand.nextInt((int) ORANGE_SETTINGS[MAX_DROP]) + 1;
				evt.drops.add(new ItemStack(MultiMakerItems.orange, drop));
			}	
		}
	}
	
	public boolean fruitDropped(float settings[], BiomeGenBase biome, Random rand) {
		
		float temperature = biome.temperature;
		float rainfall = biome.rainfall;
		
		if (temperature > settings[TEMP_MIN] &&
			temperature < settings[TEMP_MAX] &&
			rainfall > settings[RAIN_MIN] &&
			rainfall < settings[RAIN_MAX]) {
			int probability = (int) settings[BASE_CHANCE];
			int deviation = rand.nextInt((int) settings[DEVIATION]);
			int bonus = 0;
			
			if (Math.abs(temperature - settings[OPTIMAL_TEMP]) < 0.1) {
				bonus = 5;
			} else if (Math.abs(temperature - settings[OPTIMAL_TEMP]) < 0.3) {
				bonus = 2;
			}
			probability += deviation + bonus;
			
			if (probability >= (rand.nextInt(RAND_MAX) + 1)) {
				return true;
			}
		}
		
		return false;
	}
}
