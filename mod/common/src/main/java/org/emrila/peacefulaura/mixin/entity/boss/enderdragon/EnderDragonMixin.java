package org.emrila.peacefulaura.mixin.entity.boss.enderdragon;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.Level;
import org.emrila.peacefulaura.PeacefulAuraUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.function.Predicate;

@Mixin(EnderDragon.class)
abstract class EnderDragonMixin extends LivingEntity {

    protected EnderDragonMixin(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    @Unique
    private final Predicate<Entity> PREVENT_TARGET = entity -> {
        if(entity instanceof LivingEntity livingEntity){
            return PeacefulAuraUtil.preventTargeting(this, livingEntity);
        }
        return false;
    };

    @Inject(method = "hurt(Lnet/minecraft/server/level/ServerLevel;Ljava/util/List;)V", at = @At("HEAD"), cancellable = true)
    void peacefulAura$hurt(final ServerLevel level, final List<Entity> entities, CallbackInfo ci) {
        if(PeacefulAuraUtil.hasAura(this)) {
            entities.clear();
            ci.cancel();
        }
        entities.removeIf(PREVENT_TARGET);
    }

    @Inject(method = "knockBack", at = @At("HEAD"), cancellable = true)
    void peacefulAura$knockBack(ServerLevel serverLevel, List<Entity> entities, CallbackInfo ci) {
        if(PeacefulAuraUtil.hasAura(this)) {
            entities.clear();
            ci.cancel();
        }
        entities.removeIf(PREVENT_TARGET);
    }

    @Inject(method = "addEffect", at = @At("RETURN"), cancellable = true)
    void peacefulAura$addEffect(MobEffectInstance newEffect, Entity source, CallbackInfoReturnable<Boolean> cir) {
        if(PeacefulAuraUtil.isAura(newEffect)) {
            boolean addedEffect = super.addEffect(newEffect, source);
            cir.setReturnValue(addedEffect);
        }
    }
}
