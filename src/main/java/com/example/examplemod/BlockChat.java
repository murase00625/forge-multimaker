package com.example.examplemod;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockChat {
	@SubscribeEvent
	public void sendMessage(BreakEvent event) {
		
		String blockType = event.state.getBlock().getLocalizedName();
		
		event.getPlayer().addChatComponentMessage(
				new ChatComponentText(EnumChatFormatting.GOLD + "You broke a " + blockType + "!"));
	}
}
