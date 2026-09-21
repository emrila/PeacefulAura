
package org.emrila.peacefulaura;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public final class PeacefulAuraUtil {

    private static final Holder<MobEffect> PEACEFUL_AURA_EFFECT = ModUtil.getHolderForEffect();

    public static boolean hasAura(final LivingEntity entity) {
        return entity != null && entity.hasEffect(PEACEFUL_AURA_EFFECT);
    }

    public static boolean isAura(final MobEffectInstance effect) {
        return effect.is(PEACEFUL_AURA_EFFECT);
    }

    public static boolean preventTargeting(final LivingEntity initiator, final LivingEntity target){
       return hasAura(initiator) || hasAura(target);
    }
}
