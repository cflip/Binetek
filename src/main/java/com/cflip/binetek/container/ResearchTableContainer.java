package com.cflip.binetek.container;

import com.cflip.binetek.item.TechBookItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.Optional;

public class ResearchTableContainer extends Container {
	public static final ITextComponent TITLE = new TranslationTextComponent("container.research_table");

	private static class TechBookInputSlot extends Slot {
		public TechBookInputSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			super(inventoryIn, index, xPosition, yPosition);
		}

		@Override
		public boolean isItemValid(ItemStack stack) {
			return stack.getItem() instanceof TechBookItem;
		}
	}

	private final CraftingInventory craftingGrid = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory craftingResult = new CraftResultInventory();
	private final Inventory bookInput = new Inventory(1);

	private World world;
	private PlayerEntity player;

	public ResearchTableContainer(int windowId, PlayerInventory inventory, PacketBuffer packet) {
		super(ContainerList.RESEARCH_TABLE, windowId);
		player = inventory.player;
		this.world = player.world;

		addSlot(new CraftingResultSlot(player, craftingGrid, craftingResult, 0, 145, 35));
		addSlot(new TechBookInputSlot(bookInput, 0, 15, 35));

		// Crafting grid
		for (int gy = 0; gy < 3; ++gy) {
			for (int gx = 0; gx < 3; ++gx) {
				addSlot(new Slot(craftingGrid, gx + gy * 3, 51 + gx * 18, 18 + gy * 18));
			}
		}

		// Player inventory
		for (int iy = 0; iy < 3; ++iy) {
			for (int ix = 0; ix < 9; ++ix) {
				addSlot(new Slot(inventory, ix + iy * 9 + 9, 8 + ix * 18, 84 + iy * 18));
			}
		}

		// Player hotbar
		for (int h = 0; h < 9; ++h) {
			addSlot(new Slot(inventory, h, 8 + h * 18, 142));
		}
	}

	@Override
	public void onCraftMatrixChanged(IInventory inventory) {
		if (!world.isRemote) {
			ServerPlayerEntity sPlayer = (ServerPlayerEntity) player;
			ItemStack stack = ItemStack.EMPTY;
			Optional<ICraftingRecipe> optionalRecipe = world.getServer().getRecipeManager().getRecipe(IRecipeType.CRAFTING, craftingGrid, world);

			if (optionalRecipe.isPresent()) {
				ICraftingRecipe recipe = optionalRecipe.get();

				if (craftingResult.canUseRecipe(world, sPlayer, recipe)) {
					stack = recipe.getCraftingResult(craftingGrid);
				}
			}

			craftingResult.setInventorySlotContents(0, stack);
			sPlayer.connection.sendPacket(new SSetSlotPacket(windowId, 0, stack));
		}
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity player, int index) {
		ItemStack stack = inventorySlots.get(index).getStack();
		if (stack.getItem() instanceof TechBookItem && bookInput.isEmpty()) {
			bookInput.setInventorySlotContents(0, stack.copy());
			stack.setCount(0);
		}

		return ItemStack.EMPTY;
	}

	@Override
	public void onContainerClosed(PlayerEntity player) {
		clearContainer(player, player.world, bookInput);
		clearContainer(player, player.world, craftingGrid);
	}

	@Override
	public boolean canInteractWith(PlayerEntity player) {
		return true;
	}
}
