package org.emrila.peacefulaura.datagen;

import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;

public class PeacefulAuraRecipeProvider extends RecipeProvider {

    private static Item bakedPoisonousPotato;

    protected PeacefulAuraRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static void setRecipeItem(final Item bakedPoisonousPotato) {
        PeacefulAuraRecipeProvider.bakedPoisonousPotato = bakedPoisonousPotato;
    }

    @Override
    public void buildRecipes() {
        buildCookingRecipes(Items.POISONOUS_POTATO, bakedPoisonousPotato);
    }

    @SuppressWarnings("SameParameterValue")
    private void buildCookingRecipes(final Item ingredientItem, final Item resultItem) {
        final float defaultExperience = 0.35f;
        final Ingredient ingredient = Ingredient.of(ingredientItem);
        final String hasName = RecipeProvider.getHasName(ingredientItem);
        final Criterion<InventoryChangeTrigger.TriggerInstance> trigger = this.has(ingredientItem);

        SimpleCookingRecipeBuilder
                .campfireCooking(ingredient, RecipeCategory.FOOD, resultItem, defaultExperience, 600)
                .unlockedBy(hasName, trigger)
                .save(this.output, RecipeProvider.getConversionRecipeName(resultItem, Items.CAMPFIRE));

        SimpleCookingRecipeBuilder
                .smelting(ingredient, RecipeCategory.FOOD, CookingBookCategory.FOOD, resultItem, defaultExperience, 200)
                .unlockedBy(hasName, trigger)
                .save(this.output);

        SimpleCookingRecipeBuilder
                .smoking(ingredient, RecipeCategory.FOOD, resultItem, defaultExperience, 100)
                .unlockedBy(hasName, trigger)
                .save(this.output, RecipeProvider.getConversionRecipeName(resultItem, Items.SMOKER));
    }
}
