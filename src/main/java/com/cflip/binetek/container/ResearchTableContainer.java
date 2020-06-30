package com.cflip.binetek.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.ParametersAreNonnullByDefault;

public class ResearchTableContainer extends WorkbenchContainer {
	public static final ITextComponent TITLE = new TranslationTextComponent("container.research_table");

	public ResearchTableContainer(int windowId, PlayerInventory inventory, IWorldPosCallable worldPos) {
		super(windowId, inventory, worldPos);
	}

	public ResearchTableContainer(int windowId, PlayerInventory inventory, PacketBuffer packet) {
		super(windowId, inventory, IWorldPosCallable.of(inventory.player.world, packet.readBlockPos()));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}
}
