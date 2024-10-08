package com.Infinity.Nexus.Core.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Rect2i;

public abstract class InfoArea extends GuiGraphics {
    protected final Rect2i area;
    protected InfoArea(Minecraft minecraft, MultiBufferSource.BufferSource bufferSource, Rect2i area) {
        super(minecraft, bufferSource);
        this.area = area;
    }

    public static void draw(GuiGraphics transform) {
    }
}