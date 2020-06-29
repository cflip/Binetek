package com.cflip.binetek.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CoalCokeItem extends Item {
    public CoalCokeItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 3200;
    }
}
