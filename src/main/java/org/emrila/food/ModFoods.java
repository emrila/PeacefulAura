package org.emrila.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.emrila.effect.ModEffects;


public final class ModFoods {
    public static final FoodProperties GRILLED_POISONOUS_POTATO = new FoodProperties.Builder()
            .nutrition(0)
            .saturationModifier(0.0f)
            .alwaysEdible()
            .build();

    public static final Consumable GRILLED_POISONOUS_POTATO_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.0f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(ModEffects.PEACEFUL_EFFECT, 1200),1.0f))
            .build();
}
