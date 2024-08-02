package com.Infinity.Nexus.Core.block.entity;

import com.Infinity.Nexus.Core.InfinityNexusCore;
import com.Infinity.Nexus.Core.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityNexusCore.MOD_ID);

    public static final RegistryObject<Block> FAKE_STONE = registerBlock("fake_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.0f, 6.0f).noLootTable().sound(SoundType.STONE).mapColor(MapColor.STONE)));
    public static final RegistryObject<Block> FAKE_GRASS_BLOCK = registerBlock("fake_grass_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).strength(2.0f, 6.0f).noLootTable().sound(SoundType.ROOTED_DIRT).mapColor(MapColor.GRASS)));
    public static final RegistryObject<Block> FAKE_DIRT = registerBlock("fake_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(2.0f, 6.0f).noLootTable().sound(SoundType.ROOTED_DIRT).mapColor(MapColor.DIRT)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
