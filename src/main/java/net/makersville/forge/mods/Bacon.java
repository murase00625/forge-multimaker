package net.makersville.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Bacon extends ItemFood {
	
	public static final String NAME = "chunkyBacon";
	
	int[] potionIDs = {PotionSelect.REGEN, PotionSelect.SPEED, PotionSelect.JUMP};
	PotionSelect baconPotions;
	
	public Bacon() {
		super(5, 1.0f, true);
		baconPotions = new PotionSelect(potionIDs);
		baconPotions.selectPotion(this, 600, 2, 0.5f);
		this.setAlwaysEdible();
		this.setUnlocalizedName(Bacon.NAME);
		this.setCreativeTab(CreativeTabs.tabFood);
		
		GameRegistry.registerItem(this, NAME);
		
		GameRegistry.addRecipe(
				new ItemStack(this),
				" s ",
				"sps",
				" s ",
				's', Items.sugar,
				'p', Items.cooked_porkchop
				);
		
	}
	
	public EnumAction getItemUseAction(ItemStack food)
	{
		return EnumAction.EAT;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn,
			EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		stack.stackSize = stack.stackSize + 2;
		baconPotions.selectPotion(this, 600, 2, 0.5f);
		
	}
	
}
