package com.Infinity.Nexus.Core.datagen;


import com.Infinity.Nexus.Core.InfinityNexusCore;
import com.Infinity.Nexus.Core.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, InfinityNexusCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.REDSTONE_COMPONENT);
        simpleItem(ModItems.BASIC_COMPONENT);
        simpleItem(ModItems.REINFORCED_COMPONENT);
        simpleItem(ModItems.LOGIC_COMPONENT);
        simpleItem(ModItems.ADVANCED_COMPONENT);
        simpleItem(ModItems.REFINED_COMPONENT);
        simpleItem(ModItems.INTEGRAL_COMPONENT);
        simpleItem(ModItems.INFINITY_COMPONENT);
        simpleItem(ModItems.ANCESTRAL_COMPONENT);

        simpleItem(ModItems.LINKING_TOOL);

        simpleItem(ModItems.SPEED_UPGRADE);
        simpleItem(ModItems.STRENGTH_UPGRADE);
        simpleItem(ModItems.MUFFLER_UPGRADE);
        simpleItem(ModItems.PUSHER_UPGRADE);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(InfinityNexusCore.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleTools(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(InfinityNexusCore.MOD_ID, "item/" + item.getId().getPath()));
    }
}
