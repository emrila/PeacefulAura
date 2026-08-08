package org.emrila.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import org.emrila.PeacefulAura;

public final class ModEffects {
    public static final Holder<MobEffect> PEACEFUL_EFFECT = registerMobEffect("peaceful_aura",
            new ModEffect(MobEffectCategory.BENEFICIAL, 0x208320));

    private static Holder<MobEffect> registerMobEffect(String name, MobEffect effect) {
        PeacefulAura.Log("💜 Registering mob effect {}", name);
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, PeacefulAura.id(name), effect);
    }

    public static void init() {
        PeacefulAura.Log("💜 Registering effects for {}", PeacefulAura.MOD_ID);
    }

}
