package com.Infinity.Nexus.Core.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REDSTONE_COMPONENT.get())
        //        .pattern("AAA")
        //        .pattern("BCB")
        //        .pattern("EDE")
        //        .define('A', ModCrystalItems.DARIUM_CRYSTAL.get())
        //        .define('B', ModItemsProgression.SOLAR_CORE.get())
        //        .define('C', ModItemsAdditions.REFINED_COMPONENT.get())
        //        .define('D', ModItemsAdditions.INFINIUM_STELLARUM_INGOT.get())
        //        .define('E', ModItemsProgression.STABLE_MATTER.get())
        //        .unlockedBy("has_redstone", inventoryTrigger(ItemPredicate.Builder.item().of(Items.REDSTONE).build()))
        //        .save(pWriter, "basic_component");
    }

}