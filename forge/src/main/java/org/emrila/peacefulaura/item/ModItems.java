package org.emrila.peacefulaura.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.emrila.peacefulaura.ModConstants;
import org.emrila.peacefulaura.ModUtil;

public class ModItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModConstants.MOD_ID);

    public static final RegistryObject<Item> BAKED_POISONOUS_POTATO = ITEMS.register(
            ModUtil.BAKED_POISONOUS_POTATO_ID.getPath(),
            () -> ModUtil.createFoodItem(ITEMS.key(ModUtil.BAKED_POISONOUS_POTATO_ID))
    );

    public static void register(BusGroup modBusGroup) {
        ITEMS.register(modBusGroup);
    }
}
