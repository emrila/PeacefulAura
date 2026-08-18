package org.emrila.peacefulaura.mixin.entity;

import net.minecraft.world.entity.LivingEntity;
import org.emrila.peacefulaura.PeacefulAuraUtil;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin {

    @Inject(method = "canAttack", at = @At("RETURN"), cancellable = true)
    void peacefulAura$canAttack(LivingEntity target, @NonNull CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity)(Object)this;
        if (cir.getReturnValue() && PeacefulAuraUtil.preventTargeting(self, target)){
                cir.setReturnValue(false);
            }
    }

    @Inject(method = "canBeSeenAsEnemy", at = @At("RETURN"), cancellable = true)
    void peacefulAura$canBeSeenAsEnemy(@NonNull CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity)(Object)this;
        if (cir.getReturnValue() && PeacefulAuraUtil.hasAura(self)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "attackable", at = @At("RETURN"), cancellable = true)
    void peacefulAura$attackable(@NonNull CallbackInfoReturnable<Boolean> cir){
        LivingEntity self = (LivingEntity)(Object)this;
        if (cir.getReturnValue() && PeacefulAuraUtil.hasAura(self)) {
            cir.setReturnValue(false);
        }
    }
}
