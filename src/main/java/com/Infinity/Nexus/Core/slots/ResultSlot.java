package com.Infinity.Nexus.Core.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class ResultSlot extends SlotItemHandler {
    public ResultSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    /**
     * Sempre retorna falso, indicando que o ItemStack não pode ser colocado em um local específico.
     *
     * @param stack O ItemStack a ser verificado
     * @return Sempre false
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return false;
    }
    @Override
    public int getMaxStackSize() {
        return 64;
    }
}