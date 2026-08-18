package org.emrila.peacefulaura.datagen;

import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import org.emrila.peacefulaura.item.ModItems;
import org.jspecify.annotations.NonNull;

import java.util.function.BiConsumer;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected @NonNull ItemModelGenerators getItemModelGenerators(@NonNull ItemInfoCollector items, @NonNull SimpleModelCollector models) {
        return new ModItemModelGenerators(items, models);
    }

    private static final class ModItemModelGenerators extends ItemModelGenerators {
        private ModItemModelGenerators(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
            super(itemModelOutput, modelOutput);
        }

        @Override
        public void run() {
            generateFlatItem(ModItems.BAKED_POISONOUS_POTATO.get(), ModelTemplates.FLAT_ITEM);
        }
    }
}
