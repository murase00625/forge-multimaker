package net.makersville.forge.mods.multimaker;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		MultiMakerItems.createItems();
		MultiMakerBlocks.createBlocks();
		
		MultiMakerItems.registerRecipes();
    }

    public void init(FMLInitializationEvent e) {
    	GameRegistry.registerWorldGenerator(new MultiMakerWorldGen(), 0);
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
