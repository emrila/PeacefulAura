package org.emrila.peacefulaura.datagen;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.RegistriesDatapackGenerator;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.data.RegistryDataBuilder;
import org.emrila.peacefulaura.ModConstants;

import java.util.Set;

public class ModRecipeProvider {

    public static RegistriesDatapackGenerator create(PackOutput output) {
        RegistrySetBuilder recipeRegistryBuilder = new RegistrySetBuilder()
                .add(new MultiRegistryBootstrap() {
                    @Override
                    public Set<ResourceKey<? extends Registry<?>>> requestedRegistries() {
                        return Set.of(Registries.RECIPE, Registries.ADVANCEMENT);
                    }

                    @Override
                    public void run(BootstrapGetter registries) {
                        PeacefulAuraRecipeProvider.buildRecipes(registries.get(Registries.RECIPE), registries.get(Registries.ADVANCEMENT));
                    }
                });

        return RegistryDataBuilder.of()
                .modid(ModConstants.MOD_ID)
                .reloadable(recipeRegistryBuilder)
                .reloadableGenerator(output);
    }
}
