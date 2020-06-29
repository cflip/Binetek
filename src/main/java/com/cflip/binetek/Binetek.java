package com.cflip.binetek;

import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Binetek.MODID)
public class Binetek {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "binetek";

	public Binetek() {
		MinecraftForge.EVENT_BUS.register(this);
	}

}
