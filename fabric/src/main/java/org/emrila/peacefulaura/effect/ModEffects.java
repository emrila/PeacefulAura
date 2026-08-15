package org.emrila.peacefulaura.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import org.emrila.peacefulaura.PeacefulAuraUtil;
import org.emrila.peacefulaura.PeacefulAura;

public final class ModEffects {
    public static final Holder<MobEffect> PEACEFUL_EFFECT = Registry.registerForHolder(
            BuiltInRegistries.MOB_EFFECT,
            PeacefulAura.id("peaceful_aura"),
            new PeacefulAuraEffect());

    public static void init(String modId) {
        PeacefulAura.Log("💜 Registering effects for {}", modId);
        PeacefulAuraUtil.setModEffect(PEACEFUL_EFFECT);
    }
}
