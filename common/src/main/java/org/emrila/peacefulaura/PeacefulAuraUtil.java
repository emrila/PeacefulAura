
package org.emrila.peacefulaura;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.emrila.peacefulaura.effect.ModEffectCondition;

public final class PeacefulAuraUtil {

    private static ModEffectCondition modEffectCondition = new ModEffectCondition(){};

    public static void setModEffect(final Holder<MobEffect> effectHolder) {
        PeacefulAuraUtil.modEffectCondition = new ModEffectCondition(){
            @Override
            public boolean isModEffect(MobEffectInstance effect) {
                return effect.is(effectHolder);
            }

            @Override
            public boolean hasModEffect(LivingEntity entity) {
                return entity != null && entity.hasEffect(effectHolder);
            }

            @Override
            public boolean hasEitherModEffect(LivingEntity initiator, LivingEntity target) {
                return hasModEffect(initiator) || hasModEffect(target);
            }
        };
    }

    public static boolean hasAura(final LivingEntity entity) {
        return modEffectCondition.hasModEffect(entity);
    }

    public static boolean isAura(final MobEffectInstance effect) {
        return modEffectCondition.isModEffect(effect);
    }

    public static boolean preventTargeting(final LivingEntity attacker, final LivingEntity target){
        return modEffectCondition.hasEitherModEffect(attacker, target);
    }


}
