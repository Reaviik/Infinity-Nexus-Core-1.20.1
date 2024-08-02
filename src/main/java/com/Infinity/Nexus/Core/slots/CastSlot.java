package com.Infinity.Nexus.Core.slots;

import com.Infinity.Nexus.Core.utils.ModUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class CastSlot extends SlotItemHandler {
    public CastSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    /**
     * Verifica se o ItemStack pode ser colocado em um local específico.
     *
     * @param stack O ItemStack a ser verificado
     * @return true se o ItemStack não é um upgrade nem um componente, false caso contrário
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return !(ModUtils.isUpgrade(stack) || ModUtils.isComponent(stack));
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}