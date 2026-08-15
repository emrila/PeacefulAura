package org.emrila.peacefulaura.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import org.emrila.peacefulaura.ModUtil;
import org.emrila.peacefulaura.effect.ModEffects;


public final class ModFoods {
    public static final FoodProperties GRILLED_POISONOUS_POTATO = ModUtil.buildFoodProperty();
    public static final Consumable GRILLED_POISONOUS_POTATO_CONSUMABLE = ModUtil.buildConsumable(ModEffects.PEACEFUL_EFFECT);
}
