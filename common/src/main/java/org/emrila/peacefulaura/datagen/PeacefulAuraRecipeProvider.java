package org.emrila.peacefulaura.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.BrewingRecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.emrila.peacefulaura.ModUtil;

public class PeacefulAuraRecipeProvider extends RecipeProvider {

    protected PeacefulAuraRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    public static PeacefulAuraRecipeProvider create(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput){
        return new PeacefulAuraRecipeProvider(recipeOutput, advancementOutput);
    }

    public static void buildRecipes(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput){
        PeacefulAuraRecipeProvider provider = new PeacefulAuraRecipeProvider(recipeOutput, advancementOutput);
        provider.buildRecipes();
    }

    @Override
    public void buildRecipes() {
        buildCookingRecipes();
        buildBrewingRecipes();
    }

    private void buildCookingRecipes() {
        Item ingredientItem = Items.POISONOUS_POTATO;
        Item resultItem = ModUtil.getItem(ModUtil.BAKED_POISONOUS_POTATO_ID);

        float defaultExperience = 0.35f;
        Ingredient ingredient = Ingredient.of(ingredientItem);
        String hasName = RecipeProvider.getHasName(ingredientItem);
        Criterion<InventoryChangeTrigger.TriggerInstance> trigger = this.has(ingredientItem);

        SimpleCookingRecipeBuilder.campfireCooking(ingredient, RecipeCategory.FOOD, resultItem, defaultExperience, 600)
                .unlockedBy(hasName, trigger)
                .save(this.output, modRecipeKey(RecipeProvider.getConversionRecipeName(resultItem, Items.CAMPFIRE)));

        SimpleCookingRecipeBuilder.smelting(ingredient, RecipeCategory.FOOD, CookingBookCategory.FOOD, resultItem, defaultExperience, 200)
                .unlockedBy(hasName, trigger)
                .save(this.output);

        SimpleCookingRecipeBuilder.smoking(ingredient, RecipeCategory.FOOD, resultItem, defaultExperience, 100)
                .unlockedBy(hasName, trigger)
                .save(this.output, modRecipeKey(RecipeProvider.getConversionRecipeName(resultItem, Items.SMOKER)));
    }

    private void buildBrewingRecipes(){
        Holder<Potion> peacefulPotion = ModUtil.getHolderForPotion(ModUtil.POTION_ID);
        Holder<Potion> longPeacefulPotion = ModUtil.getHolderForPotion(ModUtil.POTION_LONG_ID);
        Item bakedPoisonousPotato = ModUtil.getItem(ModUtil.BAKED_POISONOUS_POTATO_ID);

        buildBrewingRecipes(Potions.WATER, bakedPoisonousPotato, peacefulPotion);
        buildBrewingRecipes(peacefulPotion, Items.REDSTONE, longPeacefulPotion);
    }

    private void buildBrewingRecipes(Holder<Potion> inputPotion, Item reagentItem, Holder<Potion> outputPotion) {
        saveBrewingRecipe(BrewingRecipeBuilder.brewingMix(Items.POTION, inputPotion, reagentItem, outputPotion));
        saveBrewingRecipe(BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, inputPotion, reagentItem, outputPotion));
        saveBrewingRecipe(BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, inputPotion, reagentItem, outputPotion));
        saveBrewingRecipe(BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, outputPotion, Items.GUNPOWDER, Items.SPLASH_POTION));
        saveBrewingRecipe(BrewingRecipeBuilder.brewingContainerTransform(Items.SPLASH_POTION, outputPotion, Items.DRAGON_BREATH, Items.LINGERING_POTION));
    }

    private void saveBrewingRecipe(BrewingRecipeBuilder builder) {
        String path = builder.defaultId().identifier().getPath();
        builder.save(this.output, modRecipeKey(path));
    }

    private static ResourceKey<Recipe<?>> modRecipeKey(String path) {
        return ResourceKey.create(Registries.RECIPE, ModUtil.id(path));
    }

}
