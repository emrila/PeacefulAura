package org.emrila.peacefulaura.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.emrila.peacefulaura.PeacefulAura;
import org.emrila.peacefulaura.food.ModFoods;


import java.util.function.Function;

public final class ModItems {
    public static final Item BAKED_POISONOUS_POTATO = registerItem(properties ->
            new Item(properties.food(ModFoods.GRILLED_POISONOUS_POTATO, ModFoods.GRILLED_POISONOUS_POTATO_CONSUMABLE)));

    private static Item registerItem(Function<Item.Properties, Item> function) {
        Identifier identifier = PeacefulAura.id("baked_poisonous_potato");
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, identifier);
        Item.Properties itemProperties = new Item.Properties().setId(itemKey);

        return Registry.register(BuiltInRegistries.ITEM, identifier, function.apply(itemProperties));
    }

    public static void init(String modId){
        PeacefulAura.Log("💜 Registering items for {}", modId);
        CreativeModeTabEvents.ModifyOutput listener = output -> output.accept(BAKED_POISONOUS_POTATO);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(listener);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(listener);
    }

}
