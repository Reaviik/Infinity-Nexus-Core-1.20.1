package com.Infinity.Nexus.Core.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class FuelSlot extends SlotItemHandler {
    public FuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    /**
     * Verifica se o ItemStack pode ser colocado em um local específico com base no tempo de queima do item.
     *
     * @param stack O ItemStack a ser verificado
     * @return true se o tempo de queima do ItemStack é maior que zero, false caso contrário
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, null) > 0;
    }
    @Override
    public int getMaxStackSize() {
        return 64;
    }
}