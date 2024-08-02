package com.Infinity.Nexus.Core.slots;

import com.Infinity.Nexus.Core.utils.ModUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class UpgradeSlot extends SlotItemHandler {
    public UpgradeSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    /**
     * Verifica se o ItemStack é um upgrade.
     *
     * @param stack O ItemStack a ser verificado
     * @return true se o ItemStack for um upgrade, false caso contrário
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return ModUtils.isUpgrade(stack);
    }
    @Override
    public int getMaxStackSize() {
        return 4;
    }
}