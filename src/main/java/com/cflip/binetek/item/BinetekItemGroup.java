package com.cflip.binetek.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BinetekItemGroup extends ItemGroup {
	public static final BinetekItemGroup instance = new BinetekItemGroup();

	public BinetekItemGroup() {
		super("binetek");
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.fertilizerPouch);
	}
}
