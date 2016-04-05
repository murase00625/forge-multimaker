package net.makersville.student.examplemod.proxy;

import net.makersville.forge.mods.multimaker.MultiMaker;
import net.makersville.forge.mods.multimaker.MultiMakerBlocks;
import net.makersville.forge.mods.multimaker.MultiMakerItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        
        MultiMakerItems.renderItems(MultiMaker.MODID);
        MultiMakerBlocks.renderBlocks();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
