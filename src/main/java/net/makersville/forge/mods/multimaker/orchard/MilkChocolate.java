package net.makersville.forge.mods.multimaker.orchard;

import net.makersville.forge.mods.util.PotionSelect;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MilkChocolate extends ItemFood {

	public static final String NAME = "milkChocolate";
	
	public MilkChocolate() {
		super(8, 4f, false);
		
		this.setAlwaysEdible();
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setUnlocalizedName(NAME);
		
		GameRegistry.registerItem(this, NAME);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn,
			EntityPlayer playerIn) {
		playerIn.addPotionEffect(new PotionEffect(PotionSelect.SPEED, 480*20, 4));
		playerIn.addPotionEffect(new PotionEffect(PotionSelect.JUMP, 480*20, 4));
		playerIn.addPotionEffect(new PotionEffect(PotionSelect.HASTE, 480*20, 4));
		return super.onItemUseFinish(stack, worldIn, playerIn);
	}
	
	
	
}
