package org.emrila.peacefulaura.item.alchemy;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.ModUtil;

public class ModPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, ModConstants.MOD_ID);

    public static final RegistryObject<Potion> PEACEFUL_POTION = POTIONS.register(
            ModUtil.POTION_ID.getPath(),
            () -> ModUtil.constructPotion(false)
    );

    public static final RegistryObject<Potion> PEACEFUL_LONG_POTION = POTIONS.register(
            ModUtil.POTION_LONG_ID.getPath(),
            () -> ModUtil.constructPotion(true)
    );

    public static void register(BusGroup modBusGroup) {
        POTIONS.register(modBusGroup);
    }
}
