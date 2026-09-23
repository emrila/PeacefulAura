package org.emrila.peacefulaura.mixin.entity.boss.enderdragon.phases;

import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.enderdragon.phases.AbstractDragonPhaseInstance;
import net.minecraft.world.entity.boss.enderdragon.phases.DragonSittingScanningPhase;
import org.emrila.peacefulaura.PeacefulAuraUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DragonSittingScanningPhase.class)
abstract class DragonSittingScanningPhaseMixin extends AbstractDragonPhaseInstance {

    @Shadow
    @Final
    private static int SITTING_ATTACK_VIEW_RANGE;

    @Shadow
    @Final
    private static int SITTING_CHARGE_VIEW_RANGE;

    @Shadow
    @Final
    private static int SITTING_ATTACK_Y_VIEW_RANGE;

    public DragonSittingScanningPhaseMixin(EnderDragon dragon) {
        super(dragon);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    void peacefulAura$DragonSittingScanningPhase(EnderDragon dragon, CallbackInfo ci) {
        DragonSittingScanningPhaseAccessor.setChargeTargeting(TargetingConditions.forCombat()
                .range(SITTING_CHARGE_VIEW_RANGE)
                .selector((target, level) -> !PeacefulAuraUtil.preventTargeting(this.dragon, target)));

        ((DragonSittingScanningPhaseAccessor) this).peacefulAura$SetScanTargeting(
                TargetingConditions.forCombat()
                        .range(SITTING_ATTACK_VIEW_RANGE)
                        .selector((target, level) -> {
                            if(PeacefulAuraUtil.preventTargeting(this.dragon, target)) {
                                return false;
                            }
                            return Math.abs(target.getY() - this.dragon.getY()) <= SITTING_ATTACK_Y_VIEW_RANGE;
                        }));

    }

}
