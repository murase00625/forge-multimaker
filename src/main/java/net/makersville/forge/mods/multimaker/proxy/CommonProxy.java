package net.makersville.forge.mods.multimaker.proxy;

import net.makersville.forge.mods.multimaker.MultiMakerBlocks;
import net.makersville.forge.mods.multimaker.MultiMakerItems;
import net.makersville.forge.mods.multimaker.MultiMakerWorldGen;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * @author Morio Murase
 * 
 */

/** The CommonProxy performs tasks that both client and server sides must perform.
 * In particular, any custom items/blocks/entities, crafting or smelting recipes,
 * and anything else that's related to setting up the mod's custom world.
 * 
 * Sided proxies are beneficial because the server doesn't need to do certain things
 * essential to the client, like render graphics or playback audio. All the server
 * needs to be concerned with is creating and updating the game world and everything
 * in it. In Minecraft 1.8 and later, this separation of tasks is now enforced, and
 * any attempt to set up graphic rendering or audio playback on the server will trigger
 * a warning.
 * 
 * Note that all of the methods in the CommonProxy are called from the main mod class,
 * in this case MultiMaker. Forge will automatically detect which subclass is
 * appropriate for the situation.
 * 
 * While this may be overkill for simple modifications to vanilla Minecraft, sooner
 * or later you'll want to make the next ultimate uber-complex MMO mod with all the
 * bells and whistles, in which case you will need to have proxies.
 *
 */
public class CommonProxy {
	
	// While the main class uses the @EventHandler annotation, the proxy classes don't
	// need it because the main class calls these methods.
	
	// Initialize any custom objects (entities, items, blocks) in the preInit method.
	// Don't try to set up renderers here, the ServerProxy subclass will throw an
	// error!
	public void preInit(FMLPreInitializationEvent e) {
		MultiMakerItems.createItems();
		MultiMakerBlocks.createBlocks();
		
		MultiMakerItems.registerRecipes();
    }
	
	// Custom world generators go here. World generators really only get called when
	// a new world is created (Create World in single player for the client, or when
	// a server is started with no world directory), so both proxies need it.
	
	// In order to place custom ores/trees/etc. within the environment, you will need
	// to create a custom world generator that is aware of the custom objects, which
	// is harder than it really is.
    public void init(FMLInitializationEvent e) {
    	GameRegistry.registerWorldGenerator(new MultiMakerWorldGen(), 0);
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
