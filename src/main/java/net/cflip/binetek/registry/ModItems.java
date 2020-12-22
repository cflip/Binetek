package net.cflip.binetek.registry;

import net.cflip.binetek.BinetekMod;
import net.cflip.binetek.materials.SteelToolMaterial;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {



	// Materials and baubles
	public static final Item COAL_COKE = new Item(new Item.Settings().group(BinetekMod.BINETEK_MATERIALS));
	public static final Item SULFUR = new Item(new Item.Settings().group(BinetekMod.BINETEK_MATERIALS));



	//Tools and Weapons
	public static final ToolMaterial STEELTOOLMATERIAL = new SteelToolMaterial();
	public static final Item STEEL_SWORD = new SwordItem(STEELTOOLMATERIAL, 3,-2.4F, new Item.Settings().group(BinetekMod.BINETEK_TOOLS));


public static void registerItems() {
	// Materials and baubles
	Registry.register(Registry.ITEM, new Identifier(BinetekMod.MOD_ID, "coal_coke"), COAL_COKE);
	Registry.register(Registry.ITEM, new Identifier(BinetekMod.MOD_ID, "sulfur"), SULFUR);
	Registry.register(Registry.ITEM, new Identifier("binetek", "limestone"),new BlockItem(ModBlocks.LIMESTONE, new Item.Settings().group(BinetekMod.BINETEK_MATERIALS)));

	// Tools and Weapons
	Registry.register(Registry.ITEM, new Identifier(BinetekMod.MOD_ID, "steel_sword"), STEEL_SWORD);

	}
}
