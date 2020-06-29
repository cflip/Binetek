package com.cflip.binetek.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CokeFuelHandler extends Item {

    public CokeFuelHandler(Properties properties) {
        super(properties);
    }
    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 3200;
    }
}
