package org.emrila.peacefulaura;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.emrila.peacefulaura.effect.ModEffects;
import org.emrila.peacefulaura.item.ModItems;
import org.emrila.peacefulaura.item.alchemy.ModPotions;

@Mod(ModConstants.MOD_ID)
public class PeacefulAura {

    public PeacefulAura(IEventBus eventBus) {
        eventBus.addListener(this::commonSetup);

        ModConstants.LOG.info("Hello NeoForge world!");

        ModItems.register(eventBus);

        ModPotions.register(eventBus);

        ModEffects.register(eventBus);

        NeoForge.EVENT_BUS.register(this);

        eventBus.addListener(this::addCreative);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if(tabKey == CreativeModeTabs.INGREDIENTS || tabKey == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.BAKED_POISONOUS_POTATO);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}