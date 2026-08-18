package org.emrila.peacefulaura.item.alchemy;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.ModUtil;
import org.emrila.peacefulaura.effect.ModEffects;

public class ModPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ModConstants.MOD_ID);

    public static final RegistryObject<Potion> PEACEFUL_POTION = POTIONS.register("peaceful_aura",
            () -> ModUtil.constructPotion(ModEffects.PEACEFUL_EFFECT.getHolder().orElseThrow(), false)
    );

    public static final RegistryObject<Potion> PEACEFUL_LONG_POTION = POTIONS.register("long_peaceful_aura",
            () -> ModUtil.constructPotion(ModEffects.PEACEFUL_EFFECT.getHolder().orElseThrow(), true)
    );

    public static void register(BusGroup modBusGroup) {
        POTIONS.register(modBusGroup);
    }
}
