package org.emrila.peacefulaura;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.emrila.peacefulaura.effect.ModEffects;
import org.emrila.peacefulaura.item.ModItems;
import org.emrila.peacefulaura.item.alchemy.ModPotions;

@Mod(ModConstants.MOD_ID)
public final class PeacefulAura {

    public PeacefulAura(FMLJavaModLoadingContext context) {
        BusGroup modBusGroup = context.getModBusGroup();

        ModEffects.register(modBusGroup);
        ModPotions.register(modBusGroup);
        ModItems.register(modBusGroup);

        FMLCommonSetupEvent.getBus(modBusGroup).addListener(PeacefulAura::commonSetup);
        BuildCreativeModeTabContentsEvent.BUS.addListener(PeacefulAura::addCreative);
        GatherDataEvent.getBus(modBusGroup).addListener(PeacefulAuraDataGen::gatherData);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
    }

    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey == CreativeModeTabs.INGREDIENTS || tabKey == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BAKED_POISONOUS_POTATO);
        }
    }

}
