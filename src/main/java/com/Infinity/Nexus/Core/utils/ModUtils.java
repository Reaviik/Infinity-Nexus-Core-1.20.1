package com.Infinity.Nexus.Core.utils;

import com.Infinity.Nexus.Core.items.custom.ComponentItem;
import com.Infinity.Nexus.Core.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ModUtils {
    public static int getComponentLevel(ItemStack stack) {
        if (stack.getItem() == ModItems.REDSTONE_COMPONENT.get()) {
            return 1;
        }
        if (stack.getItem() == ModItems.BASIC_COMPONENT.get()) {
            return 2;
        }
        if (stack.getItem() == ModItems.REINFORCED_COMPONENT.get()) {
            return 3;
        }
        if (stack.getItem() == ModItems.LOGIC_COMPONENT.get()) {
            return 4;
        }
        if (stack.getItem() == ModItems.ADVANCED_COMPONENT.get()) {
            return 5;
        }
        if (stack.getItem() == ModItems.REFINED_COMPONENT.get()) {
            return 6;
        }
        if (stack.getItem() == ModItems.INTEGRAL_COMPONENT.get()) {
            return 7;
        }
        if (stack.getItem() == ModItems.INFINITY_COMPONENT.get()) {
            return 8;
        }
        if (stack.getItem() == ModItems.ANCESTRAL_COMPONENT.get()) {
            return 9;
        }
        return 0;
    }
    public static int getSpeed(ItemStackHandler itemHandler, int[] upgradeSlots) {
        int speed = 0;
        for (int i : upgradeSlots) {
            if (itemHandler.getStackInSlot(i).getItem() == ModItems.SPEED_UPGRADE.get()) {
                speed += itemHandler.getStackInSlot(i).getCount();
            }else if (itemHandler.getStackInSlot(i).getItem() == ModItems.PUSHER_UPGRADE.get()) {
                speed += 4;
            }
        }
        return speed;
    }
    public static int getStrength(ItemStackHandler itemHandler, int[] upgradeSlots) {
        int strength = 0;
        for (int i : upgradeSlots) {
            if (itemHandler.getStackInSlot(i).getItem() == ModItems.STRENGTH_UPGRADE.get()) {
                strength += itemHandler.getStackInSlot(i).getCount();
            }
        }
        return strength;
    }
    public static int getMuffler(ItemStackHandler itemHandler, int[] upgradeSlots) {
        int muffler = 0;
        for (int i : upgradeSlots) {
            if (itemHandler.getStackInSlot(i).getItem() == ModItems.MUFFLER_UPGRADE.get()) {
                muffler ++;
            }
        }
        return muffler;
    }
    public static boolean getPusher(ItemStackHandler itemHandler, int[] upgradeSlots) {
        for (int i : upgradeSlots) {
            if (itemHandler.getStackInSlot(i).getItem() == ModItems.PUSHER_UPGRADE.get()) {
                return true;
            }
        }
        return false;
    }
    public static boolean isUpgrade(ItemStack stack) {
        return stack.getItem() == ModItems.STRENGTH_UPGRADE.get()
                || stack.getItem() == ModItems.SPEED_UPGRADE.get()
                || stack.getItem() == ModItems.MUFFLER_UPGRADE.get()
                || stack.getItem() == ModItems.PUSHER_UPGRADE.get();

    }
    public static boolean canPlaceItemInContainer(ItemStack itemStack, int slotIndex, IItemHandler iItemHandler) {
        ItemStack slotStack = iItemHandler.getStackInSlot(slotIndex);

        if (!slotStack.isEmpty()) {
            if (!itemStack.is(slotStack.getItem())) {
                return false;
            }

            if (!ItemStack.isSameItemSameTags(itemStack, slotStack)) {
                return false;
            }

            int slotCapacity = iItemHandler.getSlotLimit(slotIndex);
            int stackCapacity = itemStack.getMaxStackSize();
            int slotCount = slotStack.getCount();
            int itemCount = itemStack.getCount();

            if (itemCount + slotCount > slotCapacity) {
                return false;
            }

            if (itemCount + slotCount > stackCapacity) {
                return false;
            }
        }

        return true;
    }
    public static boolean isComponent(ItemStack stack) {
        return stack.getItem() instanceof ComponentItem;
    }

    public static void useComponent(ItemStack component, Level level, BlockPos pos) {

        if (component.getItem() == ModItems.ANCESTRAL_COMPONENT.get()) {
            int uses = component.getOrCreateTag().contains("Uses") ? component.getOrCreateTag().getInt("Uses") : 1;
            if (uses <= 1 && !component.getOrCreateTag().getBoolean("isInfinite")) {
                component.shrink(1);
                level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1.0f, 1.0f);
            } else {
                if (component.getOrCreateTag().getBoolean("isInfinite")) {
                    component.getOrCreateTag().putInt("Uses", (uses - 1));
                } else {
                    component.getOrCreateTag().putInt("Uses", (uses - 1));
                    component.hurt(1, level.random, null);
                }
            }
        } else {
            if (component.getDamageValue() >= component.getMaxDamage() && component.getItem() != ModItems.INFINITY_COMPONENT.get()) {
                component.shrink(1);
                level.playSound(null, pos, SoundEvents.ITEM_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
            } else {
                component.hurt(1, level.random, null);
            }
        }
    }
    public static boolean canInsert(IItemHandler itemHandler, int slots, ItemStack stack) {
        return itemHandler.getStackInSlot(slots).isEmpty() && !isUpgrade(stack) && !isComponent(stack);
    }

    public static void ejectItemsWhePusher(BlockPos pos,int[] componentSlot, int[] outputSlot, ItemStackHandler inventory, Level level) {
        if(getPusher(inventory, componentSlot)){
            try {
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity != null) {
                    blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, Direction.DOWN).ifPresent(iItemHandler -> {
                        //Para cada slot de Saida
                        for (int i : outputSlot) {
                            ItemStack outputStack = inventory.getStackInSlot(i);
                            if (!outputStack.isEmpty()) {
                                //Para cada slot de entrada
                                for (int j = 0; j < iItemHandler.getSlots(); j++) {
                                    //Se o slot de entrada estiver vazio ou puder inserir o item
                                    if (iItemHandler.getStackInSlot(j).isEmpty() || (iItemHandler.getStackInSlot(j).getItem() == outputStack.getItem())) {
                                        if((iItemHandler.getStackInSlot(j).getCount() + outputStack.getCount()) < iItemHandler.getSlotLimit(j)) {
                                            iItemHandler.insertItem(j, outputStack, false);
                                            inventory.extractItem(i, outputStack.getCount(), false);
                                            break;
                                        }else if((iItemHandler.getStackInSlot(j).getCount() + 1) <= iItemHandler.getSlotLimit(j)){
                                            iItemHandler.insertItem(j, new ItemStack(outputStack.getItem(), 1), false);
                                            inventory.extractItem(i, 1, false);
                                            ejectItemsWhePusher(pos, componentSlot, outputSlot, inventory, level);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            } catch (Exception ignored) {
            }
        }
    }
}
