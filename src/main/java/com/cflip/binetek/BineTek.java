package com.cflip.binetek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(BineTek.MODID)
public class BineTek {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "binetek";

	public BineTek() {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
