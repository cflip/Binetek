package com.cflip.binetek.gen;

import com.cflip.binetek.block.BlockList;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class BinetekOreGen {
	public static void generate() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			addOre(biome, BlockList.sulfurOre, 8, 7, 0, 16);
			addOre(biome, BlockList.copperOre, 16, 12, 0, 64);
		}
	}

	public static void addOre(Biome biome, Block oreBlock, int rarity, int size, int minLevel, int maxLevel) {
		ConfiguredPlacement placementConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(rarity, minLevel, 0, maxLevel));
		OreFeatureConfig featureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, oreBlock.getDefaultState(), size);
		biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(featureConfig).withPlacement(placementConfig));
	}
}
