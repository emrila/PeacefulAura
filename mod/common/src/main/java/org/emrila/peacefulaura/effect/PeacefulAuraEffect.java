
package org.emrila.peacefulaura.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class PeacefulAuraEffect extends MobEffect {

    public PeacefulAuraEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x208320);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return true;
    }
}
