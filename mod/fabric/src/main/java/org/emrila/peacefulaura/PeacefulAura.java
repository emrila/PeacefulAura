package org.emrila.peacefulaura;

import net.fabricmc.api.ModInitializer;
import org.emrila.peacefulaura.effect.ModEffects;
import org.emrila.peacefulaura.item.ModItems;
import org.emrila.peacefulaura.item.alchemy.ModPotions;

public class PeacefulAura implements ModInitializer {

    @Override
    public void onInitialize() {
        ModEffects.init();
        ModItems.init();
        ModPotions.init();
    }

}
