package net.makersville.forge.mods;

import java.util.Random;

import net.minecraft.item.ItemFood;


/**
 * @author M.Murase
 *	
 *	Potion ID mapper and random potion selector. Useful for foodstuffs where a random effect from a selected list is desired.
 */
public class PotionSelect {
	Random rand = new Random();
	int[] idlist = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
	int range;
	
	public static final int SPEED = 1;
	public static final int SLOW = 2;
	public static final int HASTE = 3;
	public static final int FATIGUE = 4;
	public static final int STRENGTH = 5;
	public static final int HEAL = 6;
	public static final int HURT = 7;
	public static final int JUMP = 8;
	public static final int NAUSEA = 9;
	public static final int REGEN = 10;
	public static final int RESIST = 11;
	public static final int FIRE_RESIST = 12;
	public static final int WATER_BREATH = 13;
	public static final int INVISIBILITY = 14;
	public static final int BLIND = 15;
	public static final int NIGHT_VISION = 16;
	public static final int HUNGER = 17;
	public static final int WEAKNESS = 18;
	public static final int POISON = 19;
	public static final int WITHER = 20;
	public static final int HEALTH_UP = 21;
	public static final int ABSORB = 22;
	public static final int SATURATION = 23;

	/**
	 * Returns a PotionSelect object that will randomly apply a potion effect from the selected potion IDs.
	 * @param ids The array of potion IDs; suggested usage is {PotionSelect.REGEN, ...}
	 */
	public PotionSelect(int[] ids) {
		idlist = ids;
		range = idlist.length;
	}

	public PotionSelect() {
		range = idlist.length;
	}
	
	public void selectPotion(ItemFood item, int duration, int amplifier, float probability) {
		item.setPotionEffect(idlist[rand.nextInt(range)], duration, amplifier, probability);
	}
	
}
