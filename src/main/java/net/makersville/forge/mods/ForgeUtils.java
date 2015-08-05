package net.makersville.forge.mods;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForgeUtils {
	public static void renderItem(String modid, String name) {
		Item modItem = GameRegistry.findItem(modid, name);
		String key = modid + ":" + name;
		
		ModelResourceLocation mrl =
			new ModelResourceLocation(key, "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(modItem, 0, mrl);
	}
	
	public static void renderBlock(String modid, String name, Block block) {
		String key = modid + ":" + name;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(key, "inventory"));
	}
}
