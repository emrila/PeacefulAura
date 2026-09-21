package org.emrila.peacefulaura;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.emrila.peacefulaura.datagen.ModModelProvider;
import org.emrila.peacefulaura.datagen.ModRecipeProvider;

@EventBusSubscriber(modid = ModConstants.MOD_ID)
public class PeacefulAuraDataGen {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        generator.addProvider(true, ModModelProvider.create(packOutput, ModConstants.MOD_ID));
        event.createReloadableRegistryObjects(ModRecipeProvider.create());
    }
}
