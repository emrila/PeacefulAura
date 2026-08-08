/**
 *
 */
package org.emrila.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import org.emrila.item.ModItems;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.POISONOUS_POTATO), RecipeCategory.FOOD, ModItems.BAKED_POISONOUS_POTATO, 0.35f, 600)
                        .unlockedBy("has_poisonous_potato", this.has(Items.POISONOUS_POTATO))
                        .save(this.output, "baked_poisonous_potato_from_campfire");

                SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.POISONOUS_POTATO), RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.BAKED_POISONOUS_POTATO, 0.35f, 200)
                        .unlockedBy("has_poisonous_potato", this.has(Items.POISONOUS_POTATO))
                        .save(this.output);

                SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.POISONOUS_POTATO), RecipeCategory.FOOD, ModItems.BAKED_POISONOUS_POTATO, 0.35f, 100)
                        .unlockedBy("has_poisonous_potato", this.has(Items.POISONOUS_POTATO))
                        .save(this.output, "baked_poisonous_potato_from_smoking");
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "Peaceful Aura Recipes";
    }
}
