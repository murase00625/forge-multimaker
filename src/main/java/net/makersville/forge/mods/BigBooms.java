package net.makersville.forge.mods;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BigBooms {
	@SubscribeEvent
	public void explode(MinecartCollisionEvent event) {
		EntityMinecart minecart = event.minecart;
		minecart.worldObj.createExplosion(minecart,
										minecart.posX,
										minecart.posY,
										minecart.posZ,
										6, false);		
	}
	
}
