package org.emrila.peacefulaura.event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.item.ModItems;
import org.emrila.peacefulaura.item.alchemy.ModPotions;
import org.jspecify.annotations.NonNull;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(@NonNull BrewingRecipeRegisterEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.WATER, ModItems.BAKED_POISONOUS_POTATO.get(), ModPotions.PEACEFUL_POTION.getHolder().orElseThrow());
        builder.addMix(ModPotions.PEACEFUL_POTION.getHolder().orElseThrow(), Items.REDSTONE, ModPotions.PEACEFUL_LONG_POTION.getHolder().orElseThrow());
    }
}
