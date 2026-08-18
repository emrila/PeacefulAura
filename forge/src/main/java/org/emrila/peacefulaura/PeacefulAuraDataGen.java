package org.emrila.peacefulaura;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.emrila.peacefulaura.datagen.ModModelProvider;
import org.emrila.peacefulaura.datagen.ModRecipeProvider;
import org.emrila.peacefulaura.item.ModItems;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID)
public class PeacefulAuraDataGen {
    @SubscribeEvent
    public static void gatherData(@NonNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        ModRecipeProvider.setRecipeItem(ModItems.BAKED_POISONOUS_POTATO.get());

        generator.addProvider(event.includeClient(), new ModModelProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider.Runner(packOutput, lookupProvider));
    }
}
