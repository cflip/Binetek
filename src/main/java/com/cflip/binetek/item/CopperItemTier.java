package com.cflip.binetek.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class CopperItemTier implements IItemTier {
	public static final CopperItemTier instance = new CopperItemTier();

	@Override
	public int getMaxUses() {
		return 200;
	}

	@Override
	public float getEfficiency() {
		return 5;
	}

	@Override
	public float getAttackDamage() {
		return 1.5f;
	}

	@Override
	public int getHarvestLevel() {
		return 2;
	}

	@Override
	public int getEnchantability() {
		return 6;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromStacks(new ItemStack(ItemList.copperIngot));
	}
}
