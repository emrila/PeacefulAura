package org.emrila.peacefulaura.event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.item.ModItems;
import org.emrila.peacefulaura.item.alchemy.ModPotions;

@EventBusSubscriber(modid = ModConstants.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.WATER, ModItems.BAKED_POISONOUS_POTATO.asItem(), ModPotions.PEACEFUL_POTION);
        builder.addMix(ModPotions.PEACEFUL_POTION, Items.REDSTONE, ModPotions.PEACEFUL_LONG_POTION);
    }
}
