package com.Infinity.Nexus.Core.slots;

import com.Infinity.Nexus.Core.utils.ModUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class ComponentSlot extends SlotItemHandler {
    public ComponentSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }
    /**
     * Verifica se o ItemStack é um componente.
     *
     * @param stack O ItemStack a ser verificado
     * @return true se o ItemStack é um componente, false caso contrário
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return ModUtils.isComponent(stack);
    }
    @Override
    public int getMaxStackSize() {
        return 1;
    }
}