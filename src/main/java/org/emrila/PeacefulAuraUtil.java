
package org.emrila;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.emrila.effect.ModEffects;

public final class PeacefulAuraUtil {

    public static boolean hasAura(final LivingEntity entity) {
        return entity != null && entity.hasEffect(ModEffects.PEACEFUL_EFFECT);
    }

    public static boolean isAura(final MobEffectInstance effect) {
        return effect.is(ModEffects.PEACEFUL_EFFECT);
    }

    public static boolean preventTargeting(final LivingEntity attacker, final LivingEntity target){
        return hasAura(attacker) || hasAura(target);
    }

}
