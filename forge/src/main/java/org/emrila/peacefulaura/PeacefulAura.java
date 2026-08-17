package org.emrila.peacefulaura;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.emrila.peacefulaura.effect.ModEffects;
import org.emrila.peacefulaura.event.ModEvents;
import org.emrila.peacefulaura.item.ModItems;
import org.emrila.peacefulaura.item.alchemy.ModPotions;

@Mod(ModConstants.MOD_ID)
public final class PeacefulAura {

    public PeacefulAura(FMLJavaModLoadingContext context) {
        BusGroup modBusGroup = context.getModBusGroup();

        ModEffects.register(modBusGroup);
        ModPotions.register(modBusGroup);
        ModItems.register(modBusGroup);

        BuildCreativeModeTabContentsEvent.BUS.addListener(this::addCreative);
        BrewingRecipeRegisterEvent.BUS.addListener(ModEvents::onBrewingRecipeRegister);

        GatherDataEvent.getBus(modBusGroup).addListener(PeacefulAuraDataGen::gatherData);
        FMLCommonSetupEvent.getBus(modBusGroup).addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        PeacefulAuraUtil.setModEffect(ModEffects.PEACEFUL_EFFECT.getHolder().orElseThrow());
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey == CreativeModeTabs.INGREDIENTS || tabKey == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BAKED_POISONOUS_POTATO);
        }
    }

}
