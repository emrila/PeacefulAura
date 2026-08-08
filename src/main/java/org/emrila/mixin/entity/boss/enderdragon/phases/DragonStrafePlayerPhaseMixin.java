package org.emrila.mixin.entity.boss.enderdragon.phases;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.enderdragon.phases.AbstractDragonPhaseInstance;
import net.minecraft.world.entity.boss.enderdragon.phases.DragonStrafePlayerPhase;
import org.emrila.PeacefulAuraUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DragonStrafePlayerPhase.class)
abstract class DragonStrafePlayerPhaseMixin extends AbstractDragonPhaseInstance {

    public DragonStrafePlayerPhaseMixin(EnderDragon dragon) {
        super(dragon);
    }

    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    void peacefulAura$setTarget(LivingEntity target, CallbackInfo ci) {
        if(PeacefulAuraUtil.preventTargeting(this.dragon, target)) {
            ci.cancel();
        }
    }
}
