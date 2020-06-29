package com.cflip.binetek;

import com.cflip.binetek.block.BlockList;
import com.cflip.binetek.item.FertilizerPouchItem;
import com.cflip.binetek.item.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BinetekRegistry {
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ItemList.fertilizerDust = new BoneMealItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(Binetek.MODID, "fertilizer_dust"),
                ItemList.fertilizerPouch = new FertilizerPouchItem(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(Binetek.MODID, "fertilizer_pouch"),
                ItemList.coalCoke = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName(Binetek.MODID, "coal_coke"),
                ItemList.researchTable = new BlockItem(BlockList.researchTable, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(BlockList.researchTable.getRegistryName()),
                ItemList.limeStone = new BlockItem(BlockList.limeStone, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.limeStone.getRegistryName())
        );
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                BlockList.researchTable = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.6f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)).setRegistryName(Binetek.MODID, "research_table"),
                BlockList.limeStone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.6f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)).setRegistryName(Binetek.MODID, "limestone")
        );
    }
}
