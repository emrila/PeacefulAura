package org.emrila.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.emrila.PeacefulAura;
import org.emrila.food.ModFoods;

import java.util.function.Function;

public final class ModItems {
    public static final Item BAKED_POISONOUS_POTATO = registerItem("baked_poisonous_potato", properties ->
            new Item(properties.food(ModFoods.GRILLED_POISONOUS_POTATO, ModFoods.GRILLED_POISONOUS_POTATO_CONSUMABLE)));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        PeacefulAura.Log("💜 Registering item {}", name);
        return Registry.register(BuiltInRegistries.ITEM, PeacefulAura.id(name), function.apply(
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM, PeacefulAura.id(name)))));
    }

    public static void init(){
        PeacefulAura.Log("💜 Registering items for {}", PeacefulAura.MOD_ID);
        CreativeModeTabEvents.ModifyOutput listener = output -> output.accept(BAKED_POISONOUS_POTATO);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(listener);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(listener);
    }

}
