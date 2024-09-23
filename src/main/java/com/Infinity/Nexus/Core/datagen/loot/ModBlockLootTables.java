package com.Infinity.Nexus.Core.datagen.loot;

import com.Infinity.Nexus.Core.block.entity.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Stream;

public class ModBlockLootTables extends BlockLootSubProvider {


    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FAKE_DIRT.get());
        this.dropSelf(ModBlocks.FAKE_GRASS_BLOCK.get());
        this.dropSelf(ModBlocks.FAKE_STONE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        Stream<Block> additions = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get);


        return additions::iterator;
    }
}
