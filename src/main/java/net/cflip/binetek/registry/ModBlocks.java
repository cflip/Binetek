package net.cflip.binetek.registry;

import net.cflip.binetek.BinetekMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	public static final Block LIMESTONE = new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f));

	public static void registerBlocks() {

		Registry.register(Registry.BLOCK, new Identifier(BinetekMod.MOD_ID, "limestone"), LIMESTONE);

	}

}
