package com.Infinity.Nexus.Core.inventory;

import com.Infinity.Nexus.Core.utils.ModUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

import java.util.concurrent.atomic.AtomicBoolean;

public class LinkedInventory {
    public static boolean insertItem(String name, Level level, ItemStack stack, IItemHandler itemHandler, int[] OUTPUT_SLOT){
        AtomicBoolean success = new AtomicBoolean(false);
        String[] parts = name.substring(1, name.length() - 1).split(",");
        int xl = 0;
        int yl = 0;
        int zl = 0;
        String facel = "up";

        for (String part : parts) {
            String[] keyValue = part.split("=");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "x" -> xl = Integer.parseInt(value);
                case "y" -> yl = Integer.parseInt(value);
                case "z" -> zl = Integer.parseInt(value);
                case "face" -> facel = value;
            }
        }
        BlockEntity blockEntity = level.getBlockEntity(new BlockPos(xl, yl, zl));
        if (blockEntity != null && canLink(blockEntity)) {
            //Se o bloco na coordenada tiver um inventario então ->
            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, getLinkedSide(facel)).ifPresent(linkedInventory -> {
                //Para cada slot no inventario do bloco
                for (int slot = 0; slot < linkedInventory.getSlots(); slot++) {
                    if (ModUtils.canPlaceItemInContainer(stack.copy(), slot, linkedInventory) && linkedInventory.isItemValid(slot, stack.copy())) {
                        linkedInventory.insertItem(slot, stack.copy(), false);
                        success.set(true);
                        break;
                    }
                }
                //Para cada slot no inventario da máquina.
                for (int slot = 0; slot < linkedInventory.getSlots(); slot++) {
                    for (int outputSlot : OUTPUT_SLOT) {
                        ItemStack outputItem = itemHandler.getStackInSlot(outputSlot).copy();
                        if (!outputItem.isEmpty() && linkedInventory.isItemValid(slot, stack.copy()) && ModUtils.canPlaceItemInContainer(outputItem, slot, linkedInventory)) {
                            linkedInventory.insertItem(slot, outputItem, false);
                            itemHandler.extractItem(outputSlot, outputItem.getCount(), false);
                            success.set(true);
                            break;
                        }
                    }
                }
            });
        }
        return success.get();
    }
    private static boolean canLink(BlockEntity blockEntity) {
        return (int) Math.sqrt(blockEntity.getBlockPos().distSqr(blockEntity.getBlockPos())) < 100;
    }
    private static Direction getLinkedSide(String side) {
        return switch (side) {
            case "down" -> Direction.DOWN;
            case "north" -> Direction.NORTH;
            case "south" -> Direction.SOUTH;
            case "west" -> Direction.WEST;
            case "east" -> Direction.EAST;
            default -> Direction.UP;
        };
    }
}
