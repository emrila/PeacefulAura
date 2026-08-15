package org.emrila;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.emrila.effect.ModEffects;
import org.emrila.item.ModItems;

import org.emrila.item.alchemy.ModPotionBrewing;
import org.emrila.item.alchemy.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PeacefulAura implements ModInitializer {
	public static final String MOD_ID = "peacefulaura";
	private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Log("💜 PeacefulAura initialized!");

		ModEffects.init();
		ModItems.init();
		ModPotions.init();
		ModPotionBrewing.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static void Log(String format, Object... arg){
		if(LOGGER.isDebugEnabled()){
			LOGGER.info(format, arg);
		}
	}

}
