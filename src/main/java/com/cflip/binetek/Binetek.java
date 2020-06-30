package com.cflip.binetek;

import com.cflip.binetek.block.BlockList;
import com.cflip.binetek.block.ResearchTableBlock;
import com.cflip.binetek.item.BinetekItemGroup;
import com.cflip.binetek.item.CoalCokeItem;
import com.cflip.binetek.item.FertilizerPouchItem;
import com.cflip.binetek.item.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Binetek.MODID)
public class Binetek {
    public static final String MODID = "binetek";

    public Binetek() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void loadComplete(FMLLoadCompleteEvent event) {
            for (Biome biome : ForgeRegistries.BIOMES) {
                ConfiguredPlacement placementConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16));
                OreFeatureConfig featureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockList.sulfurOre.getDefaultState(), 7);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(featureConfig).withPlacement(placementConfig));
            }
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    // ITEM ITEMS
                    ItemList.fertilizerDust = new BoneMealItem(new Item.Properties().group(BinetekItemGroup.instance)).setRegistryName(Binetek.MODID, "fertilizer_dust"),
                    ItemList.fertilizerPouch = new FertilizerPouchItem(new Item.Properties().group(BinetekItemGroup.instance)).setRegistryName(Binetek.MODID, "fertilizer_pouch"),
                    ItemList.coalCoke = new CoalCokeItem(new Item.Properties().group(BinetekItemGroup.instance)).setRegistryName(Binetek.MODID, "coal_coke"),
                    ItemList.sulfur = new Item(new Item.Properties().group(BinetekItemGroup.instance)).setRegistryName(Binetek.MODID, "sulfur"),
                    ItemList.techbookChem = new Item(new Item.Properties().group(BinetekItemGroup.instance).maxStackSize(1)).setRegistryName(Binetek.MODID, "techbook_chemical"),
                    ItemList.techbookConst = new Item(new Item.Properties().group(BinetekItemGroup.instance).maxStackSize(1)).setRegistryName(Binetek.MODID, "techbook_construction"),
                    ItemList.techbookOrd = new Item(new Item.Properties().group(BinetekItemGroup.instance).maxStackSize(1)).setRegistryName(Binetek.MODID, "techbook_order"),
                    ItemList.techbookWeap = new Item(new Item.Properties().group(BinetekItemGroup.instance).maxStackSize(1)).setRegistryName(Binetek.MODID, "techbook_weaponry"),

                    // BLOCK ITEMS
                    ItemList.researchTable = new BlockItem(BlockList.researchTable, new Item.Properties().group(BinetekItemGroup.instance)).setRegistryName(BlockList.researchTable.getRegistryName()),
                    ItemList.limeStone = new BlockItem(BlockList.limeStone, new Item.Properties().group(BinetekItemGroup.instance)).setRegistryName(BlockList.limeStone.getRegistryName()),
                    ItemList.sulfurOre = new BlockItem(BlockList.sulfurOre, new Item.Properties().group(BinetekItemGroup.instance)).setRegistryName(BlockList.sulfurOre.getRegistryName())
            );
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    BlockList.researchTable = new ResearchTableBlock().setRegistryName(Binetek.MODID, "research_table"),
                    BlockList.limeStone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.6f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)).setRegistryName(Binetek.MODID, "limestone"),
                    BlockList.sulfurOre = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)).setRegistryName(Binetek.MODID, "sulfur_ore")
            );
        }
    }
}
