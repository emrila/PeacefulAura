package org.emrila.item.alchemy;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import org.emrila.PeacefulAura;
import org.emrila.effect.ModEffects;

public final class ModPotions {

    public static Holder<Potion> PEACEFUL_POTION = registerPotion("peaceful_aura",
            new Potion("peaceful_aura", new MobEffectInstance(ModEffects.PEACEFUL_EFFECT,3600, 0, false, true)));

    public static Holder<Potion> PEACEFUL_LONG_POTION = registerPotion("long_peaceful_aura",
            new Potion("peaceful_aura", new MobEffectInstance(ModEffects.PEACEFUL_EFFECT, 9600, 0, false, true)));

    private static Holder<Potion> registerPotion(String name, Potion potion) {
        PeacefulAura.Log("💜 Registering potion {}", name);
        return Registry.registerForHolder(BuiltInRegistries.POTION, PeacefulAura.id(name), potion);
    }

    public static void init() {
        PeacefulAura.Log("💜 Registering potions for {}", PeacefulAura.MOD_ID);
    }

}
