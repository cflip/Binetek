package com.cflip.binetek.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.ForgeEventFactory;

public class FertilizerPouchItem extends Item {
	public FertilizerPouchItem(Properties properties) {
		super(properties.maxStackSize(1).maxDamage(16).setNoRepair());
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos pos = context.getPos();

		if (applyBonemeal(context.getItem(), world, pos, context.getPlayer())) {
			if (!world.isRemote) world.playEvent(Constants.WorldEvents.BONEMEAL_PARTICLES, pos, 0);
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.PASS;
		}
	}

	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, PlayerEntity player) {
		BlockState blockstate = worldIn.getBlockState(pos);
		int hook = ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, blockstate, stack);
		if (hook != 0) return hook > 0;

		if (blockstate.getBlock() instanceof IGrowable) {
			IGrowable igrowable = (IGrowable) blockstate.getBlock();
			if (igrowable.canGrow(worldIn, pos, blockstate, worldIn.isRemote)) {
				if (worldIn instanceof ServerWorld) {
					if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, blockstate)) {
						igrowable.grow((ServerWorld) worldIn, worldIn.rand, pos, blockstate);
					}

					stack.damageItem(1, player, playerEntity -> stack.shrink(1));
				}
				return true;
			}
		}

		return false;
	}
}
