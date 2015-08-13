package net.makersville.forge.mods.multimaker;

import net.makersville.forge.mods.multimaker.orchard.FruitDrops;
import net.makersville.forge.mods.multimaker.orchard.OrangeFruit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
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
	public static final String VERSION = "0.1 alpha 1";
	
	@Instance
	public static MultiMaker instance = new MultiMaker();
	
	@SidedProxy(clientSide="net.makersville.forge.mods.multimaker.ClientProxy", serverSide="net.makersville.forge.mods.multimaker.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
		
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		
		config.save();
		
		FruitDrops fd = new FruitDrops();
		
		MinecraftForge.EVENT_BUS.register(fd);
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
