package com.Infinity.Nexus.Core.renderer;

import com.Infinity.Nexus.Core.items.ModItems;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Optional;

public class RenderScreenTooltips {
    public static void renderComponentSlotTooltip(GuiGraphics guiGraphics, ResourceLocation texture, int i, int i1, int i2, int i3, int i4, int i5) {
        guiGraphics.blit(texture, i, i1, i2, i3, i4, i5);
    }
    public static void renderUpgradeSlotTooltipAndItems(Font font, GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, int x, int y) {
        pGuiGraphics.renderTooltip(font, List.of(Component.translatable("tooltip.infinity_nexus_core.upgrades")), Optional.empty(), pMouseX - x, pMouseY - y);
        int upgradePos = 7;
        List <ItemStack> upgradeList = List.of(new ItemStack(ModItems.SPEED_UPGRADE.get(), 1), new ItemStack(ModItems.STRENGTH_UPGRADE.get(), 1));
        for (ItemStack itemStack : upgradeList) {
            pGuiGraphics.renderFakeItem(itemStack, (pMouseX - x) + upgradePos, pMouseY - y);
            upgradePos += 16;
        }
    }
    public static void renderComponentSlotTooltipAndItems(Font font, GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, int x, int y) {
        pGuiGraphics.renderTooltip(font, List.of(Component.translatable("tooltip.infinity_nexus_core.component")), Optional.empty(), pMouseX - x, pMouseY - y);
        int componentPos = 7;
        List <ItemStack> upgradeList = List.of(
                new ItemStack(ModItems.REDSTONE_COMPONENT.get(), 1),
                new ItemStack(ModItems.BASIC_COMPONENT.get(), 1),
                new ItemStack(ModItems.REINFORCED_COMPONENT.get(), 1),
                new ItemStack(ModItems.LOGIC_COMPONENT.get(), 1),
                new ItemStack(ModItems.ADVANCED_COMPONENT.get(), 1),
                new ItemStack(ModItems.REFINED_COMPONENT.get(), 1),
                new ItemStack(ModItems.INTEGRAL_COMPONENT.get(), 1),
                new ItemStack(ModItems.INFINITY_COMPONENT.get(), 1),
                new ItemStack(ModItems.ANCESTRAL_COMPONENT.get(), 1));
        for (ItemStack itemStack : upgradeList) {
            pGuiGraphics.renderFakeItem(itemStack, (pMouseX - x) + componentPos, pMouseY - y);
            componentPos += 16;
        }
    }
    public static void renderLinkToolSlotTooltipAndItem(Font font, GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, int x, int y) {
        pGuiGraphics.renderTooltip(font, List.of(Component.translatable("tooltip.infinity_nexus_core.linking")), Optional.empty(), pMouseX - x, pMouseY - y);
        int upgradePos = 7;
        List <ItemStack> upgradeList = List.of(new ItemStack(ModItems.SPEED_UPGRADE.get(), 1), new ItemStack(ModItems.STRENGTH_UPGRADE.get(), 1));
        for (ItemStack itemStack : upgradeList) {
            pGuiGraphics.renderFakeItem(itemStack, (pMouseX - x) + upgradePos, pMouseY - y);
            upgradePos += 16;
        }
    }
    public static void renderTooltipArea(Font font, GuiGraphics pGuiGraphics,List<Component> componentsTooltip, int pMouseX, int pMouseY, int x, int y) {
        pGuiGraphics.renderTooltip(font, componentsTooltip, Optional.empty(), pMouseX - x, pMouseY - y);
    }
}
