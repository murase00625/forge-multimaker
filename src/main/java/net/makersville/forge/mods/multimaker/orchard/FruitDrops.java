package net.makersville.forge.mods.multimaker.orchard;

import java.util.ArrayList;
import java.util.Random;

import net.makersville.forge.mods.multimaker.MultiMakerItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
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
	
	private static final int RAND_MAX = 100;
	
	private ArrayList<DroppableFruit> fruitList;
	
	public FruitDrops() {
		fruitList.add((DroppableFruit) MultiMakerItems.orange);
	}
	
	@SubscribeEvent
	public void dropFruit(BlockEvent.HarvestDropsEvent evt) {
		if (evt.state.getBlock() == Blocks.leaves) {
			
			Random rand = evt.world.rand;
			BiomeGenBase biome = evt.world.getBiomeGenForCoords(evt.pos);
			
			float settings[];
			
			for (DroppableFruit fruit : fruitList) {
				settings = fruit.getDrops();
				if (settings.length != 7) {
					evt.state.getPlayer().addChatComponentMessage(
							new ChatComponentText(EnumChatFormatting.GOLD +
									"Something is seriously wrong with t!"));
				} else if (fruitDropped(fruit.getDrops(), biome, rand)) {
					int drop = rand.nextInt((int) fruit.getDrops()[MAX_DROP]) + 1;
					evt.drops.add(new ItemStack(MultiMakerItems.orange, drop));
				}	
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
