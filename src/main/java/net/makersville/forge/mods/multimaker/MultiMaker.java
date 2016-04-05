package net.makersville.forge.mods.multimaker;

import net.makersville.forge.mods.multimaker.orchard.FruitDrops;
import net.makersville.forge.mods.multimaker.proxy.ClientProxy;
import net.makersville.forge.mods.multimaker.proxy.CommonProxy;
import net.makersville.forge.mods.multimaker.ranching.AnimalDrops;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MultiMaker.MODID, name = MultiMaker.MODNAME, version = MultiMaker.VERSION)
public class MultiMaker {
	
	public static final String MODID = "multimaker";
	public static final String MODNAME = "MultiMaker mod";
	public static final String VERSION = "0.1 alpha 2";
	
	@Instance
	public static MultiMaker instance = new MultiMaker();
	
	@SidedProxy(clientSide="net.makersville.forge.mods.multimaker.proxy.ClientProxy",
				serverSide="net.makersville.forge.mods.multimaker.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
		
		FruitDrops fd = new FruitDrops();
		AnimalDrops ad = new AnimalDrops();
		
		MultiMakerItems.assignFruit(fd);
		
		// If there are custom event methods for vanilla Minecraft events,
		// they must be registered with the Forge event bus.
		MinecraftForge.EVENT_BUS.register(fd);
		MinecraftForge.EVENT_BUS.register(ad);
		
		if (this.proxy instanceof ClientProxy) {
			((ClientProxy) this.proxy).setModID(MultiMaker.MODID);
		}
		
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	this.proxy.postInit(e);
    }

}
