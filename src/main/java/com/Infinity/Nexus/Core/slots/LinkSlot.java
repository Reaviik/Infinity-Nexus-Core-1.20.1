package com.Infinity.Nexus.Core.slots;

import com.Infinity.Nexus.Core.items.ModItems;
import com.Infinity.Nexus.Core.utils.ModUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class LinkSlot extends SlotItemHandler {
    public LinkSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    /**
     * Verifica se o ItemStack pode ser colocado em um local específico com base em condições adicionais.
     *
     * @param stack O ItemStack a ser verificado
     * @return true se o ItemStack não é um upgrade nem um componente e é igual ao item LINKING_TOOL da classe ModItems, false caso contrário
     */
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return !(ModUtils.isUpgrade(stack) || ModUtils.isComponent(stack)) && stack.is(ModItems.LINKING_TOOL.get());
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}