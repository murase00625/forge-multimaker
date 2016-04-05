package net.makersville.student.examplemod;

import net.makersville.student.examplemod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

// @Mod(modid = ExampleMod.MODID, name = ExampleMod.MODNAME, version = ExampleMod.VERSION)
public class ExampleMod {
	
	public static final String MODID = "examplemod";
	public static final String MODNAME = "Example Mod";
	public static final String VERSION = "0.1";
	
//	@Instance
//	public static ExampleMod instance = new ExampleMod();
	
	@SidedProxy(clientSide="net.makersville.student.examplemod.proxy.ClientProxy",
				serverSide="net.makersville.student.examplemod.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
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
