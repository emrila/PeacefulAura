package org.emrila.peacefulaura.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.emrila.peacefulaura.item.ModItems;
import org.jspecify.annotations.NonNull;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected Stream<Block> getKnownBlocks() {
        return Stream.empty();
    }

    @Override
    protected Stream<Item> getKnownItems() {
        return Stream.of(ModItems.BAKED_POISONOUS_POTATO.get());
    }

    @Override
    protected @NonNull BlockModelGenerators getBlockModelGenerators(@NonNull BlockStateGeneratorCollector blocks, @NonNull ItemInfoCollector items, @NonNull SimpleModelCollector models) {
        return new BlockModelGenerators(blocks, items, models) {
            @Override
            public void run() {
            }
        };
    }

    @Override
    protected @NonNull ItemModelGenerators getItemModelGenerators(@NonNull ItemInfoCollector items, @NonNull SimpleModelCollector models) {
        return new ItemModelGenerators(items, models) {
            @Override
            public void run() {
                generateFlatItem(ModItems.BAKED_POISONOUS_POTATO.get(), ModelTemplates.FLAT_ITEM);
            }
        };
    }

}
