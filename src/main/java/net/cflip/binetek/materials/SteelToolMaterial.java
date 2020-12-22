package net.cflip.binetek.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SteelToolMaterial implements ToolMaterial {
	@Override
	public int getDurability() {
		return 0;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 0;
	}

	@Override
	public float getAttackDamage() {
		return 2.5F;
	}

	@Override
	public int getMiningLevel() {
		return 0;
	}

	@Override
	public int getEnchantability() {
		return 0;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return null;
	}
}
