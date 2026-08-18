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
import org.jspecify.annotations.NonNull;

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

    @SuppressWarnings("SameParameterValue")
    private void buildCookingRecipes(final Item ingredientItem, final Item cookedItem) {
        final float defaultExperience = 0.35f;
        final Ingredient ingredient = Ingredient.of(ingredientItem);
        final String criterionName = "has_" + itemId(ingredientItem);
        final Criterion<InventoryChangeTrigger.TriggerInstance> trigger = this.has(ingredientItem);
        final String cookedItemId = itemId(cookedItem);

        SimpleCookingRecipeBuilder
                .campfireCooking(ingredient, RecipeCategory.FOOD, cookedItem, defaultExperience, 600)
                .unlockedBy(criterionName, trigger)
                .save(this.output, cookedItemId+"_from_campfire");

        SimpleCookingRecipeBuilder
                .smelting(ingredient, RecipeCategory.FOOD, CookingBookCategory.FOOD, cookedItem, defaultExperience, 200)
                .unlockedBy(criterionName, trigger)
                .save(this.output);

        SimpleCookingRecipeBuilder
                .smoking(ingredient, RecipeCategory.FOOD, cookedItem, defaultExperience, 100)
                .unlockedBy(criterionName, trigger)
                .save(this.output, cookedItemId+"_from_smoking");
    }

    private void buildBrewingRecipes(Holder<Potion> inputPotion, Item reagentItem, Holder<Potion> outputPotion){
        BrewingRecipeBuilder.brewingMix(Items.POTION,inputPotion, reagentItem, outputPotion).save(this.output);
        BrewingRecipeBuilder.brewingMix(Items.SPLASH_POTION, inputPotion, reagentItem, outputPotion).save(this.output);
        BrewingRecipeBuilder.brewingMix(Items.LINGERING_POTION, inputPotion, reagentItem, outputPotion).save(this.output);
        BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, outputPotion, Items.DRAGON_BREATH, Items.LINGERING_POTION).save(this.output);
        BrewingRecipeBuilder.brewingContainerTransform(Items.POTION, outputPotion, Items.GUNPOWDER, Items.SPLASH_POTION).save(this.output);
    }

    private @NonNull String itemId(@NonNull Item item){
        var descriptionID = item.getDescriptionId().split("\\.");
        return descriptionID[descriptionID.length-1];
    }

}
