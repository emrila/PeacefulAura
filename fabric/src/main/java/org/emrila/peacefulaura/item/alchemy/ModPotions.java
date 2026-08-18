package org.emrila.peacefulaura.item.alchemy;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.alchemy.Potion;
import org.emrila.peacefulaura.ModUtil;
import org.emrila.peacefulaura.PeacefulAura;
import org.emrila.peacefulaura.effect.ModEffects;

public final class ModPotions {

    public static final Holder<Potion> PEACEFUL_POTION = registerPotion("peaceful_aura",
            ModUtil.constructPotion(ModEffects.PEACEFUL_EFFECT, false));

    public static final Holder<Potion> PEACEFUL_LONG_POTION = registerPotion("long_peaceful_aura",
            ModUtil.constructPotion(ModEffects.PEACEFUL_EFFECT, true));

    private static Holder<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, PeacefulAura.id(name), potion);
    }

    public static void init(String modId) {
        PeacefulAura.Log("💜 Registering potions for {}", modId);
    }

}
