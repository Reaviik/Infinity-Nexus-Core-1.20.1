package com.Infinity.Nexus.Core.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class SwordSlot extends SlotItemHandler {
    public SwordSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    /**
     * Verifica se o ItemStack pode ser colocado em um local específico com base no tipo do item.
     *
     * @param stack O ItemStack a ser verificado
     * @return true se o item do ItemStack for uma instância da classe SwordItem, false caso contrário
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return stack.getItem() instanceof SwordItem;
    }
    @Override
    public int getMaxStackSize() {
        return 1;
    }
}