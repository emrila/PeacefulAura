package org.emrila.peacefulaura;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.emrila.peacefulaura.datagen.ModModelProvider;
import org.emrila.peacefulaura.datagen.ModRecipeProvider;
import org.emrila.peacefulaura.datagen.PeacefulAuraRecipeProvider;
import org.emrila.peacefulaura.item.ModItems;
import org.jspecify.annotations.NonNull;

public final class PeacefulAuraDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(@NonNull FabricDataGenerator fabricDataGenerator) {
		PeacefulAuraRecipeProvider.setRecipeItem(ModItems.BAKED_POISONOUS_POTATO);

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
