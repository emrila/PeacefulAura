package org.emrila.peacefulaura.mixin.entity.boss;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;
import org.emrila.peacefulaura.PeacefulAuraUtil;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(WitherBoss.class)
abstract class WitherBossMixin extends LivingEntity {

    WitherBossMixin(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    @Inject(method = "performRangedAttack(Lnet/minecraft/world/entity/LivingEntity;F)V", at = @At("HEAD"), cancellable = true)
    void peacefulAura$performRangedAttack(LivingEntity target, float power, CallbackInfo ci){
        if (PeacefulAuraUtil.hasAura(this)){
            ci.cancel();
        }
    }

    @Inject(method = "performRangedAttack(ILnet/minecraft/world/entity/LivingEntity;)V", at = @At("HEAD"), cancellable = true)
    void peacefulAura$performRangedAttack(int head, LivingEntity target, CallbackInfo ci){
        if (PeacefulAuraUtil.hasAura(this)) {
            ci.cancel();
        }
    }

    @Inject(method = "addEffect", at = @At("RETURN"), cancellable = true)
    void peacefulAura$addEffect(MobEffectInstance newEffect, Entity source, @NonNull CallbackInfoReturnable<Boolean> cir){
        if(!cir.getReturnValue() && PeacefulAuraUtil.isAura(newEffect)){
            boolean addedEffect = super.addEffect(newEffect, source);
            cir.setReturnValue(addedEffect);
        }
    }

    @Inject(method = "canBeAffected", at = @At("RETURN"), cancellable = true)
    void peacefulAura$canBeAffected(MobEffectInstance newEffect, @NonNull CallbackInfoReturnable<Boolean> cir){
        if(cir.getReturnValue() || PeacefulAuraUtil.isAura(newEffect)){
            cir.setReturnValue(true);
        }
    }
}
