package com.cflip.binetek.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class TechShelfBlock extends Block {
	public static final DirectionProperty DIRECTION = HorizontalBlock.HORIZONTAL_FACING;

	public TechShelfBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.5f).harvestTool(ToolType.AXE).harvestLevel(1).sound(SoundType.WOOD));
		setDefaultState(getStateContainer().getBaseState().with(DIRECTION, Direction.NORTH));
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return getDefaultState().with(DIRECTION, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation rotation) {
		return state.with(DIRECTION, rotation.rotate(state.get(DIRECTION)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(DIRECTION)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DIRECTION);
	}
}
