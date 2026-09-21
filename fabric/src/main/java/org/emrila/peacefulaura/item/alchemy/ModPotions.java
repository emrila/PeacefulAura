package org.emrila.peacefulaura.item.alchemy;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.alchemy.Potion;
import org.emrila.peacefulaura.ModUtil;

public final class ModPotions {

    public static final Holder<Potion> PEACEFUL_POTION = registerPotion(ModUtil.POTION_ID, ModUtil.constructPotion(false));
    public static final Holder<Potion> PEACEFUL_LONG_POTION = registerPotion(ModUtil.POTION_LONG_ID, ModUtil.constructPotion(true));

    private static Holder<Potion> registerPotion(Identifier id, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, id, potion);
    }
    public static void init() {
    }

}
