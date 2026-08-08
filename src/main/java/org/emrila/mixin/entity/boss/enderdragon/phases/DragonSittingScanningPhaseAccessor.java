package org.emrila.mixin.entity.boss.enderdragon.phases;

import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.boss.enderdragon.phases.DragonSittingScanningPhase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DragonSittingScanningPhase.class)
public interface DragonSittingScanningPhaseAccessor {

    @Accessor("CHARGE_TARGETING")
    @Mutable
    static void setChargeTargeting(TargetingConditions chargeTargeting){
        throw new AssertionError("Untransformed @Accessor");
    }

    @Accessor("scanTargeting")
    @Mutable
    void peacefulAura$SetScanTargeting(TargetingConditions scanTargeting);

}
