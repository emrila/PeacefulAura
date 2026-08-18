
package org.emrila.peacefulaura;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.emrila.peacefulaura.datagen.ModModelProvider;
import org.emrila.peacefulaura.datagen.ModRecipeProvider;
import org.emrila.peacefulaura.item.ModItems;


import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ModConstants.MOD_ID)
public class PeacefulAuraDataGen {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        ModRecipeProvider.setRecipeItem(ModItems.BAKED_POISONOUS_POTATO.asItem());

        generator.addProvider(true, new ModModelProvider(packOutput, ModConstants.MOD_ID));
        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
    }
}
