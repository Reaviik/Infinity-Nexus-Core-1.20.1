package com.Infinity.Nexus.Core.items.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class LinkingTool extends Item {
    public LinkingTool(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.translatable("tooltip.infinity_nexus_core.linking_tool"));
        } else {
            components.add(Component.translatable("tooltip.infinity_nexus_core.pressShift"));
        }
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && !context.getLevel().isClientSide) {
            int x = (int) context.getClickedPos().getX();
            int y = (int) context.getClickedPos().getY();
            int z = (int) context.getClickedPos().getZ();
            MutableComponent message = Component.literal("§b[§aCoordinates§b]: "+ "w=0,x=" + x + ",y=" + y + ",z=" + z);
            Style style = Style.EMPTY.withClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, Component.literal("w=0,x=" + x + ",y=" + y + ",z=" + z).getString()));
            message.withStyle(style);
            player.getMainHandItem().setHoverName(Component.literal("w=0,x=" + x + ",y=" + y + ",z=" + z));
            player.sendSystemMessage(message);
            return InteractionResult.FAIL;
        }
        return super.onItemUseFirst(stack, context);
    }
}
