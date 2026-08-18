package org.emrila.peacefulaura;


import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.jspecify.annotations.NonNull;

public class ModUtil {

    public static @NonNull FoodProperties buildFoodProperty(){
        return new FoodProperties.Builder()
                .nutrition(0)
                .saturationModifier(0.0f)
                .alwaysEdible()
                .build();
    }

    public static @NonNull Consumable buildConsumable(Holder<MobEffect> effectHolder){
        return Consumables.defaultFood()
                .consumeSeconds(1.0f)
                .onConsume(new ApplyStatusEffectsConsumeEffect(
                        new MobEffectInstance(effectHolder, 1200),1.0f))
                .build();
    }

    public static Potion constructPotion(Holder<MobEffect> effectHolder, boolean isLong){
        final int duration = isLong ? 9600 : 3600;
        return new Potion("peaceful_aura", new MobEffectInstance(effectHolder, duration));
    }

}
