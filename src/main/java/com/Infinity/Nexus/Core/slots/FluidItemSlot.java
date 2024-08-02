package com.Infinity.Nexus.Core.slots;

import com.Infinity.Nexus.Core.utils.ModUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class FluidItemSlot extends SlotItemHandler {
    public FluidItemSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    /**
     * Verifica se o ItemStack pode ser colocado em um local específico com base em condições adicionais.
     *
     * @param stack O ItemStack a ser verificado
     * @return true se o ItemStack não é um componente nem um upgrade OU possui a capacidade FLUID_HANDLER_ITEM presente, false caso contrário
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return !(ModUtils.isComponent(stack) || ModUtils.isUpgrade(stack)) || stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}