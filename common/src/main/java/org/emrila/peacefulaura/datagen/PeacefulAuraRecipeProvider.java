package org.emrila.peacefulaura.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.Holder;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public class PeacefulAuraRecipeProvider extends RecipeProvider {

    private static Item bakedPoisonousPotato;
    private static Holder<Potion> peacefulPotion;
    private static Holder<Potion> longPeacefulPotion;


    protected PeacefulAuraRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    public static void setRecipeItem(final Item bakedPoisonousPotato) {
        PeacefulAuraRecipeProvider.bakedPoisonousPotato = bakedPoisonousPotato;
    }

    public static void setPotions(final Holder<Potion> peacefulPotion, final Holder<Potion> longPeacefulPotion) {
        PeacefulAuraRecipeProvider.peacefulPotion = peacefulPotion;
        PeacefulAuraRecipeProvider.longPeacefulPotion = longPeacefulPotion;
    }

    @Override
    public void buildRecipes() {
        buildCookingRecipes(Items.POISONOUS_POTATO, bakedPoisonousPotato);
        buildBrewingRecipes(Potions.WATER, bakedPoisonousPotato, peacefulPotion);
        buildBrewingRecipes(peacefulPotion, Items.REDSTONE, longPeacefulPotion);
    }

    private void buildBrewingRecipes(Holder<Potion> inputPotion, Item reagentItem, Holder<Potion> outputPotion){
        BrewingRecipeBuilder.brewingMix(Items.POTION,inputPotion, reagentItem, outputPotion).save(this.output);
        BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, inputPotion, reagentItem, outputPotion).save(this.output);
        BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, inputPotion, reagentItem, outputPotion).save(this.output);
        BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, outputPotion, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(this.output);
        BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, outputPotion, Items.GUNPOWDER, Items.SPLASH_POTION).save(this.output);
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
