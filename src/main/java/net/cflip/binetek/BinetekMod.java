package net.cflip.binetek;

import net.cflip.binetek.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class BinetekMod implements ModInitializer {

	public static final String MOD_ID = "binetek";

	public static final ItemGroup BINETEK_MATERIALS = FabricItemGroupBuilder.build(
			new Identifier("binetek", "general"),
			() -> new ItemStack(ModItems.COAL_COKE));

	public static final ItemGroup BINETEK_TOOLS = FabricItemGroupBuilder.create(
			new Identifier("binetek", "other"))
			.icon(() -> new ItemStack(ModItems.STEEL_SWORD))
			.build();


	@Override
	public void onInitialize() {
		ModItems.registerItems();
	}
}
