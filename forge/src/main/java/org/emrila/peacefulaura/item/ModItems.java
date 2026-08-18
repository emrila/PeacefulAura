package org.emrila.peacefulaura.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.food.ModFoods;

public class ModItems {

    private static final String BAKED_POISONOUS_POTATO_ID = "baked_poisonous_potato";

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModConstants.MOD_ID);

    public static final RegistryObject<Item> BAKED_POISONOUS_POTATO = ITEMS.register(BAKED_POISONOUS_POTATO_ID,
            () -> new Item(new Item.Properties()
                    .setId(ITEMS.key(BAKED_POISONOUS_POTATO_ID))
                    .food(ModFoods.GRILLED_POISONOUS_POTATO, ModFoods.GRILLED_POISONOUS_POTATO_CONSUMABLE))
    );

    public static void register(BusGroup modBusGroup) {
        ITEMS.register(modBusGroup);
    }
}
