package com.Infinity.Nexus.Core.items.custom;

import com.Infinity.Nexus.Core.items.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UpgradeItem extends Item {
    public UpgradeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            if(stack.getItem() == ModItems.SPEED_UPGRADE.get()) {
                components.add(Component.translatable("item.infinity_nexus_core.speed_description"));
            } else if(stack.getItem() == ModItems.STRENGTH_UPGRADE.get()) {
                components.add(Component.translatable("item.infinity_nexus_core.strength_description"));
            }else if(stack.getItem() == ModItems.MUFFLER_UPGRADE.get()) {
                components.add(Component.translatable("item.infinity_nexus_core.muffler_description"));
            } else if(stack.getItem() == ModItems.PUSHER_UPGRADE.get()) {
                components.add(Component.translatable("item.infinity_nexus_core.pusher_description"));
            }
            components.add(Component.translatable("tooltip.infinity_nexus_core.upgrade_install"));
        } else {
            components.add(Component.translatable("tooltip.infinity_nexus_core.pressShift"));
        }

        super.appendHoverText(stack, level, components, flag);
    }
}
