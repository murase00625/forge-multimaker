package net.makersville.student.examplemod.proxy;

import net.makersville.student.examplemod.BlockDictionary;
import net.makersville.student.examplemod.ExampleMod;
import net.makersville.student.examplemod.ItemDictionary;
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
        
        ItemDictionary.renderItems(ExampleMod.MODID);
        BlockDictionary.renderBlocks(ExampleMod.MODID);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
