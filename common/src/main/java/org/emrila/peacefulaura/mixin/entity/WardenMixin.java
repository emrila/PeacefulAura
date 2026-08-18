package org.emrila.peacefulaura.mixin.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.Level;
import org.emrila.peacefulaura.PeacefulAuraUtil;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Warden.class)
abstract class WardenMixin extends LivingEntity {
    protected WardenMixin(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    @Inject(method = "canTargetEntity", at = @At("RETURN"), cancellable = true)
    void peacefulAura$canTargetEntity(Entity entity, @NonNull CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue() && entity instanceof LivingEntity livingEntity && PeacefulAuraUtil.preventTargeting(this, livingEntity)) {
            cir.setReturnValue(false);
        }
    }
}
