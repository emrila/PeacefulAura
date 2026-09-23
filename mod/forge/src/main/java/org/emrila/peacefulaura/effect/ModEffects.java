package org.emrila.peacefulaura.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.ModUtil;

public class ModEffects {

    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ModConstants.MOD_ID);
    public static final RegistryObject<MobEffect> PEACEFUL_EFFECT = MOB_EFFECTS.register(ModUtil.EFFECT_ID.getPath(), PeacefulAuraEffect::new);

    public static void register(BusGroup modBusGroup) {
        MOB_EFFECTS.register(modBusGroup);
    }
}
