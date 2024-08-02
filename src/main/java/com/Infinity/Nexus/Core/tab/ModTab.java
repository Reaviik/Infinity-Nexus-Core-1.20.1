package com.Infinity.Nexus.Core.tab;

import com.Infinity.Nexus.Core.InfinityNexusCore;
import com.Infinity.Nexus.Core.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InfinityNexusCore.MOD_ID);
                                                                                                            //Tab Name
    public static final RegistryObject<CreativeModeTab> NEXUS_TAB_UPGRADES = CREATIVE_MODE_TABS.register("infinity_nexus_core",
                                                                    //Tab Icon
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.REDSTONE_COMPONENT.get()))
                    //Tab Title
                    .title(Component.translatable("itemGroup.infinity_nexus_core"))
                    .displayItems((pParameters, pOutput) -> {
                        //-------------------------//-------------------------//
                        pOutput.accept(new ItemStack(ModItems.REDSTONE_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.BASIC_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.REINFORCED_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.LOGIC_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.ADVANCED_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.REFINED_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.INTEGRAL_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.INFINITY_COMPONENT.get()));
                        pOutput.accept(new ItemStack(ModItems.ANCESTRAL_COMPONENT.get()));

                        pOutput.accept(new ItemStack(ModItems.SPEED_UPGRADE.get()));
                        pOutput.accept(new ItemStack(ModItems.STRENGTH_UPGRADE.get()));
                        pOutput.accept(new ItemStack(ModItems.MUFFLER_UPGRADE.get()));

                        pOutput.accept(new ItemStack(ModItems.LINKING_TOOL.get()));
                        //-------------------------//-------------------------//
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
