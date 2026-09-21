package org.emrila.peacefulaura.item.alchemy;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.ModUtil;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(BuiltInRegistries.POTION, ModConstants.MOD_ID);

    public static final Holder<Potion> PEACEFUL_POTION = POTIONS.register(ModUtil.POTION_ID.getPath(), () -> ModUtil.constructPotion(false));
    public static final Holder<Potion> PEACEFUL_LONG_POTION = POTIONS.register(ModUtil.POTION_LONG_ID.getPath(), () -> ModUtil.constructPotion(true));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
