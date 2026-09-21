package org.emrila.peacefulaura.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import org.emrila.peacefulaura.item.ModItems;

public class ModModelProvider {
    public static ModelProvider create(PackOutput output, String modId){
        return new ModelProvider(output, modId){
            @Override
            protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
                itemModels.generateFlatItem(ModItems.BAKED_POISONOUS_POTATO.get(), ModelTemplates.FLAT_ITEM);
            }
        };
    }
}
