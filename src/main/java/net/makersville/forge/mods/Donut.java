package net.makersville.forge.mods;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Donut extends ItemFood {
	
	public static final String NAME = "donut";
	
	PotionSelect donutPotions;
	int[] potionIDs = {PotionSelect.SLOW, PotionSelect.REGEN};
	Random rand = new Random();
	int numPotions = 2;
	
	public Donut() {
		super(35, 1.0f, true);
		donutPotions = new PotionSelect(potionIDs);
		donutPotions.selectPotion(this, 600, 2, 0.5f);
		this.setAlwaysEdible();
		this.setUnlocalizedName(Donut.NAME);
		this.setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(this, NAME);
	}
	
	public EnumAction getItemUseAction(ItemStack food)
	{
		return EnumAction.EAT;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn,
			EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		donutPotions.selectPotion(this, 600, 2, 0.5f);
	}
	
}
