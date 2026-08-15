package org.emrila.peacefulaura.effect;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.PeacefulAuraUtil;

public final class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, ModConstants.MOD_ID);

    public static final Holder<MobEffect> PEACEFUL_EFFECT = MOB_EFFECTS.register("peaceful_aura", PeacefulAuraEffect::new);

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
        PeacefulAuraUtil.setModEffect(PEACEFUL_EFFECT);
    }

}
