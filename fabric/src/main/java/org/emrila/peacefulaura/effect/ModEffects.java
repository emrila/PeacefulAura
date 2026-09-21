package org.emrila.peacefulaura.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import org.emrila.peacefulaura.ModUtil;

public final class ModEffects {
    public static final Holder<MobEffect> PEACEFUL_EFFECT =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, ModUtil.EFFECT_ID, new PeacefulAuraEffect());

    public static void init() {}
}
