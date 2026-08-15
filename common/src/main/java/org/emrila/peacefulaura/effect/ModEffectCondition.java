package org.emrila.peacefulaura.effect;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public interface ModEffectCondition {
    default boolean isModEffect(final MobEffectInstance effect){
        return false;
    }
    default boolean hasModEffect(final LivingEntity entity){
        return false;
    }
    default boolean hasEitherModEffect(final LivingEntity initiator, final LivingEntity target){
        return false;
    }
}
