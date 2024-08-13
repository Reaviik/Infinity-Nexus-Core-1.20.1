package com.Infinity.Nexus.Core.fakePlayer;

/*
 * This file is part of Industrial Foregoing.
 *
 * Copyright 2021, Buuz135
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.FakePlayer;

import java.util.UUID;
import java.util.logging.Level;

public class IFFakePlayer extends FakePlayer {

    private static final UUID uuid = UUID.fromString("376b0492-4386-40ec-8907-2124f2d65823");
    private ItemStack heldItem = new ItemStack(Items.NETHERITE_SWORD);

    private static final GameProfile PROFILE;

    public IFFakePlayer(ServerLevel worldIn) {
        super(worldIn, PROFILE);
    }

    @Override
    public ItemStack getItemInHand(InteractionHand pHand) {
        return new ItemStack(heldItem.getItem());
    }

    @Override
    public void setItemInHand(InteractionHand pHand, ItemStack pStack) {
        heldItem = pStack;
    }

    public static UUID getUuid() {
        return uuid;
    }

    @Override
    public EntityType<?> getType() {
        return EntityType.PLAYER;
    }

    public boolean onPlaceItemIntoWorld(Level world, BlockPos pos, ItemStack stack, InteractionHand hand, Direction direction) {
        this.setItemInHand(hand, stack);
        return ForgeHooks.onPlaceItemIntoWorld(
                new UseOnContext(this, hand,
                        new BlockHitResult(Vec3.ZERO, direction, pos, false))) == InteractionResult.SUCCESS;
    }
    static {
        PROFILE = new GameProfile(uuid, "[IN]");
    }
}