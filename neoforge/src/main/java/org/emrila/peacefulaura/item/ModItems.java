package org.emrila.peacefulaura.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.food.ModFoods;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModConstants.MOD_ID);

    public static final DeferredItem<Item> BAKED_POISONOUS_POTATO = ITEMS.registerItem("baked_poisonous_potato",
            properties -> new Item(properties.food(ModFoods.GRILLED_POISONOUS_POTATO, ModFoods.GRILLED_POISONOUS_POTATO_CONSUMABLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
