package com.cflip.binetek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(BineTek.MODID)
public class BineTek {
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "binetek";

	public BineTek() {
//		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
		}
	}
}
