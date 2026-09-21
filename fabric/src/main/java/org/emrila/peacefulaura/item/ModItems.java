package org.emrila.peacefulaura.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.emrila.peacefulaura.ModUtil;

public final class ModItems {
    public static final Item BAKED_POISONOUS_POTATO = Registry.register(
            BuiltInRegistries.ITEM,
            ModUtil.BAKED_POISONOUS_POTATO_ID,
            ModUtil.createFoodItem(ResourceKey.create(Registries.ITEM, ModUtil.BAKED_POISONOUS_POTATO_ID)));

    public static void init(){
        CreativeModeTabEvents.ModifyOutput listener = output -> output.accept(BAKED_POISONOUS_POTATO);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(listener);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(listener);
    }

}
