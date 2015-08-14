package net.makersville.forge.mods.multimaker.ranching;

import java.util.Random;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * @author Morio Murase
 * 
 * Here's a simple example of a subscribed event, or a method that can be attached
 * to an existing event in Minecraft.
 * 
 * With this code, Minecraft will randomly drop 0, 1, or 2 Bones when a Cow or Sheep
 * are killed. Now you can have Bones and Bonemeal in Peaceful difficulty.
 * 
 * Although there's a SubscribeEvent annotation, that doesn't mean the method will
 * be activated-- at some point in the initialization process, this code has to be
 * injected into Minecraft. That code is in the main class.
 *
 */
public class AnimalDrops {

	private Random rand = new Random();
	
	@SubscribeEvent
	public void additionalDrops(LivingDropsEvent evt) {
		if (evt.entity instanceof EntityCow || evt.entity instanceof EntitySheep) {
			evt.entityLiving.dropItem(Items.bone, rand.nextInt(3));
		}
			
	}
	
	
}
