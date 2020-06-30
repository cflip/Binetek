package com.cflip.binetek.block;

import com.cflip.binetek.container.ResearchTableContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.ParametersAreNonnullByDefault;

public class ResearchTableBlock extends Block {
	public ResearchTableBlock() {
		super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.6f).harvestTool(ToolType.AXE));
	}

	@ParametersAreNonnullByDefault
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		if (!world.isRemote) {
			player.openContainer(state.getContainer(world, pos));
		}
		return ActionResultType.PASS;
	}

	@ParametersAreNonnullByDefault
	@Override
	public INamedContainerProvider getContainer(BlockState state, World world, BlockPos pos) {
		return new SimpleNamedContainerProvider((windowId, inventory, player) -> new ResearchTableContainer(windowId, inventory, IWorldPosCallable.of(world, pos)), ResearchTableContainer.TITLE);
	}
}
