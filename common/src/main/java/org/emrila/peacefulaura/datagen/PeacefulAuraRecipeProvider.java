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
import org.jspecify.annotations.NonNull;

public class PeacefulAuraRecipeProvider extends RecipeProvider {

    private static CookingRecipe COOKING_RECIPE;

    protected PeacefulAuraRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static void setRecipeItem(Item bakedPoisonousPotato) {
        COOKING_RECIPE = new CookingRecipe(Items.POISONOUS_POTATO, bakedPoisonousPotato);
    }

    @Override
    public void buildRecipes() {
        COOKING_RECIPE.saveRecipe(this.has(COOKING_RECIPE.ingredientItem), this.output);
    }

    public record CookingRecipe(Item ingredientItem, Item cookedItem, float experience){
        CookingRecipe(Item ingredientItem, Item cookedItem){
            this(ingredientItem, cookedItem, 0.35f);
        }

        @NonNull String itemId(@NonNull Item item){
            var descriptionID = item.getDescriptionId().split("\\.");
            return descriptionID[descriptionID.length-1];
        }

        @NonNull String formatOutputId(String cookingSource){
            return "%s_from_%s".formatted(itemId(cookedItem), cookingSource);
        }

        void saveRecipe(Criterion<InventoryChangeTrigger.TriggerInstance> trigger, RecipeOutput output){
            final Ingredient ingredient = Ingredient.of(ingredientItem);
            final String criterionName = "has_" + itemId(ingredientItem);

            SimpleCookingRecipeBuilder
                    .campfireCooking(ingredient, RecipeCategory.FOOD, cookedItem, experience, 600)
                    .unlockedBy(criterionName, trigger)
                    .save(output, formatOutputId("campfire"));

            SimpleCookingRecipeBuilder
                    .smelting(ingredient, RecipeCategory.FOOD, CookingBookCategory.FOOD, cookedItem, experience, 200)
                    .unlockedBy(criterionName, trigger)
                    .save(output);

            SimpleCookingRecipeBuilder
                    .smoking(ingredient, RecipeCategory.FOOD, cookedItem, experience, 100)
                    .unlockedBy(criterionName, trigger)
                    .save(output, formatOutputId("smoking"));
        }

    }

}
