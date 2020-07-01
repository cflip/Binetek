package com.cflip.binetek.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class SulfurOreBlock extends OreBlock {
	public SulfurOreBlock() {
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(3).harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE));
	}

	@Override
	public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silkTouch) {
		return silkTouch == 0 ? RANDOM.nextInt(2): 0;
	}
}
