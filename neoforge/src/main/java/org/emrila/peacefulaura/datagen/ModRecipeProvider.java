package org.emrila.peacefulaura.datagen;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.recipes.RecipeProvider;

public class ModRecipeProvider {
    public static RegistrySetBuilder create(){
        return new RegistrySetBuilder()
                .add(RecipeProvider.asBootstrap(PeacefulAuraRecipeProvider::create));
    }
}
