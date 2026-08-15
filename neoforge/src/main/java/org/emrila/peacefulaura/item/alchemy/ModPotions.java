package org.emrila.peacefulaura.item.alchemy;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.ModUtil;
import org.emrila.peacefulaura.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, ModConstants.MOD_ID);

    public static final Holder<Potion> PEACEFUL_POTION = POTIONS.register("peaceful_aura",
            () -> ModUtil.constructPotion(ModEffects.PEACEFUL_EFFECT, false));

    public static final Holder<Potion> PEACEFUL_LONG_POTION = POTIONS.register("long_peaceful_aura",
            () -> ModUtil.constructPotion(ModEffects.PEACEFUL_EFFECT, true));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
