
package org.emrila.item.alchemy;


import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import org.emrila.PeacefulAura;
import org.emrila.item.ModItems;

public final class ModPotionBrewing {
    public static void init() {
        PeacefulAura.Log("💜 Registering potion recipes for {}", PeacefulAura.MOD_ID);

        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.WATER, Ingredient.of(ModItems.BAKED_POISONOUS_POTATO), ModPotions.PEACEFUL_POTION);

            builder.registerPotionRecipe(
                    ModPotions.PEACEFUL_POTION, Ingredient.of(Items.REDSTONE), ModPotions.PEACEFUL_LONG_POTION);
        });
    }
}
