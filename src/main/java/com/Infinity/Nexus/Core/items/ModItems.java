package com.Infinity.Nexus.Core.items;


import com.Infinity.Nexus.Core.InfinityNexusCore;
import com.Infinity.Nexus.Core.items.custom.ComponentItem;
import com.Infinity.Nexus.Core.items.custom.LinkingTool;
import com.Infinity.Nexus.Core.items.custom.UpgradeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InfinityNexusCore.MOD_ID);

    public static final RegistryObject<Item> SPEED_UPGRADE = ITEMS.register("speed_upgrade", () -> new UpgradeItem(new Item.Properties().stacksTo(4).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> STRENGTH_UPGRADE = ITEMS.register("strength_upgrade", () -> new UpgradeItem(new Item.Properties().stacksTo(4).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MUFFLER_UPGRADE = ITEMS.register("muffler_upgrade", () -> new UpgradeItem(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PUSHER_UPGRADE = ITEMS.register("pusher_upgrade", () -> new UpgradeItem(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> LINKING_TOOL = ITEMS.register("linking_tool", () -> new LinkingTool(new Item.Properties().stacksTo(1).durability(-1)));

    public static final RegistryObject<Item> REDSTONE_COMPONENT = ITEMS.register("redstone_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(1000).rarity(Rarity.COMMON), "§2Base Durability:§e 1000"));
    public static final RegistryObject<Item> BASIC_COMPONENT = ITEMS.register("basic_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(2000).rarity(Rarity.COMMON), "§2Base Durability:§e 2000"));
    public static final RegistryObject<Item> REINFORCED_COMPONENT = ITEMS.register("reinforced_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(4000).rarity(Rarity.UNCOMMON), "§2Base Durability:§e 4000"));
    public static final RegistryObject<Item> LOGIC_COMPONENT = ITEMS.register("logic_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(8000).rarity(Rarity.UNCOMMON), "§2Base Durability:§e 8000"));
    public static final RegistryObject<Item> ADVANCED_COMPONENT = ITEMS.register("advanced_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(16000).rarity(Rarity.RARE), "§2Base Durability:§e 16000"));
    public static final RegistryObject<Item> REFINED_COMPONENT = ITEMS.register("refined_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(32000).rarity(Rarity.RARE), "§2Base Durability:§e 32000"));
    public static final RegistryObject<Item> INTEGRAL_COMPONENT = ITEMS.register("integral_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(64000).rarity(Rarity.EPIC), "§2Base Durability:§e 64000"));
    public static final RegistryObject<Item> INFINITY_COMPONENT = ITEMS.register("infinity_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(-1).rarity(Rarity.EPIC), "§2Base Durability:§e Infinity"));
    public static final RegistryObject<Item> ANCESTRAL_COMPONENT = ITEMS.register("ancestral_component", () -> new ComponentItem(new Item.Properties().stacksTo(1).durability(10).rarity(Rarity.EPIC), ""));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}