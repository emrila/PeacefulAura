package org.emrila.peacefulaura;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.emrila.peacefulaura.effect.ModEffects;
import org.emrila.peacefulaura.item.ModItems;
import org.emrila.peacefulaura.item.alchemy.ModPotionBrewing;
import org.emrila.peacefulaura.item.alchemy.ModPotions;

public class PeacefulAura implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstants.LOG.info("Hello Fabric world!");

        ModEffects.init(ModConstants.MOD_ID);
        ModItems.init(ModConstants.MOD_ID);
        ModPotions.init(ModConstants.MOD_ID);
        ModPotionBrewing.init(ModConstants.MOD_ID);
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(ModConstants.MOD_ID, path);
    }

    public static void Log(String format, Object... arg){
        if(ModConstants.LOG.isDebugEnabled()){
            ModConstants.LOG.info(format, arg);
        }
    }
}
