package org.emrila.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.emrila.item.ModItems;
import org.emrila.item.alchemy.ModPotions;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
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

                BrewingRecipeBuilder.brewingMix(Items.POTION, Potions.WATER, ModItems.BAKED_POISONOUS_POTATO, ModPotions.PEACEFUL_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, Potions.WATER, ModItems.BAKED_POISONOUS_POTATO, ModPotions.PEACEFUL_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, Potions.WATER, ModItems.BAKED_POISONOUS_POTATO, ModPotions.PEACEFUL_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, ModPotions.PEACEFUL_POTION, Items.GLOWSTONE_DUST, Items.LINGERING_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, ModPotions.PEACEFUL_POTION, Items.GUNPOWDER, Items.SPLASH_POTION)
                        .save(this.output);

                BrewingRecipeBuilder.brewingMix(Items.POTION, ModPotions.PEACEFUL_POTION, Items.REDSTONE, ModPotions.PEACEFUL_LONG_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, ModPotions.PEACEFUL_POTION, Items.REDSTONE, ModPotions.PEACEFUL_LONG_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, ModPotions.PEACEFUL_POTION, Items.REDSTONE, ModPotions.PEACEFUL_LONG_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, ModPotions.PEACEFUL_LONG_POTION, Items.GLOWSTONE_DUST, Items.LINGERING_POTION)
                        .save(this.output);
                BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, ModPotions.PEACEFUL_LONG_POTION, Items.GUNPOWDER, Items.SPLASH_POTION)
                        .save(this.output);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "Peaceful Aura Recipes";
    }
}
